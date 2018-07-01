package com.example.administrator.coursewaredemo.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.*;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        Button btnTextToast = (Button) findViewById(R.id.btnTextToast);
        btnTextToast.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){//获得按钮的ID
            case R.id.btnTextToast:
//                Toast textToast = Toast.makeText(ToastActivity.this, "您有新邮件来了！\n请马上去看看！",Toast.LENGTH_LONG);
//                textToast.show();

                //自定义的toast
//				Toast toast = Toast.makeText(this,
//						"自定义显示的toast", Toast.LENGTH_LONG);
//				toast.setGravity(Gravity.CENTER, -50, 20);
//				toast.show();

//                initImg();






                Toast toast = Toast.makeText(ToastActivity.this,"您好！",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,100,100);

                LinearLayout linearLayout = (LinearLayout) toast.getView();

                ImageView imageView = new ImageView(ToastActivity.this);
                imageView.setImageResource(R.drawable.ic_launcher);

                linearLayout.addView(imageView,0);

                toast.show();























                break;
        }

    }

    private void initImg() {
        //第一步，获取toast对象
        Toast toast= Toast.makeText(this,"带图片的toast",Toast.LENGTH_SHORT);

        toast.setGravity(Gravity.CENTER, -50, 20);

        //第二步，获取到toast的布局
        LinearLayout linearLayout = (LinearLayout) toast.getView();

        //第三步，生成一个图片控件
        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.ic_launcher);

        //show
        linearLayout.addView(img,1);
        toast.show();

    }
}
