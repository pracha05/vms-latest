// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
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

    target.mToolBar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolBar'", Toolbar.class);
    target.layoutBusiness = Utils.findRequiredViewAsType(source, R.id.cv_business, "field 'layoutBusiness'", RelativeLayout.class);
    target.layoutPerson = Utils.findRequiredViewAsType(source, R.id.cv_person, "field 'layoutPerson'", RelativeLayout.class);
    target.cbBusiness = Utils.findRequiredViewAsType(source, R.id.cb_business, "field 'cbBusiness'", CheckBox.class);
    target.cbPerson = Utils.findRequiredViewAsType(source, R.id.cb_person, "field 'cbPerson'", CheckBox.class);
    target.etEmail = Utils.findRequiredViewAsType(source, R.id.et_email, "field 'etEmail'", EditText.class);
    target.etPhone = Utils.findRequiredViewAsType(source, R.id.et_phone, "field 'etPhone'", EditText.class);
    target.etGst = Utils.findRequiredViewAsType(source, R.id.et_gst, "field 'etGst'", EditText.class);
    target.etPassword = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'etPassword'", EditText.class);
    target.btnSignUp = Utils.findRequiredViewAsType(source, R.id.btn_sign_up, "field 'btnSignUp'", Button.class);
    target.ivBusiness = Utils.findRequiredViewAsType(source, R.id.iv_business, "field 'ivBusiness'", ImageView.class);
    target.ivPersion = Utils.findRequiredViewAsType(source, R.id.iv_person, "field 'ivPersion'", ImageView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    target.rootLayout = Utils.findRequiredViewAsType(source, R.id.root_layout, "field 'rootLayout'", RelativeLayout.class);
    target.tvBusinessText = Utils.findRequiredViewAsType(source, R.id.iv_business_text, "field 'tvBusinessText'", TextView.class);
    target.tvPersonText = Utils.findRequiredViewAsType(source, R.id.iv_person_text, "field 'tvPersonText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignUpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolBar = null;
    target.layoutBusiness = null;
    target.layoutPerson = null;
    target.cbBusiness = null;
    target.cbPerson = null;
    target.etEmail = null;
    target.etPhone = null;
    target.etGst = null;
    target.etPassword = null;
    target.btnSignUp = null;
    target.ivBusiness = null;
    target.ivPersion = null;
    target.progressBar = null;
    target.rootLayout = null;
    target.tvBusinessText = null;
    target.tvPersonText = null;
  }
}
