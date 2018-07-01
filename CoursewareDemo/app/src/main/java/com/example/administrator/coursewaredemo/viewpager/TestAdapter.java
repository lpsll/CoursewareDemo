package com.example.administrator.coursewaredemo.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.coursewaredemo.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/12.
 */

public class TestAdapter extends PagerAdapter {
    ArrayList<View> arrayList;
    public TestAdapter(GuideActivity guideActivity, ArrayList<View> views) {
        this.arrayList =views;
    }

    @Override
    public int getCount() {
        if(arrayList!=null){
            return arrayList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(arrayList.get(position));
        if(position==(arrayList.size()-1)){
            ImageView imageView = (ImageView) container.findViewById(R.id.five);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        return arrayList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(arrayList.get(position));
        super.destroyItem(container, position, object);
    }
}
