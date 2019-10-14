package com.vms.customer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TruckImgPojo  {
    @SerializedName("Banner")
    @Expose
    public List<Banner> banner = null;
    public class Banner {

        @SerializedName("image")
        @Expose
        public String image;

    }
}
