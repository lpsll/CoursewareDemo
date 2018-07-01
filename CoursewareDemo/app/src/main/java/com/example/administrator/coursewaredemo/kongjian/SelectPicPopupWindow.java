package com.example.administrator.coursewaredemo.kongjian;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

public class SelectPicPopupWindow extends Activity implements OnClickListener{
	private Button btn1,btn2,btn3;
	private LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.window);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		
		layout = (LinearLayout) findViewById(R.id.layout);
		
		
		
		
		
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			
			break;
        case R.id.layout:
	        Toast.makeText(getApplicationContext(), "提示：点击窗口外部关闭窗口!", Toast.LENGTH_LONG).show();
			
			break;

		default:
			break;
		}
	}

}
