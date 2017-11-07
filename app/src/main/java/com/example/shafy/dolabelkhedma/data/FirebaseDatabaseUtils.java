package com.example.shafy.dolabelkhedma.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.model.SimpleAngel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;


public class FirebaseDatabaseUtils {
    private static final String TAG = FirebaseDatabaseUtils.class.getSimpleName();

    private FirebaseDatabaseUtils() {
    }

    public static void addAngel(final Context context, DatabaseReference angelRef, final DatabaseReference simpleAngelRef, final Angel angel) {
        final String angelId = angelRef.push().getKey();
        angelRef.child(angelId).setValue(angel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                SimpleAngel simpleAngel = new SimpleAngel(angel.getmName(), angel.ismGender(), angel.getmClass());
                addSimpleAngel(context, simpleAngelRef, simpleAngel, angelId);
            }
        });
    }

    private static void addSimpleAngel(final Context contex, DatabaseReference simpleAngelRef, SimpleAngel simpleAngel, String angelId) {
        simpleAngelRef.child(angelId).setValue(simpleAngel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(contex, contex.getString(R.string.angel_added), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
