package com.vms.customer.adapters;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vms.customer.activity.BookingSummery;
import com.vms.customer.model.BookingSummaryPojo;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import java.util.ArrayList;
import java.util.List;

public class BookingSummaryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<BookingSummaryPojo.Velhicle> list = new ArrayList<>();
    BookingSummery context;
    BookingSummaryPojo data;

    public BookingSummaryAdapter(BookingSummery context, BookingSummaryPojo data) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookingsummary_layout, parent, false);
        return new BookingsummaryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof BookingsummaryHolder) {
            final BookingsummaryHolder cholder = (BookingsummaryHolder) holder;
            cholder.tv_booksum_vname.setText(list.get(position).velhicleinfo);


            cholder.tv_booksum_vname.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoBold(context)));
            cholder.tv_booksum_capacity.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoBold(context)));
              cholder.tv_booksum_vehicle.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoBold(context)));



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

    private class BookingsummaryHolder extends RecyclerView.ViewHolder {
        TextView tv_booksum_capacity,tv_booksum_vehicle,
                tv_booksum_vname;
        ImageView img_mtype;

        public BookingsummaryHolder(View view) {
            super(view);
            tv_booksum_vname = view.findViewById(R.id.tv_booksum_vname);
            tv_booksum_capacity=view.findViewById(R.id.tv_booksum_capacity);

            tv_booksum_vehicle = view.findViewById(R.id.tv_booksum_vehicle);

        }
    }
}
