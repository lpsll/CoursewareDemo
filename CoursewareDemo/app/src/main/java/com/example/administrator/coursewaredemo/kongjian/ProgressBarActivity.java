package com.example.administrator.coursewaredemo.kongjian;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

public class ProgressBarActivity extends AppCompatActivity{
    ProgressBar progressBar;
    int max =100;
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        num =0;
        progressBar = (ProgressBar) findViewById(R.id.pb);
        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num<max){
                    num+= 20;
                    progressBar.setProgress(num);
                }else {
                    Toast.makeText(ProgressBarActivity.this,"加载完成，重新加载！",Toast.LENGTH_SHORT).show();
                    num=0;
                    progressBar.setProgress(num);
                }



            }
        });
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ProgressDialog的第一种，以一个滚动的环状图标
                // 第一种方法，使用ProgressDialog构造函数
				ProgressDialog dialog = new ProgressDialog(ProgressBarActivity.this);
				dialog.setTitle("等待");
				dialog.setMessage("加载中.......");
				dialog.setIcon(R.drawable.ic_launcher);
				dialog.show();
            }
        });
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 第二种方法，使用ProgressDialog构造函数
                final ProgressDialog dialog = ProgressDialog.show(ProgressBarActivity.this, "等待", "加载中.....");
                dialog.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        finally{
                            dialog.dismiss();
                        }
                    }
                }).start();








            }
        });


    }
}
