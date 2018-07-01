package com.example.administrator.coursewaredemo.wangluo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/5.
 */

public class HanlderActivtiy  extends Activity implements View.OnClickListener {
    private TextView text;
    private Button btn1,btn2;
    private LinearLayout container;
    Handler handler = new Handler();

    Runnable r = new Runnable() {

        @Override
        public void run() {
            System.out.println("handler_id---->"+Thread.currentThread().getId());
            System.out.println("handler_name---->"+Thread.currentThread().getName());
            //延时10s，为了观察主界面中内容出现的时间
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hanlder);
        handler.post(r);
        text = (TextView) findViewById(R.id.text);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        TextView text = new TextView(this);
        text.setText("新添加的");
        container.addView(text);

        //例子2
        //启动线程
        MyThread myThread = new MyThread();
        new Thread(myThread).start();

    }




  //例子2
    class MyThread implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}

			Message msg = Message.obtain();
			Bundle b = new Bundle();
			b.putString("str", "aaa");
			msg.setData(b);
			//这里handler的实例化在线程中
            //线程启动的时候就已经实例化了
			myHandler.sendMessage(msg);
		}

    }
  //例子2
    Handler myHandler = new Handler(){
    	@Override
    	public void handleMessage(Message msg) {
    		super.handleMessage(msg);
    		Bundle b = msg.getData();
   		    String str = b.getString("str");
    		btn1.append(str);

    	}

    };



    //例子1：
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
		case R.id.btn1:
            thandler.post(update_thread);
			break;
        case R.id.btn2:
            thandler.removeCallbacks(update_thread);
			break;

            default:
                break;
        }
    }
//例子1：
    //创建Handler对象
Handler thandler = new Handler();
   //新建一个线程对象
    Runnable update_thread  = new Runnable() {
    	//将要执行的操作写在线程对象的run方法当中
		@Override
		public void run() {
			text.append("\nupdate_thread...");
			//调用Handler的postDelayed()方法
	    	//这个方法的作用是：将要执行的线程对象放入到队列当中，待时间结束后，运行制定的线程对象
	    	//第一个参数是Runnable类型：将要执行的线程对象
	    	//第二个参数是long类型：延迟的时间，以毫秒为单位
            thandler.postDelayed(update_thread, 2000);
		}
	};



}
