package com.example.administrator.coursewaredemo.activity.demo2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

public class SecondActivity extends Activity {
	private EditText s_et1;
	private TextView s_tv1;
	private Button s_btn1;

	// static int RESULT_CODE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		s_et1 = (EditText) findViewById(R.id.s_et1);
		s_tv1 = (TextView) findViewById(R.id.s_tv1);
		s_btn1 = (Button) findViewById(R.id.s_btn1);

		Intent intent = getIntent();
		if(intent!=null){
			String msg = intent.getStringExtra("msg");
			int num = intent.getExtras().getInt("num");
			s_tv1.setText(msg);
		}

		
		s_btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String result = s_et1.getText().toString().trim();

				Intent intent = new Intent();
				intent.putExtra("result", result);


				setResult(1002, intent);

				finish();
			}
		});

	}

}
