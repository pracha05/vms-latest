package com.vms.customer.network;

public class ServiceURL {
    public static State selectedState = State.STAGING;

    public static String BaseUrl = getBaseURL();

    public enum State {
        STAGING, LIVE
    }

    public static String getBaseURL() {

        String url = null;
        switch (selectedState) {

            case STAGING:
                url = "http://vms.prachatech.com/api/";
                break;
            case LIVE:
                url = "http://vms.prachatech.com/api/";
                break;
        }
        return url;
    }
}
