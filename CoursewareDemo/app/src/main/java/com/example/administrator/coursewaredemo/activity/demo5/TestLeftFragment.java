package com.example.administrator.coursewaredemo.activity.demo5;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/8.
 */

public class TestLeftFragment extends Fragment implements View.OnClickListener{
    Button button1,button2,button3;


    public interface MyListener{
        public void setMsg(int index);
    }


    MyListener myListener;
    @Override
    public void onAttach(Activity activity) {
        myListener = (MyListener) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_left,null);
        button1 = (Button) view.findViewById(R.id.btn1);
        button2 = (Button) view.findViewById(R.id.btn2);
        button3 = (Button) view.findViewById(R.id.btn3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                myListener.setMsg(1);
                break;
            case R.id.btn2:
                myListener.setMsg(2);
                break;
            case R.id.btn3:
                myListener.setMsg(3);
                break;
        }
    }
}
