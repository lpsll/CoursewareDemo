package com.example.administrator.coursewaredemo.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

//这是单选按钮的例子
public class RadioButtonActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb1,rb2,rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        rg = (RadioGroup) findViewById(R.id.rg);
        //获取3个单选按钮
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);


        //设置事件监听
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.e("checkedId--",""+checkedId);
                if(checkedId == rb2.getId()){
                    Toast.makeText(RadioButtonActivity.this,"恭喜您，回答正确！答案是：" + rb2.getText(),Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(RadioButtonActivity.this,"您回答错误！请选择其他选项",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
