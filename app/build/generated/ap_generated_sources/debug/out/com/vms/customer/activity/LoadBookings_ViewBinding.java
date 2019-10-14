// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoadBookings_ViewBinding implements Unbinder {
  private LoadBookings target;

  @UiThread
  public LoadBookings_ViewBinding(LoadBookings target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoadBookings_ViewBinding(LoadBookings target, View source) {
    this.target = target;

    target.img_loadbook_back = Utils.findRequiredViewAsType(source, R.id.img_loadbook_back, "field 'img_loadbook_back'", ImageView.class);
    target.tv_loadbook_header = Utils.findRequiredViewAsType(source, R.id.tv_loadbook_header, "field 'tv_loadbook_header'", TextView.class);
    target.tv_lb_sheader = Utils.findRequiredViewAsType(source, R.id.tv_lb_sheader, "field 'tv_lb_sheader'", TextView.class);
    target.btn_fullload = Utils.findRequiredViewAsType(source, R.id.btn_fullload, "field 'btn_fullload'", Button.class);
    target.btn_box = Utils.findRequiredViewAsType(source, R.id.btn_box, "field 'btn_box'", Button.class);
    target.btn_partload = Utils.findRequiredViewAsType(source, R.id.btn_partload, "field 'btn_partload'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoadBookings target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_loadbook_back = null;
    target.tv_loadbook_header = null;
    target.tv_lb_sheader = null;
    target.btn_fullload = null;
    target.btn_box = null;
    target.btn_partload = null;
  }
}
