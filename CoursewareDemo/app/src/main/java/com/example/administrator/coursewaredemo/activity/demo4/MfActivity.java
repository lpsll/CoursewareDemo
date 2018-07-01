package com.example.administrator.coursewaredemo.activity.demo4;



import android.app.FragmentManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;

import android.app.FragmentTransaction;
import android.view.Window;

import com.example.administrator.coursewaredemo.R;

public class MfActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mf);
		
		
		FragmentOne fOne = new FragmentOne();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(R.id.fl, fOne);
		ft.commit();
	}

}
