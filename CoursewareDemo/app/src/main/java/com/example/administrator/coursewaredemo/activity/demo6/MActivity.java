package com.example.administrator.coursewaredemo.activity.demo6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.administrator.coursewaredemo.R;

import java.util.ArrayList;
import java.util.List;



public class MActivity extends FragmentActivity {

	ImageView mTvTabHome;
	ImageView mTvTabOrder;
	ImageView mTvTabCampaign;
	ImageView mTvTabMine;
	public static final String TAG ="tag";
	public static final int TAB_NUM = 4;
	private ImageView[] mTabViews = new ImageView[TAB_NUM];
	private FragmentManager fragmentManager;
	private List<Fragment> fragmentList = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_m);
		initView();
	}

	//首页的流程：
	//第一步,初始化，fragmentManager，四个ImageView的赋值
	//第二步，做判断，通过findFragmentByTag来判断fragment是否存在，如果存在走第三步，如果不存在，创建fragment
	//第三部，隐藏所有fragment，然后展示当前的fragment
	//第四步，其他处理，包括切换tab的背景颜色
	public void initView() {
		mTvTabHome = (ImageView) findViewById(R.id.tv_tab_home);
		mTvTabOrder = (ImageView) findViewById(R.id.tv_tab_order);
		mTvTabCampaign = (ImageView) findViewById(R.id.tv_tab_campaign);
		mTvTabMine = (ImageView) findViewById(R.id.tv_tab_mine);

		fragmentManager = getSupportFragmentManager();
		mTabViews[0] = mTvTabHome;
		mTabViews[1] = mTvTabOrder;
		mTabViews[2] = mTvTabCampaign;
		mTabViews[3] = mTvTabMine;

		for (int i = 0; i < mTabViews.length; i++) {
			Log.e(TAG,"for---fragmentList---"+fragmentList);
			fragmentList.add(null);
			final int j = i;
			mTabViews[i].setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					showTab(j);
				}
			});
		}
		showTab(0); // 显示目标tab
	}

	/**
	 * @param fragment 除了fragment，其他的都hide
	 */
	private void hideAllFragments(Fragment fragment) {
		Log.e(TAG,"hideAllFragments-fragment-"+fragment);
		for (int i = 0; i < TAB_NUM; i++) {
			Fragment f = fragmentManager.findFragmentByTag("tag" + i);
			Log.e(TAG,"hideAllFragments-f-"+f);
			if (f != null && f.isAdded() && f != fragment) {
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				//隐藏当前的Fragment，仅仅是设为不可见，并不会销毁
				transaction.hide(f);
				transaction.commitAllowingStateLoss();
				//当fragment被用户可见时，setUserVisibleHint()会调用且传入true值，当fragment不被用户可见时，setUserVisibleHint()则得到false值
				f.setUserVisibleHint(false);
			}
		}
	}

	private Fragment addFragment(int index) {
		//FragmentTransaction对fragment进行添加,移除,替换,以及执行其他动作。
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		Fragment fragment = null;
		switch (index) {
			case 0:
				fragment = new HomeFragment();
				break;
			case 1:
				fragment = new OrderFragment();
				break;
			case 2:
				fragment = new CampaignFragment();
				break;
			case 3:
				fragment = new MineFragment();
				break;

		}
		fragmentList.add(index, fragment);
		Log.e(TAG, "addFragment-fragmentList--" + fragmentList);
//		transaction.add(R.id.realtabcontent, fragment, "tag" + index);
		//提交事物
		transaction.commitAllowingStateLoss();
		return fragment;
	}

	private void showFragment(Fragment fragment) {
		Log.e(TAG,"showFragment-fragment---"+fragment);
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.show(fragment);
		transaction.commitAllowingStateLoss();
		fragment.setUserVisibleHint(true);
	}

	/**
	 * 切换tab
	 *
	 * @param idx
	 */
	private void showTab(int idx) {

		Fragment targetFragment = fragmentManager.findFragmentByTag("tag" + idx);
		Log.e(TAG,"showTab-targetFragment-"+targetFragment);
		//targetFragment.isAdded(),如果该Fragment对象被添加到了它的Activity中，那么它返回true，否则返回false。
		if (targetFragment == null || !targetFragment.isAdded()) {
			if (idx < fragmentList.size() && fragmentList.get(idx) != null) {
				targetFragment = fragmentList.get(idx);
				Log.e(TAG,"showTab-if-"+targetFragment);
			} else {
				targetFragment = addFragment(idx);
				Log.e(TAG,"showTab-else-"+targetFragment);
			}
		}
		hideAllFragments(targetFragment);
		showFragment(targetFragment);
		for (int i = 0; i < TAB_NUM; i++) {
			if (idx == i) {
				mTabViews[i].setBackgroundColor(getResources().getColor(R.color.navi_press));

			} else {
				mTabViews[i].setBackgroundColor(getResources().getColor(R.color.navi));

			}
		}

	}

}