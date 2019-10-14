// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TermsOfUseActivity_ViewBinding implements Unbinder {
  private TermsOfUseActivity target;

  @UiThread
  public TermsOfUseActivity_ViewBinding(TermsOfUseActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TermsOfUseActivity_ViewBinding(TermsOfUseActivity target, View source) {
    this.target = target;

    target.mToolBar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolBar'", Toolbar.class);
    target.tvWelcomeText = Utils.findRequiredViewAsType(source, R.id.welcome_text, "field 'tvWelcomeText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TermsOfUseActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolBar = null;
    target.tvWelcomeText = null;
  }
}
