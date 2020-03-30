package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

public class MySeekBar extends AppCompatActivity {

    SeekBar volume_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_seek_bar);
        volume_bar=(SeekBar)findViewById(R.id.volume_bar);
        volume_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(),"progress is "+volume_bar.getProgress(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"started!! yay",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Toast.makeText(getApplicationContext(),"stopped",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
