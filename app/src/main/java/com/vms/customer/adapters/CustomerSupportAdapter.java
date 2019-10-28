package com.vms.customer.adapters;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vms.customer.activity.CustomerSupport;
import com.vms.customer.model.CustomerSupportPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import java.util.ArrayList;
import java.util.List;

public class CustomerSupportAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<CustomerSupportPojo.Support> list = new ArrayList<>();
    CustomerSupport context;
    CustomerSupportPojo data;

    public CustomerSupportAdapter(CustomerSupport context, CustomerSupportPojo data) {
        this.context = context;
        this.data = data;

        list.addAll(data.support);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.supportcustomer, parent, false);
        return new CustomerSupportholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof CustomerSupportholder) {
            final CustomerSupportholder cholder = (CustomerSupportholder) holder;
            cholder.tv_customer_vname.setText(list.get(position).velhicleinfo);


            cholder.tv_customer_vname.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoBold(context)));
            cholder.tv_customer_capacity.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoBold(context)));
            cholder.tv_customer_vehicle.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoBold(context)));

            cholder.btn_customer_query.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

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

    private class CustomerSupportholder extends RecyclerView.ViewHolder {
        TextView tv_customer_capacity,tv_customer_vehicle,
                tv_customer_vname;
        ImageView img_customer_vehicle;
        Button btn_customer_query;

        public CustomerSupportholder(View view) {
            super(view);
            tv_customer_capacity = view.findViewById(R.id.tv_customer_capacity);
            tv_customer_vehicle=view.findViewById(R.id.tv_customer_vname);
            btn_customer_query=view.findViewById(R.id.btn_customer_query);
            tv_customer_vname = view.findViewById(R.id.tv_customer_vname);

        }
    }
}
