package com.example.shafy.dolabelkhedma.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.model.Phone;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;


public class FirebaseDatabaseUtils {
    private static final String TAG = FirebaseDatabaseUtils.class.getSimpleName();

    private FirebaseDatabaseUtils() {
    }

    public static void addAngel(final Context context, DatabaseReference angelRef,
                                final DatabaseReference simpleAngelRef,final Angel angel,String angelClass,
                                StorageReference storageRef,Bitmap profileImage,
                                final DatabaseReference phoneRef, Phone[] phones,
                                DatabaseReference dobRef,String dob) {

        final String angelId = angelRef.push().getKey();
        if(phoneRef!=null)
            addProfileImage(context,storageRef,profileImage,angelId);

        addDob(dobRef,angelId,dob);

        addPhoneNumber(phoneRef,angelId,phones);

        String simpleAngel = angel.getmName();
        addSimpleAngel(simpleAngelRef, simpleAngel, angelId, angelClass);

        angelRef.child(angelId).setValue(angel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(context, context.getString(R.string.angel_added), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static void addPhoneNumber(DatabaseReference phoneRef,String id,Phone[] phones){
        for (int i=0;i<phones.length;i++)
        phoneRef.child(id).child(String.valueOf(i)).setValue(phones[i]);
    }
    private static void addDob(DatabaseReference dobRef,String id,String dob){
        dobRef.child(id).setValue(dob);
    }

    private static void addProfileImage(final Context context, StorageReference sr, Bitmap profileImage, String id){
        if(profileImage!=null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            profileImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] data = baos.toByteArray();
            UploadTask uploadTask = sr.child(id).child("pp").putBytes(data);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploads
                    int errorCode = ((StorageException) exception).getErrorCode();
                    String errorMessage = exception.getMessage();
                    Log.e("upload error : ", errorMessage);
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // TODO inform user
                }
            });
        }
    }

    private static void addSimpleAngel(DatabaseReference simpleAngelRef,
                                       String simpleAngel, String angelId, String angelClass) {
        simpleAngelRef.child("class_" + angelClass).child(angelId).setValue(simpleAngel);
    }

    public static void addAngelAttendance(DatabaseReference angelAttendanceRef,DatabaseReference angelRef,
                                       String simpleAngel, String angelId, String angelClass,String date) {
        angelRef.child(angelId).child("attendance").child(date).setValue(true);
        angelAttendanceRef.child(date).child("class_"+String.valueOf(angelClass)).child(angelId).setValue(simpleAngel);
    }

    public static void removeAngelAttendance(DatabaseReference angelAttendanceRef,DatabaseReference angelRef,
                                          String simpleAngel, String angelId, String angelClass,String date) {
        angelRef.child(angelId).child("attendance").child(date).removeValue();
        angelAttendanceRef.child(date).child("class_"+String.valueOf(angelClass)).child(angelId).removeValue();
    }

}
