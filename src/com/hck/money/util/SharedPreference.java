package com.hck.money.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreference {
	private static SharedPreferences pref;
	private static Editor editor;

	public SharedPreference(Context context) {

		pref = context.getSharedPreferences(Context.ACTIVITY_SERVICE,
				Context.MODE_APPEND);
	}

	public static void saveName(String name, Context context) { // 保存昵称
		editor = pref.edit();
		editor.putString("name", name);
		editor.commit();
	}

	public static String getName(Context context) { // 获取用户昵称
		return pref.getString("name", null);
	}

	public static float getTextSize(Context context) { // 获取字体大小
		return pref.getFloat("size", 18.0f);
	}

	public static void saveSize(float size, Context context) { // 保存字体大小
		editor = pref.edit();
		editor.putFloat("size", size);
		editor.commit();
	}

	public static void saveIsTiShi(boolean b, Context context) { // 保存是否开启更新提示
		editor = pref.edit();
		editor.putBoolean("isTrue", b);
		editor.commit();
	}

	public static boolean getBoolen() { // 获取是否更新
		return pref.getBoolean("isTrue", false);
	}

	public static boolean isSheZhi() {
		return pref.getBoolean("isSheZhi", false);
	}

	public static void saveshezhi(boolean b, Context context) {
		editor = pref.edit();
		editor.putBoolean("isSheZhi", b);
		editor.commit();
	}

	public static void saveIsFirst(boolean b) { // 是否第一次用
		editor = pref.edit();
		editor.putBoolean("isFirst", false);
		editor.commit();
	}

	public static boolean IsFirst() { // 是否第一次用
		return pref.getBoolean("isFirst", true);
	}

	
}
