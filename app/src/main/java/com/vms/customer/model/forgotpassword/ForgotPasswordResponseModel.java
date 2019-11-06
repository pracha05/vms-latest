package com.vms.customer.model.forgotpassword;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordResponseModel {

    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;

    public ForgotPasswordResponseModel(String status, String messgae){
        this.setStatus(status);
        this.setMessage(getMessage());
    }


    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
