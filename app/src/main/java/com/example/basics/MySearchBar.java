package com.example.basics;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.core.view.MenuItemCompat;
//  import android.support.v4.view.MenuItemCompat;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toolbar;

public class MySearchBar extends AppCompatActivity {

    String[] yaar={"aman","gaurav","vasu","nandi paaji","sangam","sunil","gurasees"};   // random string[] array
    ArrayAdapter<String> adapter;
    ListView yaara_di_list;
//    Toolbar toolbar;
//    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_search_bar);
//        toolbar = (android.widget.Toolbar)findViewById(R.id.my_too_bar);
        yaara_di_list=(ListView)findViewById(R.id.yaara_di_list);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,yaar);
        yaara_di_list.setAdapter(adapter);
        // setSupportActionBar(toolbar);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
     // menu=toolbar.getMenu();
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
        MenuItem menuitem=menu.findItem(R.id.my_search_bar);
        androidx.appcompat.widget.SearchView searchview=(androidx.appcompat.widget.SearchView)MenuItemCompat.getActionView(menuitem);
        searchview.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
