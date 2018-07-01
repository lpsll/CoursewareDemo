package com.example.administrator.coursewaredemo.activity.demo5;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/8.
 */

public class TestRightFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_right,null);
        return view;
    }

}
