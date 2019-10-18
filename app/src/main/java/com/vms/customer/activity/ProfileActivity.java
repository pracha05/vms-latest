package com.vms.customer.activity;

import android.content.Intent;
import android.graphics.Typeface;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends BaseActivity {

//    @BindView(R.id.img_prof_edit)
//    ImageView img_prof_edit;
//    @BindView(R.id.tv_prof_header)
//    TextView tv_prof_header;
//
//    @BindView(R.id.tv_prof_regno)
//    TextView tv_prof_regno;
//    @BindView(R.id.tv_prof_gst)
//    TextView tv_prof_gst;
//    @BindView(R.id.tv_prof_pan)
//    TextView tv_prof_pan;
//    @BindView(R.id.tv_prof_name)
//    TextView tv_prof_name;
//    @BindView(R.id.tv_prof_compname)
//    TextView tv_prof_compname;
//    @BindView(R.id.tv_prof_mobile)
//    TextView tv_prof_mobile;
//    @BindView(R.id.tv_prof_altnumber)
//    TextView tv_prof_altnumber;
//    @BindView(R.id.tv_prof_email)
//    TextView tv_prof_email;
//    @BindView(R.id.tv_prof_address)
//    TextView tv_prof_address;
//    @BindView(R.id.tv_prof_geoloc)
//    TextView tv_prof_geoloc;
//    @BindView(R.id.tv_prof_godanloc)
//    TextView tv_prof_godanloc;
//    @BindView(R.id.img_prof_back)
//    ImageView img_prof_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
//        img_prof_back.setOnClickListener(this);
//        img_prof_edit.setOnClickListener(this);
//        tv_prof_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
//        tv_prof_regno.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
//        tv_prof_gst.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
//        tv_prof_pan.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
//        tv_prof_name.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
//        tv_prof_compname.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
//        tv_prof_mobile.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
//        tv_prof_altnumber.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
//        tv_prof_email.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
//        tv_prof_address.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
//        tv_prof_geoloc.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
//        tv_prof_godanloc.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.img_prof_edit:
//                startActivity(IntentFactory.createEditProfileActivity(ProfileActivity.this));
//                break;
//            case R.id.img_prof_back:
//                finish();
//                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
//
//                break;
//
//        }

    }

}
