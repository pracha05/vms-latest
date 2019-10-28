package com.vms.customer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.vms.customer.model.TruckImgPojo;
import com.vms.customer.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerSliderAdapter extends PagerAdapter

{

    private Context context;
    private LayoutInflater layoutInflater;

    List<TruckImgPojo.Banner> list = new ArrayList<>();
    TruckImgPojo data;
    public ViewPagerSliderAdapter(Context context, TruckImgPojo data) {
        this.context=context;
        this.data=data;
        list.addAll(data.banner);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.customslider_layout, null);
        ImageView imageView =  view.findViewById(R.id.sliderimageView);
        Glide.with(context)
                .load(list.get(position).image)

                .into( imageView);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}
