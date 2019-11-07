package com.vms.customer.model.forgotpassword;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordResponseModel {

    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("id")
    private int id;
    @SerializedName("otp")
    private String otp;



    public ForgotPasswordResponseModel(int status, String message,int id,String otp){
        this.setStatus(status);
        this.setMessage(message);
        this.setId(id);
        this.setOtp(otp);
    }


    public int getStatus() { return status; }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
