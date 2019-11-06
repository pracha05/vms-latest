package com.vms.customer.activity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

import com.google.android.material.snackbar.Snackbar;
import com.vms.customer.R;
import com.vms.customer.constant.Constant;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.model.registration.RegistrationRequestModel;
import com.vms.customer.model.registration.RegistrationResponseModel;
import com.vms.customer.model.signin.SignInRequestModel;
import com.vms.customer.model.signin.SignInResponseModel;
import com.vms.customer.network.NetworkConstant;
import com.vms.customer.preferences.VmsPreferenceHelper;
import com.vms.customer.service.VmsApiClient;
import com.vms.customer.service.VmsWebService;
import com.vms.customer.utils.GSTINValidator;
import com.vms.customer.utils.PlatformUtils;

public class SignUpActivity extends BaseActivity {

    private static final String TAG = SignUpActivity.class.getName();

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @BindView(R.id.cv_business)
    RelativeLayout layoutBusiness;

    @BindView(R.id.cv_person)
    RelativeLayout layoutPerson;

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

    @BindView(R.id.iv_business)
    ImageView ivBusiness;

    @BindView(R.id.iv_person)
    ImageView  ivPersion;
//
//    @BindView(R.id.iv_logo_img_back)
//    ImageView ivBack;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.root_layout)
    RelativeLayout rootLayout;

    @BindView(R.id.iv_business_text)
    TextView tvBusinessText;

    @BindView(R.id.iv_person_text)
    TextView tvPersonText;


    private VmsWebService apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.create_one);

            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
            });
        }
        btnSignUp.setOnClickListener(this);
        layoutPerson.setOnClickListener(this);
        layoutBusiness.setOnClickListener(this);
      //  ivBack.setOnClickListener(this);
        apiInterface = VmsApiClient.getClient().create(VmsWebService.class);
        cbBusiness.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is business checked?
                if (((CheckBox) v).isChecked()) {
                    //uncheck person
                    if (cbPerson.isChecked())
                        cbPerson.setChecked(false);
//                    if((!etGst.isEnabled()))
//                        etGst.setEnabled(true);
                    if (etGst.getVisibility() == View.GONE) {
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
                    if (cbBusiness.isChecked())
                        cbBusiness.setChecked(false);
//                    if((etGst.isEnabled()))
//                        etGst.setEnabled(false);
                    if (etGst.getVisibility() == View.VISIBLE) {
                        etGst.setVisibility(View.GONE);
                    }
                }

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_up:
                Intent intent = IntentFactory.createVerifyOtpActivity(SignUpActivity.this);
                intent.putExtra(Constant.STRING_EXTRA, etPhone.getText().toString());
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                progressBar.setVisibility(View.VISIBLE);
//                if (validate()) {
//                    RegistrationRequestModel registrationRequestModel = new RegistrationRequestModel
//                            (etEmail.getText().toString(), etPassword.getText().toString(),
//                                    etPhone.getText().toString(), NetworkConstant.ACCOUNT_TYPE_BUSINESS, NetworkConstant.STEP_ONE,
//                                    etGst.getText().toString());
//                    Call<RegistrationResponseModel> call = apiInterface.createUser(registrationRequestModel);
//                    call.enqueue(new Callback<RegistrationResponseModel>() {
//                        @Override
//                        public void onResponse(Call<RegistrationResponseModel> call, Response<RegistrationResponseModel> response) {
//                            RegistrationResponseModel registrationResponseModel = response.body();
//                            Timber.d("Response message" + registrationResponseModel.getMessage());
//                            if (registrationResponseModel.getStatus() == NetworkConstant.STATUS_ONE) {
//                                progressBar.setVisibility(View.GONE);
//                                VmsPreferenceHelper.saveCustomerIdToPreference(SignUpActivity.this,String.valueOf(registrationResponseModel.getId()));
//                                Intent intent = IntentFactory.createVerifyOtpActivity(SignUpActivity.this);
//                                intent.putExtra(Constant.STRING_EXTRA, etPhone.getText().toString());
//                                intent.putExtra(Constant.STRING_EXTRA1,String.valueOf(registrationResponseModel.getId()));
//                                intent.putExtra(Constant.STRING_EXTRA2,registrationResponseModel.getOtp());
//                                startActivity(intent);
//                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                            } else {
//                                progressBar.setVisibility(View.GONE);
//                                progressBar.setVisibility(View.GONE);
//                                if(registrationResponseModel.getMessage()!=null
//                                        && !registrationResponseModel.getMessage().isEmpty()){
//                                    showErrorDialog(registrationResponseModel.getMessage());
//                                }else {
//                                    showErrorDialog(getString(R.string.general_error_message));
//                                }
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<RegistrationResponseModel> call, Throwable t) {
//                            Log.d("FAIL", "onfail");
//                            progressBar.setVisibility(View.GONE);
//                            showErrorDialog(getString(R.string.general_error_message));
//                            call.cancel();
//                        }
//                    });
//                }
                break;
//            case R.id.iv_logo_img_back:
//                startActivity(IntentFactory.createUserLoginActivity(this));
//                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
//                break;

            case R.id.cv_business:
                layoutBusiness.setBackgroundResource(R.drawable.card_view_border_red);
                layoutPerson.setBackgroundResource(R.drawable.card_view_border);
                tvBusinessText.setTextColor(PlatformUtils.getColorWrapper(this,R.color.colorWhite));
                tvPersonText.setTextColor(PlatformUtils.getColorWrapper(this,R.color.colorLightDarkGray));
                cbBusiness.setChecked(true);
                ivBusiness.setBackgroundResource(R.drawable.ic_business_white);
                ivPersion.setBackgroundResource(R.drawable.ic_launcher_user_gray);
                if (etGst.getVisibility() == View.GONE) {
                    etGst.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.cv_person:
                layoutPerson.setBackgroundResource(R.drawable.card_view_border_red);
                layoutBusiness.setBackgroundResource(R.drawable.card_view_border);
                tvPersonText.setTextColor(PlatformUtils.getColorWrapper(this,R.color.colorWhite));
                tvBusinessText.setTextColor(PlatformUtils.getColorWrapper(this,R.color.colorLightDarkGray));
                cbPerson.setChecked(true);
                ivPersion.setBackgroundResource(R.drawable.ic_launcher_user);
                ivBusiness.setBackgroundResource(R.drawable.ic_business);
                if (etGst.getVisibility() == View.VISIBLE) {
                    etGst.setVisibility(View.GONE);
                }
                break;

        }

    }

    /**
     * validate sign up fields
     * @return
     */
    public boolean validate() {
        String email = this.etEmail.getText().toString();
        String phone = this.etPhone.getText().toString();
        String gst = this.etGst.getText().toString();
        String password = this.etPassword.getText().toString();

        if (email.isEmpty()) {
            Snackbar
                    .make(rootLayout, R.string.email_blank,
                            Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }

        if (email.matches("[a-zA-Z]+") && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Snackbar
                    .make(rootLayout, R.string.email_error_mesage,
                            Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }

        if (phone.isEmpty() || phone.length() < 10) {
            Snackbar
                    .make(rootLayout, R.string.mobile_number_error_mesage,
                            Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }

        if (cbBusiness.isChecked()) {
            if (gst.isEmpty()) {
                Snackbar
                        .make(rootLayout, R.string.gst_blank,
                                Snackbar.LENGTH_SHORT)
                        .show();
                return false;
            }

            try {
                if (GSTINValidator.validGSTIN(gst)) {
                    return true;
                } else {
                    Snackbar
                            .make(rootLayout, R.string.gst_number_error_mesage,
                                    Snackbar.LENGTH_SHORT)
                            .show();
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }

        if (password.isEmpty()) {
            Snackbar
                    .make(rootLayout, R.string.password_blank,
                            Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }

        if (password.length() < 6) {
            Snackbar
                    .make(rootLayout, R.string.password_size_check,
                            Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }

        return true;

    }
}
