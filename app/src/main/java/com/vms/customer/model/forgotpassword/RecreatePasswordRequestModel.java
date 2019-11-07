package com.vms.customer.model.forgotpassword;

import com.google.gson.annotations.SerializedName;

public class RecreatePasswordRequestModel {

    @SerializedName("password")
    public String password;

    @SerializedName("confirm_password")
    public String confPassword;

    @SerializedName("step")
    private int step;


    public RecreatePasswordRequestModel(String password, String confPassword,int step){
        this.setPassword(password);
        this.setConfPassword(confPassword);
        this.setStep(step);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
