package com.vms.customer.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.vms.customer.activity.TruckDetailsFourOptions;
import com.vms.customer.models.BookingSummaryPojo;
import com.vms.customer.R;

import java.util.ArrayList;
import java.util.List;


public class TruckListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<BookingSummaryPojo.Velhicle> list = new ArrayList<>();
    Context context;
    BookingSummaryPojo data;

    public TruckListAdapter(Context context, BookingSummaryPojo data) {
        this.context = context;
        this.data = data;
        list.addAll(data.velhicle);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listoftruck_layout, parent, false);
        return new BookingsummaryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof BookingsummaryHolder) {
            final BookingsummaryHolder cholder = (BookingsummaryHolder) holder;
                  cholder.img_truck_list_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, TruckDetailsFourOptions.class);
                    context.startActivity(intent);
                }
            });
                  cholder.card_view_listtruck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class BookingsummaryHolder extends RecyclerView.ViewHolder {

        CardView card_view_listtruck;
        LinearLayout img_truck_list_next;

        public BookingsummaryHolder(View view) {
            super(view);
            card_view_listtruck = view.findViewById(R.id.card_view_listtruck);
            img_truck_list_next = view.findViewById(R.id.img_truck_list_next);
        }
    }

}
