package com.example.basics;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MyPagerAdapter extends PagerAdapter
{
    private int[] photos={R.drawable.house5,R.drawable.house4,R.drawable.house3,R.drawable.house2};
        Context context;
        public MyPagerAdapter(Context context)
        {
            this.context=context;
        }


    @Override
    public int getCount() {
        return photos.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(ImageView)object;
//        return false;
    }
    @Override
    public Object instantiateItem(ViewGroup container,int position)
    {
        ImageView photo_item=new ImageView(this.context);
        photo_item.setScaleType(ImageView.ScaleType.CENTER_CROP);
        photo_item.setImageResource(photos[position]);
        ((ViewPager)container).addView(photo_item,0);
        return photo_item;
    }
    @Override
    public void destroyItem(ViewGroup container,int position,Object v)
    {
        ((ViewPager)container).removeView((ImageView)v);
    }
}
