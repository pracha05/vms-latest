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

public class ReferenceCodeActivity_ViewBinding implements Unbinder {
  private ReferenceCodeActivity target;

  @UiThread
  public ReferenceCodeActivity_ViewBinding(ReferenceCodeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReferenceCodeActivity_ViewBinding(ReferenceCodeActivity target, View source) {
    this.target = target;

    target.img_referal_back = Utils.findRequiredViewAsType(source, R.id.img_referal_back, "field 'img_referal_back'", ImageView.class);
    target.tv_referal_header = Utils.findRequiredViewAsType(source, R.id.tv_referal_header, "field 'tv_referal_header'", TextView.class);
    target.tv_referal_ref_code = Utils.findRequiredViewAsType(source, R.id.tv_referal_ref_code, "field 'tv_referal_ref_code'", TextView.class);
    target.btn_refer = Utils.findRequiredViewAsType(source, R.id.btn_refer, "field 'btn_refer'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReferenceCodeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_referal_back = null;
    target.tv_referal_header = null;
    target.tv_referal_ref_code = null;
    target.btn_refer = null;
  }
}
