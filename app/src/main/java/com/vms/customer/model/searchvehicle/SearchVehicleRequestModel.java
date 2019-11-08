package com.vms.customer.model.searchvehicle;

import com.google.gson.annotations.SerializedName;

public class SearchVehicleRequestModel {

    @SerializedName("pickup")
    private String pickup;
    @SerializedName("delivery")
    private String delivery;
    @SerializedName("loadtype")
    private String loadType;
    @SerializedName("size")
    private String size;
    @SerializedName("material")
    private String material;
    @SerializedName("date")
    private String date;
    @SerializedName("departuretime")
    private String departureTime;
    @SerializedName("arrivaltime")
    private String arrivalTime;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public SearchVehicleRequestModel(String pickup,String delivery,String loadType,String size,String material,
                                     String date,String departureTime,String arrivalTime,String latitude,
                                     String longitude){
        this.setPickup(pickup);
        this.setDelivery(delivery);
        this.setLoadType(loadType);
        this.setSize(size);
        this.setMaterial(material);
        this.setDate(date);
        this.setDepartureTime(departureTime);
        this.setArrivalTime(arrivalTime);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
