// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactAllList_ViewBinding implements Unbinder {
  private ContactAllList target;

  @UiThread
  public ContactAllList_ViewBinding(ContactAllList target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContactAllList_ViewBinding(ContactAllList target, View source) {
    this.target = target;

    target.img_contact_back = Utils.findRequiredViewAsType(source, R.id.img_contact_back, "field 'img_contact_back'", ImageView.class);
    target.tv_contact_header = Utils.findRequiredViewAsType(source, R.id.tv_contact_header, "field 'tv_contact_header'", TextView.class);
    target.img_contact_addcontact = Utils.findRequiredViewAsType(source, R.id.img_contact_addcontact, "field 'img_contact_addcontact'", ImageView.class);
    target.rc_contactlist = Utils.findRequiredViewAsType(source, R.id.rc_contactlist, "field 'rc_contactlist'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactAllList target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_contact_back = null;
    target.tv_contact_header = null;
    target.img_contact_addcontact = null;
    target.rc_contactlist = null;
    target.progressBar = null;
  }
}
