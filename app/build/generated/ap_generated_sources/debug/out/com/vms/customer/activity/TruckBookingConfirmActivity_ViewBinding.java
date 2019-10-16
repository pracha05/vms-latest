// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TruckBookingConfirmActivity_ViewBinding implements Unbinder {
  private TruckBookingConfirmActivity target;

  @UiThread
  public TruckBookingConfirmActivity_ViewBinding(TruckBookingConfirmActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TruckBookingConfirmActivity_ViewBinding(TruckBookingConfirmActivity target, View source) {
    this.target = target;

    target.img_bookcnfm_back = Utils.findRequiredViewAsType(source, R.id.img_bookcnfm_back, "field 'img_bookcnfm_back'", ImageView.class);
    target.tv_bookcnfm_header = Utils.findRequiredViewAsType(source, R.id.tv_bookcnfm_header, "field 'tv_bookcnfm_header'", TextView.class);
    target.rc_bookedtrucklist = Utils.findRequiredViewAsType(source, R.id.rc_bookedtrucklist, "field 'rc_bookedtrucklist'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TruckBookingConfirmActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_bookcnfm_back = null;
    target.tv_bookcnfm_header = null;
    target.rc_bookedtrucklist = null;
  }
}
