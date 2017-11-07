package com.example.shafy.dolabelkhedma.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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
import com.example.shafy.dolabelkhedma.adapter.AttendanceAddingListAdapter;
import com.example.shafy.dolabelkhedma.adapter.AttendanceRemovingListAdapter;
import com.example.shafy.dolabelkhedma.data.DolabElKhedmaContract;
import com.example.shafy.dolabelkhedma.data.DolabElKhedmaDbHelper;
import com.example.shafy.dolabelkhedma.data.TestUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AttendanceActivity extends AppCompatActivity implements AttendanceRemovingListAdapter.OnAttendanceRemoved,AttendanceAddingListAdapter.OnAttendanceAdding {

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
    private static Cursor mAdded;
    private static SQLiteDatabase mDb;

    @Override
    protected void onResume() {
        super.onResume();
        updatePager();
    }

    private static DolabElKhedmaDbHelper dbHelper;
    private static Cursor  mNotAdded;
    private static AttendanceRemovingListAdapter.OnAttendanceRemoved removed;
    private static AttendanceAddingListAdapter.OnAttendanceAdding adding;
    private static String[] CLASS= new String[]{"1","2","3"};
    private static  int gender;
    private static int classNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setElevation(0);
        removed=this;
        adding=this;
        gender=1;
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        dbHelper=new DolabElKhedmaDbHelper(this);
        mDb = dbHelper.getReadableDatabase();
        //mDb.delete(DolabElKhedmaContract.AttendanceEntry.TABLE_NAME,null,null);
        //TestUtil.insertFakeData(mDb);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setRotation(180);

        fillPager();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    public void fillPager(){
        // Set up the ViewPager with the sections adapter.
        //getDataNotAdded();
        //getDataAdded();
        mAttendanceTapAdapter = new AttendanceTapAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAttendanceTapAdapter);
    }
    public void updatePager(){
        // Set up the ViewPager with the sections adapter.
        //getDataNotAdded();
        //getDataAdded();
        mAttendanceTapAdapter.notifyDataSetChanged();

    }


    public static Cursor  getDataAdded(int i){

        SQLiteQueryBuilder qb =new SQLiteQueryBuilder();
        Date cDate = new Date();
        Locale l = new Locale("en","eg");
        String fDate = new SimpleDateFormat("yyyy-MM-dd",l).format(cDate);
        fDate="'"+fDate+"'";
        qb.setTables(DolabElKhedmaContract.MainDataEnrty.TABLE_NAME +
                " INNER JOIN " + DolabElKhedmaContract.AttendanceEntry.TABLE_NAME + " ON " +
                DolabElKhedmaContract.MainDataEnrty.TABLE_NAME+"."+DolabElKhedmaContract.MainDataEnrty._ID +
                " = " + DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID+" WHERE "+
                DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER+" = "+ gender +
                " AND "+ DolabElKhedmaContract.MainDataEnrty.TABLE_NAME+
                "."+DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class+" = "+CLASS[i]+
                " AND "+ DolabElKhedmaContract.AttendanceEntry.COLUMNS_Date+" = "+fDate);
        String orderedBy = DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME+" ASC";


        mAdded  =qb.query(mDb,
                null,
                null,null,
                //DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH+" = "+"'1' and "+
                  //      DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class+" = '"+CLASS[i]+"'",null,
                null,null,orderedBy);
        /*
        mAdded [1] =mDb.query(DolabElKhedmaContract.AttendanceEntry.TABLE_NAME,
                null,
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH+" = "+"'1' and "+
                        DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class+" = '"+CLASS[1]+"'",null,
                null,null,null);
        mAdded [2] =mDb.query(DolabElKhedmaContract.AttendanceEntry.TABLE_NAME,
                null,
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH+" = "+"'1' and "+
                        DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class+" = '"+CLASS[2]+"'",null,
                null,null,null);*/
        mAdded.moveToFirst();
        return  mAdded;
    }
    public static Cursor getDataNotAdded(int i){

        Date cDate = new Date();
        Locale l = new Locale("en","eg");
        String fDate = new SimpleDateFormat("yyyy-MM-dd",l).format(cDate);
        fDate="'"+fDate+"'";

        SQLiteQueryBuilder qb =new SQLiteQueryBuilder();
        qb.setTables(DolabElKhedmaContract.MainDataEnrty.TABLE_NAME +
                " LEFT JOIN " + DolabElKhedmaContract.AttendanceEntry.TABLE_NAME + " ON " +
                DolabElKhedmaContract.MainDataEnrty.TABLE_NAME+"."+DolabElKhedmaContract.MainDataEnrty._ID +
                " = " + DolabElKhedmaContract.AttendanceEntry.TABLE_NAME+"."+
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID+" WHERE "+
                DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER+" = "+ gender +
                " AND "+ DolabElKhedmaContract.MainDataEnrty.TABLE_NAME+
                "."+DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class+" = "+CLASS[i]+" AND "+
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID+" IS NULL"+
                " OR "+ DolabElKhedmaContract.AttendanceEntry.COLUMNS_Date+" != "+fDate);
        String orderedBy = DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME+" ASC";

        mNotAdded =qb.query(mDb,
                null,
                null,null,
                null,null,null);
        /*
        mNotAdded[1] =mDb.query(DolabElKhedmaContract.AttendanceEntry.TABLE_NAME,
                null,
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH+" = "+"'0' and "+
                        DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class+" = '"+CLASS[1]+"'",null,
                null,null,null);
        mNotAdded[2] =mDb.query(DolabElKhedmaContract.AttendanceEntry.TABLE_NAME,
                null,
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH+" = "+"'0' and "+
                        DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class+" = '"+CLASS[2]+"'",null,
                null,null,null);*/
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
    public void OnAddingHandler(Cursor data ,int position) {

        data.moveToPosition(position);
        int _id = data.getInt(data.getColumnIndex(DolabElKhedmaContract.MainDataEnrty._ID));
        int cN = data.getInt(data.getColumnIndex(DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class));
        Date cDate = new Date();
        Locale l = new Locale("en","eg");
        String fDate = new SimpleDateFormat("yyyy-MM-dd",l).format(cDate);

        ContentValues cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH,1);
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID,_id);
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class,cN);
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_Date,fDate);
        long i  =mDb.insert(DolabElKhedmaContract.AttendanceEntry.TABLE_NAME,
                null,
                cv);
        updatePager();

    }
    @Override
    public void OnRemoveHandler(String position) {
        ContentValues cv = new ContentValues();
        cv.put(DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH,0);
        int i  =mDb.delete(DolabElKhedmaContract.AttendanceEntry.TABLE_NAME,
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID+" = "+position,null);
        updatePager();
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
            classNumber= getArguments().getInt(ARG_SECTION_NUMBER)-1;
            getDataNotAdded(classNumber);
            getDataAdded(classNumber);

            RecyclerView rv =(RecyclerView)mRootView.findViewById(R.id.rv_attendance_active);
            AttendanceRemovingListAdapter mAdapter=new AttendanceRemovingListAdapter( removed,mAdded);
            LinearLayoutManager layoutManager =new LinearLayoutManager(mRootView.getContext(),LinearLayoutManager.VERTICAL,false){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(mAdapter);
            rv.setHasFixedSize(true);

            AttendanceAddingListAdapter mAdapter2=new AttendanceAddingListAdapter(adding,mNotAdded);
            RecyclerView rv2 =(RecyclerView)mRootView.findViewById(R.id.rv_attendance_passive);
            LinearLayoutManager layoutManager2 =new LinearLayoutManager(mRootView.getContext(),LinearLayoutManager.VERTICAL,false){
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
