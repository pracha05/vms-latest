// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditContact_ViewBinding implements Unbinder {
  private EditContact target;

  @UiThread
  public EditContact_ViewBinding(EditContact target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EditContact_ViewBinding(EditContact target, View source) {
    this.target = target;

    target.img_edit_contact_edit = Utils.findRequiredViewAsType(source, R.id.img_edit_contact_edit, "field 'img_edit_contact_edit'", ImageView.class);
    target.tv_edit_contact_header = Utils.findRequiredViewAsType(source, R.id.tv_edit_contact_header, "field 'tv_edit_contact_header'", TextView.class);
    target.txt_editcompany = Utils.findRequiredViewAsType(source, R.id.txt_editcompany, "field 'txt_editcompany'", TextView.class);
    target.edt_editcompany = Utils.findRequiredViewAsType(source, R.id.edt_editcompany, "field 'edt_editcompany'", EditText.class);
    target.txt_editphonenumber = Utils.findRequiredViewAsType(source, R.id.txt_editphonenumber, "field 'txt_editphonenumber'", TextView.class);
    target.edt_editcontactphonenumber = Utils.findRequiredViewAsType(source, R.id.edt_editcontactphonenumber, "field 'edt_editcontactphonenumber'", EditText.class);
    target.txt_editgst = Utils.findRequiredViewAsType(source, R.id.txt_editgst, "field 'txt_editgst'", TextView.class);
    target.edt_editgst = Utils.findRequiredViewAsType(source, R.id.edt_editgst, "field 'edt_editgst'", EditText.class);
    target.tx_editcustomer = Utils.findRequiredViewAsType(source, R.id.tx_editcustomer, "field 'tx_editcustomer'", TextView.class);
    target.edt_editcustomer = Utils.findRequiredViewAsType(source, R.id.edt_editcustomer, "field 'edt_editcustomer'", EditText.class);
    target.tx_editemail = Utils.findRequiredViewAsType(source, R.id.tx_editemail, "field 'tx_editemail'", TextView.class);
    target.edt_editemail = Utils.findRequiredViewAsType(source, R.id.edt_editemail, "field 'edt_editemail'", EditText.class);
    target.txt_editaddress = Utils.findRequiredViewAsType(source, R.id.txt_editaddress, "field 'txt_editaddress'", TextView.class);
    target.edt_editaddress = Utils.findRequiredViewAsType(source, R.id.edt_editaddress, "field 'edt_editaddress'", EditText.class);
    target.btn_submit = Utils.findRequiredViewAsType(source, R.id.btn_submit, "field 'btn_submit'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EditContact target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_edit_contact_edit = null;
    target.tv_edit_contact_header = null;
    target.txt_editcompany = null;
    target.edt_editcompany = null;
    target.txt_editphonenumber = null;
    target.edt_editcontactphonenumber = null;
    target.txt_editgst = null;
    target.edt_editgst = null;
    target.tx_editcustomer = null;
    target.edt_editcustomer = null;
    target.tx_editemail = null;
    target.edt_editemail = null;
    target.txt_editaddress = null;
    target.edt_editaddress = null;
    target.btn_submit = null;
  }
}
