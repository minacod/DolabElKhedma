package com.example.shafy.dolabelkhedma.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shafy on 19/10/2017.
 */

public class DolabElKhedmaDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="dolabelkhedma.db";

    private static int DATABASE_VERSION=1;

    public DolabElKhedmaDbHelper(Context c){
        super(c,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreatQuery = "create table "+ DolabElKhedmaContract.AttendanceEntry.TABLE_NAME+" ( "+
                DolabElKhedmaContract.AttendanceEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_Date+" DATE, "+
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_PERSON_ID+" INTEGER, "+
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_Class+" INTEGER, "+
                DolabElKhedmaContract.AttendanceEntry.COLUMNS_CH+" TEXT "+");";
        db.execSQL(sqlCreatQuery);

        String sqlCreatQuery2 = "create table "+ DolabElKhedmaContract.MainDataEnrty.TABLE_NAME+" ( "+
                DolabElKhedmaContract.MainDataEnrty._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                DolabElKhedmaContract.MainDataEnrty.COLUMNS_NAME+" TEXT, "+
                DolabElKhedmaContract.MainDataEnrty.COLUMNS_DOB+" DATE, "+
                DolabElKhedmaContract.MainDataEnrty.COLUMNS_GENDER+" INTEGER, "+
                DolabElKhedmaContract.MainDataEnrty.COLUMNS_Class+" INTEGER, "+
                DolabElKhedmaContract.MainDataEnrty.COLUMNS_ADDRESS+" TEXT "+");";
        db.execSQL(sqlCreatQuery2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists "+ DolabElKhedmaContract.AttendanceEntry.TABLE_NAME);
        onCreate(db);

        db.execSQL("drop table if exists "+ DolabElKhedmaContract.MainDataEnrty.TABLE_NAME);
        onCreate(db);
    }
}
