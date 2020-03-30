package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MyProgessBarTask extends AppCompatActivity {

    ProgressDialog my_progress_bar;
    private Handler mytask_handler =new Handler();
    int progressStatus=0;
     Button button;
    int filesize=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progess_bar_task);
        button =(Button)findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_progress_bar =new ProgressDialog(v.getContext());
                my_progress_bar.setCancelable(true);
                my_progress_bar.setMessage("donloading");
                my_progress_bar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                my_progress_bar.setProgress(0);
                my_progress_bar.setMax(0);
                my_progress_bar.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while(progressStatus <100)
                        {
                                    progressStatus=doSomeLogic();
                                    try
                                    {
                                        Thread.sleep(1000);

                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }


                                    // han
                                    mytask_handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                                my_progress_bar.setProgress(progressStatus);
                                        }
                                    });


                        }

                        try
                        {
                            Thread.sleep(1000);

                        }catch (Exception e){e.printStackTrace();}
                        finally {
                            my_progress_bar.dismiss();
                        }

                    }
                }).start();


            }
        });
    }


    private int doSomeLogic()
    {
        while(filesize <10000)
        {
            filesize++;
            if(filesize==1000)
            {
                return 10;
            }
            if(filesize==2000)
            {
                return 20;
            }

        }
        return 100;

    }






}
