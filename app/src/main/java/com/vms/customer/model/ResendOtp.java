package com.vms.customer.model;

import com.google.gson.annotations.SerializedName;

public class ResendOtp {
    @SerializedName("mobile")
    public String mobile;

    public ResendOtp(String mobile){
        this.mobile = mobile;
    }
}
