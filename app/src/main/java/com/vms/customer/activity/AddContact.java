package com.vms.customer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddContact extends BaseActivity {

    @BindView(R.id.img_contact_back)
    ImageView img_contact_back;
    @BindView(R.id.tv_contact_header)
    TextView tv_contact_header;
    @BindView(R.id.txt_contactcompany)
    TextView txt_contactcompany;
    @BindView(R.id.edt_contactcompany)
    EditText edt_contactcompany;
    @BindView(R.id.txt_contactphonenumber)
    TextView txt_contactphonenumber;
    @BindView(R.id.edt_contactphonenumber)
    EditText edt_contactphonenumber;
    @BindView(R.id.txt_contactgst)
    TextView txt_contactgst;
    @BindView(R.id.edt_contactgst)
    EditText edt_contactgst;
    @BindView(R.id.tx_contactcustomer)
    TextView tx_contactcustomer;
    @BindView(R.id.edt_contactcustomer)
    EditText edt_contactcustomer;
    @BindView(R.id.tx_contactemail)
    TextView tx_contactemail;
    @BindView(R.id.edt_contactemail)
    EditText edt_contactemail;
    @BindView(R.id.txt_contactaddress)
    TextView txt_contactaddress;
    @BindView(R.id.edt_contactaddress)
    EditText edt_contactaddress;
    @BindView(R.id.img_contact_contactlist)
    ImageView img_contact_contactlist;
    @BindView(R.id.btn_submit)
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        ButterKnife.bind(this);
        img_contact_back.setOnClickListener(this);
        img_contact_contactlist.setOnClickListener(this);
        btn_submit.setOnClickListener(this);

        tv_contact_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        btn_submit.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));

        txt_contactcompany.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_contactphonenumber.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_contactgst.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        tx_contactcustomer.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        tx_contactemail.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_contactaddress.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        edt_contactcompany.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_contactphonenumber.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_contactgst.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_contactcustomer.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_contactemail.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));
        edt_contactaddress.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetAvenirRegular(this)));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                startActivity(IntentFactory.createDetailsInfoActivity(AddContact.this));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;
            case R.id.img_contact_back:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;

            case R.id.img_contact_contactlist:
                Intent intent = new Intent(AddContact.this, ContactDetailsInfo.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }

    }
}
