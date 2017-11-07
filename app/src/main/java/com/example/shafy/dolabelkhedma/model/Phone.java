package com.example.shafy.dolabelkhedma.model;

/**
 * Created by rev on 31/10/17.
 */

public class Phone {
    private String mAngelId;
    private String mPhoneOwner;
    private String mPhone;

    public Phone(String mAngelId, String mPhoneOwner, String mPhone) {
        this.mAngelId = mAngelId;
        this.mPhoneOwner = mPhoneOwner;
        this.mPhone = mPhone;
    }

    public String getmAngelId() {
        return mAngelId;
    }

    public void setmAngelId(String mAngelId) {
        this.mAngelId = mAngelId;
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
}
