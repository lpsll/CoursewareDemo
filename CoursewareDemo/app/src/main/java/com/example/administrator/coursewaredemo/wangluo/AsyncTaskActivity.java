package com.example.administrator.coursewaredemo.wangluo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/9/6.
 */

public class AsyncTaskActivity extends Activity implements View.OnClickListener {
    private static final String TAG="mythou_AsnycTask";
    private TextView mShowLogTextView;
    private Button mPlayMusicButton;
    private Button mStopMusicButton;
    private DownLoad mDownLoad;
    private ImageView mNetImageView;
    private Bitmap mDownLoadBtBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);
        mDownLoad = new DownLoad();
        mShowLogTextView = (TextView)findViewById(R.id.text);
        mPlayMusicButton = (Button)findViewById(R.id.btn);
        mStopMusicButton = (Button)findViewById(R.id.btn1);
        mNetImageView = (ImageView)findViewById(R.id.imageShow);
        mPlayMusicButton.setOnClickListener(this);
        mStopMusicButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v==mPlayMusicButton)
        {
            //传入下载图片的地址 mythou
            //mDownLoad.execute("http://pic.desk.chinaz.com/file/10.11.10/7/jillxs40.jpg");
            mDownLoad.execute("http://www.baidu.com/img/bdlogo.gif");
        }

    }




    private class DownLoad extends AsyncTask<String, Integer, String>
    {
        //onPreExecute方法在execute()后执行
        @Override
        protected void onPreExecute()
        {
            Log.i(TAG, "onPreExecute() enter");
            mShowLogTextView.setText("onPreExecute。。。begin downLoad");
        }

        //doInBackground方法内部执行后台任务,不能在里面更新UI，否则有异常。
        @Override
        protected String doInBackground(String... params)
        {
            Log.i(TAG, "doInBackground(String... params) enter");

            URL imageUrl=null;
            try
            {
                imageUrl=new URL(params[0]);
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
                Log.e(TAG, e.getMessage());
            }
            try
            {
                //使用HttpURLConnection打开连接
                HttpURLConnection urlConn=(HttpURLConnection)imageUrl.openConnection();
                urlConn.setDoInput(true);
                urlConn.connect();
                //将得到的数据转化成InputStream
                InputStream is=urlConn.getInputStream();
                //将InputStream转换成Bitmap
                mDownLoadBtBitmap= BitmapFactory.decodeStream(is);
                is.close();
                //不能在这里更新UI,否则有异常
                //mNetImageView.setImageBitmap(bitmap);
            }catch(IOException e)
            {
                Log.e(TAG,e.getMessage());
            }

            return "ok";
        }

        //onProgressUpdate方法用于更新进度信息
        @Override
        protected void onProgressUpdate(Integer... progresses)
        {
            Log.i(TAG, "onProgressUpdate(Integer... progresses) enter");

            mShowLogTextView.setText("onProgressUpdate Down loading...");
        }

        //onPostExecute用于doInBackground执行完后，更新界面UI。
        //result是doInBackground返回的结果
        @Override
        protected void onPostExecute(String result)
        {
            Log.i(TAG, "onPostExecute(Result result) called");
            mShowLogTextView.setText("Down load finish result="+result);

            mNetImageView.setImageBitmap(mDownLoadBtBitmap);
        }

        //onCancelled方法用于取消Task执行，更新UI
        @Override
        protected void onCancelled()
        {
            Log.i(TAG, "onCancelled() called");
            mShowLogTextView.setText("onCancelled");
        }
    }
}
