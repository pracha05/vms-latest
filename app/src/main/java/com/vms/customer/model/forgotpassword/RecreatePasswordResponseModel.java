package com.vms.customer.model.forgotpassword;

import com.google.gson.annotations.SerializedName;

public class RecreatePasswordResponseModel {

    @SerializedName("status")
    private int status;

    @SerializedName("message")
    private String message;

    public RecreatePasswordResponseModel(int status , String message){
        this.setStatus(status);
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
