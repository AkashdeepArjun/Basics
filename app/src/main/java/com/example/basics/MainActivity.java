package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button button;
    Toast toast;
    ToggleButton toggle;
    View screen;
    CheckBox keep_logged;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.login_button);
//        toggle=(ToggleButton)findViewById(R.id.toggle);
        screen=this.getWindow().getDecorView();
        keep_logged=(CheckBox)findViewById(R.id.keep_logged);
        LayoutInflater inflator=getLayoutInflater();
        View my_layout=inflator.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.custom_toast_layout));
        toast= new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setView(my_layout);
//        toggle.setChecked(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    toast.show();
            }
        });
////        toggle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!toggle.isActivated())
//                {
//                    toggle.setActivated(true);
//                   screen.setBackgroundColor(Color.BLACK);
//                   toggle.setText("white");
//                }
//                else
//                {
//                    toggle.setActivated(false);
//
//                    screen.setBackgroundColor(Color.WHITE);
//                    toggle.setText("dark");
//                }
//            }});
    }

}
