package com.habitude.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView mImageView = (ImageView) findViewById(R.id.imageView);

        // mImageView.setImageURI(Uri.parse("C:\\Users\\ADMIN\\AndroidStudioProjects\\MyApplication\\app\\src\\main\\res\\drawable\\logo.jpg"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(title.this, MainActivity.class);
                title.this.startActivity(mainIntent);
                title.this.finish();
            }
        }, 3000);
    }
}
