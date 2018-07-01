package com.example.administrator.coursewaredemo.activity.demo2;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.coursewaredemo.R;


public class FristActivity extends Activity implements OnClickListener {
	private EditText et1, et2, et3, et_1, et_2, et_3;
	private Button btn1, btn_1;

	// private int RESULT_CODE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frist);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et3 = (EditText) findViewById(R.id.et3);
		btn1 = (Button) findViewById(R.id.btn1);
		et_1 = (EditText) findViewById(R.id.et_1);
		et_2 = (EditText) findViewById(R.id.et_2);
		et_3 = (EditText) findViewById(R.id.et_3);
		btn_1 = (Button) findViewById(R.id.btn_1);

		btn1.setOnClickListener(this);
		btn_1.setOnClickListener(this);

	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn1:
			Intent intent = new Intent(FristActivity.this, SecondActivity.class);
//			FristActivity.this.startActivity(intent);
			
			String str1 =et1.getText().toString().trim();
			String str2 =et2.getText().toString().trim();
			String string = str1+"+"+str2+"=?";
			intent.putExtra("msg", string);
			intent.putExtra("num", 1);
			FristActivity.this.startActivity(intent);

			
//			FristActivity.this.startActivityForResult(intent, 1000);
			break;
		case R.id.btn_1:

			Intent intent1 = new Intent(FristActivity.this, SecondActivity.class);
			intent1.putExtra("msg", et_1.getText().toString().trim() + "+"
					+ et_2.getText().toString().trim() + "=?");


			FristActivity.this.startActivityForResult(intent1, 1001);
			break;

		default:
			break;
		}

	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1000 && resultCode == 1000) {
			String requestValue = data.getStringExtra("result");
			et3.setText(requestValue);
		}
		if (requestCode == 1001 && resultCode == 1002) {
			String request_value = data.getStringExtra("result");
			et_3.setText(request_value);
		}

	}
}
