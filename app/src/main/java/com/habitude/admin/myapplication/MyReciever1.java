package com.habitude.admin.myapplication;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import java.util.Calendar;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by ADMIN on 16-10-2016.
 */

public class MyReciever1 extends BroadcastReceiver {
    private static final int NOTIFICATION_ID = 3;

    @Override
    public void onReceive(Context context, Intent intent) {

        final DBhelper helper = new DBhelper(context, null, null, 0);

        String msg = "";
        String day = "";
        Cursor cur = null;
        Calendar calendar = Calendar.getInstance();
        int daym = calendar.get(Calendar.DAY_OF_WEEK);
        Toast.makeText(context, String.valueOf(daym), Toast.LENGTH_LONG).show();
        switch (daym) {
            case Calendar.SUNDAY:
                day = day + "sunday";
                // Current day is Sunday

            case Calendar.MONDAY:
                day = day + "monday";
                // Current day is Monday

            case Calendar.TUESDAY:
                // etc.
        }
        //cur = helper.selecttype(day);
        cur = helper.selRecs();
        if (cur != null && cur.moveToNext()) {

            cur.moveToFirst();
            {
                do {

                    msg = msg + cur.getString(0) + "\n";
                } while (cur.moveToNext());
            }
        }
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        try {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
            mBuilder.setSmallIcon(R.drawable.logo);
            mBuilder.setContentTitle("Todays Tasks");
            mBuilder.setContentText(msg);
            mBuilder.setStyle(new NotificationCompat.BigTextStyle()
                    .bigText(msg));
            mBuilder.setPriority(NotificationCompat.PRIORITY_MAX);


            NotificationManager mNotifyMgr =
                    (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

            mNotifyMgr.notify(1, mBuilder.build());
        } catch (Exception e) {
            Toast.makeText(context, "Error: " + e, Toast.LENGTH_LONG).show();
        }
    }
}
