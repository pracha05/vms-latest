package com.vms.customer.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vms.customer.adapters.insuranceproviderAdapter;
import com.vms.customer.R;
import com.vms.customer.models.insuranceproviderPojo;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InsuranceProvider extends BaseActivity {
    @BindView(R.id.img_insurance_back)
    ImageView img_insurance_back;
    @BindView(R.id.tv_insurance_header)
    TextView tv_insurance_header;
    @BindView(R.id.rc_insurance)
    RecyclerView rc_insurance;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_provider);
        ButterKnife.bind(this);
        img_insurance_back.setOnClickListener(this);
        rc_insurance.setOnClickListener(this);
        rc_insurance.setLayoutManager(new GridLayoutManager(this, 1));

        tv_insurance_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        if (isConnected()) {
           // showDialog();
            progressBar.setVisibility(View.VISIBLE);
            insuranceproviderlist();
        } else {
            showToast(getResources().getString(R.string.nointernet));
        }
    }

    private void insuranceproviderlist() {
        String URL = "https://api.myjson.com/bins/f48ul";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, response -> {
            hideDialog();
            Gson gson = new Gson();
            insuranceproviderPojo data = gson.fromJson(String.valueOf(response), insuranceproviderPojo.class);

            insuranceproviderAdapter hAdapter = new insuranceproviderAdapter(InsuranceProvider.this, data);
            rc_insurance.setAdapter(hAdapter);
            progressBar.setVisibility(View.GONE);
        }, error -> {
            progressBar.setVisibility(View.GONE);
           // hideDialog();
            showToast("hiiiiiiiiiii");

        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.img_insurance_back:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;
        }
    }


}
