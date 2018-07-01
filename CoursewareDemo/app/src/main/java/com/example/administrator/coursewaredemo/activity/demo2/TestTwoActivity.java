package com.example.administrator.coursewaredemo.activity.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/7.
 */

public class TestTwoActivity extends AppCompatActivity {
    private EditText s_et1;
    private TextView s_tv1;
    private Button s_btn1;
    public static final int RECODE = 1001;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        s_et1 = (EditText) findViewById(R.id.s_et1);
        s_tv1 = (TextView) findViewById(R.id.s_tv1);
        s_btn1 = (Button) findViewById(R.id.s_btn1);
        s_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = s_et1.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("result",s);
                setResult(11,intent);
                finish();



            }
        });

        Intent intent= getIntent();
        if(null!=intent){
            String s = intent.getStringExtra("msg");
            s_tv1.setText(s);
        }


    }

}
