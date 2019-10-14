// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileActivity_ViewBinding implements Unbinder {
  private ProfileActivity target;

  @UiThread
  public ProfileActivity_ViewBinding(ProfileActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfileActivity_ViewBinding(ProfileActivity target, View source) {
    this.target = target;

    target.img_prof_edit = Utils.findRequiredViewAsType(source, R.id.img_prof_edit, "field 'img_prof_edit'", ImageView.class);
    target.tv_prof_header = Utils.findRequiredViewAsType(source, R.id.tv_prof_header, "field 'tv_prof_header'", TextView.class);
    target.tv_prof_regno = Utils.findRequiredViewAsType(source, R.id.tv_prof_regno, "field 'tv_prof_regno'", TextView.class);
    target.tv_prof_gst = Utils.findRequiredViewAsType(source, R.id.tv_prof_gst, "field 'tv_prof_gst'", TextView.class);
    target.tv_prof_pan = Utils.findRequiredViewAsType(source, R.id.tv_prof_pan, "field 'tv_prof_pan'", TextView.class);
    target.tv_prof_name = Utils.findRequiredViewAsType(source, R.id.tv_prof_name, "field 'tv_prof_name'", TextView.class);
    target.tv_prof_compname = Utils.findRequiredViewAsType(source, R.id.tv_prof_compname, "field 'tv_prof_compname'", TextView.class);
    target.tv_prof_mobile = Utils.findRequiredViewAsType(source, R.id.tv_prof_mobile, "field 'tv_prof_mobile'", TextView.class);
    target.tv_prof_altnumber = Utils.findRequiredViewAsType(source, R.id.tv_prof_altnumber, "field 'tv_prof_altnumber'", TextView.class);
    target.tv_prof_email = Utils.findRequiredViewAsType(source, R.id.tv_prof_email, "field 'tv_prof_email'", TextView.class);
    target.tv_prof_address = Utils.findRequiredViewAsType(source, R.id.tv_prof_address, "field 'tv_prof_address'", TextView.class);
    target.tv_prof_geoloc = Utils.findRequiredViewAsType(source, R.id.tv_prof_geoloc, "field 'tv_prof_geoloc'", TextView.class);
    target.tv_prof_godanloc = Utils.findRequiredViewAsType(source, R.id.tv_prof_godanloc, "field 'tv_prof_godanloc'", TextView.class);
    target.img_prof_back = Utils.findRequiredViewAsType(source, R.id.img_prof_back, "field 'img_prof_back'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfileActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_prof_edit = null;
    target.tv_prof_header = null;
    target.tv_prof_regno = null;
    target.tv_prof_gst = null;
    target.tv_prof_pan = null;
    target.tv_prof_name = null;
    target.tv_prof_compname = null;
    target.tv_prof_mobile = null;
    target.tv_prof_altnumber = null;
    target.tv_prof_email = null;
    target.tv_prof_address = null;
    target.tv_prof_geoloc = null;
    target.tv_prof_godanloc = null;
    target.img_prof_back = null;
  }
}
