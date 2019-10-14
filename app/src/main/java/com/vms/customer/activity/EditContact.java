package com.vms.customer.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditContact extends BaseActivity {
    @BindView(R.id.img_edit_contact_edit)
    ImageView img_edit_contact_edit;
    @BindView(R.id.tv_edit_contact_header)
    TextView tv_edit_contact_header;

    @BindView(R.id.txt_editcompany)
    TextView txt_editcompany;
    @BindView(R.id.edt_editcompany)
    EditText edt_editcompany;

    @BindView(R.id.txt_editphonenumber)
    TextView txt_editphonenumber;
    @BindView(R.id.edt_editcontactphonenumber)
    EditText edt_editcontactphonenumber;
    @BindView(R.id.txt_editgst)
    TextView txt_editgst;
    @BindView(R.id.edt_editgst)
    EditText edt_editgst;
    @BindView(R.id.tx_editcustomer)
    TextView tx_editcustomer;
    @BindView(R.id.edt_editcustomer)
    EditText edt_editcustomer;
    @BindView(R.id.tx_editemail)
    TextView tx_editemail;
    @BindView(R.id.edt_editemail)
    EditText edt_editemail;
    @BindView(R.id.txt_editaddress)
    TextView txt_editaddress;
    @BindView(R.id.edt_editaddress)
    EditText edt_editaddress;
    @BindView(R.id.btn_submit)
    Button btn_submit;


    private String companyname, phonenumber, gstnumber, CustomerName, emailid, Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        ButterKnife.bind(this);
        img_edit_contact_edit.setOnClickListener(this);
        btn_submit.setOnClickListener(this);

        tv_edit_contact_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tx_editcustomer.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_editphonenumber.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_editgst.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        tx_editcustomer.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        tx_editemail.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        txt_editaddress.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        edt_editcompany.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        edt_editcontactphonenumber.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        edt_editgst.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        edt_editcustomer.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        edt_editemail.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        edt_editaddress.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));

        Bundle b = getIntent().getExtras();
        companyname = b.getString("companyname");
        phonenumber = b.getString("phonenumber");
        gstnumber = b.getString("gstnumber");
        CustomerName = b.getString("CustomerName");
        emailid = b.getString("emailid");
        Address = b.getString("Address");

        edt_editcompany.setText(companyname);
        edt_editcontactphonenumber.setText(phonenumber);
        edt_editgst.setText(gstnumber);
        edt_editcustomer.setText(CustomerName);
        edt_editemail.setText(emailid);
        edt_editaddress.setText(Address);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_edit_contact_edit:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;

            case R.id.btn_submit:
                break;
        }

    }

}
