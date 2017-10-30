package com.example.shafy.dolabelkhedma.model;

/**
 * Created by shafy on 30/10/2017.
 */

public class SimpleAngel {

    private String name;
    private boolean gender;
    private int classNum;

    public SimpleAngel(String name, boolean gender, int classNum) {
        this.name = name;
        this.gender = gender;
        this.classNum = classNum;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }
}
