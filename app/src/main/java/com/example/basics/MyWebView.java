package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MyWebView extends AppCompatActivity {

    WebView web_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);
        web_content=(WebView)findViewById(R.id.web_container);
        web_content.loadUrl("file:///assets/website.html");
    }
}
