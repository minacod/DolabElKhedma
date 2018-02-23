package com.example.shafy.dolabelkhedma.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.databinding.ActivityAngelBinding;
import com.example.shafy.dolabelkhedma.databinding.InfoSummaryBinding;
import com.example.shafy.dolabelkhedma.databinding.PersonInfoBinding;
import com.example.shafy.dolabelkhedma.databinding.PersonMainInfoBinding;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.model.Phone;
import com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AngelActivity extends AppCompatActivity {

    ActivityAngelBinding mMainBinding;
    private String mAngelId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_angel);

        mMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_angel);

        Intent i = getIntent();
        mAngelId = i.getStringExtra("id");

        FirebaseDatabase fdb =FirebaseReferencesUtils.getSyncedFirebaseInstanse();
        DatabaseReference reference = FirebaseReferencesUtils.getAngelsReference(this,fdb);
        DatabaseReference dobRef = FirebaseReferencesUtils.getDobReference(this,fdb);
        DatabaseReference phonesRef = FirebaseReferencesUtils.getPhoneReference(this,fdb);

        final ArrayList<Phone> phones = new ArrayList<>();
        phonesRef.child(mAngelId).child("0").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                phones.add(dataSnapshot.getValue(Phone.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        phonesRef.child(mAngelId).child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                phones.add(dataSnapshot.getValue(Phone.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        phonesRef.child(mAngelId).child("2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                phones.add(dataSnapshot.getValue(Phone.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        final String[] dob = {""};
        dobRef.child(mAngelId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dob[0] = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        final Angel[] angel = {new Angel()};
        reference.child(mAngelId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                angel[0] = dataSnapshot.getValue(Angel.class);
                updateUi(angel[0], dob[0],phones);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        FirebaseStorage fs= FirebaseReferencesUtils.getFirebaseStorageInstanse();
        StorageReference sr = FirebaseReferencesUtils.getAngelStorageReference(this,fs);
        GlideApp.with(this)
                .load(sr.child(mAngelId).child("pp"))
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

    void updateUi(final Angel angel, final String dob, final ArrayList<Phone> phones){
        mMainBinding.tvName.setText(angel.getmName());
        mMainBinding.iPersonInfo.iInfoSummary.tvCoinsNumber.setText(String.valueOf(angel.getmCoins()));
        mMainBinding.iPersonInfo.iInfoSummary.tvScoreNumber.setText(String.valueOf(angel.getmScore()));
        mMainBinding.iPersonInfo.iMainInfo.tvAddress.setText(String.valueOf(angel.getmAddress()));
        mMainBinding.iPersonInfo.iMainInfo.tvBuildingNumber.setText(String.valueOf(angel.getmHomeNum()));
        mMainBinding.iPersonInfo.iMainInfo.tvMmyy.setText(dob.substring(0,6));
        mMainBinding.iPersonInfo.iMainInfo.tvDd.setText(dob.substring(8,9));

        mMainBinding.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent i = new Intent(AngelActivity.this,AddingAngelActivity.class);
             i.putExtra("edit",true);
             i.putExtra("id",mAngelId);
             i.putExtra("angel",angel);
             i.putExtra("dob",dob);
             i.putExtra("phones",phones);
             startActivity(i);
            }
        });
    }
}
