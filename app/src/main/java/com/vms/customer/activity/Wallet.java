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

public class Wallet extends BaseActivity {
    @BindView(R.id.img_wallet_back)
    ImageView img_wallet_back;
    @BindView(R.id.tv_wallet_header)
    TextView tv_wallet_header;
    @BindView(R.id.tv_wallet)
    TextView tv_wallet;
    @BindView(R.id.tv_wallet_code)
    TextView tv_wallet_code;

    @BindView(R.id.tv_wallet_value)
    TextView tv_wallet_value;

    @BindView(R.id.tv_wallet_usage_allowed)
    TextView tvWalletUsageAllowed;

    @BindView(R.id.tv_wallet_usage_month)
    TextView tvUsageMonth;

    @BindView(R.id.tv_wallet_usage)
    TextView tvWalletUsage;

    @BindView(R.id.tv_wallet_usage_price)
    TextView tvWalletUsagePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);
        img_wallet_back.setOnClickListener(this);
        tv_wallet_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_wallet.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_wallet_code.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tv_wallet_value.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvWalletUsageAllowed.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvUsageMonth.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvWalletUsage.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        tvWalletUsagePrice.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.img_wallet_back:
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
        break;

}
    }
}
