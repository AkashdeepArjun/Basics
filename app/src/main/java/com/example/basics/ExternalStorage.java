package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExternalStorage extends AppCompatActivity {
    EditText field_file,field_data;
    Button button_save,button_restore;
    TextView output_area;
    StringBuilder output_text;
    String[] permissions ={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermissions(permissions,1);
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(getApplicationContext(),"granted permisiions",Toast.LENGTH_SHORT).show();
        }
        setContentView(R.layout.activity_external_storage);
        output_text=new StringBuilder();
        output_area=(TextView)findViewById(R.id.output_area);
        field_data=(EditText)findViewById(R.id.field_data);
        field_file=(EditText)findViewById(R.id.field_file);
        button_save=(Button)findViewById(R.id.button_save);
        button_restore=(Button)findViewById(R.id.button_restore);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMyData();
            }
        });
        button_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restoreMyData();
            }
        });

    }
    public void saveMyData()
    {
        try
        {
            String filename,data;
            filename=field_file.getText().toString();
            data=field_data.getText().toString();
            File myfile =new File("/sdcard/"+filename
            );
            myfile.createNewFile();
            FileOutputStream fos=new FileOutputStream(myfile);
            OutputStreamWriter fw=new OutputStreamWriter(fos);
            fw.append(data);
            Toast.makeText(getApplicationContext(),"data saved!",Toast.LENGTH_SHORT).show();
            fw.close();
            fos.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void restoreMyData()
    {
        try
        {
            String temp;
            File myfile = new File("/sdcard/"+field_file.getText().toString());
            FileInputStream fis=new FileInputStream(myfile);
            BufferedReader readr =new BufferedReader(new InputStreamReader(fis));
            while((temp=readr.readLine())!=null)
            {
                output_text.append(temp);
            }
            readr.close();
            fis.close();
            output_area.setText(output_text);


        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
