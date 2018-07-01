package com.example.administrator.coursewaredemo.list;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

public class MyGridAdapter extends BaseAdapter{

	private Context context;
	ArrayList<GridViewEntity> list;
	String[] title;
	int[] images;

	public MyGridAdapter(Context context, ArrayList<GridViewEntity> list) {
		this.list = list;
		this.context = context;
	}

//	public MyGridAdapter(Context context, String[] title, int[] images) {
//
//		this.context = context;
//	}


	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return getItem(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	class Holder{
		private ImageView images;
		private TextView text;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		Holder holder;
		if(convertView == null){
			holder = new Holder();
			convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
			holder.images = (ImageView) convertView.findViewById(R.id.img);
			holder.text = (TextView) convertView.findViewById(R.id.text);
			convertView.setTag(holder);
		}else {
			holder = (Holder) convertView.getTag();
		}
		holder.images.setImageResource(list.get(position).getPic());
		holder.text.setText(list.get(position).getTitle());

		return convertView;
	}

}
