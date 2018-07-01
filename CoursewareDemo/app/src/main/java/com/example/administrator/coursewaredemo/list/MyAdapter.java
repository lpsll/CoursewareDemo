package com.example.administrator.coursewaredemo.list;

import java.util.ArrayList;



import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

public class MyAdapter extends BaseAdapter {

	private ArrayList<String> items;
	private Context context;

	public MyAdapter(Context context, ArrayList<String> items) {
		this.context = context;
		this.items = items;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	class ViewHolder {
		private TextView tv;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.list_item, null);
			viewHolder.tv = (TextView) convertView.findViewById(R.id.tv);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		viewHolder.tv.setText(items.get(position));
		return convertView;
	}

	public void addCount(String s){
		items.add(s);
	}

	

	public void additem(String item) {
		items.add(item);
	}
}
