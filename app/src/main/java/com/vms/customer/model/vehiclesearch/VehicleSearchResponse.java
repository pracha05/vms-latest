package com.vms.customer.model.vehiclesearch;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VehicleSearchResponse {

    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("vehicles")
    private ArrayList<Vehicles> vehicles = new ArrayList<>();

    public VehicleSearchResponse(String status, String message, ArrayList<Vehicles> vehicles ){
        this.setStatus(status);
        this.setMessage(message);
        this.setVehicles(vehicles);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }
}
