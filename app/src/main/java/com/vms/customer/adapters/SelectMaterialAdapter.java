package com.vms.customer.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.vms.customer.activity.MaterialType;
import com.vms.customer.models.SelMaterialCategory;
import com.vms.customer.R;
import com.vms.customer.utils.AppFonts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectMaterialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<SelMaterialCategory.Message> list = new ArrayList<>();
    Context context;
    SelMaterialCategory data;

    public SelectMaterialAdapter(MaterialType context, SelMaterialCategory data) {
        this.context = context;
        this.data = data;
        Collections.reverse(data.message);
        list.addAll(data.message);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_gv_layout, parent, false);
        return new HomeCatrgoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof HomeCatrgoryHolder) {
            final HomeCatrgoryHolder cholder = (HomeCatrgoryHolder) holder;
            cholder.txt_mtype.setText(list.get(position).catName);
            cholder.txt_mtype.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), AppFonts.GetRobotoBold(context)));

            String img = null;
            if(list.get(position).catImg!=null)
            {
                img=list.get(position).catImg.trim();
            }

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.vmslogo);

            Glide.with(context)
                    .setDefaultRequestOptions(requestOptions)
                    .load(data.imagePath + img)
                    .into(cholder.img_mtype);

            cholder.img_mtype.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class HomeCatrgoryHolder extends RecyclerView.ViewHolder {
        TextView txt_mtype;
        ImageView img_mtype;

        public HomeCatrgoryHolder(View view) {
            super(view);
            txt_mtype = itemView.findViewById(R.id.txt_mtype);
            img_mtype = itemView.findViewById(R.id.img_mtype);
        }
    }
}
