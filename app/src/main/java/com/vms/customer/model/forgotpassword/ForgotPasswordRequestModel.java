package com.vms.customer.model.forgotpassword;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordRequestModel {
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("step")
    private String step;
    @SerializedName("otp")
    private String otp;
    @SerializedName("message")
    private String message;
    @SerializedName("id")
    private String id;
    @SerializedName("password")
    private String password;
    @SerializedName("confirm_password")
    private String confirmPassword;
    @SerializedName("user_otp")
    private String userOtp;

    public ForgotPasswordRequestModel(String mobile, String step, String otp, String message,
                                      String id, String password, String confirmPassword, String userOtp){
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

    public void setStep(String step) {
        this.step = step;
    }

    public void setOtp(String otp) { this.otp = otp; }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(String id) {
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
