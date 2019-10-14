package com.vms.customer.model;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordRequestModel {
    @SerializedName("id")
    public String id;
    @SerializedName("password")
    public String password;
    @SerializedName("confirm_password")
    public String confirmPassword;
}
