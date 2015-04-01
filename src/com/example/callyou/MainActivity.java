package com.example.callyou;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button CallButton;
	private EditText CallNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//找到布局文件中定义的按钮
		CallNumber = (EditText) this.findViewById(R.id.number);
		CallButton = (Button) this.findViewById(R.id.callButton);
		//为按钮定义操作
		CallButton.setOnClickListener(new ClickButton());
	}
	private void callMethod() {
		//把EditTest中的内容转换成String对象。
		String numberString = CallNumber.getText().toString().trim();
		/*
		 * 执行判断方法，
		 * 判断对象是否为空
		 * */
		if (TextUtils.isEmpty(numberString)) {
			//弹出提示信息
			Toast.makeText(MainActivity.this, "电话号码不能为空", Toast.LENGTH_SHORT).show();
			return;//结束方法，return后面的内容不再执行
		}
		//定义一个Intent意图
		Intent intent = new Intent();
		intent.setAction("android.intent.action.CALL");//给intent定义活动
		intent.setData(Uri.parse("tel: " + numberString));//设置内容
		startActivity(intent);//通过意图，启动相应的活动
	}
	/*
	 * 定义内部类实现OnlickListener接口。
	 * */
	private final class ClickButton implements OnClickListener {

		@Override
		public void onClick(View v) {
			callMethod();

		}
	}
	/*
	 * 点击事件的4种实现
	 * 1.定义类实现接口功能
	 * 2.匿名内部类实现接口功能
	 * 3.主类实现接口功能，用this调用实现。
	 * */
	
}
