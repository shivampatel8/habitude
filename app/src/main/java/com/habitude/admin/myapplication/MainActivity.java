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

public class MainActivity extends AppCompatActivity {

    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button yourBtn1 = (Button) findViewById(R.id.button1);
        Button yourBtn2 = (Button) findViewById(R.id.button2);
        Button yourBtn3 = (Button) findViewById(R.id.button3);
        Button yourBtn4 = (Button) findViewById(R.id.button4);
        Button yourBtn5 = (Button) findViewById(R.id.button5);
        Button yourBtn6 = (Button) findViewById(R.id.button6);
        Intent alarmIntent = new Intent(MainActivity.this, MyReciever1.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);
        startAt3();
        startAt7();
        yourBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), customize.class);
                startActivity(mainIntent);
            }
        });
        yourBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(getApplicationContext(), template.class);
                startActivity(mainIntent);
            }
        });
        yourBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(getApplicationContext(), current.class);
                startActivity(mainIntent);
            }
        });
        yourBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(getApplicationContext(), list.class);
                startActivity(mainIntent);
            }
        });
        yourBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), tips.class);
                startActivity(mainIntent);
            }
        });
        yourBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* final DBhelper helper = new DBhelper(getApplicationContext(), null, null, 0);
                String msg = null;
                Cursor cur = null;
                cur = helper.selRecs();
                if (cur != null && cur.moveToNext()) {

                    cur.moveToFirst();
                    {
                        do {
                            msg=msg + cur.getString(0);
                        } while (cur.moveToNext());
                    }
                }
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
                mBuilder.setSmallIcon(R.drawable.notification_template_icon_bg);
                mBuilder.setContentTitle("Notification Alert, Click Me!");
                mBuilder.setContentText("Hi, This is Android Notification Detail!");
                //NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationManager mNotifyMgr =
                        (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
// notificationID allows you to update the notification later on.
                mNotifyMgr.notify(1, mBuilder.build());
                mBuilder.setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(msg));*/
                Intent mainIntent = new Intent(getApplicationContext(), settings.class);
                startActivity(mainIntent);


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

    public void startAt7() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 1000 * 60 * 60 * 24;

        /* Set the alarm to start at 7:00 AM */
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 07);
        calendar.set(Calendar.MINUTE, 00);

        /* Repeating on every 24 Hours interval */
        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                interval, pendingIntent);
    }

    public void startAt3() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 1000 * 60 * 60 * 24;

        /* Set the alarm to start at 3:00 PM */
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 00);

        /* Repeating on every 24 Hours interval */
        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                interval, pendingIntent);
    }

}


