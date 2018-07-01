package com.example.administrator.coursewaredemo.kongjian;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/6.
 */

public class TestOneActivtiy extends AppCompatActivity {
    ProgressBar progressBar;
    int num;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        num =0;
        progressBar = (ProgressBar) findViewById(R.id.pb);
        Button btn1 = (Button) findViewById(R.id.btn3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num<100){
                    progressBar.setVisibility(View.VISIBLE);
                    num+=20;
                    progressBar.setProgress(num);
                }else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(TestOneActivtiy.this,"加载完成！",Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog = new ProgressDialog(TestOneActivtiy.this);
                dialog.setTitle("进度！");
                dialog.setIcon(R.drawable.ic_launcher);
                dialog.setMessage("加载");
                dialog.show();
            }
        });
    }
}
