package com.example.administrator.coursewaredemo.activity.demo3;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

public class SerializableActivity extends Activity{
	
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_serializable);
		text = (TextView) findViewById(R.id.stext);
		Entity entity = (Entity) getIntent().getBundleExtra("entity").getSerializable("bundler");
		text.setText("名字："+entity.getName()+"\n"+"年纪："+entity.getAge());

	}

}
