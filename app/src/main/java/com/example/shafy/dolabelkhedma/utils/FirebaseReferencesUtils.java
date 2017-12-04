package com.example.shafy.dolabelkhedma.utils;

import android.content.Context;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;

public class FirebaseReferencesUtils {
    private static FirebaseDatabase mFDB;
    private static DatabaseReference angelsRef;
    private static DatabaseReference maleSimpleAngelsRef;
    private static DatabaseReference femaleSimpleAngelsRef;
    private static DatabaseReference maleAngelsAttendanceRef;
    private static DatabaseReference femaleAngelsAttendanceRef;
    private static DatabaseReference phoneRef;
    private static DatabaseReference dobRef;
    private static FirebaseStorage mFS;

    private FirebaseReferencesUtils() {
    }

    public static FirebaseDatabase getSyncedFirebaseInstanse() {
        if (mFDB == null) {
            mFDB = FirebaseDatabase.getInstance();
            mFDB.setPersistenceEnabled(true);
        }
        return mFDB;
    }

    public static DatabaseReference getAngelsReference(Context context, FirebaseDatabase fdb) {

        if (angelsRef==null) {
            angelsRef = fdb.getReference(context.getString(R.string.firebase_angel));
        }
        return angelsRef;
    }

    public static FirebaseStorage getFirebaseStorageInstanse() {
        if(mFS==null){
            mFS = FirebaseStorage.getInstance();
        }
        return mFS;
    }

    public static DatabaseReference getDobReference(Context context, FirebaseDatabase fdb) {
        if(dobRef==null){
            dobRef = fdb.getReference(context.getString(R.string.firebase_dob));
            dobRef.keepSynced(true);
        }
        return dobRef;
    }
    public static DatabaseReference getPhoneReference(Context context, FirebaseDatabase fdb) {
        if(phoneRef==null) {
            phoneRef = fdb.getReference(context.getString(R.string.firebase_phone));
            phoneRef.keepSynced(true);
        }
        return phoneRef;
    }
    public static StorageReference getAngelStorageReference(Context context,FirebaseStorage fs){
        return fs.getReference().child(context.getString(R.string.firebase_angel));
    }

    public static DatabaseReference getSimpleAngelsReference(Context context, FirebaseDatabase fdb, boolean gender) {
        DatabaseReference simpleAngelsRef;
        if(gender) {
            simpleAngelsRef = getMaleSimpleAngelsRef(context, fdb);
        } else {
            simpleAngelsRef = getFemaleSimpleAngelsRef(context, fdb);
        }
        simpleAngelsRef.keepSynced(true);
        return simpleAngelsRef;
    }

    private static DatabaseReference getMaleSimpleAngelsRef(Context context, FirebaseDatabase fdb) {
        if (maleSimpleAngelsRef == null) {
            maleSimpleAngelsRef = fdb.getReference(context.getString(R.string.firebase_maleSimpleAngle));
        }
        return maleSimpleAngelsRef;
    }

    private static DatabaseReference getFemaleSimpleAngelsRef(Context context, FirebaseDatabase fdb) {
        if (femaleSimpleAngelsRef== null) {
            femaleSimpleAngelsRef = fdb.getReference(context.getString(R.string.firebase_femaleSimpleAngle));
        }
        return femaleSimpleAngelsRef;
    }

    public static DatabaseReference getAngelsAttendanceReference(Context context, FirebaseDatabase fdb, boolean gender) {
        DatabaseReference angelsAttendanceRef;
        if(gender) {
            angelsAttendanceRef = getMaleAngelsAttendanceRef(context, fdb);
        } else {
            angelsAttendanceRef = getFemaleAngelsAttendanceRef(context, fdb);
        }
        angelsAttendanceRef.keepSynced(true);
        return angelsAttendanceRef;
    }

    private static DatabaseReference getMaleAngelsAttendanceRef(Context context, FirebaseDatabase fdb) {
        if (maleAngelsAttendanceRef == null) {
            maleAngelsAttendanceRef = fdb.getReference(context.getString(R.string.firebase_male_attendance));
        }
        return maleAngelsAttendanceRef;
    }

    private static DatabaseReference getFemaleAngelsAttendanceRef(Context context, FirebaseDatabase fdb) {
        if (femaleAngelsAttendanceRef== null) {
            femaleAngelsAttendanceRef = fdb.getReference(context.getString(R.string.firebase_female_attendance));
        }
        return femaleAngelsAttendanceRef;
    }
}
