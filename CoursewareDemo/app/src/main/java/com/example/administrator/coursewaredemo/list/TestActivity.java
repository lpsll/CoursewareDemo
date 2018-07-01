package com.example.administrator.coursewaredemo.list;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.OnClickActivity;
import com.example.administrator.coursewaredemo.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/11.
 */

public class TestActivity extends AppCompatActivity {

    GridView gridView;
    GridViewEntity entity;
    ArrayList<GridViewEntity> list = new ArrayList<GridViewEntity>();
    private int[] images = {R.drawable.logo_01,R.drawable.logo_02,R.drawable.logo_03,R.drawable.logo_04,R.drawable.logo_05,R.drawable.logo_06,R.drawable.logo_07,R.drawable.logo_08,R.drawable.logo_09};
    private String[] title = {"赵王","钱王","孙王","李王","王王","朝王","马王","汉王","秦王"};
    MyGridAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView = (GridView) findViewById(R.id.gv);
        //第一步：创建数据源的实体类，添加数据到实体类中,把实体类添加到集合中
        for(int i =0;i<9;i++){
            //创建实体类对象
            entity = new GridViewEntity();
            //给实体类对象添加数据
            entity.setPic(images[i]);
            entity.setTitle(title[i]);
            //给集合添加已经添加数据的实体类
            list.add(entity);
        }


        //第二步：把添加了实体类的集合传递到adapter中
        adapter = new MyGridAdapter(this,list);
        gridView.setAdapter(adapter);


        //第三步：设置集合列表的内部点击事件,把每一个子项的数据展示出来
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = list.get(position).getTitle();
                int i = list.get(position).getPic();
                Toast.makeText(TestActivity.this,"标题是："+s+"\n"+"图片索引是："+i,Toast.LENGTH_SHORT).show();
            }
        });



    }





}
