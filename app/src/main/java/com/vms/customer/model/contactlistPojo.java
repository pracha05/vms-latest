package com.vms.customer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class contactlistPojo {
    @SerializedName("Contact")
    @Expose
    public List<Contact> contact = null;


    public class Contact {

        @SerializedName("companyname")
        @Expose
        public String companyname;
        @SerializedName("nameofthecustomer")
        @Expose
        public String nameofthecustomer;
        @SerializedName("Mobilenumber")
        @Expose
        public String mobilenumber;
        @SerializedName("Emailid")
        @Expose
        public String emailid;
        @SerializedName("gstnumber")
        @Expose
        public String gstnumber;
        @SerializedName("Map")
        @Expose
        public String map;
        @SerializedName("Address")
        @Expose
        public String address;
        @SerializedName("SaveAddress")
        @Expose
        public String saveAddress;
}}