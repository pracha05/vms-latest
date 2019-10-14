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

public class ContactDetailsInfo_ViewBinding implements Unbinder {
  private ContactDetailsInfo target;

  @UiThread
  public ContactDetailsInfo_ViewBinding(ContactDetailsInfo target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContactDetailsInfo_ViewBinding(ContactDetailsInfo target, View source) {
    this.target = target;

    target.img_condetails_contact_back = Utils.findRequiredViewAsType(source, R.id.img_condetails_contact_back, "field 'img_condetails_contact_back'", ImageView.class);
    target.tv_condetails_contact_header = Utils.findRequiredViewAsType(source, R.id.tv_condetails_contact_header, "field 'tv_condetails_contact_header'", TextView.class);
    target.img_threedot = Utils.findRequiredViewAsType(source, R.id.img_threedot, "field 'img_threedot'", ImageView.class);
    target.tv_condetails_contact_company = Utils.findRequiredViewAsType(source, R.id.tv_condetails_contact_company, "field 'tv_condetails_contact_company'", TextView.class);
    target.txt_condetails_contact_company = Utils.findRequiredViewAsType(source, R.id.txt_condetails_contact_company, "field 'txt_condetails_contact_company'", TextView.class);
    target.tv_condetails_contact_customer = Utils.findRequiredViewAsType(source, R.id.tv_condetails_contact_customer, "field 'tv_condetails_contact_customer'", TextView.class);
    target.txt_condetails_contact_customer = Utils.findRequiredViewAsType(source, R.id.txt_condetails_contact_customer, "field 'txt_condetails_contact_customer'", TextView.class);
    target.tv_condetails_contact_mobile = Utils.findRequiredViewAsType(source, R.id.tv_condetails_contact_mobile, "field 'tv_condetails_contact_mobile'", TextView.class);
    target.txt_condetails_contact_mobile = Utils.findRequiredViewAsType(source, R.id.txt_condetails_contact_mobile, "field 'txt_condetails_contact_mobile'", TextView.class);
    target.tv_condetails_contact_email = Utils.findRequiredViewAsType(source, R.id.tv_condetails_contact_email, "field 'tv_condetails_contact_email'", TextView.class);
    target.txt_condetails_contact_email = Utils.findRequiredViewAsType(source, R.id.txt_condetails_contact_email, "field 'txt_condetails_contact_email'", TextView.class);
    target.tv_condetails_contact_gst = Utils.findRequiredViewAsType(source, R.id.tv_condetails_contact_gst, "field 'tv_condetails_contact_gst'", TextView.class);
    target.txt_condetails_contact_gst = Utils.findRequiredViewAsType(source, R.id.txt_condetails_contact_gst, "field 'txt_condetails_contact_gst'", TextView.class);
    target.tv_condetails_contact_map = Utils.findRequiredViewAsType(source, R.id.tv_condetails_contact_map, "field 'tv_condetails_contact_map'", TextView.class);
    target.txt_condetails_contact_map = Utils.findRequiredViewAsType(source, R.id.txt_condetails_contact_map, "field 'txt_condetails_contact_map'", TextView.class);
    target.tv_condetails_contact_Address = Utils.findRequiredViewAsType(source, R.id.tv_condetails_contact_Address, "field 'tv_condetails_contact_Address'", TextView.class);
    target.txt_condetails_contact_Address = Utils.findRequiredViewAsType(source, R.id.txt_condetails_contact_Address, "field 'txt_condetails_contact_Address'", TextView.class);
    target.tv_condetails_contact_save = Utils.findRequiredViewAsType(source, R.id.tv_condetails_contact_save, "field 'tv_condetails_contact_save'", TextView.class);
    target.txt_condetails_contact_save = Utils.findRequiredViewAsType(source, R.id.txt_condetails_contact_save, "field 'txt_condetails_contact_save'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactDetailsInfo target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_condetails_contact_back = null;
    target.tv_condetails_contact_header = null;
    target.img_threedot = null;
    target.tv_condetails_contact_company = null;
    target.txt_condetails_contact_company = null;
    target.tv_condetails_contact_customer = null;
    target.txt_condetails_contact_customer = null;
    target.tv_condetails_contact_mobile = null;
    target.txt_condetails_contact_mobile = null;
    target.tv_condetails_contact_email = null;
    target.txt_condetails_contact_email = null;
    target.tv_condetails_contact_gst = null;
    target.txt_condetails_contact_gst = null;
    target.tv_condetails_contact_map = null;
    target.txt_condetails_contact_map = null;
    target.tv_condetails_contact_Address = null;
    target.txt_condetails_contact_Address = null;
    target.tv_condetails_contact_save = null;
    target.txt_condetails_contact_save = null;
  }
}
