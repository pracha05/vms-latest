// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddLoadActivity_ViewBinding implements Unbinder {
  private AddLoadActivity target;

  @UiThread
  public AddLoadActivity_ViewBinding(AddLoadActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddLoadActivity_ViewBinding(AddLoadActivity target, View source) {
    this.target = target;

    target.img_addload_back = Utils.findRequiredViewAsType(source, R.id.img_addload_back, "field 'img_addload_back'", ImageView.class);
    target.btn_add_loaded = Utils.findRequiredViewAsType(source, R.id.btn_add_loaded, "field 'btn_add_loaded'", Button.class);
    target.tv_addload_header = Utils.findRequiredViewAsType(source, R.id.tv_addload_header, "field 'tv_addload_header'", TextView.class);
    target.tv_addload_sourcepoint = Utils.findRequiredViewAsType(source, R.id.tv_addload_sourcepoint, "field 'tv_addload_sourcepoint'", TextView.class);
    target.tv_addload_destpoint = Utils.findRequiredViewAsType(source, R.id.tv_addload_destpoint, "field 'tv_addload_destpoint'", TextView.class);
    target.tv_al_select_truck = Utils.findRequiredViewAsType(source, R.id.tv_al_select_truck, "field 'tv_al_select_truck'", TextView.class);
    target.tv_al_select_material = Utils.findRequiredViewAsType(source, R.id.tv_al_select_material, "field 'tv_al_select_material'", TextView.class);
    target.tv_al_select_date = Utils.findRequiredViewAsType(source, R.id.tv_al_select_date, "field 'tv_al_select_date'", TextView.class);
    target.edt_al_remark = Utils.findRequiredViewAsType(source, R.id.edt_al_remark, "field 'edt_al_remark'", EditText.class);
    target.sp_al_select_time = Utils.findRequiredViewAsType(source, R.id.sp_al_select_time, "field 'sp_al_select_time'", Spinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddLoadActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_addload_back = null;
    target.btn_add_loaded = null;
    target.tv_addload_header = null;
    target.tv_addload_sourcepoint = null;
    target.tv_addload_destpoint = null;
    target.tv_al_select_truck = null;
    target.tv_al_select_material = null;
    target.tv_al_select_date = null;
    target.edt_al_remark = null;
    target.sp_al_select_time = null;
  }
}
