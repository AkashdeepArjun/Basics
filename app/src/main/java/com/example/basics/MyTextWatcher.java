package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MyTextWatcher extends AppCompatActivity {

    String[] food={"daal","rice","wheat","potatos","narial"};
    ListView my_food;
    EditText search_field;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_text_watcher);
        my_food=(ListView)findViewById(R.id.my_food);
        search_field=(EditText)findViewById(R.id.search_field);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,food);
        my_food.setAdapter(adapter);
        search_field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
