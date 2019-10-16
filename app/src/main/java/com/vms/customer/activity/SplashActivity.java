package com.vms.customer.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.vms.customer.R;
import com.crashlytics.android.answers.Answers;
import io.fabric.sdk.android.Fabric;

public class SplashActivity extends AppCompatActivity {
    Handler handler=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Answers(), new Crashlytics());
        setContentView(R.layout.activity_splash);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                //startActivity(new Intent(SplashActivity.this,IntroductionPagerActivity.class));
                //startActivity(new Intent(SplashActivity.this,SignUpActivity.class));
                finish();
            }
        },1500);
    }
}