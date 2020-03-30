package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.TtsSpan;
import android.widget.DigitalClock;

import java.security.DigestException;

public class MyClock extends AppCompatActivity {

    DigitalClock my_clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_clock);
    }
}
