package com.vms.customer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.ui.ViewDialog;

public class SignInActivity extends BaseActivity {

    private static final String TAG = SignInActivity.class.getName();

    @BindView(R.id.tv_registration)
    TextView tvSignUp;

    @BindView(R.id.et_email)
    EditText edtEmail;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        tvSignUp.setOnClickListener(this);
        edtEmail.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= edtEmail.getTotalPaddingRight()) {
                       //start dashboard activity
                        startActivity(new Intent(SignInActivity.this,HomeActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                        return true;
                    }
                }
                return false;
            }
        });
//        ViewDialog viewDialog = new ViewDialog(this);
//        viewDialog.showDialog();
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.tv_registration:
                startActivity(IntentFactory.createRegistrationActivity(this));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }
}
