package com.vms.customer.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.vms.customer.R;
import com.vms.customer.service.SmartDialogClickListener;
import com.vms.customer.utils.DialogsUtils;
import com.vms.customer.utils.NetworkConnection;
import com.vms.customer.utils.SmartDialog;
import com.vms.customer.utils.SmartDialogBuilder;

import java.util.ArrayList;


public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Tag for logging.
     */
    public static final String TAG = BaseActivity.class.getSimpleName();


    private static final int MY_PERMISSIONS_REQUEST = 1;
    private NetworkConnection connection;
    private Dialog dialog;

    private static String[] permissionsRequiredList = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
    };

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

    @Override
    public void onStart() {
        super.onStart();
        ArrayList<String> permissionRequired = new ArrayList();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            permissionRequired.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            permissionRequired.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if (permissionRequired.size() > 0) {
            String[] permissions = new String[permissionRequired.size()];
            permissions = permissionRequired.toArray(permissions);

            ActivityCompat.requestPermissions(this,
                    permissions,
                    MY_PERMISSIONS_REQUEST);
        }
    }


    private static int getPermissionIndex(String permission) {
        int result = -1;
        for (int i = 0; i < permissionsRequiredList.length; i++) {
            if (permission.equals(permissionsRequiredList[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (grantResults.length == 0) {
            return;
        }
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                for (int i = 0; i < permissions.length; i++) {
                    String permission = permissions[i];
                    int permissionIndex = getPermissionIndex(permission);

                    switch (permissionIndex) {
                        case 0: {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            } else {
                                new AlertDialog.Builder(this)
                                        .setTitle(R.string.permission_denied)
                                        .setMessage(R.string.permission_message)
                                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        })
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .setOnCancelListener(new DialogInterface.OnCancelListener() {
                                            @Override
                                            public void onCancel(DialogInterface dialog) {
                                               // finish();
                                            }
                                        })
                                        .show();
                            }

                        }
                        break;
                    }
                }
            }
        }
    }

    public void hideDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }

    public boolean isConnected() {
        return connection.isNetworkAvailable(this);
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

    /**
     * show error dialog
     */

    public void showErrorDialog(String message){
        new SmartDialogBuilder(this)
                .setTitle("Error")
                .setSubTitle(message)
                .setCancalable(false)
                .setNegativeButtonHide(true) //hide cancel button
                .setPositiveButton("OK", new SmartDialogClickListener() {
                    @Override
                    public void onClick(SmartDialog smartDialog) {
                        //Toast.makeText(BaseActivity.this,"Ok button Click",Toast.LENGTH_SHORT).show();
                        smartDialog.dismiss();
                    }
                }).build().show();
//                .setNegativeButton("Cancel", new SmartDialogClickListener() {
//            @Override
//            public void onClick(SmartDialog smartDialog) {
//                Toast.makeText(BaseActivity.this,"Cancel button Click",Toast.LENGTH_SHORT).show();
//                smartDialog.dismiss();
//
//            }

    }
}
