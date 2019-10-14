// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListOfVechilesActivity_ViewBinding implements Unbinder {
  private ListOfVechilesActivity target;

  @UiThread
  public ListOfVechilesActivity_ViewBinding(ListOfVechilesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListOfVechilesActivity_ViewBinding(ListOfVechilesActivity target, View source) {
    this.target = target;

    target.img_listoftruck_back = Utils.findRequiredViewAsType(source, R.id.img_listoftruck_back, "field 'img_listoftruck_back'", ImageView.class);
    target.tv_listoftruck_header = Utils.findRequiredViewAsType(source, R.id.tv_listoftruck_header, "field 'tv_listoftruck_header'", TextView.class);
    target.rc_trucklist = Utils.findRequiredViewAsType(source, R.id.rc_trucklist, "field 'rc_trucklist'", RecyclerView.class);
    target.btn_book_trucks = Utils.findRequiredViewAsType(source, R.id.btn_book_trucks, "field 'btn_book_trucks'", Button.class);
    target.btn_filter_three = Utils.findRequiredViewAsType(source, R.id.btn_filter_three, "field 'btn_filter_three'", Button.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListOfVechilesActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_listoftruck_back = null;
    target.tv_listoftruck_header = null;
    target.rc_trucklist = null;
    target.btn_book_trucks = null;
    target.btn_filter_three = null;
    target.progressBar = null;
  }
}
