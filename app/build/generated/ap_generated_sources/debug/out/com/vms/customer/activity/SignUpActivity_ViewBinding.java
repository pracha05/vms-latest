// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignUpActivity_ViewBinding implements Unbinder {
  private SignUpActivity target;

  @UiThread
  public SignUpActivity_ViewBinding(SignUpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SignUpActivity_ViewBinding(SignUpActivity target, View source) {
    this.target = target;

    target.cbBusiness = Utils.findRequiredViewAsType(source, R.id.cb_business, "field 'cbBusiness'", CheckBox.class);
    target.cbPerson = Utils.findRequiredViewAsType(source, R.id.cb_person, "field 'cbPerson'", CheckBox.class);
    target.etEmail = Utils.findRequiredViewAsType(source, R.id.et_email, "field 'etEmail'", EditText.class);
    target.etPhone = Utils.findRequiredViewAsType(source, R.id.et_phone, "field 'etPhone'", EditText.class);
    target.etGst = Utils.findRequiredViewAsType(source, R.id.et_gst, "field 'etGst'", EditText.class);
    target.etPassword = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'etPassword'", EditText.class);
    target.btnSignUp = Utils.findRequiredViewAsType(source, R.id.btn_sign_up, "field 'btnSignUp'", Button.class);
    target.ivBack = Utils.findRequiredViewAsType(source, R.id.iv_logo_img_back, "field 'ivBack'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignUpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cbBusiness = null;
    target.cbPerson = null;
    target.etEmail = null;
    target.etPhone = null;
    target.etGst = null;
    target.etPassword = null;
    target.btnSignUp = null;
    target.ivBack = null;
  }
}
