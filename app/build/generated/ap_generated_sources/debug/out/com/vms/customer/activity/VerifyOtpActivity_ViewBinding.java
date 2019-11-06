// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.goodiebag.pinview.Pinview;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VerifyOtpActivity_ViewBinding implements Unbinder {
  private VerifyOtpActivity target;

  @UiThread
  public VerifyOtpActivity_ViewBinding(VerifyOtpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VerifyOtpActivity_ViewBinding(VerifyOtpActivity target, View source) {
    this.target = target;

    target.mToolBar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolBar'", Toolbar.class);
    target.tvResendCode = Utils.findRequiredViewAsType(source, R.id.resend, "field 'tvResendCode'", TextView.class);
    target.tvPhoneText = Utils.findRequiredViewAsType(source, R.id.phone_text, "field 'tvPhoneText'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    target.btnVerifyOTP = Utils.findRequiredViewAsType(source, R.id.btn_verify_otp, "field 'btnVerifyOTP'", Button.class);
    target.otpView = Utils.findRequiredViewAsType(source, R.id.otp_view, "field 'otpView'", Pinview.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VerifyOtpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolBar = null;
    target.tvResendCode = null;
    target.tvPhoneText = null;
    target.progressBar = null;
    target.btnVerifyOTP = null;
    target.otpView = null;
  }
}
