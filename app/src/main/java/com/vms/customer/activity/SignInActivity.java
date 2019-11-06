package com.vms.customer.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
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
import com.vms.customer.service.SmartDialogClickListener;
import com.vms.customer.service.VmsApiClient;
import com.vms.customer.service.VmsWebService;
import com.vms.customer.ui.ViewDialog;
import com.vms.customer.utils.NetworkConnection;
import com.vms.customer.utils.PlatformUtils;
import com.vms.customer.utils.SmartDialog;
import com.vms.customer.utils.SmartDialogBuilder;

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

    @BindView(R.id.et_password)
    EditText edtPassword;

    private VmsWebService apiInterface;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        tvSignUp.setOnClickListener(this);
        apiInterface = VmsApiClient.getClient().create(VmsWebService.class);
        tvForgotPassword.setOnClickListener(this);
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
                                if(isConnected()) {
                                    if (validate()) {
                                        progressBar.setVisibility(View.VISIBLE);
                                        SignInRequestModel signInRequestModel = new SignInRequestModel(edtEmail.getText().toString(), NetworkConstant.STEP_ONE);
                                        Call<SignInResponseModel> call = apiInterface.getUser(signInRequestModel);
                                        call.enqueue(new Callback<SignInResponseModel>() {
                                            @Override
                                            public void onResponse(Call<SignInResponseModel> call, Response<SignInResponseModel> response) {
                                                SignInResponseModel signInResponseModel = response.body();
                                                Timber.d("Response message" + signInResponseModel.message);
                                                if (signInResponseModel.status == NetworkConstant.STATUS_ONE) {
                                                    progressBar.setVisibility(View.GONE);
                                                    //email register ----> change UI
                                                    edtPassword.setVisibility(View.VISIBLE);
                                                    edtEmail.setVisibility(View.GONE);
                                                } else {
                                                    progressBar.setVisibility(View.GONE);
                                                    if (signInResponseModel.message != null
                                                            && !signInResponseModel.message.isEmpty()) {
                                                        showStatusDialog(signInResponseModel.message);
                                                    } else {
                                                        showErrorDialog(getString(R.string.general_error_message));
                                                    }
                                                    edtPassword.setVisibility(View.GONE);
                                                    edtEmail.setVisibility(View.VISIBLE);
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<SignInResponseModel> call, Throwable t) {
                                                Log.d("FAIL", "onfail");
                                                progressBar.setVisibility(View.GONE);
                                                showErrorDialog(getString(R.string.general_error_message));
                                                call.cancel();
                                            }
                                        });
                                    }//if
                                }else{
                                    //network not available
                                    showErrorDialog(getString(R.string.network_connection));
                                }
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

            case R.id.forgot_password:
                //handle forgot password
                showInputDialog();
                break;
        }
    }

    /**
     * show forgot password dialog
     */
    protected void showInputDialog() {

        LayoutInflater layoutInflater = LayoutInflater.from(SignInActivity.this);
        View promptView = layoutInflater.inflate(R.layout.user_input_dialog_box, null);
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(SignInActivity.this);
        alertDialogBuilder.setView(promptView);
        alertDialogBuilder.setTitle("");
        final EditText phoneNumber = (EditText) promptView.findViewById(R.id.input_phone);
        alertDialogBuilder.setCancelable(true)
                .setNegativeButton(getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton(getString(R.string.btn_submit), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        final AlertDialog alert = alertDialogBuilder.create();
        alert.show();
        alert.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phoneNumber.getText().toString().isEmpty() ||
                        phoneNumber.getText().toString().length()<10) {
                    phoneNumber.setError(getString(R.string.mobile_number_error_mesage));
                } else {
                    phoneNumber.setError(null);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (phoneNumber != null && SignInActivity.this != null) {
                                InputMethodManager imm = (InputMethodManager) SignInActivity.this
                                        .getSystemService(
                                                Context.INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(
                                        phoneNumber.getWindowToken(), 0);
                            }
                        }
                    }, 300);
                }
            }
        });
        alert.setCancelable(false);
        alert.getButton(alert.BUTTON_POSITIVE).setTextColor(PlatformUtils.getColorWrapper(getApplicationContext(), R.color.colorPrimary));
        alert.getButton(alert.BUTTON_NEGATIVE).setTextColor(PlatformUtils.getColorWrapper(getApplicationContext(), R.color.red_shade));
    }

    /**
     * show status dialog
     */

    public void showStatusDialog(String message){
        new SmartDialogBuilder(this)
                .setTitle("Information")
                .setSubTitle(message +".Please sign up!")
                .setCancalable(false)
                .setNegativeButtonHide(true) //hide cancel button
                .setPositiveButton("OK", new SmartDialogClickListener() {
                    @Override
                    public void onClick(SmartDialog smartDialog) {
                        //start sign up activity
                        startActivity(IntentFactory.createRegistrationActivity(SignInActivity.this));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        smartDialog.dismiss();
                    }
                }).build().show();


    }
}
