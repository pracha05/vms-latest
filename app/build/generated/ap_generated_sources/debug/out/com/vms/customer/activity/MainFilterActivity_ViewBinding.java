// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainFilterActivity_ViewBinding implements Unbinder {
  private MainFilterActivity target;

  @UiThread
  public MainFilterActivity_ViewBinding(MainFilterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainFilterActivity_ViewBinding(MainFilterActivity target, View source) {
    this.target = target;

    target.img_mainfilter_back = Utils.findRequiredViewAsType(source, R.id.img_mainfilter_back, "field 'img_mainfilter_back'", ImageView.class);
    target.tv_mainfilter_header = Utils.findRequiredViewAsType(source, R.id.tv_mainfilter_header, "field 'tv_mainfilter_header'", TextView.class);
    target.tv_minvalue_skbar = Utils.findRequiredViewAsType(source, R.id.tv_minvalue_skbar, "field 'tv_minvalue_skbar'", TextView.class);
    target.tv_minivalue_skbar = Utils.findRequiredViewAsType(source, R.id.tv_minivalue_skbar, "field 'tv_minivalue_skbar'", TextView.class);
    target.simpleSeekBar = Utils.findRequiredViewAsType(source, R.id.simpleSeekBar, "field 'simpleSeekBar'", SeekBar.class);
    target.simpleSeekBars = Utils.findRequiredViewAsType(source, R.id.simpleSeekBars, "field 'simpleSeekBars'", SeekBar.class);
    target.sp_flt_select_amenities = Utils.findRequiredViewAsType(source, R.id.sp_flt_select_amenities, "field 'sp_flt_select_amenities'", Spinner.class);
    target.sp_flt_select_rearing = Utils.findRequiredViewAsType(source, R.id.sp_flt_select_rearing, "field 'sp_flt_select_rearing'", Spinner.class);
    target.sp_flt_select_member = Utils.findRequiredViewAsType(source, R.id.sp_flt_select_member, "field 'sp_flt_select_member'", Spinner.class);
    target.sp_flt_select_tons = Utils.findRequiredViewAsType(source, R.id.sp_flt_select_tons, "field 'sp_flt_select_tons'", Spinner.class);
    target.sp_flt_select_height = Utils.findRequiredViewAsType(source, R.id.sp_flt_select_height, "field 'sp_flt_select_height'", Spinner.class);
    target.sp_flt_select_weight = Utils.findRequiredViewAsType(source, R.id.sp_flt_select_weight, "field 'sp_flt_select_weight'", Spinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainFilterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_mainfilter_back = null;
    target.tv_mainfilter_header = null;
    target.tv_minvalue_skbar = null;
    target.tv_minivalue_skbar = null;
    target.simpleSeekBar = null;
    target.simpleSeekBars = null;
    target.sp_flt_select_amenities = null;
    target.sp_flt_select_rearing = null;
    target.sp_flt_select_member = null;
    target.sp_flt_select_tons = null;
    target.sp_flt_select_height = null;
    target.sp_flt_select_weight = null;
  }
}
