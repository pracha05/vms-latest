package com.vms.customer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.vms.customer.R;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.utils.AppFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactDetailsInfo extends BaseActivity {

    @BindView(R.id.img_condetails_contact_back)
    ImageView img_condetails_contact_back;
    @BindView(R.id.tv_condetails_contact_header)
    TextView tv_condetails_contact_header;
    @BindView(R.id.img_threedot)
    ImageView img_threedot;
    @BindView(R.id.tv_condetails_contact_company)
    TextView tv_condetails_contact_company;
    @BindView(R.id.txt_condetails_contact_company)
    TextView txt_condetails_contact_company;

    @BindView(R.id.tv_condetails_contact_customer)
    TextView tv_condetails_contact_customer;
    @BindView(R.id.txt_condetails_contact_customer)
    TextView txt_condetails_contact_customer;
    @BindView(R.id.tv_condetails_contact_mobile)
    TextView tv_condetails_contact_mobile;
    @BindView(R.id.txt_condetails_contact_mobile)
    TextView txt_condetails_contact_mobile;
    @BindView(R.id.tv_condetails_contact_email)
    TextView tv_condetails_contact_email;
    @BindView(R.id.txt_condetails_contact_email)
    TextView txt_condetails_contact_email;

    @BindView(R.id.tv_condetails_contact_gst)
    TextView tv_condetails_contact_gst;
    @BindView(R.id.txt_condetails_contact_gst)
    TextView txt_condetails_contact_gst;

    @BindView(R.id.tv_condetails_contact_map)
    TextView tv_condetails_contact_map;
    @BindView(R.id.txt_condetails_contact_map)
    TextView txt_condetails_contact_map;

    @BindView(R.id.tv_condetails_contact_Address)
    TextView tv_condetails_contact_Address;
    @BindView(R.id.txt_condetails_contact_Address)
    TextView txt_condetails_contact_Address;

    @BindView(R.id.tv_condetails_contact_save)
    TextView tv_condetails_contact_save;
    @BindView(R.id.txt_condetails_contact_save)
    TextView txt_condetails_contact_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details_info);
        ButterKnife.bind(this);
        img_condetails_contact_back.setOnClickListener(this);
        img_threedot.setOnClickListener(this);


        tv_condetails_contact_save.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        txt_condetails_contact_save.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_condetails_contact_Address.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        txt_condetails_contact_Address.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_condetails_contact_map.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        txt_condetails_contact_map.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_condetails_contact_gst.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        txt_condetails_contact_gst.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_condetails_contact_email.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        txt_condetails_contact_email.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        txt_condetails_contact_company.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_condetails_contact_customer.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_condetails_contact_mobile.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_condetails_contact_company.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        txt_condetails_contact_customer.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        txt_condetails_contact_mobile.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_condetails_contact_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_condetails_contact_back:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;
            case R.id.img_threedot:
                PopupMenu popup = new PopupMenu(ContactDetailsInfo.this, img_threedot);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.pop_view) {

                        } else if (item.getItemId() == R.id.pop_edit) {
                            Intent intent = IntentFactory.createEditContactActivity(ContactDetailsInfo.this);
                            intent.putExtra("companyname", txt_condetails_contact_company.getText().toString());
                            intent.putExtra("phonenumber", txt_condetails_contact_mobile.getText().toString());
                            intent.putExtra("gstnumber", txt_condetails_contact_gst.getText().toString());
                            intent.putExtra("CustomerName", txt_condetails_contact_customer.getText().toString());
                            intent.putExtra("emailid", txt_condetails_contact_email.getText().toString());
                            intent.putExtra("Address", txt_condetails_contact_Address.getText().toString());
                            startActivity(intent);
                        }
                        return true;
                    }
                });

                popup.show();//showing popup menu

                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
    }
}
