package com.vms.customer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

import com.google.android.material.snackbar.Snackbar;
import com.vms.customer.R;
import com.vms.customer.VmsApplication;
import com.vms.customer.constant.Constant;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.model.signin.SignInRequestModel;
import com.vms.customer.model.signin.SignInResponseModel;
import com.vms.customer.network.NetworkConstant;
import com.vms.customer.service.VmsApiClient;
import com.vms.customer.service.VmsWebService;
import com.vms.customer.ui.ViewDialog;

import java.security.NoSuchAlgorithmException;

public class SignInActivity extends BaseActivity {

    private static final String TAG = SignInActivity.class.getName();

    @BindView(R.id.tv_registration)
    TextView tvSignUp;

    @BindView(R.id.et_email)
    EditText edtEmail;

    @BindView(R.id.forgot_password)
    TextView tvForgotPassword;

    @BindView(R.id.root_layout)
    RelativeLayout rootLayout;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private VmsWebService apiInterface;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        tvSignUp.setOnClickListener(this);
        apiInterface = VmsApiClient.getClient().create(VmsWebService.class);
        edtEmail.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= edtEmail.getTotalPaddingRight()) {
                       //start dashboard activity
//                        startActivity(new Intent(SignInActivity.this,HomeActivity.class));
//                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                        finish();

                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                            try {
                                if (validate()) {
                                    progressBar.setVisibility(View.VISIBLE);
                                    SignInRequestModel signInRequestModel = new SignInRequestModel(edtEmail.getText().toString(),NetworkConstant.STEP_ONE);
                                    Call<SignInResponseModel> call = apiInterface.getUser(signInRequestModel);
                                    call.enqueue(new Callback<SignInResponseModel>() {
                                        @Override
                                        public void onResponse(Call<SignInResponseModel> call, Response<SignInResponseModel> response) {
                                            SignInResponseModel signInResponseModel = response.body();
                                            Timber.d("Response message" + signInResponseModel.message);
                                            if (signInResponseModel.status == NetworkConstant.STATUS_ONE) {
                                                progressBar.setVisibility(View.GONE);
                                                tvForgotPassword.setVisibility(View.VISIBLE);
                                            } else {
                                                progressBar.setVisibility(View.GONE);
                                                startActivity(IntentFactory.createRegistrationActivity(SignInActivity.this));
                                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                                tvForgotPassword.setVisibility(View.GONE);
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<SignInResponseModel> call, Throwable t) {
                                            Log.d("FAIL","onfail");
                                            progressBar.setVisibility(View.GONE);
                                            showErrorDialog(getString(R.string.general_error_message));
                                            call.cancel();
                                        }
                                    });
                                }//if
                            }catch (Exception e) {
                                Timber.e("catched  Exception Message : " + e.getMessage());
                            }
                        return true;
                    }
                }
                return false;
            }
        });
    }


    /**
     * validate user inputs for signup and return status
     *
     * @return
     */
    public boolean validate() {
        String email = this.edtEmail.getText().toString();
        if(email.isEmpty()){
            Snackbar
                    .make(rootLayout, R.string.sign_in_error_mesage,
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

        if (((email.matches("[0-9]+") && email.length() > 2) && (email.length() < Constant.MOBILE_NUMBER_MINIMUM_LENGTH))){
            Snackbar
                    .make(rootLayout, R.string.mobile_number_error_mesage,
                            Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }

        if(email.matches("[0-9]+") && email.matches("[a-zA-Z]+")){
            Snackbar
                    .make(rootLayout, R.string.sign_in_error_mesage,
                            Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.tv_registration:
                startActivity(IntentFactory.createRegistrationActivity(this));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }
}
