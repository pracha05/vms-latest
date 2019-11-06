package com.vms.customer.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.goodiebag.pinview.Pinview;
import com.vms.customer.R;
import com.vms.customer.VmsApplication;
import com.vms.customer.constant.Constant;
import com.vms.customer.constant.ReceiverConstant;
import com.vms.customer.intents.IntentFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    private String userId , OTPValue;

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
            phoneNumber = getIntent().getStringExtra(Constant.STRING_EXTRA);
            userId = getIntent().getStringExtra(Constant.STRING_EXTRA1);
            tvPhoneText.setText(Html.fromHtml(getString(R.string.phone_verify_text,phoneNumber)), TextView.BufferType.SPANNABLE);
            setClickableString("(change)", tvPhoneText.getText().toString(), tvPhoneText);
        }
        setClickableString("Resend Now", tvResendCode.getText().toString(), tvResendCode);

        otpView.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                OTPValue = pinview.getValue();
            }
        });

        btnVerifyOTP.setOnClickListener(this);
        tvResendCode.setOnClickListener(this);
    }

    /*
     * Receiver to listen sms , sms verification status.
     * more action can be added to listen more events.
     */
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (action != null) {
                    if (action.equals(ReceiverConstant.ACTION_VERIFICATION_SUCCESS)) {
                        onVerificationSuccessAction();
                    } else if (action.equals(ReceiverConstant.ACTION_VERIFICATION_FAILED)) {
                        onVerificationFailedAction();
                    }
                }
            }
        }
    };

    /**
     * on phone verification success
     *
     */
    private void onVerificationSuccessAction() {
        Timber.d(TAG, "Verified!");
        progressBar.setVisibility(View.GONE);
        startActivity(IntentFactory.createPhoneNumberVerificationStatusActivity(this));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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
                otpView.setValue(otp);

            }
        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_verify_otp) {
            onSubmitClicked(v);
        }
    }

    /**
     * onSubmit
     * @param view
     */
    public void onSubmitClicked(View view) {
        startActivity(IntentFactory.createPhoneNumberVerificationStatusActivity(this));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        if (OTPValue!=null && !OTPValue.isEmpty()) {
            progressBar.setVisibility(View.VISIBLE);
            //start otp verification
        }
    }
}
