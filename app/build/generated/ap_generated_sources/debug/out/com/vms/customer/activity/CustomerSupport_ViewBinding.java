// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomerSupport_ViewBinding implements Unbinder {
  private CustomerSupport target;

  @UiThread
  public CustomerSupport_ViewBinding(CustomerSupport target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CustomerSupport_ViewBinding(CustomerSupport target, View source) {
    this.target = target;

    target.img_support_back = Utils.findRequiredViewAsType(source, R.id.img_support_back, "field 'img_support_back'", ImageView.class);
    target.tv_support_header = Utils.findRequiredViewAsType(source, R.id.tv_support_header, "field 'tv_support_header'", TextView.class);
    target.rc_customersupport = Utils.findRequiredViewAsType(source, R.id.rc_customersupport, "field 'rc_customersupport'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CustomerSupport target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_support_back = null;
    target.tv_support_header = null;
    target.rc_customersupport = null;
    target.progressBar = null;
  }
}
