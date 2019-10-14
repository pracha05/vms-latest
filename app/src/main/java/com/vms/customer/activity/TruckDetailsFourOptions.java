package com.vms.customer.activity;

import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vms.customer.adapters.ViewPagerSliderAdapter;
import com.vms.customer.models.TruckImgPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

public class TruckDetailsFourOptions extends BaseActivity {
    Button btn_frg_rating, btn_frg_profile, btn_frg_amenities, btn_frg_policies;
    LinearLayout ll_amemities, ll_profile, ll_ratings, ll_policies;
    ViewPager viewPager_truck_img;
    TextView tv_4opt_header;
    ImageView img_4opt_back;
    View view_frg_amenities,view_frg_retings,view_frg_profile,view_frg_policies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_details_four_options);
        btn_frg_policies =findViewById(R.id.btn_frg_policies);
        btn_frg_amenities =findViewById(R.id.btn_frg_amenities);
        btn_frg_profile =findViewById(R.id.btn_frg_profile);
        btn_frg_rating =findViewById(R.id.btn_frg_rating);
        tv_4opt_header =findViewById(R.id.tv_4opt_header);
        img_4opt_back =findViewById(R.id.img_4opt_back);

        view_frg_amenities = findViewById(R.id.view_frg_amenities);
        view_frg_retings = findViewById(R.id.view_frg_rating);
        view_frg_profile = findViewById(R.id.view_frg_profile);
        view_frg_policies = findViewById(R.id.view_frg_policies);

        ll_amemities = findViewById(R.id.ll_amemities);
        ll_ratings = findViewById(R.id.ll_ratings);
        ll_profile = findViewById(R.id.ll_profile);
        ll_policies = findViewById(R.id.ll_policies);
        ll_amemities.setVisibility(View.VISIBLE);
        img_4opt_back.setOnClickListener(this);

        viewPager_truck_img = findViewById(R.id.viewPager_truck_img);
        tv_4opt_header.setTypeface(Typeface.createFromAsset(this.getAssets(), AppFonts.GetRobotoBold(this)));
        btn_frg_rating.setTypeface(Typeface.createFromAsset(this.getAssets(), AppFonts.GetRobotoBold(this)));
        btn_frg_amenities.setTypeface(Typeface.createFromAsset(this.getAssets(), AppFonts.GetRobotoBold(this)));
        btn_frg_profile.setTypeface(Typeface.createFromAsset(this.getAssets(), AppFonts.GetRobotoBold(this)));
        btn_frg_policies.setTypeface(Typeface.createFromAsset(this.getAssets(), AppFonts.GetRobotoBold(this)));
        btn_frg_amenities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_4opt_header.setText("Amenities");
                ll_profile.setVisibility(View.GONE);
                ll_ratings.setVisibility(View.GONE);
                ll_policies.setVisibility(View.GONE);
                ll_amemities.setVisibility(View.VISIBLE);
                btn_frg_amenities.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_frg_rating.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                btn_frg_policies.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                btn_frg_profile.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                view_frg_amenities.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                view_frg_retings.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                view_frg_policies.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                view_frg_profile.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            }
        });
        btn_frg_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_4opt_header.setText("Profile");
                ll_profile.setVisibility(View.VISIBLE);
                ll_amemities.setVisibility(View.GONE);
                ll_policies.setVisibility(View.GONE);
                ll_ratings.setVisibility(View.GONE);
                btn_frg_amenities.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                btn_frg_rating.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                btn_frg_policies.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                btn_frg_profile.setTextColor(getResources().getColor(R.color.colorBlack));
                view_frg_amenities.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                view_frg_retings.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                view_frg_policies.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                view_frg_profile.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                {
                    RequestQueue requestQueue = Volley.newRequestQueue(TruckDetailsFourOptions.this);
                    String URL = "https://api.myjson.com/bins/13idej";


                    StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                            response -> {

                                Gson gson = new Gson();
                                TruckImgPojo data = gson.fromJson(response, TruckImgPojo.class);

                                //TODO: for home banner image
                                ViewPagerSliderAdapter viewPager_sliderAdapter = new ViewPagerSliderAdapter(TruckDetailsFourOptions.this, data);
                                viewPager_truck_img.setAdapter(viewPager_sliderAdapter);


                            }, error -> {


                    });
                    requestQueue.add(stringRequest);
                }

            }
        });
        btn_frg_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_4opt_header.setText("Ratings");
                ll_ratings.setVisibility(View.VISIBLE);
                ll_amemities.setVisibility(View.GONE);
                ll_policies.setVisibility(View.GONE);
                ll_profile.setVisibility(View.GONE);

                btn_frg_amenities.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                btn_frg_rating.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_frg_policies.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                btn_frg_profile.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                view_frg_amenities.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                view_frg_retings.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                view_frg_policies.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                view_frg_profile.setBackgroundColor(getResources().getColor(R.color.colorWhite));


            }
        });
        btn_frg_policies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_4opt_header.setText("Policies");
                ll_policies.setVisibility(View.VISIBLE);
                ll_amemities.setVisibility(View.GONE);
                ll_ratings.setVisibility(View.GONE);
                ll_profile.setVisibility(View.GONE);

                btn_frg_amenities.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                btn_frg_rating.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                btn_frg_policies.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_frg_profile.setTextColor(getResources().getColor(R.color.colorLightDarkGray));
                view_frg_amenities.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                view_frg_retings.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                view_frg_policies.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                view_frg_profile.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_4opt_back:
                finish();
                break;

        }
    }
}
