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

public class AddContact_ViewBinding implements Unbinder {
  private AddContact target;

  @UiThread
  public AddContact_ViewBinding(AddContact target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddContact_ViewBinding(AddContact target, View source) {
    this.target = target;

    target.img_contact_back = Utils.findRequiredViewAsType(source, R.id.img_contact_back, "field 'img_contact_back'", ImageView.class);
    target.tv_contact_header = Utils.findRequiredViewAsType(source, R.id.tv_contact_header, "field 'tv_contact_header'", TextView.class);
    target.txt_contactcompany = Utils.findRequiredViewAsType(source, R.id.txt_contactcompany, "field 'txt_contactcompany'", TextView.class);
    target.edt_contactcompany = Utils.findRequiredViewAsType(source, R.id.edt_contactcompany, "field 'edt_contactcompany'", EditText.class);
    target.txt_contactphonenumber = Utils.findRequiredViewAsType(source, R.id.txt_contactphonenumber, "field 'txt_contactphonenumber'", TextView.class);
    target.edt_contactphonenumber = Utils.findRequiredViewAsType(source, R.id.edt_contactphonenumber, "field 'edt_contactphonenumber'", EditText.class);
    target.txt_contactgst = Utils.findRequiredViewAsType(source, R.id.txt_contactgst, "field 'txt_contactgst'", TextView.class);
    target.edt_contactgst = Utils.findRequiredViewAsType(source, R.id.edt_contactgst, "field 'edt_contactgst'", EditText.class);
    target.tx_contactcustomer = Utils.findRequiredViewAsType(source, R.id.tx_contactcustomer, "field 'tx_contactcustomer'", TextView.class);
    target.edt_contactcustomer = Utils.findRequiredViewAsType(source, R.id.edt_contactcustomer, "field 'edt_contactcustomer'", EditText.class);
    target.tx_contactemail = Utils.findRequiredViewAsType(source, R.id.tx_contactemail, "field 'tx_contactemail'", TextView.class);
    target.edt_contactemail = Utils.findRequiredViewAsType(source, R.id.edt_contactemail, "field 'edt_contactemail'", EditText.class);
    target.txt_contactaddress = Utils.findRequiredViewAsType(source, R.id.txt_contactaddress, "field 'txt_contactaddress'", TextView.class);
    target.edt_contactaddress = Utils.findRequiredViewAsType(source, R.id.edt_contactaddress, "field 'edt_contactaddress'", EditText.class);
    target.img_contact_contactlist = Utils.findRequiredViewAsType(source, R.id.img_contact_contactlist, "field 'img_contact_contactlist'", ImageView.class);
    target.btn_submit = Utils.findRequiredViewAsType(source, R.id.btn_submit, "field 'btn_submit'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddContact target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_contact_back = null;
    target.tv_contact_header = null;
    target.txt_contactcompany = null;
    target.edt_contactcompany = null;
    target.txt_contactphonenumber = null;
    target.edt_contactphonenumber = null;
    target.txt_contactgst = null;
    target.edt_contactgst = null;
    target.tx_contactcustomer = null;
    target.edt_contactcustomer = null;
    target.tx_contactemail = null;
    target.edt_contactemail = null;
    target.txt_contactaddress = null;
    target.edt_contactaddress = null;
    target.img_contact_contactlist = null;
    target.btn_submit = null;
  }
}
