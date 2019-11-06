// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignInActivity_ViewBinding implements Unbinder {
  private SignInActivity target;

  @UiThread
  public SignInActivity_ViewBinding(SignInActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SignInActivity_ViewBinding(SignInActivity target, View source) {
    this.target = target;

    target.tvSignUp = Utils.findRequiredViewAsType(source, R.id.tv_registration, "field 'tvSignUp'", TextView.class);
    target.edtEmail = Utils.findRequiredViewAsType(source, R.id.et_email, "field 'edtEmail'", EditText.class);
    target.tvForgotPassword = Utils.findRequiredViewAsType(source, R.id.forgot_password, "field 'tvForgotPassword'", TextView.class);
    target.rootLayout = Utils.findRequiredViewAsType(source, R.id.root_layout, "field 'rootLayout'", RelativeLayout.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    target.edtPassword = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'edtPassword'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignInActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvSignUp = null;
    target.edtEmail = null;
    target.tvForgotPassword = null;
    target.rootLayout = null;
    target.progressBar = null;
    target.edtPassword = null;
  }
}
