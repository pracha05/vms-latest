package com.vms.customer.model.registration;

import com.google.gson.annotations.SerializedName;

public class RegistrationResponseModel {

    @SerializedName("status")
    private String status;
    @SerializedName("id")
    private String id;
    @SerializedName("otp")
    private String otp;
    @SerializedName("message")
    private String message;
    @SerializedName("user_otp")
    private String userOtp;

    public RegistrationResponseModel(String status, String id, String otp, String message, String userOtp){
        this.setStatus(status);
        this.setId(id);
        this.setOtp(otp);
        this.setMessage(message);
        this.setUserOtp(userOtp);
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
