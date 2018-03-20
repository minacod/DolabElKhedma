package com.example.shafy.dolabelkhedma.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.databinding.ActivityAngelBinding;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.model.Phone;
import com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class AngelActivity extends AppCompatActivity {

    ActivityAngelBinding mMainBinding;
    private String mAngelId;
    private Angel mAngel;
    ArrayList<Phone> mPhones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angel);

        mMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_angel);
        setSupportActionBar(mMainBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        mAngelId = i.getStringExtra("id");

        FirebaseDatabase fdb =FirebaseReferencesUtils.getSyncedFirebaseInstanse();
        DatabaseReference reference = FirebaseReferencesUtils.getAngelsReference(this,fdb);
        DatabaseReference dobRef = FirebaseReferencesUtils.getDobReference(this,fdb);
        DatabaseReference phonesRef = FirebaseReferencesUtils.getPhoneReference(this,fdb);

        mPhones = new ArrayList<>();
        phonesRef.child(mAngelId).child("0").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mPhones.add(dataSnapshot.getValue(Phone.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        phonesRef.child(mAngelId).child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mPhones.add(dataSnapshot.getValue(Phone.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        phonesRef.child(mAngelId).child("2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mPhones.add(dataSnapshot.getValue(Phone.class));
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
        final ArrayList<String> attendance = new ArrayList<>();
        reference.child(mAngelId).child("attendance").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                attendance.add(dataSnapshot.getKey());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        final Angel[] angel = {new Angel()};
        reference.child(mAngelId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAngel = dataSnapshot.getValue(Angel.class);
                updateUi(dob[0],attendance);
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
    }

    void updateUi( final String dob,ArrayList<String> attendance){
        mMainBinding.collapsingToolbar.setTitle(mAngel.getmName());
        mMainBinding.collapsingToolbar.setContentScrimColor(ContextCompat.getColor(this,R.color.colorPrimary));
        mMainBinding.iPersonInfo.iInfoSummary.tvCoinsNumber.setText(String.valueOf(mAngel.getmCoins()));
        mMainBinding.iPersonInfo.iInfoSummary.tvScoreNumber.setText(String.valueOf(mAngel.getmScore()));
        mMainBinding.iPersonInfo.iInfoSummary.tvAttendanceNumber.setText(String.valueOf(attendance.size()));
        mMainBinding.iPersonInfo.iInfoSummary.tvClassNumber.setText(String.valueOf(mAngel.getmClass()));
        mMainBinding.iPersonInfo.iMainInfo.tvAddress.setText(String.valueOf(mAngel.getmAddress()));
        mMainBinding.iPersonInfo.iMainInfo.tvBuildingNumber.setText(String.valueOf(mAngel.getmHomeNum()));
        mMainBinding.iPersonInfo.iMainInfo.tvMmyy.setText(dob.substring(0,7));
        mMainBinding.iPersonInfo.iMainInfo.tvDd.setText(dob.substring(8,10));

        mMainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent i = new Intent(AngelActivity.this,AddingAngelActivity.class);
             i.putExtra("edit",true);
             i.putExtra("id",mAngelId);
             i.putExtra("angel",mAngel);
             i.putExtra("dob",dob);
             i.putExtra("phones",mPhones);
             startActivity(i);
            }
        });
        Calendar c =Calendar.getInstance();
        CalendarDay last=CalendarDay.from(c);
        c.set(2018,0,1);
        CalendarDay first= CalendarDay.from(c);
        mMainBinding.calendarView.state().edit()
                .setMinimumDate(first)
                .setMaximumDate(last)
                .commit();

        mMainBinding.calendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE);
        mMainBinding.calendarView.setSelectionColor(ContextCompat.getColor(this,R.color.colorAccent));
        for (int i=0;i<attendance.size();i++) {
            int day=Integer.parseInt(attendance.get(i).substring(8,10));
            int month = Integer.parseInt(attendance.get(i).substring(5,7));
            int year =Integer.parseInt(attendance.get(i).substring(0,4));
            Calendar tmp =Calendar.getInstance();
            tmp.set(Calendar.MONTH, month-1);
            tmp.set(Calendar.DAY_OF_MONTH, day);
            tmp.set(Calendar.YEAR,year);
            mMainBinding.calendarView.setDateSelected(tmp,true);
        }
        mMainBinding.calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                mMainBinding.calendarView.setDateSelected(date,false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.angel_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        String tmp;
        switch (id){
            case R.id.a_m_facebook:
                tmp=mAngel.getmFacebook();
                if(!(tmp==null||tmp.equals(""))){
                    if(tmp.charAt(0)!='h')
                     tmp="https://"+tmp;
                    Uri uri = Uri.parse(tmp);
                    Intent i = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                }
                else
                    Toast.makeText(this, R.string.data_not_found,Toast.LENGTH_LONG).show();
                break;
            case R.id.a_m_call:
                tmp=mPhones.get(0).getmPhone();
                if(!(tmp==null||tmp.equals(""))){
                    Uri uri = Uri.parse("tel:" +tmp);
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(uri);
                    startActivity(i);
                }
                else
                    Toast.makeText(this, R.string.data_not_found,Toast.LENGTH_LONG).show();
                break;
            case R.id.a_m_send_msg:
                tmp=mPhones.get(0).getmPhone();
                if(!(tmp==null||tmp.equals(""))) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", tmp, null));
                    startActivity(i);
                }
                else
                    Toast.makeText(this, R.string.data_not_found,Toast.LENGTH_LONG).show();
                break;
            case R.id.a_m_call_dad:
                tmp=mPhones.get(1).getmPhone();
                if(!(tmp==null||tmp.equals(""))){
                    Uri uri = Uri.parse("tel:" +tmp);
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(uri);
                    startActivity(i);
                }
                else
                    Toast.makeText(this, R.string.data_not_found,Toast.LENGTH_LONG).show();
                break;
            case R.id.a_m_call_mam:
                tmp=mPhones.get(2).getmPhone();
                if(!(tmp==null||tmp.equals(""))) {
                    Uri uri = Uri.parse("tel:" + tmp);
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(uri);
                    startActivity(i);
                }
                else
                    Toast.makeText(this, R.string.data_not_found,Toast.LENGTH_LONG).show();
                break;
            default:
                return false;
        }
        return super.onOptionsItemSelected(item);
    }
}
