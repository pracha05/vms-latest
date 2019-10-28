package com.vms.customer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookingSummaryPojo {
    @SerializedName("Velhicle")
    @Expose
    public List<Velhicle> velhicle = null;


    public class Velhicle {

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
        @SerializedName("Status")
        @Expose
        public String status;

    }
}
