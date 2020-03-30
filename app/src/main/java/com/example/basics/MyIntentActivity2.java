package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyIntentActivity2 extends AppCompatActivity {

    Button title;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent2);
        title=(Button)findViewById(R.id.data_text);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.putExtra("Text","lol this is just date");
                setResult(3,intent);
                finish();
            }
        });
    }
}
