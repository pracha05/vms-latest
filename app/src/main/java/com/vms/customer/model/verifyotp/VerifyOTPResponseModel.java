package com.vms.customer.model.verifyotp;

import com.google.gson.annotations.SerializedName;

public class VerifyOTPResponseModel {

    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public VerifyOTPResponseModel(int id, String message){
        this.setStatus(id);
        this.setMessage(message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
