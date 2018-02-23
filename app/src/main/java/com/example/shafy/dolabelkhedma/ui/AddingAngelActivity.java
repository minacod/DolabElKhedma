package com.example.shafy.dolabelkhedma.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.shafy.dolabelkhedma.R;
import com.example.shafy.dolabelkhedma.data.FirebaseDatabaseUtils;
import com.example.shafy.dolabelkhedma.databinding.ActivityAddingAngelBinding;
import com.example.shafy.dolabelkhedma.model.Angel;
import com.example.shafy.dolabelkhedma.model.Phone;
import com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import static com.example.shafy.dolabelkhedma.utils.FirebaseReferencesUtils.getSyncedFirebaseInstanse;

public class AddingAngelActivity extends AppCompatActivity {

    ActivityAddingAngelBinding mBinding;
    FirebaseDatabase mFdb;
    Bitmap mProfileImage;
    String mClassNum;
    private String mAngelId;
    private Angel mAngel;
    private ArrayList<Phone> mPhones;
    private String mDob;
    private boolean mEditAngel;
    public static final int PICK_IMAGE = 1;
    private static final int REQUEST_STORAGE_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_angel);
        mFdb = getSyncedFirebaseInstanse();
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_adding_angel);

        Intent i = getIntent();
        mEditAngel = i.getBooleanExtra("edit",false);
        mAngelId = i.getStringExtra("id");
        mAngel = i.getParcelableExtra("angel");
        mDob = i.getStringExtra("dob");
        mPhones = i.getParcelableArrayListExtra("phones");

        mClassNum="1";
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ClassesList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBinding.etClass.setAdapter(adapter);
        mBinding.etClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mClassNum=String.valueOf(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

        mBinding.ivAngelPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(AddingAngelActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

                    // If you do not have permission, request it
                    ActivityCompat.requestPermissions(AddingAngelActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            REQUEST_STORAGE_PERMISSION);
                } else {
                    // Launch the camera if the permission exists
                    launchGallary();
                }

            }
        });
        if(mAngel!=null)
            updateUi();

        mBinding.etDob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    DialogFragment newFragment = new DatePickerFragment();
                    newFragment.show(getSupportFragmentManager(), "datePicker");
                }
            }
        });
    }
    private void updateUi(){

        mBinding.etName.setText(mAngel.getmName());
        mBinding.etHomeNumber.setText(String.valueOf(mAngel.getmHomeNum()));
        mBinding.etAddress.setText(mAngel.getmAddress());
        mBinding.etFbProfileUrl.setText(mAngel.getmFacebook());
        mBinding.etCoins.setText(String.valueOf(mAngel.getmCoins()));
        mBinding.etScore.setText(String.valueOf(mAngel.getmScore()));
        mBinding.etDob.setFocusable(false);
        mBinding.etDob.setText(mDob);
        mBinding.etPFatherName.setText(mAngel.getmFather());
        mBinding.etDob.setFocusable(true);
        mBinding.etAngelPhone.setText(mPhones.get(0).getmPhone());
        mBinding.etDadPhone.setText(mPhones.get(1).getmPhone());
        mBinding.etMomPhone.setText(mPhones.get(2).getmPhone());
        mBinding.rbMale.setChecked(mAngel.ismGender());
        mBinding.rbFemale.setChecked(!mAngel.ismGender());
        mBinding.etClass.setSelection(mAngel.getmClass()-1);

    }
    private void launchGallary(){
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

        startActivityForResult(chooserIntent, PICK_IMAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_STORAGE_PERMISSION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // If you get permission, launch the camera
                    launchGallary();
                } else {
                    // If you do not get permission, show a Toast
                    Toast.makeText(this, R.string.permission_denied, Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE && data!=null) {
            Uri imageUri = data.getData();

            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(imageUri, filePath, null, null, null);
            cursor.moveToFirst();
            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            mProfileImage = BitmapFactory.decodeFile(imagePath, options);
            mBinding.ivAngelPhoto.setImageBitmap(mProfileImage);

            cursor.close();
        }
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
        String homeNum = mBinding.etHomeNumber.getText().toString();
        String add = mBinding.etAddress.getText().toString() ;
        String fbProfileUrl = mBinding.etFbProfileUrl.getText().toString();
        String coins = mBinding.etCoins.getText().toString();
        String score = mBinding.etScore.getText().toString();
        String dob =mBinding.etDob.getText().toString();
        String pFather = mBinding.etPFatherName.getText().toString();
        Phone[] phones = new Phone[3];
        phones[0] = new Phone( "angel",mBinding.etAngelPhone.getText().toString());
        phones[1] = new Phone( "dad",mBinding.etDadPhone.getText().toString());
        phones[2] = new Phone( "mom",mBinding.etMomPhone.getText().toString());
        // for future
        //
        /*
        for(int i=0;i<3;i++)
           // phones[i]=new Phone( ,mBinding.etAngelPhone.getText().toString());
        */

        boolean gender = mBinding.rbMale.isChecked();

        if(name.equals("")||homeNum.equals("")||add.equals("")||mClassNum.equals("")||coins.equals("")||score.equals("")){
            Toast.makeText(this,"بيانات غير مكتمله",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            mBinding.etName.setText("");
            mBinding.etHomeNumber.setText("");
            mBinding.etAddress.setText("");
            mBinding.etFbProfileUrl.setText("");
            mBinding.etCoins.setText("");
            mBinding.etScore.setText("");
            mBinding.etDob.setText("");
            mBinding.etPFatherName.setText("");
            mBinding.etAngelPhone.setText("");
            mBinding.etDadPhone.setText("");
            mBinding.etMomPhone.setText("");
            mBinding.ivAngelPhoto.setImageResource(R.drawable.contact_avatar);
        }
        Angel angel =new Angel(
                name,
                Integer.parseInt(homeNum),
                add,
                gender,
                Integer.parseInt(mClassNum),
                fbProfileUrl,
                Integer.parseInt(coins),
                Integer.parseInt(score),
                pFather
        );

        FirebaseStorage mFS=FirebaseReferencesUtils.getFirebaseStorageInstanse();
        StorageReference sr = FirebaseReferencesUtils.getAngelStorageReference(AddingAngelActivity.this,mFS);

        DatabaseReference angleData= FirebaseReferencesUtils.getAngelsReference(AddingAngelActivity.this, mFdb);
        DatabaseReference SimpleAngleData=FirebaseReferencesUtils.getSimpleAngelsReference(AddingAngelActivity.this,
                mFdb,gender);
        DatabaseReference phoneData= FirebaseReferencesUtils.getPhoneReference(AddingAngelActivity.this,mFdb);
        DatabaseReference dobData = FirebaseReferencesUtils.getDobReference(AddingAngelActivity.this,mFdb);
        if(!mEditAngel){
            FirebaseDatabaseUtils.addAngel(AddingAngelActivity.this,
                    angleData,SimpleAngleData,
                    angel,
                    sr,mProfileImage,phoneData,phones,
                    dobData,dob);
        }
        else {
            FirebaseDatabaseUtils.editAngel(AddingAngelActivity.this,
                    angleData,mAngelId,SimpleAngleData,
                    angel,String.valueOf(mAngel.getmClass()),
                    sr,mProfileImage,phoneData,phones,
                    dobData,dob);
        }
    }


}
