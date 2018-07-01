package com.example.administrator.coursewaredemo.activity.demo4;



import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.coursewaredemo.R;


public class FragmentOne extends Fragment implements OnClickListener {
	private Button btn1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub


		View view = inflater.inflate(R.layout.fragment_one, null);
		btn1 = (Button) view.findViewById(R.id.btn1);
		btn1.setOnClickListener(this);
		return view;
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		FragmentTwo fTwo = new FragmentTwo();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.fl, fTwo);
		ft.commit();
		
	}

}
