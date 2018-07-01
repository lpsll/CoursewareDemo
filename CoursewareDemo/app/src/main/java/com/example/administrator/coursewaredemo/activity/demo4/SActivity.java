package com.example.administrator.coursewaredemo.activity.demo4;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.coursewaredemo.R;

public class SActivity extends Activity{
	private static String TAG = "FActivity";
	private static Button mybtnButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_s);
		Log.i(TAG, "onCreate is call.......");
	}



	/**
	 * 在可见生存期开始时调用
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart()
	{
		Log.i(TAG, "onStart is call start.......");
		super.onStart();
		/**
		 * 既然Activity可见，就应用任何要求的UI变化
		 */
		Log.i(TAG, "onStart is call end.......");
	}

	/**
	 * 在Activity活动状态生存期开始时调用
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume()
	{
		Log.i(TAG, "onResume is call start.......");
		super.onResume();
		/**
		 * 恢复Activity处于不活动状态时被挂起的，暂停的UI更新，线程，进程
		 */
		Log.i(TAG, "onResume is call end.......");
	}


	/**
	 * 在Activity活动状态生存期结束时被调用
	 */
	@Override
	protected void onPause()
	{
		Log.i(TAG, "onPause is call start.......");
		/**
		 * 挂起UI更新，线程或者CPU密集的进程
		 */
		super.onPause();
		Log.i(TAG, "onPause is call end.......");
	}

	@Override
	protected void onStop()
	{
		Log.i(TAG, "onStop is call start.......");
		/**
		 * 挂起UI更新，线程或者处理
		 * 当Activity不可见时，保存所有的编辑或者状态改变
		 * 调用这个方法后，进程可能会被终止
		 */
		super.onStop();

		Log.i(TAG, "onStop is callv end.......");
	}

	@Override
	protected void onDestroy()
	{
		Log.i(TAG, "onDestroy is call start.......");
		/**
		 * 清理所有的资源，包括结束线程，关闭数据库连接等
		 */
		super.onDestroy();

		Log.i(TAG, "onDestroy is call end.......");
	}

	@Override
	protected void onRestart()
	{
		Log.i(TAG, "onRestart is call start.......");
		super.onRestart();
		/**
		 * 加装载改变，知道Activity在此进程中已经可见
		 */
		Log.i(TAG, "onRestart is call end.......");
	}

}
