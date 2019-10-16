// Generated code from Butter Knife. Do not modify!
package com.vms.customer.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vms.customer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IntroductionPagerActivity_ViewBinding implements Unbinder {
  private IntroductionPagerActivity target;

  @UiThread
  public IntroductionPagerActivity_ViewBinding(IntroductionPagerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public IntroductionPagerActivity_ViewBinding(IntroductionPagerActivity target, View source) {
    this.target = target;

    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.container, "field 'mViewPager'", ViewPager.class);
    target.mNextBtn = Utils.findRequiredViewAsType(source, R.id.intro_btn_next, "field 'mNextBtn'", ImageButton.class);
    target.mSkipBtn = Utils.findRequiredViewAsType(source, R.id.intro_btn_skip, "field 'mSkipBtn'", Button.class);
    target.mFinishBtn = Utils.findRequiredViewAsType(source, R.id.intro_btn_finish, "field 'mFinishBtn'", Button.class);
    target.zero = Utils.findRequiredViewAsType(source, R.id.intro_indicator_0, "field 'zero'", ImageView.class);
    target.one = Utils.findRequiredViewAsType(source, R.id.intro_indicator_1, "field 'one'", ImageView.class);
    target.two = Utils.findRequiredViewAsType(source, R.id.intro_indicator_2, "field 'two'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IntroductionPagerActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mViewPager = null;
    target.mNextBtn = null;
    target.mSkipBtn = null;
    target.mFinishBtn = null;
    target.zero = null;
    target.one = null;
    target.two = null;
  }
}
