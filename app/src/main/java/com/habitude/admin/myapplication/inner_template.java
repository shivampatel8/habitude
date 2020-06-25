package com.habitude.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TimePicker;
import android.widget.Toast;

public class inner_template extends AppCompatActivity {
    String days = "";
    String time = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_template);
        final Intent intent = getIntent();
        final Button yourBtn1 = (Button) findViewById(R.id.b1);
        final TimePicker tp = (TimePicker) findViewById(R.id.timePicker);
        final CheckBox cb1 = (CheckBox) findViewById(R.id.sun);
        final CheckBox cb2 = (CheckBox) findViewById(R.id.mon);
        final CheckBox cb3 = (CheckBox) findViewById(R.id.tues);
        final CheckBox cb4 = (CheckBox) findViewById(R.id.wed);
        final CheckBox cb5 = (CheckBox) findViewById(R.id.thur);
        final CheckBox cb6 = (CheckBox) findViewById(R.id.fri);
        final CheckBox cb7 = (CheckBox) findViewById(R.id.sat);
        final DBhelper helper = new DBhelper(getBaseContext(), null, null, 0);
        final String id = intent.getStringExtra("mytext");
        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
        yourBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked() == true) {
                    days = days + "sunday";
                }
                if (cb2.isChecked() == true) {
                    days = days + "monday";
                }
                if (cb3.isChecked() == true) {
                    days = days + "tuesday";
                }
                if (cb4.isChecked() == true) {
                    days = days + "wednesday";
                }
                if (cb5.isChecked() == true) {
                    days = days + "thursday";
                }
                if (cb6.isChecked() == true) {
                    days = days + "friday";
                }
                if (cb7.isChecked() == true) {
                    days = days + "saturday";
                }
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                String h = String.valueOf(hour);
                String m = String.valueOf(min);
                time = h + m;
                String s1 = intent.getStringExtra("mytext");
                helper.inRecords(id, days, time);
            }
        });

    }
}
