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
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;


public class FragmentThree extends Fragment implements OnClickListener {
	private Button btn3;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_three, null);
		btn3 = (Button) view.findViewById(R.id.btn3);
		btn3.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "am a btn3 in fragmentthree",
				Toast.LENGTH_SHORT).show();
	}

}
