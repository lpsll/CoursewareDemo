package com.example.administrator.coursewaredemo.activity.demo3;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

public class ParcelableActivity extends Activity {
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parcelable);
		text = (TextView) findViewById(R.id.text);
		
	
		Police mPolice = (Police)getIntent().getParcelableExtra("keyp");     
		text.setText("Police name is: " + mPolice.getName()+"/n"+     
	                          "WorkTime is: " + mPolice.getWorkTime() + "/n");  
	
	
	}

}
