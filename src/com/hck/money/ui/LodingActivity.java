package com.hck.money.ui;

import cn.waps.AppConnect;
import cn.waps.UpdatePointsNotifier;

import com.hck.money.R;
import com.hck.money.date.UserDate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LodingActivity extends BaseActivity implements UpdatePointsNotifier{
	private ImageView imageView;
	private Animation animation; // 渐变动画
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading);
		imageView = (ImageView) findViewById(R.id.image);
		animation = AnimationUtils.loadAnimation(this, R.anim.loding);
		imageView.setAnimation(animation);
		AppConnect.getInstance(this).getPoints(this);
	}

	private void addUser() {

	}

	private void getShare() {

	}

	private void getUser() {

	}
    Handler handler=new Handler()
    {
    	public void handleMessage(android.os.Message msg) {
    		startActivity(new Intent(LodingActivity.this,MainActivity.class));
    		LodingActivity.this.finish();
    	};
    };
	@Override
	public void getUpdatePoints(String arg0, int arg1) {
		UserDate.money=arg1;
		handler.sendEmptyMessage(0);
	}

	@Override
	public void getUpdatePointsFailed(String arg0) {
           		
	}

}
