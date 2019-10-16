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
import com.vms.customer.adapters.BookingSummaryAdapter;
import com.vms.customer.models.BookingSummaryPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingSummery extends BaseActivity {
    @BindView(R.id.img_booksum_back)
    ImageView img_booksum_back;

    @BindView(R.id.tv_booksum_header)
    TextView tv_booksum_header;
    @BindView(R.id.rc_bookingsummary)
    RecyclerView rc_bookingsummary;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_summery);
        ButterKnife.bind(this);
        img_booksum_back.setOnClickListener(this);
        rc_bookingsummary.setOnClickListener(this);
        rc_bookingsummary.setLayoutManager(new GridLayoutManager(this, 1));
        tv_booksum_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));

        if (isConnected()) {
           // showDialog();
            progressBar.setVisibility(View.VISIBLE);
            menuListOptionAPI();
        } else {
            showToast(getResources().getString(R.string.nointernet));
        }
    }

    //TODO: getting data from server without passing any value
    private void menuListOptionAPI() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "https://api.myjson.com/bins/kh7ki";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                response -> {
                    hideDialog();
                    Gson gson = new Gson();
                    BookingSummaryPojo data = gson.fromJson(String.valueOf(response), BookingSummaryPojo.class);

                    BookingSummaryAdapter hAdapter = new BookingSummaryAdapter(BookingSummery.this, data);
                    rc_bookingsummary.setAdapter(hAdapter);
                    progressBar.setVisibility(View.GONE);

                }, error -> {
                progressBar.setVisibility(View.GONE);
                showToast(getResources().getString(R.string.servererror));
                Log.e("====error===>", error.getMessage());


        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        {
            switch (v.getId()) {
                case R.id.img_booksum_back:
                    finish();
                    overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                    break;
            }
        }

    }
}
