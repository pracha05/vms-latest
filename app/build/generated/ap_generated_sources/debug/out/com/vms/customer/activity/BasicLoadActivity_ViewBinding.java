// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.kofigyan.stateprogressbar.StateProgressBar;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BasicLoadActivity_ViewBinding implements Unbinder {
  private BasicLoadActivity target;

  @UiThread
  public BasicLoadActivity_ViewBinding(BasicLoadActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BasicLoadActivity_ViewBinding(BasicLoadActivity target, View source) {
    this.target = target;

    target.your_state_progress_bar_baseload1 = Utils.findRequiredViewAsType(source, R.id.your_state_progress_bar_baseload1, "field 'your_state_progress_bar_baseload1'", StateProgressBar.class);
    target.img_baseload_back = Utils.findRequiredViewAsType(source, R.id.img_baseload_back, "field 'img_baseload_back'", ImageView.class);
    target.tv_baseload_header = Utils.findRequiredViewAsType(source, R.id.tv_baseload_header, "field 'tv_baseload_header'", TextView.class);
    target.txt_loadstartpoint = Utils.findRequiredViewAsType(source, R.id.txt_loadstartpoint, "field 'txt_loadstartpoint'", TextView.class);
    target.txt_loaddropingpoint = Utils.findRequiredViewAsType(source, R.id.txt_loaddropingpoint, "field 'txt_loaddropingpoint'", TextView.class);
    target.tx_selectsizevehicle = Utils.findRequiredViewAsType(source, R.id.tx_selectsizevehicle, "field 'tx_selectsizevehicle'", TextView.class);
    target.txt_lbdate = Utils.findRequiredViewAsType(source, R.id.txt_lbdate, "field 'txt_lbdate'", TextView.class);
    target.edt_lbdate = Utils.findRequiredViewAsType(source, R.id.edt_lbdate, "field 'edt_lbdate'", TextView.class);
    target.txt_no_of_vechiles = Utils.findRequiredViewAsType(source, R.id.txt_no_of_vechiles, "field 'txt_no_of_vechiles'", TextView.class);
    target.txt_sel_size_veh = Utils.findRequiredViewAsType(source, R.id.txt_sel_size_veh, "field 'txt_sel_size_veh'", TextView.class);
    target.edt_loadstartpoint = Utils.findRequiredViewAsType(source, R.id.edt_loadstartpoint, "field 'edt_loadstartpoint'", EditText.class);
    target.edt_loaddropingpoint = Utils.findRequiredViewAsType(source, R.id.edt_loaddropingpoint, "field 'edt_loaddropingpoint'", EditText.class);
    target.edt_no_of_vechiles = Utils.findRequiredViewAsType(source, R.id.edt_no_of_vechiles, "field 'edt_no_of_vechiles'", EditText.class);
    target.ll_sel_size_veh = Utils.findRequiredViewAsType(source, R.id.ll_sel_size_veh, "field 'll_sel_size_veh'", LinearLayout.class);
    target.btn_save1 = Utils.findRequiredViewAsType(source, R.id.btn_save1, "field 'btn_save1'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BasicLoadActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.your_state_progress_bar_baseload1 = null;
    target.img_baseload_back = null;
    target.tv_baseload_header = null;
    target.txt_loadstartpoint = null;
    target.txt_loaddropingpoint = null;
    target.tx_selectsizevehicle = null;
    target.txt_lbdate = null;
    target.edt_lbdate = null;
    target.txt_no_of_vechiles = null;
    target.txt_sel_size_veh = null;
    target.edt_loadstartpoint = null;
    target.edt_loaddropingpoint = null;
    target.edt_no_of_vechiles = null;
    target.ll_sel_size_veh = null;
    target.btn_save1 = null;
  }
}
