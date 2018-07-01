package com.example.administrator.coursewaredemo.list;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/5.
 */

public class ListActivity  extends Activity implements AbsListView.OnScrollListener, View.OnClickListener {
    private ListAdapter mAdapter;
    private View LoadMoreButton;
    private Button btn;
    private ListView list;
    private int visibleItemCount;//  当前窗口可见项总数
    private int visibleLastIndex = 0;//  最后的可见项索引
    private String[] str = new String[]{"中国","动国","人国","天国","个国","想国","去国","是国","我国","好国","在国","票国"};

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        LoadMoreButton = getLayoutInflater().inflate(R.layout.load_more, null);
        btn = (Button) LoadMoreButton.findViewById(R.id.btn);
        btn.setOnClickListener(this);
        btn.setText("loadmore......");

        list = (ListView) findViewById(R.id.list);
        list.addFooterView(LoadMoreButton);
        list.setOnScrollListener(this);
//        ArrayList<String> aList = new ArrayList<String>();
//        for(int i = 0;i<10;i++){
//        	aList.add(String.valueOf(i + 1));
//		}
//        mAdapter = new ListAdapter(this,aList);

        mAdapter = new ListAdapter(this);
        list.setAdapter(mAdapter);
        setListViewHeightBasedOnChildren(list);

    }

    private void setListViewHeightBasedOnChildren(ListView list) {
        // TODO Auto-generated method stub
        // 获取ListView对应的Adapter
        android.widget.ListAdapter listAdapter = list.getAdapter();
        if(listAdapter == null){
            return;
        }
        int totalHeight = 0;
        for(int i = 0;i<listAdapter.getCount();i++){
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, list);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight+= listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = list.getLayoutParams();
        params.height = totalHeight+(list.getDividerHeight()*(listAdapter.getCount()-1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        list.setLayoutParams(params);

    }




    @Override
    public void onClick(View v) {
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                int count = mAdapter.getCount();
                for(int i = 0;i<count+10;i++){
                    mAdapter.addItem(String.valueOf(i + 1));
                }
                mAdapter.notifyDataSetChanged();
                list.setSelection(visibleLastIndex-visibleItemCount+1);
                btn.setText("load  more");
            }
        }, 3000);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int visibleLastIndex = mAdapter.getCount()-1;
        int lastIndex = visibleLastIndex +1;//加上底部的loadmore项
        if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE&&visibleLastIndex==lastIndex){
            Log.d("", "loadmore-----");
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        visibleLastIndex = firstVisibleItem + visibleItemCount -1;
    }
}
