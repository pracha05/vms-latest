package com.vms.customer.model.forgotpassword;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordRequestModel {
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("step")
    private int step;
    @SerializedName("otp")
    private String otp;
    @SerializedName("message")
    private String message;
    @SerializedName("id")
    private int id;
    @SerializedName("password")
    private String password;
    @SerializedName("confirm_password")
    private String confirmPassword;
    @SerializedName("user_otp")
    private String userOtp;

    public ForgotPasswordRequestModel(String mobile){
        this.setMobile(mobile);
    }

    public ForgotPasswordRequestModel(String mobile, int step){
        this.setMobile(mobile);
        this.setStep(step);
    }

    public ForgotPasswordRequestModel(int id,String otp, String userOtp,int step){
        this.setId(id);
        this.setOtp(otp);
        this.setUserOtp(userOtp);
        this.setStep(step);
    }

    public ForgotPasswordRequestModel(String mobile, int step, String otp, String message,
                                      int id, String password, String confirmPassword, String userOtp){
        this.setMobile(mobile);
        this.setStep(step);
        this.setOtp(otp);
        this.setMessage(message);
        this.setId(id);
        this.setPassword(password);
        this.setConfirmPassword(confirmPassword);
        this.setUserOtp(userOtp);
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void setOtp(String otp) { this.otp = otp; }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public void setUserOtp(String userOtp) {
        this.userOtp = userOtp;
    }
}
