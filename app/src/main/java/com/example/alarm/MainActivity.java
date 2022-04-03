package com.example.alarm;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, StateAdapter.OnClickToMore {

    Alarm alarm;
    Button but1;
    private RecyclerView recyclerViewAlarm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());

        Button but1 = findViewById(R.id.but1);
        but1.setOnClickListener(this);

        but1.setOnClickListener(v -> {
            MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .setHour(12)
                    .setMinute(0)
                    .setTitleText("Виберіть час для бидильника")
                    .build();



            materialTimePicker.addOnPositiveButtonClickListener(view -> {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.MINUTE, materialTimePicker.getMinute());
                calendar.set(Calendar.HOUR_OF_DAY, materialTimePicker.getHour());


                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(calendar.getTimeInMillis(), getAlarmInfoPendingIntent());

                alarmManager.setAlarmClock(alarmClockInfo, getAlarmActionPendingIntent());

            });

            materialTimePicker.show(getSupportFragmentManager(), "tag_picker");
        });

        List<Alarm> alarm = App.getInstance().getAppDatabase().modelDao().getAll("");
        Collections.reverse(alarm);
        StateAdapter stateAdapter = new StateAdapter(this, alarm);
        stateAdapter.setOnClickToMore(this);
        recyclerViewAlarm = findViewById(R.id.rv);
        recyclerViewAlarm.setAdapter(stateAdapter);
        recyclerViewAlarm.setLayoutManager(new GridLayoutManager(this, 1));

    }
    private PendingIntent getAlarmInfoPendingIntent() {
        Intent alarmInfoIntent = new Intent(this, MainActivity.class);
        alarmInfoIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return PendingIntent.getActivity(this, 0, alarmInfoIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private PendingIntent getAlarmActionPendingIntent() {
        Intent intent = new Intent(this, AlarmAct.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


        }
    }

    @Override
    public void onClick(Alarm notatka) {

    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
}
