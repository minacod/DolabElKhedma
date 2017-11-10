package com.example.shafy.dolabelkhedma.data;

import android.content.Context;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.model.SimpleAngel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class FirebaseDatabaseUtils {
    private static final String TAG = FirebaseDatabaseUtils.class.getSimpleName();

    private FirebaseDatabaseUtils() {
    }

    public static void addAngel(final Context context, DatabaseReference angelRef,
                                final DatabaseReference simpleAngelRef, final Angel angel, String angelClass) {
        final String angelId = angelRef.push().getKey();

        String simpleAngel = angel.getmName();
        addSimpleAngel(simpleAngelRef, simpleAngel, angelId, angelClass);

        angelRef.child("class_" + String.valueOf(angelClass))
                .child(angelId).setValue(angel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(context, context.getString(R.string.angel_added), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static void addSimpleAngel(DatabaseReference simpleAngelRef,
                                       String simpleAngel, String angelId, String angelClass) {
        simpleAngelRef.child("class_" + angelClass).child(angelId).setValue(simpleAngel);
    }
}
