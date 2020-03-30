package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MyContextMenu extends AppCompatActivity {

    String[] raions={"channe ki daal","arhar ki daal","allout refill pack","5 kg potatoes","2 kg sugar"};
    ListView ration_lsit;
    ArrayAdapter<String> mera_adpater;
    PopupMenu popupMenu;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_context_menu);
        button =(Button)findViewById(R.id.popup_button);
        ration_lsit=(ListView)findViewById(R.id.ration_list);
        mera_adpater=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,raions);
        ration_lsit.setAdapter(mera_adpater);
        registerForContextMenu(ration_lsit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu=new PopupMenu(MyContextMenu.this,button);
                popupMenu.getMenuInflater().inflate(R.menu.my_context_menu_layout,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id =item.getItemId();
                        switch (id){
                            case R.id.apple_item:
                                Toast.makeText(getApplicationContext(),"u selected apple", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.orange_item:
                                Toast.makeText(getApplicationContext(),"u selected orange ",Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                Toast.makeText(getApplicationContext(),"nothing selected",Toast.LENGTH_SHORT).show();

                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });




    }
    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View v,ContextMenu.ContextMenuInfo info)
    {
        super.onCreateContextMenu(contextMenu,v,info);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.my_context_menu_layout,contextMenu);
        contextMenu.setHeaderTitle("choose the approciate fruit");
//        super.onCOnt

    }
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.apple_item:
                Toast.makeText(getApplicationContext(),"u selected apple", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.orange_item:
                Toast.makeText(getApplicationContext(),"u selected orange ",Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(getApplicationContext(),"noting selected",Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
