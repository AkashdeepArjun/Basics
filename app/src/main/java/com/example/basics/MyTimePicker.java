package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MyTimePicker extends AppCompatActivity {

    TimePicker my_time_picker;
    StringBuilder builder;
    Button my_reset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_time_picker);
        builder=new StringBuilder();
        my_time_picker=(TimePicker)findViewById(R.id.my_time_picker);
        my_reset_button=(Button)findViewById(R.id.reset_button);
        my_time_picker.setIs24HourView(true);
        my_time_picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                    builder.append("hour :"+my_time_picker.getCurrentHour()+" second: "+my_time_picker.getCurrentMinute());
                    Toast.makeText(getApplicationContext(),builder.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        my_reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.delete(0,builder.length());
                Toast.makeText(getApplicationContext(),"data removed",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
