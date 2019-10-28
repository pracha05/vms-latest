package com.vms.customer.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @BindView(R.id.img_prof_edit)
    ImageView img_prof_edit;

    @BindView(R.id.card_view_personal)
    CardView cvPersonalData;

    @BindView(R.id.card_view_commercial)
    CardView cvCommercialData;

    @BindView(R.id.simpleSwitch)
    Switch simpleSwitch;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_base);
        ButterKnife.bind(this);
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            mToolBar.setTitleTextColor(getResources().getColor(R.color.colorWhite));

            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
            });
            img_prof_edit.setOnClickListener(this);
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

            simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        cvCommercialData.setVisibility(View.VISIBLE);
                    } else {
                        cvCommercialData.setVisibility(View.GONE);
                    }
                }
            });
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_prof_edit:
                startActivity(IntentFactory.createEditProfileActivity(ProfileActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                break;
        }

    }
}
