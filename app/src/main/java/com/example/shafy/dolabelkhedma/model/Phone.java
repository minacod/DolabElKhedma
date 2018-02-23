package com.example.shafy.dolabelkhedma.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rev on 31/10/17.
 */

public class Phone implements Parcelable {
    private String mPhoneOwner;
    private String mPhone;

    public Phone(String mPhoneOwner, String mPhone) {
        this.mPhoneOwner = mPhoneOwner;
        this.mPhone = mPhone;
    }

    public Phone() {
    }

    public String getmPhoneOwner() {
        return mPhoneOwner;
    }

    public void setmPhoneOwner(String mPhoneOwner) {
        this.mPhoneOwner = mPhoneOwner;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPhone);
        dest.writeString(mPhoneOwner);
    }

    public Phone(Parcel source) {
        this.mPhone = source.readString();
        this.mPhoneOwner = source.readString();
    }

    public static final Parcelable.Creator<Phone> CREATOR
            = new Parcelable.Creator<Phone>(){
        @Override
        public Phone createFromParcel(Parcel source) {
            return new Phone(source);
        }

        @Override
        public Phone[] newArray(int size) {
            return new Phone[size];
        }
    };
}
