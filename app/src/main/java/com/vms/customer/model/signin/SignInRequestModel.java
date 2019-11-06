package com.vms.customer.model.signin;

import com.google.gson.annotations.SerializedName;

public class SignInRequestModel {

    @SerializedName("email")
    public String email;

    @SerializedName("step")
    public int step;

    @SerializedName("password")
    private String password;

    public SignInRequestModel(String email, int step){
        this.setEmail(email);
        this.setStep(step);
    }

    public SignInRequestModel(String email, String password,int step){
        this.setEmail(email);
        this.setPassword(password);
        this.setStep(step);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
