package com.vms.customer.model.bookload;

import com.google.gson.annotations.SerializedName;

public class BookLoadRequestModel {
    @SerializedName("name")
    private String name;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("vehicles")
    private int[] vehicles;
    @SerializedName("material")
    private String material;
    @SerializedName("date")
    private String date;
    @SerializedName("departuretime")
    private String departureTime;
    @SerializedName("arrivaltime")
    private String arrivalTime;
    @SerializedName("total")
    private int total;

    public BookLoadRequestModel(String name, String mobile, int[] vehicles, String material,
                                String date,String departureTime,String arrivalTime,int total){

        this.setName(name);
        this.setMobile(mobile);
        this.setVehicles(vehicles);
        this.setMaterial(material);
        this.setDate(date);
        this.setDepartureTime(departureTime);
        this.setArrivaltime(arrivalTime);
        this.setTotal(total);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(int[] vehicles) {
        this.vehicles = vehicles;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivaltime() {
        return arrivalTime;
    }

    public void setArrivaltime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
