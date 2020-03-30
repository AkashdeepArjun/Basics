package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

public class MyOptionsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_options_menu);
//        Toolbar mytoolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.mytoolbar);
//        super.setSupportActionBar(mytoolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.option_menu_layout,menu);
        super.onCreateOptionsMenu(menu);
//        super.onOptionI
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int id=menuitem.getItemId();
        switch(id){
            case R.id.exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuitem);
        }
    }
}
