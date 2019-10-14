// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InsuranceProvider_ViewBinding implements Unbinder {
  private InsuranceProvider target;

  @UiThread
  public InsuranceProvider_ViewBinding(InsuranceProvider target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InsuranceProvider_ViewBinding(InsuranceProvider target, View source) {
    this.target = target;

    target.img_insurance_back = Utils.findRequiredViewAsType(source, R.id.img_insurance_back, "field 'img_insurance_back'", ImageView.class);
    target.tv_insurance_header = Utils.findRequiredViewAsType(source, R.id.tv_insurance_header, "field 'tv_insurance_header'", TextView.class);
    target.rc_insurance = Utils.findRequiredViewAsType(source, R.id.rc_insurance, "field 'rc_insurance'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InsuranceProvider target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_insurance_back = null;
    target.tv_insurance_header = null;
    target.rc_insurance = null;
    target.progressBar = null;
  }
}
