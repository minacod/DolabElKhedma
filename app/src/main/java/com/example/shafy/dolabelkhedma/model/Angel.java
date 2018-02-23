package com.example.shafy.dolabelkhedma.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Angel implements Parcelable{
    private String mName;
    private int mHomeNum;
    private String mAddress;
    private boolean mGender;
    private int mClass;
    private String mFacebook;
    private int mCoins;
    private int mScore;
    private String mFather;
    private int mLastScore;

    public Angel() {
    }

    public Angel(String mName,int homeNum,String mAddress, boolean mGender, int mClass, String mFacebook, int mCoins, int mScore, String mFather) {
        this.mName = mName;
        this.mHomeNum = homeNum;
        this.mAddress = mAddress;
        this.mGender = mGender;
        this.mClass = mClass;
        this.mFacebook = mFacebook;
        this.mCoins = mCoins;
        this.mScore = mScore;
        this.mFather = mFather;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public boolean ismGender() {
        return mGender;
    }

    public void setmGender(boolean mGender) {
        this.mGender = mGender;
    }

    public int getmClass() {
        return mClass;
    }

    public void setmClass(int mClass) {
        this.mClass = mClass;
    }

    public String getmFacebook() {
        return mFacebook;
    }

    public void setmFacebook(String mFacebook) {
        this.mFacebook = mFacebook;
    }

    public int getmCoins() {
        return mCoins;
    }

    public void setmCoins(int mCoins) {
        this.mCoins = mCoins;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

    public String getmFather() {
        return mFather;
    }

    public void setmFather(String mFather) {
        this.mFather = mFather;
    }

    public int getmHomeNum() {
        return mHomeNum;
    }

    public void setmHomeNum(int mHomeNum) {
        this.mHomeNum = mHomeNum;
    }

    public int getmLastScore() {
        return mLastScore;
    }

    public void setmLastScore(int mLastScore) {
        this.mLastScore = mLastScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mHomeNum);
        dest.writeString(mAddress);
        if(mGender)
            dest.writeInt(1);
        else
            dest.writeInt(0);
        dest.writeInt(mClass);
        dest.writeString(mFacebook);
        dest.writeInt(mCoins);
        dest.writeInt(mScore);
        dest.writeString(mFather);

    }

    public Angel(Parcel source) {

        this.mName = source.readString();
        this.mHomeNum = source.readInt();
        this.mAddress = source.readString();
        this.mGender = source.readInt() == 1;
        this.mClass = source.readInt();
        this.mFacebook = source.readString();
        this.mCoins = source.readInt();
        this.mScore = source.readInt();
        this.mFather = source.readString();

    }

    public static final Parcelable.Creator<Angel> CREATOR
            = new Parcelable.Creator<Angel>(){
        @Override
        public Angel createFromParcel(Parcel source) {
            return new Angel(source);
        }

        @Override
        public Angel[] newArray(int size) {
            return new Angel[size];
        }
    };
}
