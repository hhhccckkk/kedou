package com.hck.money.util;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.baidu.sharesdk.BaiduShareException;
import com.baidu.sharesdk.BaiduSocialShare;
import com.baidu.sharesdk.ShareContent;
import com.baidu.sharesdk.ShareListener;
import com.baidu.sharesdk.Utility;
import com.baidu.sharesdk.ui.BaiduSocialShareUserInterface;
import com.hck.money.ui.BaseActivity;
import com.hck.money.ui.BaseInterface;


public class ShareUtil {
	private static String app_key = "6fnl4bSZYSBKsEf0GiXc1ABe";
	private static BaiduSocialShare socialShare;
	private static BaiduSocialShareUserInterface socialShareUi;
	private static ShareContent content;
	public static final String QQ_SSO_APP_KEY = "100358052"; // online env
	public static final String SINA_SSO_APP_KEY = "319137445";
	
	public static Context context;
    private static BaseInterface aInterface;
	public static void share(Context context, String shareString,BaseInterface aInterface) {
		ShareUtil.aInterface=aInterface;
		ShareUtil.context = context;
		socialShare = BaiduSocialShare.getInstance(context, app_key);
		socialShare.supportQQSso(QQ_SSO_APP_KEY);
		socialShare.supportWeiBoSso(SINA_SSO_APP_KEY);
		socialShareUi = socialShare.getSocialShareUserInterfaceInstance();
		content = new ShareContent();
	//	shareString=Date.bean2.getContent()+"\n"+shareString;
		if (shareString!=null) {
			if (shareString.length()>140) {
				shareString=shareString.substring(0, 139);
			}
		}
		content.setContent(shareString);
		content.setUrl("http://www.baidu.com");
		//content.setImageUrl(Date.bean2.getImageUrl());
		share(context);
	}

	private static void share(Context context) {
		socialShareUi.showShareMenu((BaseActivity) context, content,
				Utility.SHARE_BOX_STYLE, new shareListener());
	}

	static class shareListener implements ShareListener {

		@Override
		public void onApiComplete(String arg0) {
	      aInterface.share(1, "分享成功");
		}

		@Override
		public void onAuthComplete(Bundle arg0) {
			aInterface.share(1,"登陆成功");
		}

		@Override
		public void onError(BaiduShareException arg0) {
			Log.i("hck", "shareUtil "+arg0);
		aInterface.share(0, "分享失败");
		}
	}
}
