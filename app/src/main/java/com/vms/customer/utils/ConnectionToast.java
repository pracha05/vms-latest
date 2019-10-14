package com.vms.customer.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vms.customer.R;


/**
 * Created by Bhupi on 26-Jul-18.
 */

public class ConnectionToast {
    public static void showNoNetworkToastMessage(Context context){

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View layout = inflater.inflate(R.layout.customtoastfornetwork,
                (ViewGroup) ((Activity) context).findViewById(R.id.custom_toast_network));

       // String avenirBook = context.getResources().getString(R.string.AvenirBook);
      //  String avenirHeavy = context.getResources().getString(R.string.AvenirHeavy);

        // set a message
        TextView errorMessageTextView = layout.findViewById(R.id.networkMessageTextView);
        TextView errorHeaderTextView = layout.findViewById(R.id.networkHeaderTextView);
        errorMessageTextView.setText("Please check internet connection");
       // errorHeaderTextView.setTypeface(Typeface.createFromAsset(context.getAssets(), avenirHeavy));
       // errorMessageTextView.setTypeface(Typeface.createFromAsset(context.getAssets(), avenirBook));
        errorMessageTextView.setWidth(800);
        errorHeaderTextView.setWidth(800);


        // Toast...
        final Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }

}
