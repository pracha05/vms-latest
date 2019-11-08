package com.vms.customer.model.searchvehicle;

import com.google.gson.annotations.SerializedName;

public class SearchVehicleResponseModel {
    @SerializedName("status")
    public String status;
    @SerializedName("vehicles")
    public String vehicles;
    @SerializedName("message")
    public String message;
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("body_type")
    public String bodyType;
    @SerializedName("images")
    public String images;
    @SerializedName("size")
    public String size;
    @SerializedName("capacity")
    public String capacity;
    @SerializedName("location")
    public String location;

}
