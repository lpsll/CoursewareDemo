package com.example.administrator.coursewaredemo.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.administrator.coursewaredemo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TimePickerActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener {
    private TextView textView;
    private DatePicker datePicker;
    private TimePicker timePicker;
    SimpleDateFormat sdf;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        //日历对象
        calendar = Calendar.getInstance();
        datePicker = (DatePicker) findViewById(R.id.datepicker);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), this);

        timePicker = (TimePicker) findViewById(R.id.timepicker);
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                textView.setText("时："+hourOfDay+"分："+minute);
            }
        });



        textView = (TextView) findViewById(R.id.textview);

        sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm");

        textView.setText(sdf.format(calendar.getTime()));
//        textView.setText("当前时间："+calendar.getTime());

    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        textView.setText("年："+year+"月："+(monthOfYear+1)+"日："+dayOfMonth);
    }

}
