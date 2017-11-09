package com.example.shafy.dolabelkhedma.utils;

import android.content.Context;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.model.SimpleAngel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class FirebaseReferencesUtils {
    private FirebaseReferencesUtils() {
    }
    private static FirebaseDatabase  mFDB;
    public static FirebaseDatabase getSyncedFirebaseInstanse() {
        if(mFDB==null){
            mFDB = FirebaseDatabase.getInstance();
            mFDB.setPersistenceEnabled(true);
        }
        return mFDB;
    }

    public static DatabaseReference getAngelsReference(Context context, FirebaseDatabase fdb) {
        DatabaseReference angelsRef = fdb.getReference(context.getString(R.string.firebase_angel));
        angelsRef.keepSynced(true);
        return angelsRef;
    }

    public static DatabaseReference getAttendanceReference(Context context, FirebaseDatabase fdb) {
        DatabaseReference attendanceRef = fdb.getReference(context.getString(R.string.firebase_attendance));
        attendanceRef.keepSynced(true);
        return attendanceRef;
    }
    public static DatabaseReference getPhoneReference(Context context, FirebaseDatabase fdb) {
        DatabaseReference phoneRef = fdb.getReference(context.getString(R.string.firebase_phone));
        phoneRef.keepSynced(true);
        return phoneRef;
    }

    private static ChildEventListener getAngelsRefListener(final HashMap<String, Angel> angelsMap,
                                                          final ArrayList<String> angelsIds) {
        return new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Angel newAngel = dataSnapshot.getValue(Angel.class);
                String angelId = dataSnapshot.getKey();

                angelsMap.put(angelId, newAngel);
                angelsIds.add(angelId);
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
        };
    }

    public static DatabaseReference getSimpleAngelsReference(Context context, FirebaseDatabase fdb) {
        DatabaseReference simpleAngelsRef = fdb.getReference(context.getString(R.string.firebase_simpleAngle));
        simpleAngelsRef.keepSynced(true);
        return simpleAngelsRef;
    }

    private static ChildEventListener getSimpleAngelsRefListener(final HashMap<String, SimpleAngel> simpleAngelsMap,
                                                           final ArrayList<String> simpleAngelsIds) {
        return new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                SimpleAngel newSimpleAngel = dataSnapshot.getValue(SimpleAngel.class);
                String simpleAngelId = dataSnapshot.getKey();

                simpleAngelsMap.put(simpleAngelId, newSimpleAngel);
                simpleAngelsIds.add(simpleAngelId);
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
        };
    }
}
