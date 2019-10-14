// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.kofigyan.stateprogressbar.StateProgressBar;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MaterialType_ViewBinding implements Unbinder {
  private MaterialType target;

  @UiThread
  public MaterialType_ViewBinding(MaterialType target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MaterialType_ViewBinding(MaterialType target, View source) {
    this.target = target;

    target.your_state_progress_bar_mattype2 = Utils.findRequiredViewAsType(source, R.id.your_state_progress_bar_mattype2, "field 'your_state_progress_bar_mattype2'", StateProgressBar.class);
    target.img_mattype_back = Utils.findRequiredViewAsType(source, R.id.img_mattype_back, "field 'img_mattype_back'", ImageView.class);
    target.rev_sel_material = Utils.findRequiredViewAsType(source, R.id.rev_sel_material, "field 'rev_sel_material'", RecyclerView.class);
    target.tv_mattype_header = Utils.findRequiredViewAsType(source, R.id.tv_mattypeheader, "field 'tv_mattype_header'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MaterialType target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.your_state_progress_bar_mattype2 = null;
    target.img_mattype_back = null;
    target.rev_sel_material = null;
    target.tv_mattype_header = null;
  }
}
