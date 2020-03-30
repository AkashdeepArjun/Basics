package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MyList extends AppCompatActivity {

        List<String> titles_list;
//        List<String> stites_list;

   String[] titles={"Apple","Orange","Berry"};
    String[] stits={"yummy good for health!!!","its juice tastes good","helps in blood circulation"};
    Integer[] photos={R.drawable.ic_apple,R.drawable.ic_orange
    ,R.drawable.ic_berry};
    MyListAdapter myAdapter;
    ListView fruits;
    androidx.appcompat.widget.SearchView mysearchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        titles_list=new ArrayList<String>();
        for (String i:titles
             ) {
                titles_list.add(i);
        }
        fruits=(ListView)findViewById(R.id.fruits);
        mysearchview=(androidx.appcompat.widget.SearchView)findViewById(R.id.mysearchview);
        myAdapter=new MyListAdapter(this,titles,stits,photos);
        fruits.setAdapter(myAdapter);
        mysearchview.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
//                        if(titles_list.contains(query))
//                        {
//                            ;
//                        }
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        myAdapter.getFilter().filter(newText);
                        return false;

                    }
                }
        );
//        mysearchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                myAdapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });

    }
}
