package com.example.administrator.coursewaredemo.viewpager;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.coursewaredemo.R;

public class MyPagerAdapter extends PagerAdapter {
	private ArrayList<View> views;
	private GuideActivity guideActivity;
	private static final String SHAREDPREFERENCES_NAME = "frist_pref";

	public MyPagerAdapter(ArrayList<View> views, GuideActivity guideActivity) {
		this.views = views;
		this.guideActivity = guideActivity;
	}

	//这里是返回页面的个数，如当返回0时，则无页面
	@Override
	public int getCount() {
		if(views!=null){
			Log.e("views.size()---",""+views.size());
			return views.size();
		}
		return 0;
	}
	//返回页面
	@Override
	public Object instantiateItem(ViewGroup arg0, int arg1) {
		Log.e("arg1---",""+arg1);
		arg0.addView(views.get(arg1));

		if(arg1 == views.size()-1){
			ImageView  five = (ImageView) arg0.findViewById(R.id.five);
			five.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					setGuide();
					goHome();
				}
			});
		}
		return views.get(arg1);
	}
	
	private void goHome() {
		Intent intent = new Intent(guideActivity,MiActivity.class);
		guideActivity.startActivity(intent);
		guideActivity.finish();
	}
	
	private void setGuide() {
		SharedPreferences sp = guideActivity.getSharedPreferences(SHAREDPREFERENCES_NAME,Context.MODE_PRIVATE);
		Editor et = sp.edit();
		et.putBoolean("frist_pref", false);
		et.commit();
	}
	
	@Override
	public void destroyItem(View arg0, int arg1, Object arg2) {
		((ViewPager) arg0).removeView(views.get(arg1));
	}

	//这里要返回true
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

}
