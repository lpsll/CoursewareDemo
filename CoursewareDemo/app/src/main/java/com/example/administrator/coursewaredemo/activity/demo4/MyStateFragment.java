package com.example.administrator.coursewaredemo.activity.demo4;



import android.annotation.SuppressLint;
import android.app.Activity;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.coursewaredemo.R;


public class MyStateFragment extends Fragment {
	private static String TAG = "chenjianjun";
	/**
	 * 调用该方法时，Fragment会被连接到它的父Activity上
	 */
	@Override
	public void onAttach(Activity activity)
	{
		Log.i(TAG, "-----onAttach is call start.......");
		super.onAttach(activity);
		/**
		 * 获取对父Activity的引用
		 */
		Log.i(TAG, "-----onAttach is call end.......");
	}

	/**
	 * 调用该方法来进行Fragment的初始创建
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Log.i(TAG, "-----onCreate is call start.......");
		super.onCreate(savedInstanceState);
		/**
		 * 初期化Fragment
		 */
		Log.i(TAG, "-----onCreate is call end.......");
	}

	/**
	 * 一旦Fragment已被创建，要创建它自己的用户界面时调用该方法
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		Log.i(TAG, "-----onCreateView is call start.......");
		/**
		 * 创建，或者填充Fragment的UI，并返回它
		 * 如果这个Fragment没有UI，那么返回null
		 */
		View view = inflater.inflate(R.layout.my_state_fragment, null);

		Log.i(TAG, "-----onCreateView is call end.......");
		return view;
	}

	/**
	 * 一旦父Activity和Fragment的UI已经被创建，则调用该方法
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		Log.i(TAG, "-----onActivityCreated is call start.......");
		super.onActivityCreated(savedInstanceState);
		/**
		 * 完成Fragment的初期化----那些父Activity和Fragment的View被完全填充后才能做的事情
		 */
		Log.i(TAG, "-----onActivityCreated is call end.......");
	}

	/**
	 * 在可见生命周期的开始时被调用
	 */
	@Override
	public void onStart()
	{
		Log.i(TAG, "-----onStart is call start.......");
		super.onStart();
		/**
		 * 应用所有需要的UI变化，现在Fragment是可见的
		 */
		Log.i(TAG, "-----onStart is call end.......");
	}

	/**
	 * 在活动生命周期开始时被调用
	 */
	@Override
	public void onResume()
	{
		Log.i(TAG, "-----onResume is call start.......");
		super.onResume();
		/**
		 * 恢复所有暂停的事物，如UI更新，线程或者进程等
		 */
		Log.i(TAG, "-----onResume is call end.......");
	}

	/**
	 * 在活动生命周期结束时被调用
	 */
	@Override
	public void onPause()
	{
		Log.i(TAG, "-----onPause is call start.......");
		/**
		 * 需要暂停父Activity不是活动的前台Activity时，需要暂停的事物，如UI更新，线程或者进程等
		 */
		super.onPause();
		Log.i(TAG, "-----onPause is call end.......");
	}



	/**
	 * 在可见生命周期结束时调用该方法
	 */
	@Override
	public void onStop()
	{
		Log.i(TAG, "-----onStop is call start.......");
		/**
		 * 当Fragment不可见时，暂停其余的事物，如UI更新，线程或者进程等
		 */
		super.onStop();
		Log.i(TAG, "-----onStop is call end.......");
	}

	/**
	 * 当Fragment的view被分离时，调用该方法
	 */
	@Override
	public void onDestroyView()
	{
		Log.i(TAG, "-----onDestroyView is call start.......");
		/**
		 * 清除资源相关的view
		 */
		super.onDestroyView();
		Log.i(TAG, "-----onDestroyView is call end.......");
	}

	/**
	 * 在整个生命周期结束的时候调用
	 */
	@Override
	public void onDestroy()
	{
		Log.i(TAG, "-----onDestroy is call start.......");
		/**
		 * 清除所有的资源，包括线程和关闭数据库连接等
		 */
		super.onDestroy();
		Log.i(TAG, "-----onDestroy is call end.......");
	}

	/**
	 * 当Fragment从它的父Activity上分离时调用
	 */
	@Override
	public void onDetach()
	{
		Log.i(TAG, "-----onDetach is call start.......");
		super.onDetach();
		Log.i(TAG, "-----onDetach is call end.......");
	}

}
