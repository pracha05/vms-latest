package com.vms.customer.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.vms.customer.R;
import com.vms.customer.utils.DialogsUtils;
import com.vms.customer.utils.NetworkConnection;


public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    NetworkConnection connection;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        connection = new NetworkConnection(this);
    }

    public void showDialog() {
        if (dialog == null) {
            dialog = DialogsUtils.showProgressDialog(this, "Loading data..");
            return;
        }
        if (dialog.isShowing())
            return;
        dialog.show();

    }

    public void hideDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }

    public boolean isConnected() {
        return connection.isConnectingToInternet();
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    String token = null;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
    }

    /**
     * show network unavailability dialog
     */

    public void showNetworkErrorDialog(){
        Toast.makeText(this, getString(R.string.email_id), Toast.LENGTH_SHORT).show();
    }
}
