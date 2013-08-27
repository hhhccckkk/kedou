package com.hck.money.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.hck.money.R;



public class AlertDialog {
	private Context context;
	private Button leftButton;
	private Button rightButton;
	private TextView textView;

	public AlertDialog(Context context) {
		this.context = context;
	}

	public void alert(String con) {
		final Dialog dialog = new Dialog(context, R.style.dialog);
		View view = LayoutInflater.from(context).inflate(R.layout.d_update,
				null);
		dialog.setContentView(view);
		android.view.WindowManager.LayoutParams lay = dialog.getWindow()
				.getAttributes();
		setParams(lay);
		dialog.show();
		dialog.setCancelable(false);
		leftButton = (Button) view.findViewById(R.id.update_exit);
		textView = (TextView) view.findViewById(R.id.update_content_id);
		textView.setText(con);
		leftButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				
			}
		});
		
	}

	private void setParams(android.view.WindowManager.LayoutParams lay) {
		DisplayMetrics dm = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay()
				.getMetrics(dm);

		Rect rect = new Rect();
		View view = ((Activity) context).getWindow().getDecorView();
		view.getWindowVisibleDisplayFrame(rect);
		lay.height = dm.heightPixels - rect.top;
		lay.width = dm.widthPixels;
	}

}
