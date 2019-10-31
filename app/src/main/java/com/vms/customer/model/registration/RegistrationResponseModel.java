package com.vms.customer.model.registration;

import com.google.gson.annotations.SerializedName;

public class RegistrationResponseModel {

    @SerializedName("status")
    public int status;
    @SerializedName("id")
    public int id;
    @SerializedName("otp")
    public String otp;
    @SerializedName("message")
    public String message;
    @SerializedName("user_otp")
    public String userOtp;

    public RegistrationResponseModel(int status, int id, String otp, String message, String userOtp){
        this.setStatus(status);
        this.setId(id);
        this.setOtp(otp);
        this.setMessage(message);
        this.setUserOtp(userOtp);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserOtp() {
        return userOtp;
    }

    public void setUserOtp(String userOtp) {
        this.userOtp = userOtp;
    }
}
