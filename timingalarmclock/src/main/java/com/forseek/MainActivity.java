package com.forseek;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
    TimePicker timePicker;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = Calendar.getInstance();
        timePicker = (TimePicker) findViewById(R.id.timePicker1);
        timePicker.setIs24HourView(true);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlarmActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                c.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                c.set(Calendar.MINUTE,timePicker.getCurrentMinute());
                c.set(Calendar.SECOND,0);
                alarm.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
                Toast.makeText(MainActivity.this,"闹钟设置成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
