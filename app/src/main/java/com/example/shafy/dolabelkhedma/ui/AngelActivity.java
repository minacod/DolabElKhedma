package com.example.shafy.dolabelkhedma.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.databinding.ActivityAngelBinding;
import com.example.shafy.dolabelkhedma.databinding.InfoSummaryBinding;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.util.Calendar;

public class AngelActivity extends AppCompatActivity {

    ActivityAngelBinding mMainBinding;
    InfoSummaryBinding mInfoSummaryBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_angel);

        mInfoSummaryBinding =DataBindingUtil.setContentView(this,R.layout.info_summary);

        mMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_angel);

        Intent i = getIntent();
        String id = i.getStringExtra("id");

        FirebaseDatabase fdb =FirebaseReferencesUtils.getSyncedFirebaseInstanse();
        DatabaseReference reference = FirebaseReferencesUtils.getAngelsReference(this,fdb);

        reference.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
              updateUi(dataSnapshot.getValue(Angel.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        FirebaseStorage fs= FirebaseReferencesUtils.getFirebaseStorageInstanse();
        StorageReference sr = FirebaseReferencesUtils.getAngelStorageReference(this,fs);
        GlideApp.with(this)
                .load(sr.child(id).child("pp"))
                .placeholder(R.drawable.ic_contact_avatar_large)
                .error(R.drawable.ic_contact_avatar_large)
                .into(mMainBinding.ivAngel);
        Calendar c =Calendar.getInstance();
        CalendarDay last=CalendarDay.from(c);
        c.set(2016,11,11);
        CalendarDay first= CalendarDay.from(c);
        mMainBinding.calendarView.state().edit()
                .setMinimumDate(first)
                .setMaximumDate(last)
                .commit();
    }

    void updateUi(Angel a){
        mMainBinding.tvName.setText(a.getmName());
    }
}
