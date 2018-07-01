package com.example.administrator.coursewaredemo.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/11.
 */

public class TestAdapter extends BaseAdapter{
    int[] pic;
    String[] s;
    LayoutInflater layoutInflater;
    public TestAdapter(Context context, int[] pic, String[] s) {
        this.pic = pic;
        this.s = s;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return pic.length;
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
        ImageView imageView;
        TextView textView;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView = layoutInflater.inflate(R.layout.tv_item,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.tv_item_iv);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_item_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setImageResource(pic[position]);
        viewHolder.textView.setText(s[position]);
        return convertView;
    }
}
