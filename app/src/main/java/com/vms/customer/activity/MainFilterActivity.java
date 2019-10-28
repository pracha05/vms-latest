package com.vms.customer.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.vms.customer.adapters.CustomTimeSlotAdapter;
import com.vms.customer.model.TimeSlotPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFilterActivity extends BaseActivity {
    @BindView(R.id.img_mainfilter_back)
    ImageView img_mainfilter_back;
    @BindView(R.id.tv_mainfilter_header)
    TextView tv_mainfilter_header;
    @BindView(R.id.tv_minvalue_skbar)
    TextView tv_minvalue_skbar;
    @BindView(R.id.tv_minivalue_skbar)
    TextView tv_minivalue_skbar;

    @BindView(R.id.simpleSeekBar)
    SeekBar simpleSeekBar;
    @BindView(R.id.simpleSeekBars)
    SeekBar simpleSeekBars;

    @BindView(R.id.sp_flt_select_amenities)
    Spinner sp_flt_select_amenities;
    @BindView(R.id.sp_flt_select_rearing)
    Spinner sp_flt_select_rearing;
    @BindView(R.id.sp_flt_select_member)
    Spinner sp_flt_select_member;
    @BindView(R.id.sp_flt_select_tons)
    Spinner sp_flt_select_tons;
    @BindView(R.id.sp_flt_select_height)
    Spinner sp_flt_select_height;
    @BindView(R.id.sp_flt_select_weight)
    Spinner sp_flt_select_weight;

    String[] amtSpinnerData = new String[] {"Select Amenities","1","2","3"
            ,"4"};
    List<TimeSlotPojo> amnilist;
    String[] rearSpinnerData = new String[] {"Select Rearing","5","4","3"
            ,"2","1"};
    List<TimeSlotPojo> rearlist;
    String[] memberSpinnerData = new String[] {"Select Member Ship","Prime","Gold"};
    List<TimeSlotPojo> memberlist;
    String[] tonsSpinnerData = new String[] {"Select Tons","16","20","25"};
    List<TimeSlotPojo> tonslist;
    String[] heightSpinnerData = new String[] {"Select Height","5","10","15"};
    List<TimeSlotPojo> heightlist;
    String[] weightSpinnerData = new String[] {"Select Weight","200kgs","500kgs","1000kgs"};
    List<TimeSlotPojo> weightlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_filter);
        ButterKnife.bind(this);
        img_mainfilter_back.setOnClickListener(this);
        tv_mainfilter_header.setTypeface(Typeface.createFromAsset(this.getAssets(), AppFonts.GetRobotoBold(this)));


        amnilist = new ArrayList<>();
        for (int i = 0; i < amtSpinnerData.length; i++) {

            TimeSlotPojo item = new TimeSlotPojo(amtSpinnerData[i]);
            amnilist.add(item);
        }
        CustomTimeSlotAdapter adapter = new CustomTimeSlotAdapter(MainFilterActivity.this,
                R.layout.spinner_item, amnilist);
        sp_flt_select_amenities.setAdapter(adapter);

        rearlist = new ArrayList<>();
        for (int i = 0; i < rearSpinnerData.length; i++) {

            TimeSlotPojo item = new TimeSlotPojo(rearSpinnerData[i]);
            rearlist.add(item);
        }
        adapter = new CustomTimeSlotAdapter(MainFilterActivity.this,
                R.layout.spinner_item, rearlist);
        sp_flt_select_rearing.setAdapter(adapter);

        memberlist = new ArrayList<>();
        for (int i = 0; i < memberSpinnerData.length; i++) {

            TimeSlotPojo item = new TimeSlotPojo(memberSpinnerData[i]);
            memberlist.add(item);
        }
        adapter = new CustomTimeSlotAdapter(MainFilterActivity.this,
                R.layout.spinner_item, memberlist);
        sp_flt_select_member.setAdapter(adapter);



        tonslist = new ArrayList<>();
        for (int i = 0; i < tonsSpinnerData.length; i++) {

            TimeSlotPojo item = new TimeSlotPojo(tonsSpinnerData[i]);
            tonslist.add(item);
        }
        adapter = new CustomTimeSlotAdapter(MainFilterActivity.this,
                R.layout.spinner_item, tonslist);
        sp_flt_select_tons.setAdapter(adapter);

        heightlist = new ArrayList<>();
        for (int i = 0; i < heightSpinnerData.length; i++) {

            TimeSlotPojo item = new TimeSlotPojo(heightSpinnerData[i]);
            heightlist.add(item);
        }
        adapter = new CustomTimeSlotAdapter(MainFilterActivity.this,
                R.layout.spinner_item, heightlist);
        sp_flt_select_height.setAdapter(adapter);

        weightlist = new ArrayList<>();
        for (int i = 0; i < weightSpinnerData.length; i++) {

            TimeSlotPojo item = new TimeSlotPojo(weightSpinnerData[i]);
            weightlist.add(item);
        }
        adapter = new CustomTimeSlotAdapter(MainFilterActivity.this,
                R.layout.spinner_item, weightlist);
        sp_flt_select_weight.setAdapter(adapter);


        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                tv_minvalue_skbar.setText("₹ "+progressChangedValue);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tv_minvalue_skbar.setText("₹ "+progressChangedValue);

            }
        });

        simpleSeekBars.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 1;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                tv_minivalue_skbar.setText(""+progressChangedValue);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tv_minivalue_skbar.setText(""+progressChangedValue);

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_mainfilter_back:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_out);
                break;
        }
    }
}
