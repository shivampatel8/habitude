package com.habitude.admin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class customize extends AppCompatActivity {

    String days = "";
    String time = "";
    String s1 = "";
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        et1 = (EditText) findViewById(R.id.et1);
        final EditText et1 = (EditText) findViewById(R.id.et1);
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
        tp.setIs24HourView(true);
        yourBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = (et1.getText()).toString();
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
                time = h + ":" + m;

                helper.inRecords(s1, days, time);
                Toast.makeText(getApplicationContext(), time, Toast.LENGTH_SHORT).show();
            }
        });
        et1.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       et1.setText("");
                                   }
                               }
        );
    }
}

public class MainActivity extends AppCompatActivity {
    static final int TIME_DIALOG_ID = 1111;
    private TextView view;
    public Button btnClick;
    private int hr;
    private int min;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (TextView) findViewById(R.id.output);
        final Calendar c = Calendar.getInstance();
        hr = c.get(Calendar.HOUR_OF_DAY);
        min = c.get(Calendar.MINUTE);
        updateTime(hr, min);
        addButtonClickListener();
    }

    public void addButtonClickListener() {
        btnClick = (Button) findViewById(R.id.btnClick);
        btnClick.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                createdDialog(0).show();
            }
        });
    }

    protected Dialog createdDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, timePickerListener, hr, min, false);
        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
// TODO Auto-generated method stub
            hr = hourOfDay;
            min = minutes;
            updateTime(hr, min);
        }
    };

    private static String utilTime(int value) {
        if (value < 10) return "0" + String.valueOf(value);
        else return String.valueOf(value);
    }

    private void updateTime(int hours, int mins) {
        String timeSet = "";
        if (hours > 12) {
            hours -= 12;
            timeSet = "PM";
        } else if (hours == 0) {
            hours += 12;
            timeSet = "AM";
        } else if (hours == 12)
            timeSet = "PM";
        else
            timeSet = "AM";
        String minutes = "";
        if (mins < 10)
            minutes = "0" + mins;
        else
            minutes = String.valueOf(mins);
        String aTime = new StringBuilder().append(hours).append(':').append(minutes).append(" ").append(timeSet).toString();
        view.setText(aTime);
    }