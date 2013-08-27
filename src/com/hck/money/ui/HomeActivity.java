package com.hck.money.ui;

import java.util.Random;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import cn.waps.AppConnect;
import com.dianle.Dianle;
import com.hck.money.R;
public class HomeActivity extends BaseActivity {
	private ImageView png0, png1, png2, png3, png4, png5;
	private ImageView pngs[] = { png0, png1, png2, png3, png4, png5 };
	private int imageId;
	private Random random;
	private Handler handler = new Handler();
	private A thread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		initView();
		// new AlertDialog(this).alert("hshshhs");

	}

	@Override
	protected void onResume() {
		super.onResume();
		setAnim();
	}

	@Override
	protected void onPause() {
		super.onPause();
		handler.removeCallbacks(thread);
	}

	private void initView() {
		thread = new A();
		png0 = (ImageView) findViewById(R.id.imag1);
		png1 = (ImageView) findViewById(R.id.imag2);
		png2 = (ImageView) findViewById(R.id.imag3);
		png3 = (ImageView) findViewById(R.id.imag4);
		png4 = (ImageView) findViewById(R.id.imag5);
		png5 = (ImageView) findViewById(R.id.imag6);
		pngs[0] = png0;
		pngs[1] = png1;
		pngs[2] = png2;
		pngs[3] = png3;
		pngs[4] = png4;
		pngs[5] = png5;
	}

	public void showAd1(View view) {
		AppConnect.getInstance(this).showOffers(this);
	}

	public void showAd2(View view) {
		Dianle.showOffers();
	}

	public void showAd3(View view) {
		AppConnect.getInstance(this).showTuanOffers(this);
	}

	private void setAnim() {
		handler.post(thread);
	}

	class A implements Runnable {
		ImageView imageView;

		@Override
		public void run() {
			random = new Random();
			imageId = random.nextInt(6);
			imageView = pngs[imageId];
			showAnim(imageView);
			handler.postDelayed(thread, 1000);
			Log.i("hck", "HomeActivity runrun");
		}
	}

	private void showAnim(final ImageView view) {
		view.setVisibility(View.VISIBLE);
		AnimationSet animationSet = new AnimationSet(true);

		TranslateAnimation translateAnimation = new TranslateAnimation(0.0f,
				0.0f, 300.0f, 0.0f);
		// 设置动画执行的时间（单位：毫秒）
		translateAnimation.setDuration(2000);
		// 将RotateAnimation对象添加到AnimationSet当中
		animationSet.addAnimation(translateAnimation);

		// 创建一个AlphaAnimation对象（参数表示从完全不透明到完全透明）
		AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
		// 设置动画执行的时间（单位：毫秒）
		alphaAnimation.setDuration(1000);
		// 将AlphaAnimation对象添加到AnimationSet当中
		animationSet.addAnimation(alphaAnimation);

		// 使用ImageView的startAnimation方法开始执行动画
		view.startAnimation(animationSet);
		alphaAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				view.setVisibility(View.GONE);
			}
		});

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(thread);
		AppConnect.getInstance(this).close();
	}

}
