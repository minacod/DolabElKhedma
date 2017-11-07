package com.example.shafy.dolabelkhedma.model;


public class SimpleAngel {

    private String mName;
    private boolean mGender;
    private int mClassNum;

    public SimpleAngel() {
    }

    public SimpleAngel(String name, boolean gender, int classNum) {
        this.mName = name;
        this.mGender = gender;
        this.mClassNum = classNum;
    }

    public String getName() {
        return mName;
    }

    public boolean isGender() {
        return mGender;
    }

    public void setGender(boolean gender) {
        this.mGender = gender;
    }

    public int getClassNum() {
        return mClassNum;
    }

    public void setClassNum(int classNum) {
        this.mClassNum= classNum;
    }
}
