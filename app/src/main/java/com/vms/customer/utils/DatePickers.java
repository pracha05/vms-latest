package com.vms.customer.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Bhupi on 09-Feb-19.
 */

public class DatePickers {
     public static int mYear, mMonth, mDay;
     public static String mydate;;

    public static void mypicker(Context context, final TextView textView)
    {
        Calendar mcurrentDate = Calendar.getInstance();
        mYear = mcurrentDate.get(Calendar.YEAR);
        mMonth = mcurrentDate.get(Calendar.MONTH);
        mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {

                Calendar myCalendar = Calendar.getInstance();
                try {

                    myCalendar.set(Calendar.YEAR, selectedyear);
                    myCalendar.set(Calendar.MONTH, selectedmonth);
                    myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                    String myFormat = "yyyy-MM-dd"; //Change as you need
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
                    Date date = myCalendar.getTime();
                    mydate = sdf.format(date);

                    textView.setText(mydate);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                mDay = selectedday;
                mMonth = selectedmonth;
                mYear = selectedyear;
            }
        }, mYear, mMonth, mDay);

        mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        mDatePicker.show();
        Log.e("Info "," Date ===> "+mydate);

    }


}
