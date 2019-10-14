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

public class Wallet_ViewBinding implements Unbinder {
  private Wallet target;

  @UiThread
  public Wallet_ViewBinding(Wallet target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Wallet_ViewBinding(Wallet target, View source) {
    this.target = target;

    target.img_wallet_back = Utils.findRequiredViewAsType(source, R.id.img_wallet_back, "field 'img_wallet_back'", ImageView.class);
    target.tv_wallet_header = Utils.findRequiredViewAsType(source, R.id.tv_wallet_header, "field 'tv_wallet_header'", TextView.class);
    target.tv_wallet = Utils.findRequiredViewAsType(source, R.id.tv_wallet, "field 'tv_wallet'", TextView.class);
    target.tv_wallet_code = Utils.findRequiredViewAsType(source, R.id.tv_wallet_code, "field 'tv_wallet_code'", TextView.class);
    target.tv_wallet_value = Utils.findRequiredViewAsType(source, R.id.tv_wallet_value, "field 'tv_wallet_value'", TextView.class);
    target.tvWalletUsageAllowed = Utils.findRequiredViewAsType(source, R.id.tv_wallet_usage_allowed, "field 'tvWalletUsageAllowed'", TextView.class);
    target.tvUsageMonth = Utils.findRequiredViewAsType(source, R.id.tv_wallet_usage_month, "field 'tvUsageMonth'", TextView.class);
    target.tvWalletUsage = Utils.findRequiredViewAsType(source, R.id.tv_wallet_usage, "field 'tvWalletUsage'", TextView.class);
    target.tvWalletUsagePrice = Utils.findRequiredViewAsType(source, R.id.tv_wallet_usage_price, "field 'tvWalletUsagePrice'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Wallet target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_wallet_back = null;
    target.tv_wallet_header = null;
    target.tv_wallet = null;
    target.tv_wallet_code = null;
    target.tv_wallet_value = null;
    target.tvWalletUsageAllowed = null;
    target.tvUsageMonth = null;
    target.tvWalletUsage = null;
    target.tvWalletUsagePrice = null;
  }
}
