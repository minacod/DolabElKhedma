package com.example.shafy.dolabelkhedma.ui;

import android.databinding.DataBindingUtil;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.data.FirebaseDatabaseUtils;
import com.example.shafy.dolabelkhedma.databinding.ActivityAddingAngelBinding;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils.getSyncedFirebaseInstanse;

public class AddingAngelActivity extends AppCompatActivity {

    ActivityAddingAngelBinding mBinding;
    FirebaseDatabase mFdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_angel);
        mFdb = getSyncedFirebaseInstanse();
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_adding_angel);

        mBinding.etDob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
                }
            }
        });
        mBinding.rbMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    mBinding.rbFemale.setChecked(false);
            }
        });
        mBinding.rbFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    mBinding.rbMale.setChecked(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adding_angel_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.adding_angel_menu_save:
                addData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void addData(){

        String name = mBinding.etName.getText().toString();
        String add = (mBinding.etHomeNumber.getText().toString() +" "+ mBinding.etAddress.getText().toString()) ;
        String classNum = mBinding.etClass.getText().toString();
        String fbProfileUrl = mBinding.etFbProfileUrl.getText().toString();
        String coins = mBinding.etCoins.getText().toString();
        String score = mBinding.etScore.getText().toString();
        String dob =mBinding.etDob.getText().toString();
        String pFather = mBinding.etPFatherName.getText().toString();
        if(name.equals("")||add.equals("")||classNum.equals("")||coins.equals("")||score.equals("")){
            return;
        }
        boolean gender = mBinding.rbMale.isChecked();
        Angel angel =new Angel(
                name,
                add,
                gender,
                Integer.parseInt(classNum),
                fbProfileUrl,
                Integer.parseInt(coins),
                Integer.parseInt(score),
                dob,
                pFather
        );

        DatabaseReference angleData = FirebaseReferencesUtils.getAngelsReference(AddingAngelActivity.this, mFdb, gender);
        DatabaseReference SimpleAngleData = FirebaseReferencesUtils.getSimpleAngelsReference(AddingAngelActivity.this, mFdb, gender);
        FirebaseDatabaseUtils.addAngel(AddingAngelActivity.this,angleData,SimpleAngleData,angel, classNum);

    }
}
