package com.example.administrator.coursewaredemo.activity.demo5;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/8.
 */

public class TestActivity extends Activity  implements TestLeftFragment.MyListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn);
        TestLeftFragment testLeftFragment = new TestLeftFragment();
        TestRightFragment testRightFragment = new TestRightFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.ll_left,testLeftFragment);
        ft.add(R.id.ll_right,testRightFragment);
        ft.commit();

    }


    @Override
    public void setMsg(int index) {
        TextView textView = (TextView) findViewById(R.id.right_msg_show);
        if(index==1){
            textView.setText("第一个按钮被点击！");
        }
        if(index==2){
            textView.setText("第二个按钮被点击！");
        }
        if(index==3){
            textView.setText("第三个按钮被点击！");
        }
    }
}
