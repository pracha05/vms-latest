package com.vms.customer.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;


import com.vms.customer.adapters.CustomTimeSlotAdapter;
import com.vms.customer.intents.IntentFactory;
import com.vms.customer.models.TimeSlotPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddLoadActivity extends BaseActivity {
    @BindView(R.id.img_addload_back)
    ImageView img_addload_back;
    @BindView(R.id.btn_add_loaded)
    Button btn_add_loaded;
    @BindView(R.id.tv_addload_header)
    TextView tv_addload_header;
    @BindView(R.id.tv_addload_sourcepoint)
    TextView tv_addload_sourcepoint;
    @BindView(R.id.tv_addload_destpoint)
    TextView tv_addload_destpoint;
//    @BindView(R.id.tv_addload_permit)
//    TextView tv_addload_permit;
    @BindView(R.id.tv_al_select_truck)
    TextView tv_al_select_truck;
//    @BindView(R.id.tv_addload_estimated_time)
//    TextView tv_addload_estimated_time;
//    @BindView(R.id.tv_addload_tol_gate)
//    TextView tv_addload_tol_gate;
    @BindView(R.id.tv_al_select_material)
    TextView tv_al_select_material;
//    @BindView(R.id.tv_addload_distance)
//    TextView tv_addload_distance;

    @BindView(R.id.tv_al_select_date)
    TextView tv_al_select_date;
    @BindView(R.id.edt_al_remark)
    EditText edt_al_remark;
    @BindView(R.id.sp_al_select_time)
    Spinner sp_al_select_time;
    String[] timeSpinnerData = new String[]{"Select Time", "Now", "6am - 9am", "9am - 12pm"
            , "12pm - 3pm", "3pm - 6pm"};
    List<TimeSlotPojo> timelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addload);
        ButterKnife.bind(this);
        img_addload_back.setOnClickListener(this);
        tv_addload_sourcepoint.setOnClickListener(this);
        tv_addload_destpoint.setOnClickListener(this);
        tv_al_select_material.setOnClickListener(this);
        tv_al_select_truck.setOnClickListener(this);
        tv_al_select_date.setOnClickListener(this);
        edt_al_remark.setOnClickListener(this);
        btn_add_loaded.setOnClickListener(this);
        tv_addload_header.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        btn_add_loaded.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoBold(this)));
        tv_addload_sourcepoint.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
       // tv_addload_tol_gate.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_addload_destpoint.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        //tv_addload_permit.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_al_select_material.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
      //  tv_addload_distance.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        //tv_addload_estimated_time.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_al_select_truck.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        tv_al_select_date.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));
        edt_al_remark.setTypeface(Typeface.createFromAsset(getResources().getAssets(), AppFonts.GetRobotoRegular(this)));

        timelist = new ArrayList<>();
        for (int i = 0; i < timeSpinnerData.length; i++) {

            TimeSlotPojo item = new TimeSlotPojo(timeSpinnerData[i]);
            timelist.add(item);
        }
        CustomTimeSlotAdapter adapter = new CustomTimeSlotAdapter(AddLoadActivity.this,
                R.layout.spinner_item, timelist);
        sp_al_select_time.setAdapter(adapter);
    }


    int mYear, mMonth, mDay;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.img_addload_back:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;
            case R.id.btn_add_loaded:
                startActivity(IntentFactory.createListOfVechilesActivity(AddLoadActivity.this));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                break;

            case R.id.tv_al_select_date:
                Calendar mcurrentDate = Calendar.getInstance();
                mYear = mcurrentDate.get(Calendar.YEAR);
                mMonth = mcurrentDate.get(Calendar.MONTH);
                mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                final DatePickerDialog mDatePicker = new DatePickerDialog(AddLoadActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {

                        Calendar myCalendar = Calendar.getInstance();
                        try {

                            myCalendar.set(Calendar.YEAR, selectedyear);
                            myCalendar.set(Calendar.MONTH, selectedmonth);
                            myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                            String myFormat = "yyyy-MM-dd"; //Change as you need
                            SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
                            Date date = myCalendar.getTime();
                            String sDate = sdf.format(date);

                            tv_al_select_date.setText(sDate);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        mDay = selectedday;
                        mMonth = selectedmonth;
                        mYear = selectedyear;
                    }
                }, mYear, mMonth, mDay);
                //mDatePicker.setTitle("Select date");

                mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

                mDatePicker.show();

                break;


            case R.id.tv_al_select_material:
                final AlertDialog dialogBuilder1 = new AlertDialog.Builder(AddLoadActivity.this).create();
                LayoutInflater inflater1 = AddLoadActivity.this.getLayoutInflater();
                View dialogView1 = inflater1.inflate(R.layout.truck_material_dialog, null);

                ImageView three = dialogView1.findViewById(R.id.three);

                three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogBuilder1.dismiss();
                    }
                });

                dialogBuilder1.setView(dialogView1);
                dialogBuilder1.show();


                break;

            case R.id.tv_al_select_truck:
                final AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.truck_dialog, null);

                ImageView one = dialogView.findViewById(R.id.btn_membership);

                one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogBuilder.dismiss();

                        final AlertDialog dialogBuilder = new AlertDialog.Builder(AddLoadActivity.this).create();
                        LayoutInflater inflater = AddLoadActivity.this.getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.truck_type_dialog, null);

                        ImageView two = dialogView.findViewById(R.id.two);

                        two.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialogBuilder.dismiss();

                                final AlertDialog dialogBuilder = new AlertDialog.Builder(AddLoadActivity.this).create();
                                LayoutInflater inflater = AddLoadActivity.this.getLayoutInflater();
                                View dialogView = inflater.inflate(R.layout.truck_size_dialog, null);

                                ImageView three = dialogView.findViewById(R.id.three);

                                three.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        dialogBuilder.dismiss();
                                    }
                                });

                                dialogBuilder.setView(dialogView);
                                dialogBuilder.show();


                            }
                        });

                        dialogBuilder.setView(dialogView);
                        dialogBuilder.show();


                    }
                });

                dialogBuilder.setView(dialogView);
                dialogBuilder.show();


                break;
            case R.id.tv_addload_sourcepoint:
                try {
                    Intent intent =
                            new PlaceAutocomplete
                                    .IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                                    .build(this);
                    startActivityForResult(intent, 1);
                } catch (GooglePlayServicesRepairableException e) {
                    // TODO: Handle the error.
                } catch (GooglePlayServicesNotAvailableException e) {
                    // TODO: Handle the error.
                }

                break;
            case R.id.tv_addload_destpoint:
                try {
                    Intent intent =
                            new PlaceAutocomplete
                                    .IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                                    .build(this);
                    startActivityForResult(intent, 2);
                } catch (GooglePlayServicesRepairableException e) {
                    // TODO: Handle the error.
                } catch (GooglePlayServicesNotAvailableException e) {
                    // TODO: Handle the error.
                }

                break;

        }
    }


    // A place has been received; use requestCode to track the request.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // retrive the data by using getPlace() method.
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.e("Tag", "Place: " + place.getAddress() + place.getPhoneNumber());


                tv_addload_sourcepoint.setText(place.getName() + ",\n" +
                        place.getAddress() + "\n" + place.getPhoneNumber());

            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                // TODO: Handle the error.
                Log.e("Tag", status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        } else if (requestCode == 2) {
            {
                if (resultCode == RESULT_OK) {
                    // retrive the data by using getPlace() method.
                    Place place = PlaceAutocomplete.getPlace(this, data);
                    Log.e("Tag", "Place: " + place.getAddress() + place.getPhoneNumber());


                    tv_addload_destpoint.setText(place.getName() + ",\n" +
                            place.getAddress() + "\n" + place.getPhoneNumber());

                } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                    Status status = PlaceAutocomplete.getStatus(this, data);
                    // TODO: Handle the error.
                    Log.e("Tag", status.getStatusMessage());

                } else if (resultCode == RESULT_CANCELED) {
                    // The user canceled the operation.
                }
            }
        }
    }


}
