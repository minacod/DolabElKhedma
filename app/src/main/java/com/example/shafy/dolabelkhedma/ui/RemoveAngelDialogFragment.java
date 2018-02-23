package com.example.shafy.dolabelkhedma.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.data.FirebaseDatabaseUtils;
import com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by shafy on 10/12/2017.
 */

public class RemoveAngelDialogFragment extends DialogFragment {
    private String mId;
    private String mClass;
    private boolean mGender;

    public void setmId(String mId) {
        this.mId = mId;
    }
    public void setmClass(String mClass) {
        this.mClass = mClass;
    }
    public void setmGender(boolean mGender) {
        this.mGender = mGender;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(), R.style.AlertDialogCustom );
        builder.setMessage(R.string.removing_angel_dialog_msg)
                .setTitle(R.string.removing_angel_dialog_title);
        builder.setPositiveButton("اه", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                FirebaseDatabase fb = FirebaseReferencesUtils.getSyncedFirebaseInstanse();
                FirebaseStorage fs =FirebaseReferencesUtils.getFirebaseStorageInstanse();
                DatabaseReference angelRef= FirebaseReferencesUtils.getAngelsReference(getContext(),fb);
                DatabaseReference simpleAngelRef= FirebaseReferencesUtils.getSimpleAngelsReference(getContext(),fb,mGender);
                StorageReference angelStorageRef= FirebaseReferencesUtils.getAngelStorageReference(getContext(),fs);
                DatabaseReference phoneRef= FirebaseReferencesUtils.getPhoneReference(getContext(),fb);
                DatabaseReference dobRef= FirebaseReferencesUtils.getDobReference(getContext(),fb);
                FirebaseDatabaseUtils.removeAngel(getContext(),angelRef,mId, mClass,simpleAngelRef,angelStorageRef,phoneRef,dobRef);
            }
        });
        builder.setNegativeButton("لا", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        return builder.create();
    }
}
