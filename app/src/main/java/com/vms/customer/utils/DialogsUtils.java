package com.vms.customer.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.vms.customer.R;


public class DialogsUtils {

    public static Dialog showProgressDialog(Context context, String text){
         String message=text;
        final Dialog dialog = new android.app.Dialog(context,android.R.style.Theme_Wallpaper_NoTitleBar_Fullscreen);

        View view = LayoutInflater.from(context).inflate(R.layout.progressbarlayout,null);
        //ImageView iv_progress_bar = view.findViewById(R.id.iv_progress_bar);

       // iv_progress_bar.startAnimation(AnimationUtils.loadAnimation(context,R.anim.blink_progress_bar));
        dialog.setContentView(view);
        dialog.setCancelable(false);

        dialog.show();
        return dialog;
    }
}
