// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target, View source) {
    this.target = target;

    target.tv_cus_profile = Utils.findRequiredViewAsType(source, R.id.tv_cus_profile, "field 'tv_cus_profile'", ImageView.class);
    target.tv_cus_dashboard = Utils.findRequiredViewAsType(source, R.id.tv_cus_dashboard, "field 'tv_cus_dashboard'", TextView.class);
    target.tv_cus_contact = Utils.findRequiredViewAsType(source, R.id.tv_cus_contact, "field 'tv_cus_contact'", TextView.class);
    target.tv_cus_loadbookings = Utils.findRequiredViewAsType(source, R.id.tv_cus_loadbookings, "field 'tv_cus_loadbookings'", TextView.class);
    target.tv_cus_bookingsummery = Utils.findRequiredViewAsType(source, R.id.tv_cus_bookingsummery, "field 'tv_cus_bookingsummery'", TextView.class);
    target.tv_cus_incprovider = Utils.findRequiredViewAsType(source, R.id.tv_cus_incprovider, "field 'tv_cus_incprovider'", TextView.class);
    target.tv_cus_refcode = Utils.findRequiredViewAsType(source, R.id.tv_cus_refcode, "field 'tv_cus_refcode'", TextView.class);
    target.tv_cus_support = Utils.findRequiredViewAsType(source, R.id.tv_cus_support, "field 'tv_cus_support'", TextView.class);
    target.tv_cus_wallet = Utils.findRequiredViewAsType(source, R.id.tv_cus_wallet, "field 'tv_cus_wallet'", TextView.class);
    target.tv_cus_loginedname = Utils.findRequiredViewAsType(source, R.id.tv_cus_loginedname, "field 'tv_cus_loginedname'", TextView.class);
    target.tv_cus_logout = Utils.findRequiredViewAsType(source, R.id.tv_cus_logout, "field 'tv_cus_logout'", TextView.class);
    target.tvMore = Utils.findRequiredViewAsType(source, R.id.tv_more, "field 'tvMore'", TextView.class);
    target.tv_searchview = Utils.findRequiredViewAsType(source, R.id.tv_searchview, "field 'tv_searchview'", TextView.class);
    target.tvWalletAmount = Utils.findRequiredViewAsType(source, R.id.tv_cust_wallet, "field 'tvWalletAmount'", TextView.class);
    target.tvVersion = Utils.findRequiredViewAsType(source, R.id.tv_version, "field 'tvVersion'", TextView.class);
    target.btnMembership = Utils.findRequiredViewAsType(source, R.id.btn_membership, "field 'btnMembership'", Button.class);
    target.tvMembershipMessage = Utils.findRequiredViewAsType(source, R.id.tv_message, "field 'tvMembershipMessage'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_cus_profile = null;
    target.tv_cus_dashboard = null;
    target.tv_cus_contact = null;
    target.tv_cus_loadbookings = null;
    target.tv_cus_bookingsummery = null;
    target.tv_cus_incprovider = null;
    target.tv_cus_refcode = null;
    target.tv_cus_support = null;
    target.tv_cus_wallet = null;
    target.tv_cus_loginedname = null;
    target.tv_cus_logout = null;
    target.tvMore = null;
    target.tv_searchview = null;
    target.tvWalletAmount = null;
    target.tvVersion = null;
    target.btnMembership = null;
    target.tvMembershipMessage = null;
  }
}
