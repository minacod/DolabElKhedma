package com.example.shafy.dolabelkhedma.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.adapter.HomeActivityOptionListAdapter;
import com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collections;
import java.util.List;

import static com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils.getSyncedFirebaseInstanse;

public class HomeActivity extends AppCompatActivity implements HomeActivityOptionListAdapter.OnOptionClicked{

    private static final String TAG = "HomeActivity";
    private RecyclerView mOptionsList;
    private HomeActivityOptionListAdapter mListAdapter;
    private FirebaseDatabase mFdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(getString(R.string.home_activity));

        mFdb =getSyncedFirebaseInstanse();

        //getting references to sync any data offline

        DatabaseReference AngleData= FirebaseReferencesUtils.getAngelsReference(this, mFdb);
        DatabaseReference maleSimpleAngleData=FirebaseReferencesUtils.getSimpleAngelsReference(this, mFdb, true);
        DatabaseReference femaleSimpleAngleData=FirebaseReferencesUtils.getSimpleAngelsReference(this, mFdb, false);
        FirebaseReferencesUtils.getAngelsAttendanceReference(this, mFdb,true);
        FirebaseReferencesUtils.getAngelsAttendanceReference(this, mFdb,false);
        FirebaseReferencesUtils.getPhoneReference(this, mFdb);
        DatabaseReference dobRef =FirebaseReferencesUtils.getDobReference(this, mFdb);


        mOptionsList = findViewById(R.id.rv_main_activity_options_list);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false);
        mOptionsList.setLayoutManager(layoutManager);
        mListAdapter =new HomeActivityOptionListAdapter(this);
        mOptionsList.setAdapter(mListAdapter);
        mOptionsList.setHasFixedSize(true);
    }


    @Override
    public void onClickListener(int position) {
        Intent intent;
        switch(position)
        {
            case 0:
                intent=new Intent(this,AttendanceActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent=new Intent(this,LogActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent=new Intent(this,FridayActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent=new Intent(this,DolabActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent=new Intent(this,TripActivity.class);
                startActivity(intent);
                break;
        }
    }

}
