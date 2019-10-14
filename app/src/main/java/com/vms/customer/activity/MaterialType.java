package com.vms.customer.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kofigyan.stateprogressbar.StateProgressBar;
import com.vms.customer.network.ApiUrl;
import com.vms.customer.adapters.SelectMaterialAdapter;
import com.vms.customer.models.SelMaterialCategory;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MaterialType extends BaseActivity {
    @BindView(R.id.your_state_progress_bar_mattype2)
    StateProgressBar your_state_progress_bar_mattype2;

    @BindView(R.id.img_mattype_back)
    ImageView img_mattype_back;

    @BindView(R.id.rev_sel_material)
    RecyclerView rev_sel_material;

    @BindView(R.id.tv_mattypeheader)
    TextView tv_mattype_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_type);
        ButterKnife.bind(this);
        img_mattype_back.setOnClickListener(this);
        tv_mattype_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        rev_sel_material.setLayoutManager(new GridLayoutManager(this, 3));
        if (isConnected()) {
            showDialog();
            menuListOptionAPI();
        } else {
            showToast(getResources().getString(R.string.nointernet));
        }
    }

    //TODO: getting data from server without passing any value
    private void menuListOptionAPI() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = ApiUrl.BaseUrl + ApiUrl.categories;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                response -> {
                    hideDialog();
                    Gson gson = new Gson();
                    SelMaterialCategory data = gson.fromJson(String.valueOf(response), SelMaterialCategory.class);
                    if (data.status != 0) {
                        //TODO: for home gridview
                        if (data.message != null) {
                            SelectMaterialAdapter hAdapter = new SelectMaterialAdapter(MaterialType.this, data);
                            rev_sel_material.setAdapter(hAdapter);

                        } else {
                            showToast("No Data");
                        }
                    }
                }, error -> {
            hideDialog();

            showToast(getResources().getString(R.string.servererror));

        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_mattype_back:
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}
