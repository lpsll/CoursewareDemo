package com.example.administrator.coursewaredemo.activity.demo6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/5.
 */

public class TestActivity extends FragmentActivity {
    ImageView imageView1,imageView2,imageView3,imageView4;
    ImageView[] imageViews = new ImageView[4];
    FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        imageView1 = (ImageView) findViewById(R.id.iv1);
        imageView2 = (ImageView) findViewById(R.id.iv2);
        imageView3 = (ImageView) findViewById(R.id.iv3);
        imageView4 = (ImageView) findViewById(R.id.iv4);
        imageViews[0] = imageView1;
        imageViews[1] = imageView2;
        imageViews[2] = imageView3;
        imageViews[3] = imageView4;
        fm = getSupportFragmentManager();
        //通过for循环设置四个图片底部的点击事件，并且把对应的标识传递过去
        for(int i=0;i<4;i++){
            final int j =i;
            imageViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showTab(j);

                }
            });
        }
        //设置一个默认的首页展示
        showTab(0);
    }

    private void showTab(int index) {
        //第一步：首先从fragment栈管理器中，判断取出的fragment是否存在，如果存在就不作处理，如果不存在则创建fragment
        //       创建对应的fragment，并且添加到Activity里面
        Fragment fragment =null;
        fragment = fm.findFragmentByTag("tag"+index);
        if(fragment==null||!fragment.isAdded()){
            fragment =add(index);
        }

        //第二步：隐藏多余的fragment（通过判断来实现这个功能）
        //        取出四个fragment，和当前的fragment进行判断，如果相同则不处理，如果不同，则隐藏，如果fragment不存在，则不做任何处理
        hidden(fragment);

        //第三步：展示当前的fragment
        show(fragment);

        //第四步：实现对于图片背景颜色的更换
        replaceColor(index);


    }

    private void replaceColor(int index) {
        for(int i=0;i<4;i++){
            if(i ==index){
                imageViews[i].setBackgroundResource(R.color.navi_press);
            }else {
                imageViews[i].setBackgroundResource(R.color.navi);
            }
        }
    }

    private void show(Fragment fragment) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commitAllowingStateLoss();
        fragment.setUserVisibleHint(true);
    }

    private void hidden(Fragment fragment) {
        Fragment fment =null;
        for(int i=0;i<4;i++){
            fment = fm.findFragmentByTag("tag"+i);
            if(fment!=null&&fment.isAdded()&&fment!=fragment){
                FragmentTransaction ft = fm.beginTransaction();
                ft.hide(fment);
                ft.commitAllowingStateLoss();
                fment.setUserVisibleHint(false);
            }
        }
    }

    private Fragment add(int index) {
        Fragment fragment =null;
        switch (index){
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new OrderFragment();
                break;
            case 2:
                fragment = new CampaignFragment();
                break;
            case 3:
                fragment = new MineFragment();
                break;
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.framelayout,fragment,"tag"+index);
        ft.commitAllowingStateLoss();
        return fragment;

    }

}
