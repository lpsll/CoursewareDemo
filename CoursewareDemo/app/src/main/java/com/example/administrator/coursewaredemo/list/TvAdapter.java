package com.example.administrator.coursewaredemo.list;

import java.util.ArrayList;


import android.content.Context;
import android.provider.ContactsContract.Data;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

public class TvAdapter extends BaseAdapter{
	String[] str1,str2,str3,str4,str5;
	LayoutInflater inflater;

	public TvAdapter(Context context, String[] str1, String[] str2, String[] str3, String[] str4, String[] str5) {
		this.str1 = str1;
		this.str2 = str2;
		this.str3 = str3;
		this.str4 = str4;
		this.str5 = str5;
		inflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		return str1.length;
	}

	@Override
	public Object getItem(int position) {
		return getItem(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	class ViewHolder{
		TextView textView1,textView2,textView3,textView4,textView5;

	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if(convertView==null){
			viewHolder = new ViewHolder();
			convertView  = inflater.inflate(R.layout.item_webo,null);
			viewHolder.textView1 = (TextView) convertView.findViewById(R.id.title);
			viewHolder.textView2 = (TextView) convertView.findViewById(R.id.tv);
			viewHolder.textView3 = (TextView) convertView.findViewById(R.id.text1);
			viewHolder.textView4 = (TextView) convertView.findViewById(R.id.text2);
			viewHolder.textView5 = (TextView) convertView.findViewById(R.id.text3);
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.textView1.setText(str1[position]);
		viewHolder.textView2.setText(str2[position]);
		viewHolder.textView3.setText(str3[position]);
		viewHolder.textView4.setText(str4[position]);
		viewHolder.textView5.setText(str5[position]);

		return convertView;
	}
}
