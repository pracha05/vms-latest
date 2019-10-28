package com.vms.customer.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vms.customer.adapters.TruckListAdapter;
import com.vms.customer.model.BookingSummaryPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TruckBookingConfirmActivity extends BaseActivity {
    @BindView(R.id.img_bookcnfm_back)
    ImageView img_bookcnfm_back;
    @BindView(R.id.tv_bookcnfm_header)
    TextView tv_bookcnfm_header;
    @BindView(R.id.rc_bookedtrucklist)
    RecyclerView rc_bookedtrucklist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_booking_confirm);
        ButterKnife.bind(this);
        img_bookcnfm_back.setOnClickListener(this);
        tv_bookcnfm_header.setTypeface(Typeface.createFromAsset(this.getAssets(), AppFonts.GetRobotoBold(this)));
        rc_bookedtrucklist.setHasFixedSize(false);
        rc_bookedtrucklist.setLayoutManager(new GridLayoutManager(this,1));
       // rc_bookedtrucklist.setNestedScrollingEnabled(false);

        if (isConnected()) {
            showDialog();
            getTruckList();
        } else {
            showToast(getResources().getString(R.string.nointernet));
        }
    }

    //TODO: getting data from server without passing any value
    private void getTruckList() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "https://api.myjson.com/bins/kh7ki";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                response -> {
                    hideDialog();
                    Gson gson = new Gson();
                    BookingSummaryPojo data = gson.fromJson(String.valueOf(response), BookingSummaryPojo.class);

                    TruckListAdapter hAdapter = new TruckListAdapter(TruckBookingConfirmActivity.this, data);
                    rc_bookedtrucklist.setAdapter(hAdapter);


                }, error -> {
            hideDialog();

            showToast(getResources().getString(R.string.servererror));
            Log.e("====error===>", error.getMessage());



        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_bookcnfm_back:
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                finish();
                break;

        }
    }
}
