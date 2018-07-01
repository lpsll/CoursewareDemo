package com.example.administrator.coursewaredemo.kongjian;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/1.
 */

public class MultiAutoCompleteTextViewActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiautocomplete);
        //使用数组进行绑定
        String[] autoString = new String[]
                { "a", "android", "ajax", "android market", "android apk", "android 	  	 	     qq",
                        "ajava","ajaxcontroltoolkit", "android平台", "android手机操作系统", "手机软件" };
        //实例化适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, autoString);
        // MultiAutoCompleteTextView
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteTextView.setAdapter(adapter);


        //确定范围
        multiAutoCompleteTextView.setTokenizer(new 	MultiAutoCompleteTextView.CommaTokenizer());






    }
}
