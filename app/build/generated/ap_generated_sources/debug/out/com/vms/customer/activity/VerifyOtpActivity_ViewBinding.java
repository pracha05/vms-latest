// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
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
  }

  @Override
  @CallSuper
  public void unbind() {
    VerifyOtpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolBar = null;
  }
}
