package com.example.shafy.dolabelkhedma.ui;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.adapter.AttendanceAddingListAdapter;
import com.example.shafy.dolabelkhedma.adapter.AttendanceRemovingListAdapter;
import com.example.shafy.dolabelkhedma.data.FirebaseDatabaseUtils;
import com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class AttendanceActivity extends AppCompatActivity implements
        AttendanceRemovingListAdapter.OnAttendanceRemoved,
        AttendanceAddingListAdapter.OnAttendanceAdding {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private static AttendanceTapAdapter mAttendanceTapAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private  ViewPager mViewPager;
    private static AttendanceRemovingListAdapter.OnAttendanceRemoved sRemoved;
    private static AttendanceAddingListAdapter.OnAttendanceAdding sAdding;
    private static  boolean sGender;
    private int sClassNumber;
    private static FirebaseDatabase sFDb;
    private static DatabaseReference attendanceRef;
    private static DatabaseReference simpleAngleRef;
    private static DatabaseReference angelRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setElevation(0);
        sFDb=FirebaseReferencesUtils.getSyncedFirebaseInstanse();
        sRemoved = this;
        sAdding = this;
        sGender = true;
        angelRef = FirebaseReferencesUtils.getAngelsReference(this,sFDb);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        mViewPager = findViewById(R.id.container);
        mViewPager.setRotation(180);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                sClassNumber = position;
                Log.d("lalala",String.valueOf(sClassNumber));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        fillPager();

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    public void fillPager(){
        // Set up the ViewPager with the sections adapter.
        mAttendanceTapAdapter = new AttendanceTapAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAttendanceTapAdapter);
    }
    public void updatePager(){
        // Set up the ViewPager with the sections adapter.
        mAttendanceTapAdapter.notifyDataSetChanged();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.attendance_manu, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        final Spinner spinner = (Spinner) item.getActionView();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Context context =view.getContext();
                if(parent.getItemAtPosition(position).equals(context.getString(R.string.boys))){
                    sGender = true;
                    updatePager();
                }
                else {
                    sGender = false;
                    updatePager();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml


        return super.onOptionsItemSelected(item);
    }
    @Override
    public void OnAddingHandler(String id ,String name) {
        Calendar c = Calendar.getInstance();
        Date cc = c.getTime();
        String d = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).format(cc);
        FirebaseDatabaseUtils.addAngelAttendance(attendanceRef,angelRef,name,id,String.valueOf(sClassNumber+1),d);
    }
    @Override
    public void OnRemoveHandler(String id ,String name) {

        Calendar c = Calendar.getInstance();
        Date cc = c.getTime();
        String d = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).format(cc);
        FirebaseDatabaseUtils.removeAngelAttendance(attendanceRef,angelRef,name,id,String.valueOf(sClassNumber+1),d);

    }



    public class AttendanceTapAdapter extends FragmentPagerAdapter {

        public AttendanceTapAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return  PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "أولى";
                case 1:
                    return "تانية";
                case 2:
                    return "تالتة";
            }
            return null;
        }

    }

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        private  View mRootView;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            mRootView = inflater.inflate(R.layout.fragment_attendance, container, false);
            mRootView.setRotation(180);
            int classNum = getArguments().getInt(ARG_SECTION_NUMBER);

            //TODO move it to timeUtils
            Calendar c = Calendar.getInstance();
            Date cc = c.getTime();
            String d = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).format(cc);
            attendanceRef = FirebaseReferencesUtils.getAngelsAttendanceReference(getContext(),sFDb, sGender);
            Query queryAngelsAttendance = attendanceRef.child(d).child("class_"+String.valueOf(classNum)).orderByValue();
            final HashMap<String, String> angelsAttendanceMap=new HashMap<String, String>();
            final ArrayList<String> angelsAttendanceIds=new ArrayList<String>();

            final AttendanceRemovingListAdapter mAdapter=new AttendanceRemovingListAdapter(sRemoved,angelsAttendanceMap,angelsAttendanceIds);
            simpleAngleRef = FirebaseReferencesUtils.getSimpleAngelsReference(getContext(),sFDb, sGender);
            Query querySimpleAngle = simpleAngleRef.child("class_"+String.valueOf(classNum)).orderByValue();
            final HashMap<String, String> simpleAngelsMap = new HashMap<String, String>();
            final ArrayList<String> simpleAngelsIds = new ArrayList<String>();


            final AttendanceAddingListAdapter mAdapter2=new AttendanceAddingListAdapter(sAdding,simpleAngelsMap,simpleAngelsIds);

            querySimpleAngle.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String angelName = dataSnapshot.getValue(String.class);
                    String angelId = dataSnapshot.getKey();
                    if(angelName!=null&&!(angelName.equals(angelsAttendanceMap.get(angelId)))) {
                        simpleAngelsMap.put(angelId, angelName);
                        simpleAngelsIds.add(angelId);
                    }
                    mAdapter2.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    String newSimpleAngel = dataSnapshot.getValue(String.class);
                    String simpleAngelId = dataSnapshot.getKey();
                    if(Build.VERSION.SDK_INT>=24)
                        simpleAngelsMap.replace(simpleAngelId,newSimpleAngel);
                    else {
                        simpleAngelsMap.remove(simpleAngelId);
                        simpleAngelsMap.put(simpleAngelId,newSimpleAngel);
                    }
                    mAdapter2.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    String simpleAngelId = dataSnapshot.getKey();
                    simpleAngelsMap.remove(simpleAngelId);
                    simpleAngelsIds.remove(simpleAngelsIds.indexOf(simpleAngelId));
                    mAdapter2.notifyDataSetChanged();
                }
                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });


            queryAngelsAttendance.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String newSimpleAngel = dataSnapshot.getValue(String.class);
                    String simpleAngelId = dataSnapshot.getKey();
                    angelsAttendanceMap.put(simpleAngelId, newSimpleAngel);
                    angelsAttendanceIds.add(simpleAngelId);
                    simpleAngelsMap.remove(simpleAngelId);
                    simpleAngelsIds.remove(simpleAngelId);
                    mAdapter.notifyDataSetChanged();
                    mAdapter2.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    String newSimpleAngel = dataSnapshot.getValue(String.class);
                    String simpleAngelId = dataSnapshot.getKey();
                    if(Build.VERSION.SDK_INT>=24)
                        angelsAttendanceMap.replace(simpleAngelId,newSimpleAngel);
                    else {
                        angelsAttendanceMap.remove(simpleAngelId);
                        angelsAttendanceMap.put(simpleAngelId,newSimpleAngel);
                    }
                    mAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    String simpleAngelId = dataSnapshot.getKey();
                    String simpleAngelName=dataSnapshot.getValue(String.class);
                    angelsAttendanceMap.remove(simpleAngelId);
                    angelsAttendanceIds.remove(simpleAngelId);
                    simpleAngelsMap.put(simpleAngelId,simpleAngelName);
                    simpleAngelsIds.add(simpleAngelId);
                    mAdapter.notifyDataSetChanged();
                    mAdapter2.notifyDataSetChanged();
                }
                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });




            RecyclerView rv = mRootView.findViewById(R.id.rv_attendance_active);
            LinearLayoutManager layoutManager =new LinearLayoutManager(mRootView.getContext(),LinearLayoutManager.VERTICAL,false){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(mAdapter);
            rv.setHasFixedSize(true);

            RecyclerView rv2 =mRootView.findViewById(R.id.rv_attendance_passive);
            LinearLayoutManager layoutManager2 =new LinearLayoutManager(mRootView.getContext(), LinearLayoutManager.VERTICAL,false){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            rv2.setLayoutManager(layoutManager2);
            rv2.setAdapter(mAdapter2);
            rv2.setHasFixedSize(true);

            return mRootView;
        }
    }

}
