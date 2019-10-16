package com.vms.customer.adapters;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vms.customer.activity.InsuranceProvider;
import com.vms.customer.models.insuranceproviderPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import java.util.ArrayList;
import java.util.List;

public class InsuranceProviderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<insuranceproviderPojo.Insurance> list = new ArrayList<>();
    InsuranceProvider context;
    insuranceproviderPojo data;

    public InsuranceProviderAdapter(InsuranceProvider context, insuranceproviderPojo data) {
        this.context = context;
        this.data = data;
        list.addAll(data.insurance);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insurance_provider, parent, false);
        return new InsuranceProviderAdapter.insuranceholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof InsuranceProviderAdapter.insuranceholder) {
            final InsuranceProviderAdapter.insuranceholder cholder = (InsuranceProviderAdapter.insuranceholder) holder;

            cholder.txt_insurance_policy.setText(list.get(position).policynumber);
            cholder.txt_insurance_order.setText(list.get(position).ordernumber);
            cholder.txt_insurance_date.setText(list.get(position).datepick);
            cholder.txt_insurance_pickup.setText(list.get(position).pickupplace);
            cholder.txt_insurance_droping.setText(list.get(position).dropingplace);
            cholder.txt_insurance_insurance.setText(list.get(position).insuranceamount);
            cholder.txt_insurnace_invoice.setText(list.get(position).invoiceamount);
            cholder.txt_insurance_vadility.setText(list.get(position).vadility);

            cholder.tv_insurance_policy.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoRegular(context)));
            cholder.tv_insurance_order.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoRegular(context)));
            cholder.tv_insurance_date.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoRegular(context)));
            cholder.tv_insurance_pickup.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoRegular(context)));


            cholder.tv_insurance_droping.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoRegular(context)));
            cholder.tv_insurance_insurance.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoRegular(context)));
            cholder.tv_insurance_invoice.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoRegular(context)));
            cholder.tv_insurance_vadility.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.txt_insurance_policy.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.txt_insurance_order.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.txt_insurance_date.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.txt_insurance_pickup.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.txt_insurance_droping.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.txt_insurance_insurance.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.txt_insurnace_invoice.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.txt_insurance_vadility.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));


//            RequestOptions requestOptions = new RequestOptions();
//            requestOptions.placeholder(R.drawable.vmslogo);
//
//            Glide.with(context)
//                    .setDefaultRequestOptions(requestOptions)
//                    .load(data.imagePath + img)
//                    .into(cholder.img_mtype);


        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class insuranceholder extends RecyclerView.ViewHolder {
        TextView tv_insurance_policy, txt_insurance_policy, tv_insurance_order, txt_insurance_order, tv_insurance_date, txt_insurance_date, tv_insurance_pickup, txt_insurance_pickup, tv_insurance_droping, txt_insurance_droping, tv_insurance_insurance, txt_insurance_insurance, tv_insurance_invoice, txt_insurnace_invoice, tv_insurance_vadility, txt_insurance_vadility;
        ImageView img_mtype;

        public insuranceholder(View view) {
            super(view);
            tv_insurance_policy = view.findViewById(R.id.tv_insurance_policy);
            txt_insurance_policy = view.findViewById(R.id.txt_insurance_policy);
            tv_insurance_order = view.findViewById(R.id.tv_insurance_order);
            txt_insurance_order = view.findViewById(R.id.txt_insurance_order);
            tv_insurance_date = view.findViewById(R.id.tv_insurance_date);
            txt_insurance_date = view.findViewById(R.id.txt_insurance_date);
            tv_insurance_pickup = view.findViewById(R.id.tv_insurance_pickup);
            txt_insurance_pickup = view.findViewById(R.id.txt_insurance_pickup);
            tv_insurance_droping = view.findViewById(R.id.tv_insurance_droping);
            txt_insurance_insurance = view.findViewById(R.id.txt_insurance_insurance);
            tv_insurance_insurance = view.findViewById(R.id.tv_insurance_insurance);
            txt_insurnace_invoice = view.findViewById(R.id.txt_insurance_invoice);
            tv_insurance_invoice = view.findViewById(R.id.tv_insurance_invoice);
            txt_insurance_droping = view.findViewById(R.id.txt_insurance_droping);
            tv_insurance_vadility = view.findViewById(R.id.tv_insurance_vadility);
            txt_insurance_vadility = view.findViewById(R.id.txt_insurance_vadility);

        }
    }
}