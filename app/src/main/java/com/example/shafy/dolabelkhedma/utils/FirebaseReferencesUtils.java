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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;

public class FirebaseReferencesUtils {
    private static FirebaseDatabase mFDB;
    private static DatabaseReference maleAngelsRef;
    private static DatabaseReference femaleAngelsRef;
    private static DatabaseReference maleSimpleAngelsRef;
    private static DatabaseReference femaleSimpleAngelsRef;

    private FirebaseReferencesUtils() {
    }

    private static FirebaseStorage mFS;

    public static FirebaseDatabase getSyncedFirebaseInstanse() {
        if (mFDB == null) {
            mFDB = FirebaseDatabase.getInstance();
            mFDB.setPersistenceEnabled(true);
        }
        return mFDB;
    }

    public static DatabaseReference getAngelsReference(Context context, FirebaseDatabase fdb, boolean gender) {
        DatabaseReference angelsRef;
        if (gender) {
            angelsRef = getMaleAngelsRef(context, fdb);
        } else {
            angelsRef = getFemaleAngelsRef(context, fdb);
        }
        return angelsRef;
    }


    public static FirebaseStorage getFirebaseStorageInstanse() {
        if(mFS==null){
            mFS = FirebaseStorage.getInstance();
        }
        return mFS;
    }

    public static DatabaseReference getAngelsReference(Context context, FirebaseDatabase fdb) {
        DatabaseReference angelsRef = fdb.getReference(context.getString(R.string.firebase_angel));
        angelsRef.keepSynced(true);
        return angelsRef;
    }

    private static DatabaseReference getMaleAngelsRef(Context context, FirebaseDatabase fdb) {
        if(maleAngelsRef == null) {
            maleAngelsRef = fdb.getReference(context.getString(R.string.firebase_maleangel));
        }
        return maleAngelsRef;
    }

    private static DatabaseReference getFemaleAngelsRef(Context context, FirebaseDatabase fdb) {
        if(femaleAngelsRef == null) {
            femaleAngelsRef = fdb.getReference(context.getString(R.string.firebase_femaleangel));
        }
        return maleAngelsRef;
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
    public static StorageReference getAngelStorageReference(Context context,FirebaseStorage fs){
        return fs.getReference().child(context.getString(R.string.firebase_angel));
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
        return maleAngelsRef;
    }

    private static DatabaseReference getFemaleSimpleAngelsRef(Context context, FirebaseDatabase fdb) {
        if (femaleSimpleAngelsRef== null) {
            femaleSimpleAngelsRef = fdb.getReference(context.getString(R.string.firebase_femaleSimpleAngle));
        }
        return femaleSimpleAngelsRef;
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
