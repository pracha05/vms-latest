package com.vms.customer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
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
import com.vms.customer.adapters.contactlistAdapter;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.models.contactlistPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactAllList extends BaseActivity {

    @BindView(R.id.img_contact_back)
    ImageView img_contact_back;

    @BindView(R.id.tv_contact_header)
    TextView tv_contact_header;

    @BindView(R.id.img_contact_addcontact)
    ImageView img_contact_addcontact;

    @BindView(R.id.rc_contactlist)
    RecyclerView rc_contactlist;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_all_list);
        ButterKnife.bind(this);
        img_contact_back.setOnClickListener(this);
        img_contact_addcontact.setOnClickListener(this);
        rc_contactlist.setOnClickListener(this);
        rc_contactlist.setLayoutManager(new GridLayoutManager(this, 1));
        tv_contact_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        if (isConnected()) {
            //showDialog();
            progressBar.setVisibility(View.VISIBLE);
            contactDetailsmenu();
        } else {
            showToast(getResources().getString(R.string.nointernet));
        }
    }

    private void contactDetailsmenu() {

        String URL = "https://api.myjson.com/bins/rl59l";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, response -> {
            hideDialog();
            Gson gson = new Gson();
            contactlistPojo data = gson.fromJson(String.valueOf(response), contactlistPojo.class);

            contactlistAdapter hAdapter = new contactlistAdapter(ContactAllList.this, data);
            rc_contactlist.setAdapter(hAdapter);
            progressBar.setVisibility(View.GONE);

        }, error -> {
           // hideDialog();
            progressBar.setVisibility(View.GONE);

        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_contact_back:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;

            case R.id.img_contact_addcontact:

                startActivity(IntentFactory.createAddContactActivity(ContactAllList.this));
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;
        }

    }
}
