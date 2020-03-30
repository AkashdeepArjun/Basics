package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MyRatingBar extends AppCompatActivity {
    RatingBar rating;
    Button button;
    float stars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rating_bar);
        rating=(RatingBar)findViewById(R.id.rating);
        button=(Button)findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {

                stars=rating.getRating();
//                rating.
                Toast.makeText(getApplicationContext(),"you got "+stars,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
