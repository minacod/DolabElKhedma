package com.example.shafy.dolabelkhedma.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.utils.NetworksUtils;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int RC_SIGN_IN = 123;
    private FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth();
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.main_activity));
    }

    public void auth(View view){
        auth();
    }

    private void auth(){
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        if(mUser==null){

            List<AuthUI.IdpConfig> providers = Collections.singletonList(
                    new AuthUI.IdpConfig.EmailBuilder().build());

            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(),
                    RC_SIGN_IN);

        }
        else isVerified();
    }
    void isVerified(){
        if(mUser.isEmailVerified())
            launchHome();

        else{
            FirebaseAuth.getInstance().getCurrentUser().reload().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    mUser=FirebaseAuth.getInstance().getCurrentUser();
                    if(mUser!=null&&mUser.isEmailVerified())
                        launchHome();
                    else {
                        if(NetworksUtils.isConnected(MainActivity.this))
                            mUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this, getString(R.string.varfication_mail_msg), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        else {
                            Toast.makeText(MainActivity.this, getString(R.string.offline_varifation_msg), Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }
    }

    void launchHome(){
        Intent i = new Intent(this,HomeActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                mUser = FirebaseAuth.getInstance().getCurrentUser();
                isVerified();
                // ...
            } else {
                Log.e(TAG,getString(R.string.failed_msg));
            }
        }
    }

}
