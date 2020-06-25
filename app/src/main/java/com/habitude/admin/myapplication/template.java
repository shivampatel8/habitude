package com.habitude.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class template extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        final Intent mainIntent = new Intent(template.this, inner_template.class);
        final TextView tv1 = (TextView) findViewById(R.id.tv1);
        final TextView tv2 = (TextView) findViewById(R.id.tv2);
        final TextView tv3 = (TextView) findViewById(R.id.tv3);
        final TextView tv4 = (TextView) findViewById(R.id.tv4);
        final TextView tv5 = (TextView) findViewById(R.id.tv5);
        final TextView tv6 = (TextView) findViewById(R.id.tv6);
        final TextView tv7 = (TextView) findViewById(R.id.tv7);
        final TextView tv8 = (TextView) findViewById(R.id.tv8);
        final TextView tv9 = (TextView) findViewById(R.id.tv9);
        final TextView tv10 = (TextView) findViewById(R.id.tv10);

        tv1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = tv1.getText().toString();
                mainIntent.putExtra("mytext", value);
                template.this.startActivity(mainIntent);
                template.this.finish();


                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });
        tv2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent.putExtra("mytext", (tv2.getText()).toString());
                template.this.startActivity(mainIntent);
                template.this.finish();

            }
        });
        tv3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent.putExtra("mytext", (tv3.getText()).toString());
                template.this.startActivity(mainIntent);
                template.this.finish();

            }
        });

        tv4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent.putExtra("mytext", (tv4.getText()).toString());
                template.this.startActivity(mainIntent);
                template.this.finish();

            }
        });
        tv5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent.putExtra("mytext", (tv5.getText()).toString());
                template.this.startActivity(mainIntent);
                template.this.finish();

            }
        });
        tv6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent.putExtra("mytext", (tv6.getText()).toString());
                template.this.startActivity(mainIntent);
                template.this.finish();

            }
        });
        tv7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent.putExtra("mytext", (tv7.getText()).toString());
                template.this.startActivity(mainIntent);
                template.this.finish();

            }
        });
        tv8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent.putExtra("mytext", (tv8.getText()).toString());
                template.this.startActivity(mainIntent);
                template.this.finish();

            }
        });
        tv9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent.putExtra("mytext", (tv9.getText()).toString());
                template.this.startActivity(mainIntent);
                template.this.finish();

            }
        });
        tv10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent.putExtra("mytext", (tv10.getText()).toString());
                template.this.startActivity(mainIntent);
                template.this.finish();

            }
        });

    }
}
