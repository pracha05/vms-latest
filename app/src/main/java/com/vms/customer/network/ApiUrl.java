package com.vms.customer.network;

public class ApiUrl {
    public static State selectedState = State.STAGING;

    public static String BaseUrl = getBaseURL();

    public enum State {
        STAGING, LIVE
    }

    public static String getBaseURL() {

        String url = null;
        switch (selectedState) {

            case STAGING:
                url = "http://prachatech.com/vms_api/";
                break;
            case LIVE:
                url = "http://prachatech.com/vms_api/";
                break;
        }
        return url;
    }

    final public static String categories = "categories";
    final public static String bookingsummary = "bookingsummary";

    /**
     * FB/Twitter/Youtube Link
     */
    public static String FACEBOOK_PAGE_ID = "180868135891811";
    final public static String FB_URL ="https://facebook.com/foliyoo";
    final public static String TWITTER_URL = "https://twitter.com/foliyoo";
    final public static String YOU_TUBE_URL = "https://www.youtube.com/channel/UCEHvaGutDiI3BNdvhXBBA5g/featured";
    final public static int FACEBOOK_VERSION_CODE = 3002850;

}
;