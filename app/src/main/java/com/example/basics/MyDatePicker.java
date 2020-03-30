package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MyDatePicker extends AppCompatActivity {
    StringBuilder my_date;
    DatePicker my_date_picker;
    Button mybutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_date_picker);
        my_date=new StringBuilder();
        my_date_picker=(DatePicker)findViewById(R.id.date_picker);
        mybutton=(Button)findViewById(R.id.button);
        my_date_picker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                my_date.append(my_date_picker.getYear());
                int dat=my_date_picker.getMonth();
                my_date.append("/"+(++dat));
//                my_date.append("/"+my_date_picker.getDayOfMonth());
                Toast.makeText(getApplicationContext(),my_date.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                my_date.delete(0,my_date.length());
                Toast.makeText(getApplicationContext(),"data cleared",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
