package com.vms.customer.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.goodiebag.pinview.Pinview;
import com.vms.customer.R;
import com.vms.customer.VmsApplication;
import com.vms.customer.constant.Constant;
import com.vms.customer.constant.ReceiverConstant;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.model.ResendOtp;
import com.vms.customer.model.forgotpassword.ForgotPasswordRequestModel;
import com.vms.customer.model.forgotpassword.ForgotPasswordResponseModel;
import com.vms.customer.model.registration.RegistrationRequestModel;
import com.vms.customer.model.registration.RegistrationResponseModel;
import com.vms.customer.network.NetworkConstant;
import com.vms.customer.preferences.VmsPreferenceHelper;
import com.vms.customer.service.VmsApiClient;
import com.vms.customer.service.VmsWebService;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class VerifyOtpActivity extends BaseActivity {

    private static final String TAG = VerifyOtpActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @BindView(R.id.resend)
    TextView tvResendCode;

    @BindView(R.id.phone_text)
    TextView tvPhoneText;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.btn_verify_otp)
    Button btnVerifyOTP;

    @BindView(R.id.otp_view)
    Pinview otpView;

    private String phoneNumber;
    private int userId ;
    private String OTPFromMessage , OTPFromServer , email , password;

    private VmsWebService apiInterface;
    private boolean isFromForgotPassword;

    private String[] broadCastReceiverActionList = {
            ReceiverConstant.ACTION_RECEIVE_SMS_SUCCESS,
            ReceiverConstant.ACTION_VERIFICATION_SUCCESS,
            ReceiverConstant.ACTION_VERIFICATION_FAILED
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        ButterKnife.bind(this);
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.verify_otp);

            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
            });
        }
        if(getIntent()!=null){
            if(!getIntent().hasExtra(Constant.STRING_FORGOT_PASSWORD)) {
                phoneNumber = getIntent().getStringExtra(Constant.STRING_EXTRA);
                userId = getIntent().getIntExtra(Constant.STRING_EXTRA1, 1);
                email = getIntent().getStringExtra(Constant.STRING_EXTRA3);
                password = getIntent().getStringExtra(Constant.STRING_EXTRA4);
                OTPFromServer = getIntent().getStringExtra(Constant.STRING_EXTRA2);

            }else{
                phoneNumber = getIntent().getStringExtra(Constant.STRING_EXTRA);
                userId = getIntent().getIntExtra(Constant.STRING_EXTRA1, 1);
                OTPFromServer = getIntent().getStringExtra(Constant.STRING_EXTRA2);
            }
        }
        tvPhoneText.setText(Html.fromHtml(getString(R.string.phone_verify_text, phoneNumber)), TextView.BufferType.SPANNABLE);
        setClickableString("(change)", tvPhoneText.getText().toString(), tvPhoneText);
        setClickableResendString("Resend Now", tvResendCode.getText().toString(), tvResendCode);

        otpView.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                OTPFromMessage = pinview.getValue();
            }
        });

        btnVerifyOTP.setOnClickListener(this);
        tvResendCode.setOnClickListener(this);
    }
    /**
     * on phone verification success
     *
     */
    private void onVerificationSuccessAction() {
        Timber.d(TAG, "Verified!");
        progressBar.setVisibility(View.GONE);
        startActivity(IntentFactory.createPhoneNumberVerificationStatusActivity(this));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    /**
     * on phone verification fail.
     */

    private void onVerificationFailedAction() {
        progressBar.setVisibility(View.GONE);
        showErrorDialog("Phone number verification failed! Please try again or use resend option.");
    }


    /**
     * get clicable text
     * @param clickableValue
     * @param wholeValue
     * @param yourTextView
     */
    public void setClickableResendString(String clickableValue, String wholeValue, TextView yourTextView){
        String value = wholeValue;
        SpannableString spannableString = new SpannableString(value);
        int startIndex = value.indexOf(clickableValue);
        int endIndex = startIndex + clickableValue.length();
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(getResources().getColor(R.color.colorPrimary)); // specific color for this link
            }

            @Override
            public void onClick(View widget) {
               //do resend otp request
                progressBar.setVisibility(View.VISIBLE);
                apiInterface =   apiInterface = VmsApiClient.getClient().create(VmsWebService.class);
                ResendOtp resendOtp = new ResendOtp
                        (phoneNumber);
                Call<ForgotPasswordResponseModel> call = apiInterface.resendOTP(resendOtp);
                call.enqueue(new Callback<ForgotPasswordResponseModel>() {
                    @Override
                    public void onResponse(Call<ForgotPasswordResponseModel> call, Response<ForgotPasswordResponseModel> response) {
                        ForgotPasswordResponseModel forgotPasswordResponseModel = response.body();
                        Timber.d("Response message" + forgotPasswordResponseModel.getMessage());
                        if (forgotPasswordResponseModel.getStatus() == NetworkConstant.STATUS_ONE) {
                            progressBar.setVisibility(View.GONE);
                            OTPFromServer = forgotPasswordResponseModel.getOtp();
                        } else {
                            progressBar.setVisibility(View.GONE);
                            if (forgotPasswordResponseModel.getMessage() != null
                                    && !forgotPasswordResponseModel.getMessage().isEmpty()) {
                                showErrorDialog(forgotPasswordResponseModel.getMessage());
                            } else {
                                showErrorDialog(getString(R.string.general_error_message));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ForgotPasswordResponseModel> call, Throwable t) {
                        Log.d("FAIL", "onfail");
                        progressBar.setVisibility(View.GONE);
                        showErrorDialog(getString(R.string.general_error_message));
                        call.cancel();
                    }
                });
            }
        }, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        yourTextView.setText(spannableString);
        yourTextView.setHighlightColor(
                Color.TRANSPARENT); // prevent TextView change background when highlight
        yourTextView.setMovementMethod(LinkMovementMethod.getInstance()); // <-- important, onClick in ClickableSpan won't work without this
    }



    /**
     * get clicable text
     * @param clickableValue
     * @param wholeValue
     * @param yourTextView
     */
    public void setClickableString(String clickableValue, String wholeValue, TextView yourTextView){
        String value = wholeValue;
        SpannableString spannableString = new SpannableString(value);
        int startIndex = value.indexOf(clickableValue);
        int endIndex = startIndex + clickableValue.length();
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(getResources().getColor(R.color.colorPrimary)); // specific color for this link
            }

            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
            }
        }, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        yourTextView.setText(spannableString);
        yourTextView.setHighlightColor(
                Color.TRANSPARENT); // prevent TextView change background when highlight
        yourTextView.setMovementMethod(LinkMovementMethod.getInstance()); // <-- important, onClick in ClickableSpan won't work without this
    }

    private BroadcastReceiver otpVerifyReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String actionLauncher = intent.getAction();
            if (actionLauncher.equals(ReceiverConstant.ACTION_RECEIVE_SMS_SUCCESS)) {
                //receive sms
                String otp = intent.getStringExtra(Constant.STRING_EXTRA);
                Timber.d("Message listener "+otp);
                otpView.setValue(otp);
            } if (actionLauncher.equals(ReceiverConstant.ACTION_VERIFICATION_SUCCESS)) {
                onVerificationSuccessAction();
            } else if (actionLauncher.equals(ReceiverConstant.ACTION_VERIFICATION_FAILED)) {
                onVerificationFailedAction();
            }
        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_verify_otp) {
            onSubmitClicked(v);
        }
    }

    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.otpVerifyReceiver);
    }

    protected void onResume() {
        super.onResume();
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        for (String action : this.broadCastReceiverActionList) {
            broadcastManager.registerReceiver(this.otpVerifyReceiver, new IntentFilter(action));
        }
    }

    /**
     * onSubmit
     * @param view
     */
    public void onSubmitClicked(View view) {

        if (OTPFromMessage!=null && !OTPFromMessage.isEmpty()) {

            progressBar.setVisibility(View.VISIBLE);
            apiInterface =   apiInterface = VmsApiClient.getClient().create(VmsWebService.class);
            //registration request
            if (!getIntent().hasExtra(Constant.STRING_FORGOT_PASSWORD)) {
                RegistrationRequestModel registrationRequestModel = new RegistrationRequestModel
                        (userId, OTPFromMessage, OTPFromServer, NetworkConstant.STEP_TWO);
                Call<RegistrationResponseModel> call = apiInterface.createUser(registrationRequestModel);
                call.enqueue(new Callback<RegistrationResponseModel>() {
                    @Override
                    public void onResponse(Call<RegistrationResponseModel> call, Response<RegistrationResponseModel> response) {
                        RegistrationResponseModel registrationResponseModel = response.body();
                        Timber.d("Response message" + registrationResponseModel.getMessage());
                        if (registrationResponseModel.getStatus() == NetworkConstant.STATUS_ONE) {
                            progressBar.setVisibility(View.GONE);
                            VmsPreferenceHelper.saveEmailToPreference(VerifyOtpActivity.this, email);
                            VmsPreferenceHelper.savePhoneNumberToPreference(VerifyOtpActivity.this, phoneNumber);
                            VmsPreferenceHelper.savePasswordToPreference(VerifyOtpActivity.this, password);
                            onVerificationSuccessAction();
                        } else {
                            progressBar.setVisibility(View.GONE);
                            if (registrationResponseModel.getMessage() != null
                                    && !registrationResponseModel.getMessage().isEmpty()) {
                                showErrorDialog(registrationResponseModel.getMessage());
                            } else {
                                showErrorDialog(getString(R.string.general_error_message));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RegistrationResponseModel> call, Throwable t) {
                        Log.d("FAIL", "onfail");
                        progressBar.setVisibility(View.GONE);
                        showErrorDialog(getString(R.string.general_error_message));
                        call.cancel();
                    }
                });
            }else{
                ForgotPasswordRequestModel forgotPasswordRequestModel = new ForgotPasswordRequestModel
                        (userId,OTPFromMessage, OTPFromServer, NetworkConstant.STEP_TWO);
                Call<ForgotPasswordResponseModel> call = apiInterface.resetPassword(forgotPasswordRequestModel);
                call.enqueue(new Callback<ForgotPasswordResponseModel>() {
                    @Override
                    public void onResponse(Call<ForgotPasswordResponseModel> call, Response<ForgotPasswordResponseModel> response) {
                        ForgotPasswordResponseModel forgotPasswordResponseModel = response.body();
                        Timber.d("Response message" + forgotPasswordResponseModel.getMessage());
                        if (forgotPasswordResponseModel.getStatus() == NetworkConstant.STATUS_ONE) {
                            progressBar.setVisibility(View.GONE);
                            //otp match
                            startActivity(IntentFactory.createForgotPasswordActivity(VerifyOtpActivity.this));
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            finish();
                        } else {
                            progressBar.setVisibility(View.GONE);
                            if (forgotPasswordResponseModel.getMessage() != null
                                    && !forgotPasswordResponseModel.getMessage().isEmpty()) {
                                showErrorDialog(forgotPasswordResponseModel.getMessage());
                            } else {
                                showErrorDialog(getString(R.string.general_error_message));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ForgotPasswordResponseModel> call, Throwable t) {
                        Log.d("FAIL", "onfail");
                        progressBar.setVisibility(View.GONE);
                        showErrorDialog(getString(R.string.general_error_message));
                        call.cancel();
                    }
                });
            }
        }//if
    }
}
