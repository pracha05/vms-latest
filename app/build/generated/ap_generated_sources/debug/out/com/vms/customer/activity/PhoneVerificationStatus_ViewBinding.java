// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PhoneVerificationStatus_ViewBinding implements Unbinder {
  private PhoneVerificationStatus target;

  @UiThread
  public PhoneVerificationStatus_ViewBinding(PhoneVerificationStatus target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PhoneVerificationStatus_ViewBinding(PhoneVerificationStatus target, View source) {
    this.target = target;

    target.tvTextStatus = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvTextStatus'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PhoneVerificationStatus target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTextStatus = null;
  }
}
