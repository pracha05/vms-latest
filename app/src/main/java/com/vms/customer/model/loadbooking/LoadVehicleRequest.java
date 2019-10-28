package com.vms.customer.model.loadbooking;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LoadVehicleRequest {

    @SerializedName("name")
    private String name;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("material")
    private String material;

    @SerializedName("date")
    private String date;

    @SerializedName("departuretime")
    private String departuretime;

    @SerializedName("arrivaltime")
    private String arrivaltime;

    @SerializedName("total")
    private String total;

    @SerializedName("age")
    private ArrayList<Integer> vehicleId;

    public LoadVehicleRequest(String name, String mobile, String material,
                              String date, String departuretime, String arrivaltime, String total,
                              ArrayList<Integer> vehicleId){
        this.setName(name);
        this.setMobile(mobile);
        this.setMaterial(material);
        this.setDate(date);
        this.setDeparturetime(departuretime);
        this.setArrivaltime(arrivaltime);
        this.setTotal(total);
        this.setVehicleId(vehicleId);
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

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<Integer> getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(ArrayList<Integer> vehicleId) {
        this.vehicleId = vehicleId;
    }
}
