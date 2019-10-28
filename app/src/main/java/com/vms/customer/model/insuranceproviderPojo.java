package com.vms.customer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class insuranceproviderPojo {
    @SerializedName("Insurance")
    @Expose
    public List<Insurance> insurance = null;
    public class Insurance {

        @SerializedName("Policynumber")
        @Expose
        public String policynumber;
        @SerializedName("Ordernumber")
        @Expose
        public String ordernumber;
        @SerializedName("Datepick")
        @Expose
        public String datepick;
        @SerializedName("Pickupplace")
        @Expose
        public String pickupplace;
        @SerializedName("Dropingplace")
        @Expose
        public String dropingplace;
        @SerializedName("Insuranceamount")
        @Expose
        public String insuranceamount;
        @SerializedName("Invoiceamount")
        @Expose
        public String invoiceamount;
        @SerializedName("Vadility")
        @Expose
        public String vadility;

    }
}
