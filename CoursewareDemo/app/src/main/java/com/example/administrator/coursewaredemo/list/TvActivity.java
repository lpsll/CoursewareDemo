package com.example.administrator.coursewaredemo.list;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/5.
 */

public class TvActivity extends Activity {
    private TextView top_tv;
    private ListView listView;
    private String[] str1,str2,str3,str4,str5;
    TvAdapter tvAdapter;

    //第一步：创建activity中的视图，作为容器，容纳子项，展示子项
    //第二步：创建子项(在adapter)
            //通过数据源来创建子项，数据源从activity中获取(通过构造方法的形式，将数据源从activity中传入到adapter中)
            //创建子项（这个过程进行优化）
                 //首先创建子项，然后将数据填充到子项当中
    //第三步：通过适配模式，将子项和主视图关联起来，以adapter适配器作为桥梁



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tv);
        listView = (ListView) findViewById(R.id.tv_lv);
        top_tv = (TextView) findViewById(R.id.top_tv);
        top_tv.setText("微博");
        str1 = getResources().getStringArray(R.array.title);
        str2 = getResources().getStringArray(R.array.tv);
        str3 = getResources().getStringArray(R.array.title2);
        str4 = getResources().getStringArray(R.array.title3);
        str5 = getResources().getStringArray(R.array.title4);
        tvAdapter = new TvAdapter(this,str1,str2,str3,str4,str5);
        listView.setAdapter(tvAdapter);



    }
}
