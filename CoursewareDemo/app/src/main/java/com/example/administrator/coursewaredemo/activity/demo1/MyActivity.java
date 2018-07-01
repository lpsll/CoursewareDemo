package com.example.administrator.coursewaredemo.activity.demo1;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.administrator.coursewaredemo.R;

public class MyActivity extends Activity {
	private Button btn;

	//当 activity 第一次创建时会被调用。在这个方法中你需要完成所有的正常静态设置 ，
	//比如创建一个视图（ view ）、绑定列表的数据等等。
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		Log.e("tag", "MainActivity--->oncreate");
		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {


				Intent intent = new Intent(MyActivity.this, OtherActivity.class);
				startActivity(intent);
			}
		});

	}


	//当 activity 对于用户可见前即调用这个方法。
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("tag", "MainActivity--->onStart");

	}

	//在 activity 被停止后重新启动时会调用该方法。
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.e("tag", "MainActivity--->onRestart");
	}

	//在 activity 开始与用户交互前调用该方法。在这时该activity 处于 activity 栈的顶部，并且接受用户的输入。
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e("tag", "MainActivity--->onResume");
	}

	//在系统准备开始恢复其它 activity 时会调用该方法。
	//这个方法中通常用来提交一些还没保存的更改到持久数据 中，停止一些动画或其它一些耗 CPU 的操作等等。
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.e("tag", "MainActivity--->onPause");
	}

	//在 activity 对用户不可见时将调用该方法。
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.e("tag", "MainActivity--->onStop");
	}


	//在 activity 被销毁前会调用该方法。
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e("tag", "MainActivity--->onDestroy");
	}



}

