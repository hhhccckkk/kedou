package com.hck.money.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import cn.waps.AppConnect;
import cn.waps.UpdatePointsNotifier;

import com.hck.money.R;
import com.hck.money.util.ShareUtil;
import com.hck.money.util.Toasts;

public class UserActivity extends BaseActivity implements BaseInterface,UpdatePointsNotifier{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user);
	}
	public void share(View view)
	{
		
		ShareUtil.share(this,"蝌蚪赚钱儿", this);
	}
	public void startUserInfo(View view)
	{
		startActivity(new Intent(this,UserInfoActivity.class));
	}
	public void showHelp(View view)
	{
		startActivity(new Intent(this,HelpActivity.class));
	}
	@Override
	public void share(int i,String string) {
		if (i==1) {
			AppConnect.getInstance(this).awardPoints(200, this);
			handler.sendEmptyMessage(1);
		}
		else if (i==0) {
			handler.sendEmptyMessage(0);
		}
	}
	Handler handler=new Handler()
	{
		public void handleMessage(android.os.Message msg) {
			if (msg.what==0) {
				Toasts.toastPl(UserActivity.this,"分享失败，请检查网络");
			}
			else if (msg.what==1) {
				Toasts.toastPl(UserActivity.this, "分享成功");
			}
			else if (msg.what==2) {
				Toasts.toastPl(UserActivity.this, "您成功获取200蝌蚪币");
			}
			else if (msg.what==3) {
				Toasts.toastPl(UserActivity.this,"获取蝌蚪币失败 请检查网络");
			}
		};
	};
	@Override
	public void getUpdatePoints(String arg0, int arg1) {
		
		handler.sendEmptyMessage(2);
	}
	@Override
	public void getUpdatePointsFailed(String arg0) {
		
		handler.sendEmptyMessage(3);
		
	}

}
