// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ForgotPasswordActivity_ViewBinding implements Unbinder {
  private ForgotPasswordActivity target;

  @UiThread
  public ForgotPasswordActivity_ViewBinding(ForgotPasswordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ForgotPasswordActivity_ViewBinding(ForgotPasswordActivity target, View source) {
    this.target = target;

    target.mToolBar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolBar'", Toolbar.class);
    target.edtNewPassword = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'edtNewPassword'", EditText.class);
    target.edtRePassword = Utils.findRequiredViewAsType(source, R.id.et_re_password, "field 'edtRePassword'", EditText.class);
    target.btnSubmit = Utils.findRequiredViewAsType(source, R.id.btn_submit, "field 'btnSubmit'", Button.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    target.rootLayout = Utils.findRequiredViewAsType(source, R.id.root_layout, "field 'rootLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ForgotPasswordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolBar = null;
    target.edtNewPassword = null;
    target.edtRePassword = null;
    target.btnSubmit = null;
    target.progressBar = null;
    target.rootLayout = null;
  }
}
