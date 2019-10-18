package com.vms.customer.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class EditProfile extends BaseActivity {
    @BindView(R.id.img_profile_back)
    ImageView img_profile_back;
    @BindView(R.id.img_get_maploc)
    ImageView img_get_maploc;
    @BindView(R.id.img_get_currentloc)
    ImageView img_get_currentloc;

    @BindView(R.id.tv_profile_header)
    TextView tv_profile_header;
    @BindView(R.id.t_geoloc)
    TextView t_geoloc;
    @BindView(R.id.txt_prof_regno)
    TextView txt_prof_regno;
    @BindView(R.id.txt_prof_gst)
    TextView txt_prof_gst;
    @BindView(R.id.txt_prof_pan)
    TextView txt_prof_pan;
    @BindView(R.id.txt_prof_lgname)
    TextView txt_prof_lgname;
    @BindView(R.id.txt_prof_cpname)
    TextView txt_prof_cpname;
    @BindView(R.id.txt_prof_mbnumber)
    TextView txt_prof_mbnumber;
    @BindView(R.id.txt_prof_altnumber)
    TextView txt_prof_altnumber;
    @BindView(R.id.txt_prof_emailid)
    TextView txt_prof_emailid;
    @BindView(R.id.txt_prof_address)
    TextView txt_prof_address;
    @BindView(R.id.txt_geolocation)
    TextView txt_geolocation;
    @BindView(R.id.t_goldenloc)
    TextView t_goldenloc;
    @BindView(R.id.txt_goldenlocation)
    TextView txt_goldenlocation;
    @BindView(R.id.edt_prof_regno)
    EditText edt_prof_regno;
    @BindView(R.id.edt_prof_gst)
    EditText edt_prof_gst;
    @BindView(R.id.edt_prof_pan)
    EditText edt_prof_pan;
    @BindView(R.id.edt_prof_lgname)
    EditText edt_prof_lgname;
    @BindView(R.id.edt_prof_cpname)
    EditText edt_prof_cpname;
    @BindView(R.id.edt_prof_mbnumber)
    EditText edt_prof_mbnumber;
    @BindView(R.id.edt_prof_altnumber)
    EditText edt_prof_altnumber;
    @BindView(R.id.edt_prof_email)
    EditText edt_prof_email;
    @BindView(R.id.edt_prof_address)
    EditText edt_prof_address;

    @BindView(R.id.btn_prof_restpassw)
    Button btn_prof_restpassw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);
        img_profile_back.setOnClickListener(this);
        img_get_maploc.setOnClickListener(this);
        img_get_currentloc.setOnClickListener(this);
        btn_prof_restpassw.setOnClickListener(this);
        btn_prof_restpassw.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));

        tv_profile_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        t_geoloc.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_prof_regno.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_prof_gst.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_prof_pan.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_prof_lgname.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_prof_cpname.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_prof_mbnumber.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_prof_altnumber.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_prof_emailid.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_prof_address.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_geolocation.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        txt_goldenlocation.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        t_goldenloc.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        edt_prof_regno.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_prof_gst.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_prof_pan.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_prof_lgname.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_prof_cpname.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_prof_mbnumber.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_prof_altnumber.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_prof_email.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_prof_address.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));


    }


    @Override
    public void onClick(View v) {
        {
            switch (v.getId()) {
                case R.id.btn_prof_restpassw:

                    break;
                case R.id.img_get_maploc:
                    Intent i1 = new Intent(EditProfile.this, MapActivity.class);
                    startActivityForResult(i1, 1);
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

                    break;
                case R.id.img_profile_back:
                    finish();
                    overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);

                    break;
                case R.id.img_get_currentloc:
                    Intent i2 = new Intent(EditProfile.this, MapActivity.class);
                    startActivityForResult(i2, 2);
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);

                    break;
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int permission = ContextCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION);
        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                if (permission == PackageManager.PERMISSION_GRANTED) {
                    String strEditText = data.getStringExtra("editTextValue");
                    txt_goldenlocation.setText(strEditText);
                }
            }
        } else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                if (permission == PackageManager.PERMISSION_GRANTED) {
                    String strEditText = data.getStringExtra("editTextValue");
                    txt_geolocation.setText(strEditText);
                }
            }
        }
    }

}

