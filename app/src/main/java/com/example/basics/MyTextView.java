package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MyTextView extends AppCompatActivity {
    String countries[]={"India","Canada","US","NewZeaLand","England","Finland"};
    ArrayAdapter<String> myadapter;
    AutoCompleteTextView country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_text_view);
        myadapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,countries);
        country=(AutoCompleteTextView)findViewById(R.id.country);
        country.setThreshold(1);
        country.setAdapter(myadapter);


           }
}
