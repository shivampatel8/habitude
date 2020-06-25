package com.habitude.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Toast;

public class web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        final Intent intent = getIntent();

        final String id = intent.getStringExtra("mytext");
        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
        myWebView.loadUrl(id);
    }
}
