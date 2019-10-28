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
    private String step;
    @SerializedName("gst")
    private String gst;

    public RegistrationRequestModel(String email, String password, String mobile,
                                    String accountType, String step, String gst  ){
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

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }
}
