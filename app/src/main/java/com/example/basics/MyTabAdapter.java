package com.example.basics;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.basics.Fragment_Welcome;
import com.example.basics.GetStarted_Fragment;

public class MyTabAdapter extends FragmentPagerAdapter {
    Context where;
    FragmentManager fragmentManager;
    private int total_tabs;

    public MyTabAdapter(Context where, FragmentManager fm, int tabs) {
        super(fm);
        this.where = where;
        this.fragmentManager = fm;
        this.total_tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment_Welcome frag1 = new Fragment_Welcome();
                return frag1;
            case 1:
                GetStarted_Fragment frag2=new GetStarted_Fragment();
                return frag2;
            default:
                return null;

        }

        }
    @Override
    public int getCount() {
        return this.total_tabs;
    }
}
