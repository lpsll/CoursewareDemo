package com.example.administrator.coursewaredemo.viewpager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.administrator.coursewaredemo.R;
/*
  第一个页面： 启动页面，也可以称为广告页面
 */
public class SplashActivity extends Activity{
	Boolean isFristIn = false;
	private static final String SHAREDPREFERENCES_NAME = "frist_pref";
	SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		initView();
		
	}

//	Handler mHandler = new Handler(){
//		@Override
//		public void handleMessage(Message msg) {
//			super.handleMessage(msg);
//			switch (msg.what){
//				case 0:
//					Intent intent = new Intent(SplashActivity.this,TestOneActivity.class);
//					startActivity(intent);
//					SplashActivity.this.finish();
//					break;
//				case 1:
//					Intent intent1 = new Intent(SplashActivity.this,TestTwoActivity.class);
//					startActivity(intent1);
//					SplashActivity.this.finish();
//					break;
//			}
//		}
//	};
//
//	private static final String NAME="TAG";
//	private void initView() {
//		SharedPreferences sp = getSharedPreferences(NAME,MODE_PRIVATE);
//		boolean tag = sp.getBoolean("frist_pref",true);
//		if(tag){
////			Message msg = mHandler.obtainMessage();
////			msg.what = 0;
//			mHandler.sendEmptyMessageDelayed(0,3000);
//		}else {
//			mHandler.sendEmptyMessageDelayed(1,3000);
//		}
//	}










	private Handler mHand = new Handler(){
		public void handleMessage(Message msg) {
			Log.e("msg.what---",""+msg.what);
			switch (msg.what) {
			case 0:
				goHome();
				break;
			case 1:
				goGuide();
				break;

			default:
				break;
			}
		}

		private void goGuide() {
			Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
			startActivity(intent);
			SplashActivity.this.finish();

		}

		private void goHome() {
			Intent intent = new Intent(SplashActivity.this,MiActivity.class);
			startActivity(intent);
			SplashActivity.this.finish();

		};

	};

	private void initView() {
		sp = getSharedPreferences(SHAREDPREFERENCES_NAME, MODE_PRIVATE);
//		initShare();
		isFristIn = sp.getBoolean("frist_pref", true);
		Log.e("isFristIn---",""+isFristIn);
		if(!isFristIn){
			Log.e("if---","0");
			mHand.sendEmptyMessageDelayed(0, 5000);
		}else {
			Log.e("else---","1");
			mHand.sendEmptyMessageDelayed(1, 5000);
		}

	}

	private void initShare() {
		SharedPreferences.Editor et = sp.edit();
		et.putBoolean("frist_pref", true);
		et.commit();
	}

}
