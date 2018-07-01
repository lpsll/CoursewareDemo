package com.example.administrator.coursewaredemo.activity.demo4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2018/6/11.
 */

public class Demo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_campaign,null);
        return view;
    }
}
