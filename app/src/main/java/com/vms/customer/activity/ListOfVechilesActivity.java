package com.vms.customer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vms.customer.adapters.TruckListAdapter;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.models.BookingSummaryPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListOfVechilesActivity extends BaseActivity {
    @BindView(R.id.img_listoftruck_back)
    ImageView img_listoftruck_back;
    @BindView(R.id.tv_listoftruck_header)
    TextView tv_listoftruck_header;
    @BindView(R.id.rc_trucklist)
    RecyclerView rc_trucklist;
    @BindView(R.id.btn_book_trucks)
    Button btn_book_trucks;
    @BindView(R.id.btn_filter_three)
    Button btn_filter_three;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_vechiles);
        ButterKnife.bind(this);
        img_listoftruck_back.setOnClickListener(this);
        btn_book_trucks.setOnClickListener(this);
        btn_filter_three.setOnClickListener(this);
        tv_listoftruck_header.setTypeface(Typeface.createFromAsset(this.getAssets(), AppFonts.GetRobotoBold(this)));
        rc_trucklist.setLayoutManager(new GridLayoutManager(this, 1));

        if (isConnected()) {
           // showDialog();
            progressBar.setVisibility(View.VISIBLE);
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
                  //  hideDialog();
                    progressBar.setVisibility(View.GONE);
                    Gson gson = new Gson();
                    BookingSummaryPojo data = gson.fromJson(String.valueOf(response), BookingSummaryPojo.class);

                    TruckListAdapter hAdapter = new TruckListAdapter(ListOfVechilesActivity.this, data);
                    rc_trucklist.setAdapter(hAdapter);


                }, error -> {
            //hideDialog();
            progressBar.setVisibility(View.GONE);
            showToast(getResources().getString(R.string.servererror));
            Log.e("====error===>", error.getMessage());


        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_listoftruck_back:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;
            case R.id.btn_filter_three:
                startActivity(IntentFactory.createMainFilterActivity(ListOfVechilesActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                break;
            case R.id.btn_book_trucks:
                startActivity(IntentFactory.createTruckBookingConfirmActivity(ListOfVechilesActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                break;
        }
    }
}
