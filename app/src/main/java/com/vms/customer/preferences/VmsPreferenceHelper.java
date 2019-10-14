package com.vms.customer.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.vms.customer.constant.Constant;

public class VmsPreferenceHelper {

    public static final String VMS_PREFERENCE_FILE_KEY = "vms_preference_key";

    /**
     * save email to share preference
     * @param context
     * @param email
     */
    public static final void saveEmailToPreference(Context context, String email){
        SharedPreferences sharedPref = context.getSharedPreferences(
                VMS_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Constant.KEY_USER_EMAIL, email);
        editor.commit();
    }


    /**
     * save mobile to share preference
     * @param context
     * @param phoneNumber
     */
    public static final void savePhoneNumberToPreference(Context context, String phoneNumber){
        SharedPreferences sharedPref = context.getSharedPreferences(
                VMS_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Constant.KEY_USER_MOBILE, phoneNumber);
        editor.commit();
    }

    /**
     * save customer id to share preference
     * @param context
     * @param customerId
     */
    public static final void saveCustomerIdToPreference(Context context, String customerId){
        SharedPreferences sharedPref = context.getSharedPreferences(
                VMS_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Constant.KEY_CUSTOMER_ID, customerId);
        editor.commit();
    }

    /**
     * save user logout status to shared preference
     * @param context
     * @param status
     */
    public static final void saveLogoutStatusToPreference(Context context, boolean status){
        SharedPreferences sharedPref = context.getSharedPreferences(
                VMS_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(Constant.KEY_LOGOUT, status);
        editor.commit();
    }

    /**
     * return value from local preference with given key for logout
     * @param context
     * @return
     */
    public static boolean getValueFromPreferenceForLogoutStatus(Context context){
        boolean status = false;
        SharedPreferences sharedPref = context.getSharedPreferences(
                VMS_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        status = sharedPref.getBoolean(Constant.KEY_LOGOUT, false);
        return status;
    }

    /**
     * return value from local preference with given key
     * @param context
     * @param key
     * @return
     */
    public static String getValueFromPreference(Context context,String key){
        String returnValue = "";
        SharedPreferences sharedPref = context.getSharedPreferences(
                VMS_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        returnValue = sharedPref.getString(key, "");
        return returnValue;
    }


    /**
     * Set guided tour visit status by user
     */

    public static boolean SaveGuidedTourVisitStatus(Context ctx){

        SharedPreferences.Editor editor= getSharedPreferenceEditor(ctx);
        editor.putBoolean(Constant.KEY_GUIDED_TOUR,true);
        editor.commit();
        return true;
    }

    /**
     * get guided tour visit status by user
     */
    public static boolean GetGuidedTourVisitStatus(Context ctx){

        SharedPreferences sharedPreferences = getSharedPreference(ctx);
        return sharedPreferences.getBoolean(Constant.KEY_GUIDED_TOUR,false);
    }

    /**
     * get private shared preference editor
     */

    private static SharedPreferences.Editor getSharedPreferenceEditor(Context context){

        SharedPreferences sharedPreferences = context.getSharedPreferences(VMS_PREFERENCE_FILE_KEY,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        return editor;
    }

    /**
     * get shared preference
     */

    private static SharedPreferences getSharedPreference(Context context){

        SharedPreferences sharedPreferences = context.getSharedPreferences(VMS_PREFERENCE_FILE_KEY,Context.MODE_PRIVATE);
        return sharedPreferences;
    }

}
