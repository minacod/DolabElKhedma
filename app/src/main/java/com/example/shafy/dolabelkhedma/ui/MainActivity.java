package com.example.shafy.dolabelkhedma.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.adapter.MainActivityOptionListAdapter;
import com.example.shafy.dolabelkhedma.data.FirebaseDatabaseUtils;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils.getSyncedFirebaseInstanse;

public class MainActivity extends AppCompatActivity implements MainActivityOptionListAdapter.OnOptionClicked{

    private static final String TAG = "MainActivity";
    private RecyclerView mOptionsList;
    private MainActivityOptionListAdapter mListAdapter;
    FirebaseDatabase mFdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.main_activity));

        mFdb =getSyncedFirebaseInstanse();

        //getting references to sync any data offline

        DatabaseReference AngleData= FirebaseReferencesUtils.getAngelsReference(MainActivity.this, mFdb);
        DatabaseReference maleSimpleAngleData=FirebaseReferencesUtils.getSimpleAngelsReference(MainActivity.this, mFdb, true);
        DatabaseReference femaleSimpleAngleData=FirebaseReferencesUtils.getSimpleAngelsReference(MainActivity.this, mFdb, false);
        FirebaseReferencesUtils.getAngelsAttendanceReference(MainActivity.this, mFdb,true);
        FirebaseReferencesUtils.getAngelsAttendanceReference(MainActivity.this, mFdb,false);
        FirebaseReferencesUtils.getPhoneReference(MainActivity.this, mFdb);
        DatabaseReference dobRef =FirebaseReferencesUtils.getDobReference(MainActivity.this, mFdb);


        mOptionsList = findViewById(R.id.rv_main_activity_options_list);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false);
        mOptionsList.setLayoutManager(layoutManager);
        mListAdapter =new MainActivityOptionListAdapter(this);
        mOptionsList.setAdapter(mListAdapter);
        mOptionsList.setHasFixedSize(true);
    }

    @Override
    public void onClickListener(int position) {
        Intent intent;
        switch(position)
        {
            case 0:
                intent=new Intent(MainActivity.this,AttendanceActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent=new Intent(MainActivity.this,LogActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent=new Intent(MainActivity.this,FridayActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent=new Intent(MainActivity.this,DolabActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent=new Intent(MainActivity.this,TripActivity.class);
                startActivity(intent);
                break;
        }
    }

}
