package com.vms.customer.model.loadbooking;

import com.google.gson.annotations.SerializedName;

public class LoadVechileResponse {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;

    public LoadVechileResponse(String status, String message){
        this.setStatus(status);
        this.setMessage(message);
    }

    public String getStatus() {
        return status;
    }

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
