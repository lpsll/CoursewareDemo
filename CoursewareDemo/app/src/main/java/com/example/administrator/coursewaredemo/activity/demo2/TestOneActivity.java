package com.example.administrator.coursewaredemo.activity.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/7.
 */

public class TestOneActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et1, et2, et3, et_1, et_2, et_3;
    private Button btn1, btn_1;
    Intent intent;
    private static final int REQUSTCODE = 1000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et_1 = (EditText) findViewById(R.id.et_1);
        et_2 = (EditText) findViewById(R.id.et_2);
        et_3 = (EditText) findViewById(R.id.et_3);
        btn1 = (Button) findViewById(R.id.btn1);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);
        btn_1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Intent intent = new Intent(TestOneActivity.this,TestTwoActivity.class);
                String s = et1.getText().toString().trim()+"+"+et2.getText().toString().trim()+"=?";
                intent.putExtra("msg",s);
                startActivity(intent);
                break;
            case R.id.btn_1:
                Intent intent1 = new Intent(TestOneActivity.this,TestTwoActivity.class);
                String s1 = et1.getText().toString().trim()+"+"+et2.getText().toString().trim()+"=?";
                intent1.putExtra("msg",s1);
                startActivityForResult(intent1,10);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10&&resultCode==11){
            String s = data.getStringExtra("result");
            et_3.setText(s);
        }
    }
}
