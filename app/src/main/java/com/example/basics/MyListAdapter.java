package com.example.basics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MyListAdapter extends ArrayAdapter<String> {
    private Context where;
    private String[] titles;
    private String[] subtitles;
    private Integer[] photo_ids;
    public MyListAdapter(Context where,String[] titles,String[] stites,Integer[] photos)
    {
        super(where,R.layout.row,titles);
        this.where=where;
        this.titles=titles;
        this.subtitles=stites;
        this.photo_ids=photos;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
       LayoutInflater inflator=LayoutInflater.from(getContext());
       View row=inflator.inflate(R.layout.row,null,true);
        ImageView photo=(ImageView)row.findViewById(R.id.photo);
        TextView title=(TextView)row.findViewById(R.id.title);
        TextView subtitle=(TextView)row.findViewById(R.id.sub_title);
        photo.setImageResource(this.photo_ids[position]);
        title.setText(this.titles[position]);
        subtitle.setText(this.subtitles[position]);

        return row;





    }


}
