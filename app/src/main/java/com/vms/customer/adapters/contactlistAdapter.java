package com.vms.customer.adapters;

import android.content.Intent;
import android.graphics.Typeface;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vms.customer.activity.ContactAllList;
import com.vms.customer.activity.ContactDetailsInfo;
import com.vms.customer.models.contactlistPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import java.util.ArrayList;
import java.util.List;

public class contactlistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<contactlistPojo.Contact> list = new ArrayList<>();
    ContactAllList context;
    contactlistPojo data;

    public contactlistAdapter(ContactAllList context, contactlistPojo data) {
        this.context = context;
        this.data = data;
        list.addAll(data.contact);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_lists, parent, false);
        return new contactlistAdapter.contactlistholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof contactlistAdapter.contactlistholder) {
            final contactlistAdapter.contactlistholder cholder = (contactlistAdapter.contactlistholder) holder;
            cholder.txt_contact_company.setText(list.get(position).companyname);
            cholder.txt_contact_customer.setText(list.get(position).nameofthecustomer);
            cholder.txt_contact_mobile.setText(list.get(position).mobilenumber);

            cholder.txt_contact_company.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.txt_contact_customer.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.txt_contact_mobile.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetAvenirRegular(context)));
            cholder.ll_contact_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(context, ContactDetailsInfo.class);
                    context.startActivity(i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class contactlistholder extends RecyclerView.ViewHolder {
        TextView  txt_contact_company,  txt_contact_customer,  txt_contact_mobile;
LinearLayout ll_contact_list;
        public contactlistholder(View view) {
            super(view);
            txt_contact_company = view.findViewById(R.id.txt_contact_company);
            txt_contact_customer = view.findViewById(R.id.txt_contact_customer);
            txt_contact_mobile = view.findViewById(R.id.txt_contact_mobile);
            ll_contact_list = view.findViewById(R.id.ll_contact_list);

        }
    }
}