package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MyImageSwitcher extends AppCompatActivity {
    ImageSwitcher myframe;
    Button next_button;
    Animation in,out;
    int count=-1;
    Integer[] images={R.drawable.house1,R.drawable.house2,R.drawable.house3,R.drawable.house4,R.drawable.house5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_image_switcher);
        in= AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        out=AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
        myframe=(ImageSwitcher)findViewById(R.id.my_frame);
        next_button=(Button)findViewById(R.id.next_button);
        myframe.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView photo_frame=new ImageView(getApplicationContext());
                photo_frame.setImageResource(R.drawable.ic_apple);
                photo_frame.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return photo_frame;
            }
        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count==images.length)
                {
                    count=0;
                    myframe.setImageResource(images[count]);
                }
                else
                {
                    myframe.setImageResource(images[count]);
                }
            }
        });
        myframe.setInAnimation(in);
        myframe.setOutAnimation(out);
    }
}
