package com.vms.customer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhoneVerificationStatus extends BaseActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;
    @BindView(R.id.tv_phone)
    TextView tvTextStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification_status);
        ButterKnife.bind(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = IntentFactory.createHomeActivity(PhoneVerificationStatus.this);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK
                |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                finishAffinity();
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void onClick(View v) {

    }
}
