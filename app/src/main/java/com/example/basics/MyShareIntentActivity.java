package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyShareIntentActivity extends AppCompatActivity {

    Button share_buttonl;
    Intent myintent;
    String url="https://www.google.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_share_intent);
        share_buttonl=(Button)findViewById(R.id.share_button);
        share_buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myintent=new Intent(Intent.ACTION_SEND);
                myintent.setType("text/plain");
//                myintent.putExtra(Intent.EXTRA_SUBJECT,"ENTER SUBJECT");
                myintent.putExtra(Intent.EXTRA_TEXT,url);
                startActivity(Intent.createChooser(myintent,"share via"));

            }
        });

    }
}
