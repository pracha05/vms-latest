package com.vms.customer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;
import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.model.forgotpassword.RecreatePasswordRequestModel;
import com.vms.customer.model.forgotpassword.RecreatePasswordResponseModel;
import com.vms.customer.model.registration.RegistrationResponseModel;
import com.vms.customer.network.NetworkConstant;
import com.vms.customer.service.SmartDialogClickListener;
import com.vms.customer.service.VmsApiClient;
import com.vms.customer.service.VmsWebService;
import com.vms.customer.utils.SmartDialog;
import com.vms.customer.utils.SmartDialogBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ForgotPasswordActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @BindView(R.id.et_password)
    EditText edtNewPassword;

    @BindView(R.id.et_re_password)
    EditText edtRePassword;

    @BindView(R.id.btn_submit)
    Button btnSubmit;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.root_layout)
    RelativeLayout rootLayout;

    private VmsWebService apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        apiInterface =   apiInterface = VmsApiClient.getClient().create(VmsWebService.class);
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.title_forgot_password);

            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
            });
        }
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                if (isConnected()) {
                    if (validate()) {
                        RecreatePasswordRequestModel recreatePasswordRequestModel = new RecreatePasswordRequestModel(
                                edtNewPassword.getText().toString(), edtRePassword.getText().toString(), NetworkConstant.STEP_THREE);
                        Call<RecreatePasswordResponseModel> call = apiInterface.recreatePassword(recreatePasswordRequestModel);
                        call.enqueue(new Callback<RecreatePasswordResponseModel>() {
                            @Override
                            public void onResponse(Call<RecreatePasswordResponseModel> call, Response<RecreatePasswordResponseModel> response) {
                                RecreatePasswordResponseModel recreatePasswordResponseModel = response.body();
                                Timber.d("Response message" + recreatePasswordResponseModel.getMessage());
                                if (recreatePasswordResponseModel.getStatus() == NetworkConstant.STATUS_ONE) {
                                    progressBar.setVisibility(View.GONE);
                                    showSuccessDialog(recreatePasswordResponseModel.getMessage());

                                }else {
                                    progressBar.setVisibility(View.GONE);
                                    progressBar.setVisibility(View.GONE);
                                    if (recreatePasswordResponseModel.getMessage() != null
                                            && !recreatePasswordResponseModel.getMessage().isEmpty()) {
                                        showErrorDialog(recreatePasswordResponseModel.getMessage());
                                    } else {
                                        showErrorDialog(getString(R.string.general_error_message));
                                    }
                                }
                            }@Override
                            public void onFailure(Call<RecreatePasswordResponseModel> call, Throwable t) {
                                Log.d("FAIL", "onfail");
                                progressBar.setVisibility(View.GONE);
                                showErrorDialog(getString(R.string.general_error_message));
                                call.cancel();
                            }
                        });
                    }
                }
                break;

        }
    }

    /**
     * validate sign up fields
     *
     * @return
     */
    public boolean validate() {
        String newPassword = edtNewPassword.getText().toString();
        String reNewPassword = edtRePassword.getText().toString();
        if (newPassword.isEmpty() || reNewPassword.isEmpty()) {
            Snackbar
                    .make(rootLayout, R.string.password_blank,
                            Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }
        if ((newPassword.length() < 6 || newPassword.length() > 12) ||
                (reNewPassword.length() < 6 || reNewPassword.length() > 12)) {
            Snackbar
                    .make(rootLayout, R.string.password_length,
                            Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }

        if (!newPassword.equals(reNewPassword)) {
            Snackbar
                    .make(rootLayout, R.string.password_mismatch,
                            Snackbar.LENGTH_SHORT)
                    .show();
            return false;
        }
        return true;
    }

    /**
     * show error dialog
     */

    public void showSuccessDialog(String message) {
        new SmartDialogBuilder(this)
                .setTitle("Error")
                .setSubTitle(message)
                .setCancalable(false)
                .setNegativeButtonHide(true) //hide cancel button
                .setPositiveButton("OK", new SmartDialogClickListener() {
                    @Override
                    public void onClick(SmartDialog smartDialog) {
                        Intent intent = IntentFactory.createUserLoginActivity(ForgotPasswordActivity.this);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK
                                |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        finishAffinity();
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                        smartDialog.dismiss();
                    }
                }).build().show();
    }
}
