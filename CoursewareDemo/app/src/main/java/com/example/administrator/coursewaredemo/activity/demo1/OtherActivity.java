package com.example.administrator.coursewaredemo.activity.demo1;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.coursewaredemo.R;

public class OtherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		Log.e("tag", "OtherActivity--->oncreate");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.e("tag", "OtherActivity--->onStart");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.e("tag", "OtherActivity--->onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e("tag", "OtherActivity--->onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.e("tag", "OtherActivity--->onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e("tag", "OtherActivity--->onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e("tag", "OtherActivity--->onDestroy");
	}
}
