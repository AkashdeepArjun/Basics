package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.webkit.WebBackForwardList;
import android.widget.FrameLayout;
import com.google.android.material.tabs.TabLayout;
public class MyFragments extends AppCompatActivity {
    FragmentManager fm;
    FragmentTransaction ft;
    FrameLayout mylayout;
    TabLayout mytablayout;
    Fragment_Welcome default_frag;
    Fragment current_frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragments);
        mylayout=(FrameLayout)findViewById(R.id.myframe);
        mytablayout=(TabLayout)findViewById(R.id.mytabs);
        default_frag=new Fragment_Welcome();
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.myframe,default_frag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
        mytablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition())
                {
                    case 0:
                        current_frag=new Fragment_Welcome();
                        break;
                    case 1:
                        current_frag=new GetStarted_Fragment();
                        break;
                    default:
                        current_frag=new Fragment_Welcome();
                        break;
                }
                fm=getSupportFragmentManager();
                ft=fm.beginTransaction();
                ft.replace(R.id.myframe,current_frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
