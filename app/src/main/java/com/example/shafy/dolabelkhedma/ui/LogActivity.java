package com.example.shafy.dolabelkhedma.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.adapter.LogListAdapter;
import com.example.shafy.dolabelkhedma.data.DolabElKhedmaContract;
import com.example.shafy.dolabelkhedma.data.DolabElKhedmaDbHelper;

public class LogActivity extends AppCompatActivity implements LogListAdapter.OnPersonClicked{

    private static AttendanceTapAdapter mAttendanceTapAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private  ViewPager mViewPager;
    private static SQLiteDatabase mDb;

    @Override
    protected void onResume() {
        super.onResume();
        updatePager();
    }

    private static DolabElKhedmaDbHelper dbHelper;
    private static Cursor  mNotAdded;
    private static LogListAdapter.OnPersonClicked mOnPersonClicked;
    private static String[] CLASS= new String[]{"1","2","3"};
    private static  int gender;
    private static int classNumber;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        if(getSupportActionBar()!=null)
            getSupportActionBar().setElevation(0);

        mOnPersonClicked =this;
        gender=1;
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        dbHelper=new DolabElKhedmaDbHelper(this);
        mDb = dbHelper.getWritableDatabase();

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setRotation(180);

        fillPager();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        fab=(FloatingActionButton)findViewById(R.id.add_angel);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogActivity.this,AddingAngelActivity.class));
            }
        });

    }

    public void fillPager(){

        mAttendanceTapAdapter = new AttendanceTapAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAttendanceTapAdapter);
    }
    public void updatePager(){

        mAttendanceTapAdapter.notifyDataSetChanged();

    }



    public static Cursor getDataNotAdded(int i){

        String orderedBy = DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME+" ASC";

        mNotAdded =mDb.query(DolabElKhedmaContract.MainDataEnrty.TABLE_NAME,
                null,
                DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER+" = "+gender +
                " AND "+DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class+" = "+CLASS[i] ,null,
                null,null,orderedBy);

        return mNotAdded;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.attendance_manu, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        final Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Context context =view.getContext();
                if(parent.getItemAtPosition(position).equals(context.getString(R.string.boys))){
                    gender=1;
                    updatePager();
                }
                else {
                    gender=0;
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
    public void onPersonClickedHandler(Cursor data , int position) {
        Intent i = new Intent(this,AngelActivity.class);
        startActivity(i);
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
            mRootView = inflater.inflate(R.layout.fragment_log, container, false);
            mRootView.setRotation(180);
            classNumber= getArguments().getInt(ARG_SECTION_NUMBER)-1;
            getDataNotAdded(classNumber);

            LogListAdapter mAdapter2=new LogListAdapter(mOnPersonClicked,mNotAdded);
            RecyclerView rv2 =(RecyclerView)mRootView.findViewById(R.id.rv_attendance_passive);
            LinearLayoutManager layoutManager2 =new LinearLayoutManager(mRootView.getContext(),LinearLayoutManager.VERTICAL,false);
            rv2.setLayoutManager(layoutManager2);
            rv2.setAdapter(mAdapter2);
            rv2.setHasFixedSize(true);

            return mRootView;
        }
    }
}
