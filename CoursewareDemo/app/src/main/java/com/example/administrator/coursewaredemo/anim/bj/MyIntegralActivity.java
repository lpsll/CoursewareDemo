package com.example.administrator.coursewaredemo.anim.bj;


import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

public class MyIntegralActivity extends Activity implements OnClickListener{

	Button mOne;
	Button mTwo;
	Button mThree;
	Button mFour;
	Button mFive;
	Button mSix;
	Button mServer;
	ImageView animationIV;
	private boolean mIsSign = true;
	private AnimationDrawable animationDrawable;
	//Alpha动画 - 渐变透明度
	private Animation alphaAnimation = null;
	TranslateAnimation animation;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_integral);
		initView();
	}


	public void initView() {
		mOne = (Button) findViewById(R.id.tv_one);
		mTwo = (Button) findViewById(R.id.tv_two);
		mThree = (Button) findViewById(R.id.tv_three);
		mFour = (Button) findViewById(R.id.tv_four);
		mFive = (Button) findViewById(R.id.tv_five);
		mSix = (Button) findViewById(R.id.tv_six);
		mServer = (Button) findViewById(R.id.tv_server);
		animationIV = (ImageView) findViewById(R.id.animationIV);
		mOne.setOnClickListener(this);
		mTwo.setOnClickListener(this);
		mThree.setOnClickListener(this);
		mFour.setOnClickListener(this);
		mFive.setOnClickListener(this);
		mSix.setOnClickListener(this);
		mServer.setOnClickListener(this);

	}



	private void anim() {
		animationIV.setVisibility(View.VISIBLE);
		AnimationSet set = new AnimationSet(false);
		//渐变动画
		AlphaAnimation aa = new AlphaAnimation(1, 0.3f);// 由完全透明到不透明
		//帧动画
		animationIV.setImageResource(R.drawable.gold);
		animationDrawable = (AnimationDrawable) animationIV.getDrawable();//返回imageView这个用于显示图片的控件里的图片，返回的是Drawable类型
		//位移动画
		animation = new TranslateAnimation(0,0,-10,-450);
		animation.setDuration(3600);//设置动画持续时间
		animation.setFillAfter(true);// 动画播放完之后，停留在当前状态
		animation.setInterpolator(new LinearInterpolator());//Interpolator 被用来修饰动画效果，定义动画的变化率,LinearInterpolator以均匀的速率改变

		animationDrawable.start();

		// 添加到动画集
		set.addAnimation(aa);
		set.addAnimation(animation);
		animationIV.startAnimation(set);

		animation.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				animationIV.setVisibility(View.GONE);
				mIsSign =false;
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
	}


	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.tv_one:
				if(mIsSign){
					Toast.makeText(MyIntegralActivity.this, "签到!", Toast.LENGTH_SHORT).show();
					anim();
					mOne.setBackgroundResource(R.drawable.red);
					mOne.setEnabled(false);
					mOne.setText("已签到");
					mOne.setTextColor(getResources().getColor(R.color.ffoo));
				}else {
					Toast.makeText(MyIntegralActivity.this, "您今天已经签到了，明天再来吧!", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.tv_two:
				if(mIsSign){
					anim();
					mTwo.setBackgroundResource(R.drawable.red);
					mTwo.setEnabled(false);
					mTwo.setText("已签到");
					mTwo.setTextColor(getResources().getColor(R.color.ffoo));

				}else {
					Toast.makeText(MyIntegralActivity.this, "您今天已经签到了，明天再来吧!", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.tv_three:
				if(mIsSign) {
					anim();
					mThree.setBackgroundResource(R.drawable.red);
					mThree.setEnabled(false);
					mThree.setText("已签到");
					mThree.setTextColor(getResources().getColor(R.color.ffoo));


				}else {
					Toast.makeText(MyIntegralActivity.this, "您今天已经签到了，明天再来吧!", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.tv_four:
				if(mIsSign) {
					anim();
					mFour.setBackgroundResource(R.drawable.red);
					mFour.setEnabled(false);
					mFour.setText("已签到");
					mFour.setTextColor(getResources().getColor(R.color.ffoo));


				}else {
					Toast.makeText(MyIntegralActivity.this, "您今天已经签到了，明天再来吧!", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.tv_five:
				if(mIsSign) {
					anim();
					mFive.setBackgroundResource(R.drawable.red);
					mFive.setEnabled(false);
					mFive.setText("已签到");
					mFive.setTextColor(getResources().getColor(R.color.ffoo));


				}else {
					Toast.makeText(MyIntegralActivity.this, "您今天已经签到了，明天再来吧!", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.tv_six:
				if(mIsSign) {
					anim();
					mSix.setBackgroundResource(R.drawable.red);
					mSix.setEnabled(false);
					mSix.setText("已签到");
					mSix.setTextColor(getResources().getColor(R.color.ffoo));


				}else {
					Toast.makeText(MyIntegralActivity.this, "您今天已经签到了，明天再来吧!", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.tv_server:
				if(mIsSign) {
					anim();
					mServer.setBackgroundResource(R.drawable.red);
					mServer.setEnabled(false);
					mServer.setText("已签到");
					mServer.setTextColor(getResources().getColor(R.color.ffoo));
				}else {
					Toast.makeText(MyIntegralActivity.this, "您今天已经签到了，明天再来吧!", Toast.LENGTH_SHORT).show();
				}
				break;



		}

	}






}
