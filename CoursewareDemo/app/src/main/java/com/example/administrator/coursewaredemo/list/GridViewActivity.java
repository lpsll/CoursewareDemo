package com.example.administrator.coursewaredemo.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/5.
 */

public class GridViewActivity extends Activity {
    private GridView gd;
    private MyGridAdapter myAdapter;
    private int[] images = {R.drawable.logo_01,R.drawable.logo_02,R.drawable.logo_03,R.drawable.logo_04,R.drawable.logo_05,R.drawable.logo_06,R.drawable.logo_07,R.drawable.logo_08,R.drawable.logo_09};
    private String[] title = {"赵王","钱王","孙王","李王","王王","朝王","马王","汉王","秦王"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gd = (GridView) findViewById(R.id.gv);


//        myAdapter = new MyGridAdapter(this,title,images);
        gd.setAdapter(myAdapter);



        gd.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,
                                    long arg3) {
                Toast.makeText(getApplicationContext(), "pic"+position+"title"+title[position], Toast.LENGTH_LONG).show();
            }
        });

    }


}
