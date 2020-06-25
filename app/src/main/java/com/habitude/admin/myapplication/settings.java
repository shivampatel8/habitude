package com.habitude.admin.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class settings extends AppCompatActivity {
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button yourBtn1 = (Button) findViewById(R.id.button8);
        Button yourBtn2 = (Button) findViewById(R.id.button9);
        Button yourBtn3 = (Button) findViewById(R.id.button10);
        final DBhelper helper = new DBhelper(getBaseContext(), null, null, 0);
        final DBhelper1 helper1 = new DBhelper1(getBaseContext(), null, null, 0);
        Intent alarmIntent = new Intent(settings.this, MyReciever1.class);
        pendingIntent = PendingIntent.getBroadcast(settings.this, 0, alarmIntent, 0);
        yourBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
        yourBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cancel();
            }
        });
        yourBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper.deleteall();
                helper1.deleteall();
            }
        });
    }

    public void start() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 1000;

        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
    }

    public void cancel() {

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        /*  manager.setExact(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10000,pendingIntent);*/
        manager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
    }

    public void startAt10() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 1000 * 60 * 20;

        /* Set the alarm to start at 10:30 AM */
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 17);
        calendar.set(Calendar.MINUTE, 05);

        /* Repeating on every 20 minutes interval */
        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 20, pendingIntent);
    }

}
