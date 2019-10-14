package com.vms.customer.utils;

import android.content.Context;

import com.vms.customer.R;


/**
 * Created by Bhupi on 03-Dec-18.
 */

public class AppFonts {
     Context mContext;

    public AppFonts(Context mContext1) {
        mContext = mContext1;
    }
    public static String GetRobotoRegular(Context context) {
        int roboReg = R.string.RobotoRegular;
        String robotoReguler = context.getString(roboReg);
        return robotoReguler;
    }

    public static String GetRobotoBold (Context context) {
        int robobold = R.string.RobotoBold;
        String robotoBold= context.getString(robobold);

        return robotoBold;
    }
    public static String GetAvenirRegular (Context context) {
        int avenirRegularrobobold = R.string.AvenirRegular;
        String robotoBold= context.getString(avenirRegularrobobold);

        return robotoBold;
    }

}
