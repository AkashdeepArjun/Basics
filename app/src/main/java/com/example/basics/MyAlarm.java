package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyAlarm extends AppCompatActivity {

        EditText alarm_time;
        Button set_alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_alarm);
        alarm_time=(EditText)findViewById(R.id.alarm_time);
        set_alarm=(Button)findViewById(R.id.set_alarm);
        set_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myLogic();
            }
        });

    }

    public void myLogic()
    {
        int time=Integer.parseInt(alarm_time.getText().toString());
        Intent intent =new Intent(this,MyReciever.class);
        PendingIntent alarm_event=PendingIntent.getBroadcast(this.getApplicationContext(),2,intent,0);
        AlarmManager myalarmmanager=(AlarmManager)getSystemService(ALARM_SERVICE);
        myalarmmanager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(time*1000),alarm_event);
        Toast.makeText(getApplicationContext(),"alarm set",Toast.LENGTH_LONG).show();






    }




}
