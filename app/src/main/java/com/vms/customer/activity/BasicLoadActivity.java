package com.vms.customer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;
import com.vms.customer.utils.DatePickers;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BasicLoadActivity extends BaseActivity {

    @BindView(R.id.your_state_progress_bar_baseload1)
    StateProgressBar your_state_progress_bar_baseload1;

    @BindView(R.id.img_baseload_back)
    ImageView img_baseload_back;

    @BindView(R.id.tv_baseload_header)
    TextView tv_baseload_header;
    @BindView(R.id.txt_loadstartpoint)
    TextView txt_loadstartpoint;
    @BindView(R.id.txt_loaddropingpoint)
    TextView txt_loaddropingpoint;
    @BindView(R.id.tx_selectsizevehicle)
    TextView tx_selectsizevehicle;
    @BindView(R.id.txt_lbdate)
    TextView txt_lbdate;
    @BindView(R.id.edt_lbdate)
    TextView edt_lbdate;
    @BindView(R.id.txt_no_of_vechiles)
    TextView txt_no_of_vechiles;
    @BindView(R.id.txt_sel_size_veh)
    TextView txt_sel_size_veh;
    @BindView(R.id.edt_loadstartpoint)
    EditText edt_loadstartpoint;
    @BindView(R.id.edt_loaddropingpoint)
    EditText edt_loaddropingpoint;
    @BindView(R.id.edt_no_of_vechiles)
    EditText edt_no_of_vechiles;

    @BindView(R.id.ll_sel_size_veh)
    LinearLayout ll_sel_size_veh;

    @BindView(R.id.btn_save1)
    Button btn_save1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_load_);

        ButterKnife.bind(this);
        img_baseload_back.setOnClickListener(this);
        edt_lbdate.setOnClickListener(this);
        ll_sel_size_veh.setOnClickListener(this);
        btn_save1.setOnClickListener(this);
        tv_baseload_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        btn_save1.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_lbdate.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        tx_selectsizevehicle.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_no_of_vechiles.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_loadstartpoint.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_loaddropingpoint.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        edt_lbdate.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_loadstartpoint.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_loaddropingpoint.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_no_of_vechiles.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        txt_sel_size_veh.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save1:
                Intent i = new Intent(BasicLoadActivity.this, MaterialType.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.img_baseload_back:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;
            case R.id.edt_lbdate:
                DatePickers.mypicker(BasicLoadActivity.this, edt_lbdate);
                break;
        }

    }


    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void openSingleChoice(View view) {
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
    }
}
