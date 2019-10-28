package com.vms.customer.model.vehiclesearch;

import com.google.gson.annotations.SerializedName;

public class VehicleSearchRequest {

    @SerializedName("pickup")
    private String pickup;

    @SerializedName("delivery")
    private String delivery;

    @SerializedName("loadtype")
    private String loadtype;

    @SerializedName("size")
    private String size;

    @SerializedName("material")
    private String material;

    @SerializedName("date")
    private String date;

    @SerializedName("departuretime")
    private String departuretime;

    @SerializedName("arrivaltime")
    private String arrivaltime;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    public VehicleSearchRequest(String pickup, String delivery, String loadtype, String size,
                                String material, String date, String departuretime, String arrivaltime,
                                String latitude, String longitud ){
        this.setPickup(pickup);
        this.setDelivery(delivery);
        this.setLoadtype(loadtype);
        this.setSize(size);
        this.setMaterial(material);
        this.setDate(date);
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

    public String getLoadtype() {
        return loadtype;
    }

    public void setLoadtype(String loadtype) {
        this.loadtype = loadtype;
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
