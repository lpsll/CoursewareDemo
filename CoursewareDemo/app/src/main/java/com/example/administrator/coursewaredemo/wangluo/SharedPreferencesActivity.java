package com.example.administrator.coursewaredemo.wangluo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/5.
 */

public class SharedPreferencesActivity extends Activity implements View.OnClickListener {
    private Button btn1,btn2;
    private TextView text;
    private EditText edit1,edit2;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        text = (TextView) findViewById(R.id.text);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        sp = getSharedPreferences("lp", Context.MODE_PRIVATE);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn1:
                String name = edit1.getText().toString();
                int age = Integer.parseInt(edit2.getText().toString());
                SharedPreferences.Editor et = sp.edit();
                et.putInt("age", age);
                et.putString("name", name);
                et.commit();
                Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_LONG).show();

                break;
            case R.id.btn2:
                String strValue  = sp.getString("name", "");
                int ageValue = sp.getInt("age",1 );
                text.setText("姓名："+strValue+",年龄："+ageValue);
                break;

            default:
                break;
        }
    }
}
