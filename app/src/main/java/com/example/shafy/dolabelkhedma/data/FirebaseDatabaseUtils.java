package com.example.shafy.dolabelkhedma.data;

import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.model.SimpleAngel;
import com.google.firebase.database.DatabaseReference;


public class FirebaseDatabaseUtils {
    private FirebaseDatabaseUtils() {
    }

    public static boolean addAngel(DatabaseReference angelRef, DatabaseReference simpleAngelRef, Angel angel) {
        String angelId = angelRef.push().getKey();
        boolean res = angelRef.child(angelId).setValue(angel).isSuccessful();
        if(res) {
            SimpleAngel simpleAngel = new SimpleAngel(angel.getmName(), angel.ismGender(), angel.getmClass());
            return addSimpleAngel(simpleAngelRef, simpleAngel, angelId);
        } else {
            return false;
        }
    }

    public static boolean addSimpleAngel(DatabaseReference simpleAngelRef, SimpleAngel simpleAngel, String angelId) {
        return simpleAngelRef.child(angelId).setValue(simpleAngel).isSuccessful();
    }

}
