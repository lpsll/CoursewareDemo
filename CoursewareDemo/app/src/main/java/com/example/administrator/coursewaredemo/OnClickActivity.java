package com.example.administrator.coursewaredemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lenovo on 2017/9/4.
 */

public class OnClickActivity extends Activity implements View.OnClickListener {
    private TextView mTextView;
    private Button mButton1,mButton2,mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick);
        mTextView = (TextView) findViewById(R.id.textView);
        mButton1 = (Button) findViewById(R.id.btn1);
        mButton2 = (Button) findViewById(R.id.btn2);
        mButton3 = (Button) findViewById(R.id.btn3);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
    }



    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.btn1:
                mTextView.setText("btn1被点击了！");

                break;
            case R.id.btn2:
                mTextView.setText("btn2被点击了！");

                break;

            case R.id.btn3:
                mTextView.setText("btn3被点击了！");

                break;

            default:
                break;
        }

    }




}
