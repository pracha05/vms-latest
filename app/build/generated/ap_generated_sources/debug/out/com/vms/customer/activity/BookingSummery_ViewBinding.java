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

public class BookingSummery_ViewBinding implements Unbinder {
  private BookingSummery target;

  @UiThread
  public BookingSummery_ViewBinding(BookingSummery target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BookingSummery_ViewBinding(BookingSummery target, View source) {
    this.target = target;

    target.img_booksum_back = Utils.findRequiredViewAsType(source, R.id.img_booksum_back, "field 'img_booksum_back'", ImageView.class);
    target.tv_booksum_header = Utils.findRequiredViewAsType(source, R.id.tv_booksum_header, "field 'tv_booksum_header'", TextView.class);
    target.rc_bookingsummary = Utils.findRequiredViewAsType(source, R.id.rc_bookingsummary, "field 'rc_bookingsummary'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BookingSummery target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_booksum_back = null;
    target.tv_booksum_header = null;
    target.rc_bookingsummary = null;
    target.progressBar = null;
  }
}
