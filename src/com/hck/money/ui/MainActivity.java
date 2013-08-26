package com.hck.money.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import cn.waps.AppConnect;

import com.dianle.Dianle;
import com.hck.money.R;

public class MainActivity extends TabActivity implements
		OnCheckedChangeListener {
	private TabHost tabHost;
	private TabSpec tabSpec;
	private static final String HOME = "home";
	private static final String DUI_HUAN = "money";
	private static final String USER = "user";
	private static final String MORE = "more";
	private RadioGroup rGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initAds();
		setContentView(R.layout.main);
		init();
		setLister();
		server();
	}
	private void initAds()
	{
		AppConnect.getInstance(this);
		Dianle.initDianleContext(this, "1a97234a7bba7e99e7dcaae157681eea");
		Dianle.setUpdateOnlyWifi(false);//默认为false，设置true仅在WIFI下提示更新
	}
	private void init() {
		setContentView(R.layout.main);
		rGroup = (RadioGroup) findViewById(R.id.RadioGroup);
		tabHost = this.getTabHost();
	}
	private void setLister() {
		rGroup.setOnCheckedChangeListener(this);
	}
	private void server() {
		tabSpec = tabHost.newTabSpec(HOME).setIndicator(HOME)
				.setContent(new Intent(this, HomeActivity.class));
		tabHost.addTab(tabSpec);
		tabSpec = tabHost.newTabSpec(DUI_HUAN).setIndicator(DUI_HUAN)
				.setContent(new Intent(this, GetMoneyActivity.class));
		tabHost.addTab(tabSpec);

		tabSpec = tabHost.newTabSpec(USER).setIndicator(USER)
				.setContent(new Intent(this, UserActivity.class));
		tabHost.addTab(tabSpec);
		tabSpec = tabHost.newTabSpec(MORE).setIndicator(MORE)
				.setContent(new Intent(this, MoreActivity.class));
		tabHost.addTab(tabSpec);
		tabHost.addTab(tabSpec);
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.home_id:
			tabHost.setCurrentTab(0);
			break;
		case R.id.getmoney_id:
			tabHost.setCurrentTab(1);
			break;
		case R.id.user_id:
			tabHost.setCurrentTab(2);
			break;
		case R.id.more_id:
			tabHost.setCurrentTab(3);
			break;
		}
	}

}
