package com.vms.customer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vms.customer.BuildConfig;
import com.vms.customer.R;
import com.vms.customer.activity.BaseActivity;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReferenceCodeActivity extends BaseActivity {
    @BindView(R.id.img_referal_back)
    ImageView img_referal_back;
    @BindView(R.id.tv_referal_header)
    TextView tv_referal_header;
    @BindView(R.id.tv_referal_ref_code)
    TextView tv_referal_ref_code;
    @BindView(R.id.btn_refer)
    Button btn_refer;
    String ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_code);
        ButterKnife.bind(this);
        img_referal_back.setOnClickListener(this);
        btn_refer.setOnClickListener(this);
        tv_referal_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        tv_referal_ref_code.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_referal_back:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;
            case R.id.btn_refer:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "VMS");
                String shareMessage = "We have a gift for you! Refer your friend and earn a 10% discount voucher. Your refernce code is v52gs1 " + ref + "\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
    }
}
