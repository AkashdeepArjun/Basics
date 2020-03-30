package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MyImageSlider extends AppCompatActivity {

    ViewPager my_frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_image_slider);
        my_frame=(ViewPager)findViewById(R.id.my_pager);
        MyPagerAdapter adapter = new MyPagerAdapter(this);
        my_frame.setAdapter(adapter);
    }
}
