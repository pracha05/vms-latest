package com.vms.customer.model;

import com.google.gson.annotations.SerializedName;

public class UserRegistrationRequestModel {

    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("mobile")
    public String mobile;
    @SerializedName("account_type")
    public String accountType;
}
