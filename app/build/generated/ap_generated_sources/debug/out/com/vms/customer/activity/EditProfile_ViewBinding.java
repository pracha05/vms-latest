// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditProfile_ViewBinding implements Unbinder {
  private EditProfile target;

  @UiThread
  public EditProfile_ViewBinding(EditProfile target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EditProfile_ViewBinding(EditProfile target, View source) {
    this.target = target;

    target.img_profile_back = Utils.findRequiredViewAsType(source, R.id.img_profile_back, "field 'img_profile_back'", ImageView.class);
    target.img_get_maploc = Utils.findRequiredViewAsType(source, R.id.img_get_maploc, "field 'img_get_maploc'", ImageView.class);
    target.img_get_currentloc = Utils.findRequiredViewAsType(source, R.id.img_get_currentloc, "field 'img_get_currentloc'", ImageView.class);
    target.tv_profile_header = Utils.findRequiredViewAsType(source, R.id.tv_profile_header, "field 'tv_profile_header'", TextView.class);
    target.t_geoloc = Utils.findRequiredViewAsType(source, R.id.t_geoloc, "field 't_geoloc'", TextView.class);
    target.txt_prof_regno = Utils.findRequiredViewAsType(source, R.id.txt_prof_regno, "field 'txt_prof_regno'", TextView.class);
    target.txt_prof_gst = Utils.findRequiredViewAsType(source, R.id.txt_prof_gst, "field 'txt_prof_gst'", TextView.class);
    target.txt_prof_pan = Utils.findRequiredViewAsType(source, R.id.txt_prof_pan, "field 'txt_prof_pan'", TextView.class);
    target.txt_prof_lgname = Utils.findRequiredViewAsType(source, R.id.txt_prof_lgname, "field 'txt_prof_lgname'", TextView.class);
    target.txt_prof_cpname = Utils.findRequiredViewAsType(source, R.id.txt_prof_cpname, "field 'txt_prof_cpname'", TextView.class);
    target.txt_prof_mbnumber = Utils.findRequiredViewAsType(source, R.id.txt_prof_mbnumber, "field 'txt_prof_mbnumber'", TextView.class);
    target.txt_prof_altnumber = Utils.findRequiredViewAsType(source, R.id.txt_prof_altnumber, "field 'txt_prof_altnumber'", TextView.class);
    target.txt_prof_emailid = Utils.findRequiredViewAsType(source, R.id.txt_prof_emailid, "field 'txt_prof_emailid'", TextView.class);
    target.txt_prof_address = Utils.findRequiredViewAsType(source, R.id.txt_prof_address, "field 'txt_prof_address'", TextView.class);
    target.txt_geolocation = Utils.findRequiredViewAsType(source, R.id.txt_geolocation, "field 'txt_geolocation'", TextView.class);
    target.t_goldenloc = Utils.findRequiredViewAsType(source, R.id.t_goldenloc, "field 't_goldenloc'", TextView.class);
    target.txt_goldenlocation = Utils.findRequiredViewAsType(source, R.id.txt_goldenlocation, "field 'txt_goldenlocation'", TextView.class);
    target.edt_prof_regno = Utils.findRequiredViewAsType(source, R.id.edt_prof_regno, "field 'edt_prof_regno'", EditText.class);
    target.edt_prof_gst = Utils.findRequiredViewAsType(source, R.id.edt_prof_gst, "field 'edt_prof_gst'", EditText.class);
    target.edt_prof_pan = Utils.findRequiredViewAsType(source, R.id.edt_prof_pan, "field 'edt_prof_pan'", EditText.class);
    target.edt_prof_lgname = Utils.findRequiredViewAsType(source, R.id.edt_prof_lgname, "field 'edt_prof_lgname'", EditText.class);
    target.edt_prof_cpname = Utils.findRequiredViewAsType(source, R.id.edt_prof_cpname, "field 'edt_prof_cpname'", EditText.class);
    target.edt_prof_mbnumber = Utils.findRequiredViewAsType(source, R.id.edt_prof_mbnumber, "field 'edt_prof_mbnumber'", EditText.class);
    target.edt_prof_altnumber = Utils.findRequiredViewAsType(source, R.id.edt_prof_altnumber, "field 'edt_prof_altnumber'", EditText.class);
    target.edt_prof_email = Utils.findRequiredViewAsType(source, R.id.edt_prof_email, "field 'edt_prof_email'", EditText.class);
    target.edt_prof_address = Utils.findRequiredViewAsType(source, R.id.edt_prof_address, "field 'edt_prof_address'", EditText.class);
    target.btn_prof_restpassw = Utils.findRequiredViewAsType(source, R.id.btn_prof_restpassw, "field 'btn_prof_restpassw'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EditProfile target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_profile_back = null;
    target.img_get_maploc = null;
    target.img_get_currentloc = null;
    target.tv_profile_header = null;
    target.t_geoloc = null;
    target.txt_prof_regno = null;
    target.txt_prof_gst = null;
    target.txt_prof_pan = null;
    target.txt_prof_lgname = null;
    target.txt_prof_cpname = null;
    target.txt_prof_mbnumber = null;
    target.txt_prof_altnumber = null;
    target.txt_prof_emailid = null;
    target.txt_prof_address = null;
    target.txt_geolocation = null;
    target.t_goldenloc = null;
    target.txt_goldenlocation = null;
    target.edt_prof_regno = null;
    target.edt_prof_gst = null;
    target.edt_prof_pan = null;
    target.edt_prof_lgname = null;
    target.edt_prof_cpname = null;
    target.edt_prof_mbnumber = null;
    target.edt_prof_altnumber = null;
    target.edt_prof_email = null;
    target.edt_prof_address = null;
    target.btn_prof_restpassw = null;
  }
}
