package com.vms.customer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoadBookings extends BaseActivity {
    @BindView(R.id.img_loadbook_back)
    ImageView img_loadbook_back;

    @BindView(R.id.tv_loadbook_header)
    TextView tv_loadbook_header;
    @BindView(R.id.tv_lb_sheader)
    TextView tv_lb_sheader;
    @BindView(R.id.btn_fullload)
    Button btn_fullload;
    @BindView(R.id.btn_box)
    Button btn_box;
    @BindView(R.id.btn_partload)
    Button btn_partload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_bookings);
        ButterKnife.bind(this);
        img_loadbook_back.setOnClickListener(this);
        tv_loadbook_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));

        tv_lb_sheader.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        btn_fullload.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        btn_box.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        btn_partload.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        btn_fullload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(IntentFactory.createBasicLoadActivity(LoadBookings.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
            }
        });

    }

    @Override
    public void onClick(View view) {
        {
            switch (view.getId()) {
                case R.id.img_loadbook_back:
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
