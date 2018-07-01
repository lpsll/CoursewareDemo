package com.example.administrator.coursewaredemo.list;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.coursewaredemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5.
 */

public class ListNewActivity extends Activity  {
    private View lmView;
    private Button lm_btn;
    private MyAdapter madapter;
    private Handler handler = new Handler();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listnew);
        initView();
        initData();
    }

    private void initData() {
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            items.add(String.valueOf(i + 1));
        }
        madapter = new MyAdapter(this, items);
        listView.setAdapter(madapter);

    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        lmView = getLayoutInflater().inflate(R.layout.load_more, null);
        lm_btn = (Button) lmView.findViewById(R.id.lm_btn);
        listView.addFooterView(lmView);

        lm_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                lm_btn.setText("loading...");

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        loadData();
                        madapter.notifyDataSetChanged();


                        lm_btn.setText("loadmore");
                    }

                }, 3000);

            }
        });

    }

    private void loadData() {
        int count = madapter.getCount();
        for (int i = 1; i < 6; i++) {
            madapter.additem(String.valueOf(i+count));
        }
    }


}
