package com.vms.customer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomerSupportPojo {
    @SerializedName("Support")
    @Expose
    public List<Support> support = null;

    public class Support {

        @SerializedName("velhicleinfo")
        @Expose
        public String velhicleinfo;
        @SerializedName("capacity")
        @Expose
        public String capacity;
        @SerializedName("LoadingDateTime")
        @Expose
        public String loadingDateTime;
        @SerializedName("Duration")
        @Expose
        public String duration;
        @SerializedName("Rating")
        @Expose
        public String rating;
        @SerializedName("Price")
        @Expose
        public String price;

    }
}
