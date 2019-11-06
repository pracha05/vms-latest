package com.vms.customer.model.verifyotp;

import com.google.gson.annotations.SerializedName;

public class VerifyOTPRequestModel {

    @SerializedName("id")
    private int id;

    @SerializedName("otp")
    private String otp;

    @SerializedName("user_otp")
    private String userOtp;

    @SerializedName("step")
    private int step;

    public VerifyOTPRequestModel(int id,String otp, String userOtp, int step){
        this.setId(id);
        this.setOtp(otp);
        this.setUserOtp(userOtp);
        this.setStep(step);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getUserOtp() {
        return userOtp;
    }

    public void setUserOtp(String userOtp) {
        this.userOtp = userOtp;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
