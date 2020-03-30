package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MySpinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner my_spinner;
    Toast toast;
    ArrayAdapter<String> myadapter;
    String friends[]={"aman","akash","gaurav","gurasees","sangam","suraj"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_spinner);
        my_spinner =(Spinner)findViewById(R.id.my_spinner);
        my_spinner.setOnItemSelectedListener(this);
        myadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friends);
        my_spinner.setAdapter(myadapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         Toast.makeText(getApplicationContext(),friends[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(),"nothing selected tf",Toast.LENGTH_SHORT).show();

    }
}
