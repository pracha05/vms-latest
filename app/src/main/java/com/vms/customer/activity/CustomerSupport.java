package com.vms.customer.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vms.customer.adapters.CustomerSupportAdapter;
import com.vms.customer.models.CustomerSupportPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerSupport extends BaseActivity {
    @BindView(R.id.img_support_back)
    ImageView img_support_back;
    @BindView(R.id.tv_support_header)
    TextView tv_support_header;
    @BindView(R.id.rc_customersupport)
    RecyclerView rc_customersupport;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_support);
        ButterKnife.bind(this);
        img_support_back.setOnClickListener(this);
        rc_customersupport.setOnClickListener(this);
        rc_customersupport.setLayoutManager(new GridLayoutManager(this, 1));
        tv_support_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        if (isConnected()) {
            //showDialog();
            progressBar.setVisibility(View.VISIBLE);
            CustomerSupportList();
        } else {
            showToast(getResources().getString(R.string.nointernet));
        }
    }

    private void CustomerSupportList() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "https://api.myjson.com/bins/11z5ul";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                response -> {
                    hideDialog();
                    Gson gson = new Gson();
                    CustomerSupportPojo data = gson.fromJson(String.valueOf(response), CustomerSupportPojo.class);

                    CustomerSupportAdapter hAdapter = new CustomerSupportAdapter(CustomerSupport.this, data);
                    rc_customersupport.setAdapter(hAdapter);
                    progressBar.setVisibility(View.GONE);

                }, error -> {
            //hideDialog();
            progressBar.setVisibility(View.GONE);
            showToast(getResources().getString(R.string.servererror));
            Log.e("====error===>", error.getMessage());


        });
        requestQueue.add(stringRequest);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_support_back:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;
        }

    }
}
