package com.example.administrator.coursewaredemo.activity.demo5;



import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

public class MnActivity extends Activity implements FragmentLeft.MyListener {
	private TextView right_msg_show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mn);

		FragmentLeft fLeft = new FragmentLeft();
		FragmentRight fRight = new FragmentRight();
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.add(R.id.ll_left, fLeft);
		ft.add(R.id.ll_right, fRight);
		ft.commit();


	}


	@Override
	public void showMessage(int index) {
		right_msg_show = (TextView) findViewById(R.id.right_msg_show);
		if (index == 1) {
			right_msg_show.setText("frist");
		}
		if (index == 2) {
			right_msg_show.setText("second");
		}
		if (index == 3) {
			right_msg_show.setText("third");
		}

	}

}
