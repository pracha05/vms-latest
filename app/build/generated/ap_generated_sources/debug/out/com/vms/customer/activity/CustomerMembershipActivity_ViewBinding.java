// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomerMembershipActivity_ViewBinding implements Unbinder {
  private CustomerMembershipActivity target;

  @UiThread
  public CustomerMembershipActivity_ViewBinding(CustomerMembershipActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CustomerMembershipActivity_ViewBinding(CustomerMembershipActivity target, View source) {
    this.target = target;

    target.mToolBar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolBar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CustomerMembershipActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolBar = null;
  }
}
