package com.example.shafy.dolabelkhedma.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;

import com.example.shafy.dolabelkhedma.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;
import java.util.Date;

public class AngelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_angel);

        Calendar c =Calendar.getInstance();
        CalendarDay last=CalendarDay.from(c);
        c.set(2016,11,11);
        CalendarDay first= CalendarDay.from(c);
        MaterialCalendarView mcv=(MaterialCalendarView)findViewById(R.id.calendarView);
        mcv.state().edit()
                .setMinimumDate(first)
                .setMaximumDate(last)
                .commit();
    }
}
