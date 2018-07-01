package com.example.administrator.coursewaredemo.kongjian;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2017/9/6.
 */

public class TestActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener{
    DatePicker datePicker;
    TimePicker timePicker;
    TextView textView;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        datePicker = (DatePicker) findViewById(R.id.datepicker);
        timePicker = (TimePicker) findViewById(R.id.timepicker);
        textView = (TextView) findViewById(R.id.textview);

        calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),this);

        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                textView.setText("时："+hourOfDay+"分："+minute);
            }
        });

        simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm");

        textView.setText("当前时间："+simpleDateFormat.format(calendar.getTime()));

    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        textView.setText("年："+year+"月："+(monthOfYear+1)+"日："+dayOfMonth);
    }
}
