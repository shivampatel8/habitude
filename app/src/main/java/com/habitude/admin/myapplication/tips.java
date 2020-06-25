package com.habitude.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class tips extends AppCompatActivity {
    private String lol = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        Button yourBtn1 = (Button) findViewById(R.id.button);
        Button yourBtn2 = (Button) findViewById(R.id.button7);
        Button yourBtn3 = (Button) findViewById(R.id.button11);
        Button yourBtn4 = (Button) findViewById(R.id.button12);

        yourBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), web.class);
                mainIntent.putExtra("mytext", "https://www.jeffsanders.com/top-10-habits-of-successful-people/");

                startActivity(mainIntent);

            }
        });
        yourBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(getApplicationContext(), web.class);
                mainIntent.putExtra("mytext", "http://psychcentral.com/lib/top-10-most-effective-study-habits/");

                startActivity(mainIntent);
            }
        });
        yourBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(getApplicationContext(), web.class);
                mainIntent.putExtra("mytext", "http://www.lifehack.org/articles/communication/9-daily-habits-that-will-change-your-life.html");

                startActivity(mainIntent);
            }
        });
        yourBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(getApplicationContext(), web.class);
                mainIntent.putExtra("mytext", "http://www.listchallenges.com/100-things-to-do-before-you-die");

                startActivity(mainIntent);
            }
        });


    }


}
