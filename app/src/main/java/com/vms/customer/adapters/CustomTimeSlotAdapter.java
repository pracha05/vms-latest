package com.vms.customer.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vms.customer.models.TimeSlotPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import java.util.List;

public class CustomTimeSlotAdapter extends ArrayAdapter<TimeSlotPojo> {

    LayoutInflater flater;

    public CustomTimeSlotAdapter(Activity context, int resouceId, List<TimeSlotPojo> list){

        super(context,resouceId, list);
//        flater = context.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return rowview(convertView,position);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return rowview(convertView,position);
    }

    private View rowview(View convertView , int position){

        TimeSlotPojo rowItem = getItem(position);

        viewHolder holder ;
        View rowview = convertView;
        if (rowview==null) {

            holder = new viewHolder();
            flater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = flater.inflate(R.layout.spinner_item, null, false);

            holder.txtTitle = (TextView) rowview.findViewById(R.id.titles);
            holder.txtTitle.setTypeface(Typeface.createFromAsset(getContext().getAssets(), AppFonts.GetRobotoRegular(getContext())));

            rowview.setTag(holder);
        }else{
            holder = (viewHolder) rowview.getTag();
        }
        holder.txtTitle.setText(rowItem.getTimeSpinnerDatum());

        return rowview;
    }

    private class viewHolder{
        TextView txtTitle;
    }
}