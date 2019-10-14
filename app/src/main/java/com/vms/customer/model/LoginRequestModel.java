package com.vms.customer.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequestModel {

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    public LoginRequestModel(String email,String password){
        this.email = email;
        this.password = password;
    }

}
