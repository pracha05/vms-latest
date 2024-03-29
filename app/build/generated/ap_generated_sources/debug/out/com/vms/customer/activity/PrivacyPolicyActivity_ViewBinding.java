// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PrivacyPolicyActivity_ViewBinding implements Unbinder {
  private PrivacyPolicyActivity target;

  @UiThread
  public PrivacyPolicyActivity_ViewBinding(PrivacyPolicyActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PrivacyPolicyActivity_ViewBinding(PrivacyPolicyActivity target, View source) {
    this.target = target;

    target.mToolBar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolBar'", Toolbar.class);
    target.tvWelcomeText = Utils.findRequiredViewAsType(source, R.id.welcome_text, "field 'tvWelcomeText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PrivacyPolicyActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolBar = null;
    target.tvWelcomeText = null;
  }
}
