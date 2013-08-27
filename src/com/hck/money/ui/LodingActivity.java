package com.hck.money.ui;

import com.hck.money.R;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LodingActivity extends BaseActivity{
	private ImageView imageView;
	private Animation animation; //渐变动画
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading);
		imageView=(ImageView) findViewById(R.id.image);
		animation = AnimationUtils.loadAnimation(this, R.anim.loding);
		imageView.setAnimation(animation);
	}
	private void addUser()
	{
		
	}
	private void getShare()
	{
		
	}
	private void getUser()
	{
		
	}

}
