package com.vms.customer.activity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;

public class SignUpActivity extends BaseActivity {

    private static final String TAG = SignUpActivity.class.getName();

    @BindView(R.id.cb_business)
    CheckBox cbBusiness;

    @BindView(R.id.cb_person)
    CheckBox cbPerson;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_phone)
    EditText etPhone;

    @BindView(R.id.et_gst)
    EditText etGst;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.btn_sign_up)
    Button btnSignUp;

    @BindView(R.id.iv_logo_img_back)
    ImageView ivBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        btnSignUp.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        cbBusiness.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is business checked?
                if (((CheckBox) v).isChecked()) {
                    //uncheck person
                    if(cbPerson.isChecked())
                        cbPerson.setChecked(false);
//                    if((!etGst.isEnabled()))
//                        etGst.setEnabled(true);
                    if(etGst.getVisibility() == View.GONE){
                        etGst.setVisibility(View.VISIBLE);
                    }
                }

            }
        });

        cbPerson.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is business checked?
                if (((CheckBox) v).isChecked()) {
                    //uncheck person
                    if(cbBusiness.isChecked())
                        cbBusiness.setChecked(false);
//                    if((etGst.isEnabled()))
//                        etGst.setEnabled(false);
                    if(etGst.getVisibility() == View.VISIBLE){
                        etGst.setVisibility(View.GONE);
                    }
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_sign_up:
                startActivity(IntentFactory.createVerifyOtpActivity(this));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.iv_logo_img_back:
                    startActivity(IntentFactory.createUserLoginActivity(this));
                    overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                    break;
        }
    }
}
