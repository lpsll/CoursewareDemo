package com.example.administrator.coursewaredemo.viewpager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/12.
 */

public class TestOneActivity extends AppCompatActivity {
    private static final String NAME="TAG";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        SharedPreferences sp = getSharedPreferences(NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit() ;
        editor.putBoolean("frist_pref",false);
        editor.commit();
        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TestOneActivity.this,TestTwoActivity.class);
                startActivity(intent);
                TestOneActivity.this.finish();
            }
        });
    }
}
