// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
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

    target.mToolBar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolBar'", Toolbar.class);
    target.img_prof_edit = Utils.findRequiredViewAsType(source, R.id.img_prof_edit, "field 'img_prof_edit'", ImageView.class);
    target.cvPersonalData = Utils.findRequiredViewAsType(source, R.id.card_view_personal, "field 'cvPersonalData'", CardView.class);
    target.cvCommercialData = Utils.findRequiredViewAsType(source, R.id.card_view_commercial, "field 'cvCommercialData'", CardView.class);
    target.simpleSwitch = Utils.findRequiredViewAsType(source, R.id.simpleSwitch, "field 'simpleSwitch'", Switch.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfileActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolBar = null;
    target.img_prof_edit = null;
    target.cvPersonalData = null;
    target.cvCommercialData = null;
    target.simpleSwitch = null;
  }
}
