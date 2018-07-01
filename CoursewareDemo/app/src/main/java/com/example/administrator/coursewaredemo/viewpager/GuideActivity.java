package com.example.administrator.coursewaredemo.viewpager;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.coursewaredemo.R;

public class GuideActivity extends Activity{
	private ViewPager vp;
	private ArrayList<View> views;
	private LayoutInflater inflate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);
		initView();
	}

	private void initView() {
		vp = (ViewPager) findViewById(R.id.vp);

		views = new ArrayList<View>();
		inflate = inflate.from(this);
		View view1 = inflate.inflate(R.layout.guide_one,null);
		View view2 = inflate.inflate(R.layout.guide_two,null);
		View view3 = inflate.inflate(R.layout.guide_three,null);
		View view4 = inflate.inflate(R.layout.guide_four,null);
		View view5 = inflate.inflate(R.layout.guide_five,null);
		views.add(view1);
		views.add(view2);
		views.add(view3);
		views.add(view4);
		views.add(view5);
		vp.setAdapter(new TestAdapter(this,views));







//		views = new ArrayList<View>();
//		inflate = LayoutInflater.from(this);
//		View view = inflate.inflate(R.layout.guide_one, null);
//		views.add(view);
//		views.add(inflate.inflate(R.layout.guide_two, null));
//		views.add(inflate.inflate(R.layout.guide_three, null));
//		views.add(inflate.inflate(R.layout.guide_four, null));
//		views.add(inflate.inflate(R.layout.guide_five, null));
//		Log.e("views---",""+views);
//		vp.setAdapter(new MyPagerAdapter(views,this));

	}

}
