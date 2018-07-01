package com.example.administrator.coursewaredemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/5.
 */

public class TestNewActivity extends AppCompatActivity {
    EditText mEditText1,mEditText2,mEditText3,mEditText4;
    Button mButton;
    TextView mTextView1,mTextView2,mTextView3,mTextView4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        mEditText1 = (EditText) findViewById(R.id.et1);
        mEditText2 = (EditText) findViewById(R.id.et2);
        mEditText3 = (EditText) findViewById(R.id.et3);
        mEditText4 = (EditText) findViewById(R.id.et4);
        mButton = (Button) findViewById(R.id.btn);
        mTextView1 = (TextView) findViewById(R.id.textView1);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mTextView4 = (TextView) findViewById(R.id.textView4);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = mEditText1.getText().toString().trim();
                String str2 = mEditText2.getText().toString().trim();
                String str3 = mEditText3.getText().toString().trim();
                String str4 = mEditText4.getText().toString().trim();
                if(str1.length()>0){
                    mTextView1.setText(str1);
                }else {
                    Toast.makeText(TestNewActivity.this,"账号不能为空，请输入账号！",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(str2.length()>0){
                    mTextView2.setText(str2);
                }else {
                    Toast.makeText(TestNewActivity.this,"密码不能为空，请输入密码！",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(str3.length()>0){
                    mTextView3.setText(str3);
                }else {
                    Toast.makeText(TestNewActivity.this,"年龄不能为空，请输入年龄！",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(str4.length()>0){
                    mTextView4.setText(str4);
                }else {
                    Toast.makeText(TestNewActivity.this,"年龄不能为空，请输入年龄！",Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
    }
}
