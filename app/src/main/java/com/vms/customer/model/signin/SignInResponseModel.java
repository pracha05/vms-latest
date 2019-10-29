package com.vms.customer.model.signin;

import com.google.gson.annotations.SerializedName;

public class SignInResponseModel {

    @SerializedName("status")
    public String status;

    @SerializedName("message")
    public String message;

//    public SignInResponseModel(String status , String message){
//        this.setStatus(status);
//        this.setMessage(message);
//    }
//
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
}
