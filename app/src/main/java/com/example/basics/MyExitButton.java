package com.example.basics;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyExitButton extends AppCompatActivity {
    Button exit_button;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_exit_button);
        exit_button=(Button)findViewById(R.id.exit_button);
        builder = new AlertDialog.Builder(this);
        setUpLogic();
    }
    private void setUpLogic()
    {
        builder.setMessage("You are welcome to try anything ").setTitle("Success!!");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        })
                .setCancelable(false)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        final AlertDialog dialog =builder.create();



        exit_button.setOnClickListener(new View.OnClickListener()
                                       {
                                           @Override
                                           public void onClick(View v)
                                           {
                                            dialog.show();

                                           }
                                       }
        );
    }
}
