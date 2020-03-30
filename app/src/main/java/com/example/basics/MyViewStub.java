package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

public class MyViewStub extends AppCompatActivity {

    Button stub_button;
    ViewStub stub_frame;
    boolean is_on=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_stub);
        stub_button=(Button)findViewById(R.id.stub_switch);
        stub_frame=(ViewStub)findViewById(R.id.stub_frame);
        stub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!is_on)
                {
                    stub_frame.setVisibility(View.VISIBLE);
                    is_on=true;
                    stub_button.setText("turn off");
                }
                else
                {
                    stub_frame.setVisibility(View.INVISIBLE);
                    is_on=false;
                    stub_button.setText("turn on");
                }

            }
        });



    }
}
