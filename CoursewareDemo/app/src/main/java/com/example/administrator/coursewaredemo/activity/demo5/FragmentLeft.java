package com.example.administrator.coursewaredemo.activity.demo5;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import com.example.administrator.coursewaredemo.R;


public class FragmentLeft extends Fragment {

	/** Acitivity要实现这个接口，这样Fragment和Activity就可以共享事件触发的资源了 */
	public interface MyListener {
		public void showMessage(int index);

	}

	private MyListener myListener;


	/** Fragment第一次附属于Activity时调用,在onCreate之前调用 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		myListener = (MyListener) activity;
		Log.e("myListener---",""+myListener);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		System.out.println("fragmentleft--->oncreateview");
		View view = inflater.inflate(R.layout.fragment_left, null);
		return view;
	}

	private Button btn1, btn2, btn3;
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("fragmentleft--->onresume");
		btn1 = (Button) getActivity().findViewById(R.id.btn1);
		btn2 = (Button) getActivity().findViewById(R.id.btn2);
		btn3 = (Button) getActivity().findViewById(R.id.btn3);
		MyButtonClickListener clickListener = new MyButtonClickListener();
		btn1.setOnClickListener(clickListener);
		btn2.setOnClickListener(clickListener);
		btn3.setOnClickListener(clickListener);

	}

	class MyButtonClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.btn1:
					myListener.showMessage(1);
					break;
				case R.id.btn2:
					myListener.showMessage(2);
					break;
				case R.id.btn3:
					myListener.showMessage(3);
					break;

				default:
					break;
			}

		}

	}

}
