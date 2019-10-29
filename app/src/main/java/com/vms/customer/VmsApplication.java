package com.vms.customer;

import android.app.Application;

import com.vms.customer.utils.ReleaseTree;

import timber.log.Timber;

public class VmsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ReleaseTree());
        }
    }

}
