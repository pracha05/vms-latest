package com.vms.customer;

import android.app.Application;
import android.content.Context;

import com.vms.customer.utils.ReleaseTree;

import timber.log.Timber;

public class VmsApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ReleaseTree());
        }
    }

}
