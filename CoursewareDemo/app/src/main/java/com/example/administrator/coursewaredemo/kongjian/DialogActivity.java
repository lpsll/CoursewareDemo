package com.example.administrator.coursewaredemo.kongjian;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by lenovo on 2017/9/4.
 */

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4,btn5,btn6;

	AlertDialog.Builder builder;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.dialog);

		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);
		btn6 = (Button) findViewById(R.id.btn6);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
	}

	//第六章情况，自定义
	private void initSix() {
		        builder = new AlertDialog.Builder(DialogActivity.this);
				builder.setTitle("自定义");

		        LayoutInflater inflater = getLayoutInflater();
				View layout = inflater.inflate(R.layout.dialog_item, null);
				builder.setView(layout);
		        initDialog();


			}

	private void initDialog() {

		builder.setPositiveButton("确定", null);
		builder.setNegativeButton("取消", null);

		AlertDialog dialog = builder.create();
		//位置、可从下面弹出
		Window window = dialog.getWindow();
		window.setGravity(Gravity.BOTTOM);

		//透明度
		WindowManager.LayoutParams wl = window.getAttributes();
		wl.alpha = 1f;
		window.setAttributes(wl);
		dialog.show();
	}


	//第五种情况，列表
	private void initFive() {
				builder.setTitle("列表");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setItems(new String[]{"item1","item2"}, null);
		        initDialog();
	}

	//第四钟情况，复选框
	private void initFour() {
				builder.setTitle("复选框");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setMultiChoiceItems(new String[]{"item1","item2","item3"}, null, null);
		        initDialog();
	}






	//第三种情况，单选框
	String[] str;
	int num;
	private void initThree() {
		        builder = new AlertDialog.Builder(DialogActivity.this);
				builder.setTitle("单选框");
				builder.setIcon(R.drawable.ic_launcher);
		        str = new String[]{"item1", "item2", "item3"};
				builder.setSingleChoiceItems(str, 0, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.e("which---1---",""+which);
						num = which;

					}
				});
		        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.e("which---2--",""+which);
						Toast.makeText(DialogActivity.this,str[num],Toast.LENGTH_SHORT).show();
					}
				});
	          	builder.setNegativeButton("取消", null);
		        builder.create().show();
	}

	//第二种情况，输入框
	EditText editText;
	private void initTwo() {
		        builder = new AlertDialog.Builder(DialogActivity.this);
				builder.setTitle("请输入");
				builder.setIcon(R.drawable.ic_launcher);

		        editText = new EditText(DialogActivity.this);
				builder.setView(editText);
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String  str = editText.getText().toString();
						Toast.makeText(DialogActivity.this,str,Toast.LENGTH_SHORT).show();
					}
				});
				builder.setNegativeButton("取消", null);
				builder.create().show();
	}

	//第一种类型，三个按钮
	private void initOne() {

		builder = new AlertDialog.Builder(DialogActivity.this);
		builder.setTitle("提示");
		builder.setMessage("确定退出吗？");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						dialog.dismiss();
						DialogActivity.this.finish();

					}
				}
		);
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				dialog.dismiss();
			}
		});




//		builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
//			@Override
//			public void onClick(DialogInterface dialog, int arg1) {
//				Toast.makeText(DialogActivity.this, "已经忽略了", Toast.LENGTH_LONG).show();
//				dialog.cancel();
//			}
//		});

		builder.create().show();
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





			case R.id.btn4:
				initFour();
				break;
			case R.id.btn5:
				initFive();
				break;
			case R.id.btn6:
				initSix();
				break;

		}
	}
}
