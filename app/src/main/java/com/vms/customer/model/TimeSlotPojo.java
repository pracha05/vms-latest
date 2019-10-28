package com.vms.customer.model;

public class TimeSlotPojo {
    String timeSpinnerDatum;
    public TimeSlotPojo(String timeSpinnerDatum) {
        this.timeSpinnerDatum=timeSpinnerDatum;
    }

    public String getTimeSpinnerDatum() {
        return timeSpinnerDatum;
    }

    public void setTimeSpinnerDatum(String timeSpinnerDatum) {
        this.timeSpinnerDatum = timeSpinnerDatum;
    }
}
