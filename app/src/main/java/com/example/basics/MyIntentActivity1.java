package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyIntentActivity1 extends AppCompatActivity {
    Intent intent;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent1);
        button=(Button)findViewById(R.id.next_screen_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),MyIntentActivity2.class);
                startActivityForResult(intent,3);
            }
        });
    }
    @Override
    protected void onActivityResult(int rc,int result_code,Intent data)
    {
        super.onActivityResult(rc,result_code,data);
        Toast.makeText(getApplicationContext(),data.getStringExtra("Text"),Toast.LENGTH_SHORT).show();
    }
}
