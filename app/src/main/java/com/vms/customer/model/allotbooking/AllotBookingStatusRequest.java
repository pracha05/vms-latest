package com.vms.customer.model.allotbooking;

import com.google.gson.annotations.SerializedName;

public class AllotBookingStatusRequest {

    @SerializedName("status")
    private String status;

    @SerializedName("bookingid")
    private String bookingId;

    @SerializedName("driverid")
    private String driverId;

    public AllotBookingStatusRequest(String status, String bookingId, String driverId){
        this.setStatus(status);
        this.setBookingId(bookingId);
        this.setDriverId(driverId);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
}
