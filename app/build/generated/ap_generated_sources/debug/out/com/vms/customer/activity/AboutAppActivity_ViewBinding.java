// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutAppActivity_ViewBinding implements Unbinder {
  private AboutAppActivity target;

  @UiThread
  public AboutAppActivity_ViewBinding(AboutAppActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AboutAppActivity_ViewBinding(AboutAppActivity target, View source) {
    this.target = target;

    target.mToolBar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolBar'", Toolbar.class);
    target.tvCopyRight = Utils.findRequiredViewAsType(source, R.id.copyright_label, "field 'tvCopyRight'", TextView.class);
    target.imgFacebook = Utils.findRequiredViewAsType(source, R.id.facebook_img, "field 'imgFacebook'", ImageView.class);
    target.imgTwitter = Utils.findRequiredViewAsType(source, R.id.twitter_image, "field 'imgTwitter'", ImageView.class);
    target.imgYouTube = Utils.findRequiredViewAsType(source, R.id.youtube_image, "field 'imgYouTube'", ImageView.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.contact_us_value, "field 'email'", TextView.class);
    target.phone = Utils.findRequiredViewAsType(source, R.id.contact_us_phone, "field 'phone'", TextView.class);
    target.tvAppVersion = Utils.findRequiredViewAsType(source, R.id.app_version, "field 'tvAppVersion'", TextView.class);
    target.tvGitVersion = Utils.findRequiredViewAsType(source, R.id.git_version, "field 'tvGitVersion'", TextView.class);
    target.tvAbtApp = Utils.findRequiredViewAsType(source, R.id.about_app_description, "field 'tvAbtApp'", TextView.class);
    target.tvContactUs = Utils.findRequiredViewAsType(source, R.id.contact_us, "field 'tvContactUs'", TextView.class);
    target.tvPhoneText = Utils.findRequiredViewAsType(source, R.id.contact_phone, "field 'tvPhoneText'", TextView.class);
    target.tvAddress = Utils.findRequiredViewAsType(source, R.id.address, "field 'tvAddress'", TextView.class);
    target.tvAddressValue = Utils.findRequiredViewAsType(source, R.id.address_value_1, "field 'tvAddressValue'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AboutAppActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolBar = null;
    target.tvCopyRight = null;
    target.imgFacebook = null;
    target.imgTwitter = null;
    target.imgYouTube = null;
    target.email = null;
    target.phone = null;
    target.tvAppVersion = null;
    target.tvGitVersion = null;
    target.tvAbtApp = null;
    target.tvContactUs = null;
    target.tvPhoneText = null;
    target.tvAddress = null;
    target.tvAddressValue = null;
  }
}
