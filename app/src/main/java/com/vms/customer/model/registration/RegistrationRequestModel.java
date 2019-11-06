package com.vms.customer.model.registration;

import com.google.gson.annotations.SerializedName;

public class RegistrationRequestModel {

    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("account_type")
    private String accountType;
    @SerializedName("step")
    private int step;
    @SerializedName("gst")
    private String gst;
    @SerializedName("id")
    private String id;
    @SerializedName("otp")
    private String otp;
    @SerializedName("user_otp")
    private String userOtp;

    public RegistrationRequestModel(String otp, String userOtp,int step){
        this.setOtp(otp);
        this.setUserOtp(userOtp);
        this.setStep(step);
    }

    public RegistrationRequestModel(String email, String password, String mobile,
                                    String accountType, int step, String gst  ){
        this.setEmail(email);
        this.setPassword(password);
        this.setMobile(mobile);
        this.setAccountType(accountType);
        this.setStep(step);
        this.setGst(gst);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
