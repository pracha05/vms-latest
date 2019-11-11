package com.vms.customer.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.vms.customer.R;
import com.crashlytics.android.answers.Answers;
import com.vms.customer.constant.Constant;
import com.vms.customer.preferences.VmsPreferenceHelper;

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

                /**
                 * Guided tour not visited by the user
                 * show guided tour page
                 */
                if(!VmsPreferenceHelper.GetGuidedTourVisitStatus(SplashActivity.this)){

                    startActivity(new Intent(SplashActivity.this, IntroductionPagerActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();

                }
                /**
                 * if user has been logout or email is not in preferences show signin screen
                 */
                else if(VmsPreferenceHelper.getValueFromPreferenceForLogoutStatus(SplashActivity.this)){

                    startActivity(new Intent(SplashActivity.this,SignInActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();

                }
                else if((VmsPreferenceHelper.getValueFromPreference(SplashActivity.this, Constant.KEY_USER_EMAIL).isEmpty())){

                    startActivity(new Intent(SplashActivity.this,SignInActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();

                }else {
                    //show dashboard to user
                    startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
//                startActivity(new Intent(SplashActivity.this,HomeActivity.class));
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                finish();
            }
        },1500);
    }
}