package com.example.administrator.coursewaredemo.list;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/9/5.
 */

public class ListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private int itemClicker;


    private Context context;
    private ArrayList<String> aList;
//	private String[] str;


    private ArrayList<HashMap<String, Object>> getDate(){
        ArrayList<HashMap<String, Object>> aList = new ArrayList<HashMap<String,Object>>();
        for(int i =0;i<10;i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("title", "这是第"+i+"行");
            map.put("text", "排名第"+i);
            aList.add(map);

        }
        return aList;

    }


	public ListAdapter(Context context, ArrayList<String> aList) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.aList = aList;
//		this.str = str;
	}

    public ListAdapter(Context context) {
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return getDate().size();
//		return aList.size();
//		return str.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return aList.get(position);
//		return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    class Holder{
        private TextView text_name,text_age;

    }
    @Override
    public View getView(int position, View view, ViewGroup arg2) {
        // TODO Auto-generated method stub
        Holder holder;
        if(view == null){
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(R.layout.item_list, null);
            holder.text_name = (TextView) view.findViewById(R.id.text_name);
            holder.text_age = (TextView) view.findViewById(R.id.text_age);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        holder.text_name.setText(getDate().get(position).get("title").toString());
        holder.text_age.setText(getDate().get(position).get("text").toString());

//		holder.text_name.setText(aList.get(position));
//		holder.text_name.setText(aList.get(index));
//		holder.text_age.setText(str[position]);

        if(position == itemClicker){
            view.setBackgroundColor(Color.BLUE);
        }else {
            view.setBackgroundColor(Color.RED);
        }



        return view;
    }

    public void addItem(String item) {
        // TODO Auto-generated method stub
        aList.add(item);
    }


    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        // TODO Auto-generated method stub
        itemClicker = position;
        this.notifyDataSetChanged();
    }
}
