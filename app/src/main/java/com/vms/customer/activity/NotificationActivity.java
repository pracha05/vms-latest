package com.vms.customer.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationActivity extends BaseActivity {
    @BindView(R.id.img_noti_back)
    ImageView img_noti_back;

    @BindView(R.id.tv_notification_header)
    TextView tv_notification_header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        img_noti_back.setOnClickListener(this);
        tv_notification_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));

    }
    @Override
    public void onClick(View v) {
        {
            switch (v.getId()) {
                case R.id.img_noti_back:
                    finish();
                    overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);

                    break;
            }
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
    }
}
