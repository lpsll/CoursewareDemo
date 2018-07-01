package com.example.administrator.coursewaredemo.kongjian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/1.
 */

public class AutoCompleteTextActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        //使用数组进行绑定
        String[] autoString = new String[]
                { "a", "android", "ajax", "android market", "android apk", "android 	  	 	     qq",
                        "ajava","ajaxcontroltoolkit", "android平台", "android手机操作系统", "手机软件" };


        //实例化适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, autoString);

        //设置适配器
        autoCompleteTextView.setAdapter(adapter);


    }




}
