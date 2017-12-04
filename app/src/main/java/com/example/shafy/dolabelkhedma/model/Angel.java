package com.example.shafy.dolabelkhedma.model;


public class Angel {
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
}
