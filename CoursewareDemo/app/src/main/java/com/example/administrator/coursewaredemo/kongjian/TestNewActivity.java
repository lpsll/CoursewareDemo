package com.example.administrator.coursewaredemo.kongjian;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/6.
 */

public class TestNewActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn1,btn2,btn3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                initOne();
                break;
            case R.id.btn2:
                initTwo();
                break;
            case R.id.btn3:
                initThree();

                break;
        }
    }

    String[] str ;
    int num;
    private void initThree() {
        AlertDialog.Builder builder = new AlertDialog.Builder(TestNewActivity.this);
        builder.setTitle("提示");
        builder.setIcon(R.drawable.ic_launcher);
        str = new String[]{"第一","第二","第三","第四"};
        builder.setSingleChoiceItems(str, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                num = which;
            }
        });
        builder.setPositiveButton("确定",new AlertDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(TestNewActivity.this,str[num],Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消",new AlertDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    EditText editText;
    private void initTwo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(TestNewActivity.this);
        builder.setTitle("提示");
        builder.setIcon(R.drawable.ic_launcher);
        editText = new EditText(TestNewActivity.this);
        builder.setView(editText);
        builder.setPositiveButton("确定",new AlertDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(TestNewActivity.this,editText.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消",new AlertDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }


    private void initOne() {
        AlertDialog.Builder builder = new AlertDialog.Builder(TestNewActivity.this);
        builder.setTitle("提示");
        builder.setMessage("确定退出吗？");
        builder.setPositiveButton("确定",new AlertDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                TestNewActivity.this.finish();
            }
        });
        builder.setNegativeButton("取消",new AlertDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
       
    }
}
