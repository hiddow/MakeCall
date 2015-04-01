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
		//�ҵ������ļ��ж���İ�ť
		CallNumber = (EditText) this.findViewById(R.id.number);
		CallButton = (Button) this.findViewById(R.id.callButton);
		//Ϊ��ť�������
		CallButton.setOnClickListener(new ClickButton());
	}
	private void callMethod() {
		//��EditTest�е�����ת����String����
		String numberString = CallNumber.getText().toString().trim();
		/*
		 * ִ���жϷ�����
		 * �ж϶����Ƿ�Ϊ��
		 * */
		if (TextUtils.isEmpty(numberString)) {
			//������ʾ��Ϣ
			Toast.makeText(MainActivity.this, "�绰���벻��Ϊ��", Toast.LENGTH_SHORT).show();
			return;//����������return��������ݲ���ִ��
		}
		//����һ��Intent��ͼ
		Intent intent = new Intent();
		intent.setAction("android.intent.action.CALL");//��intent����
		intent.setData(Uri.parse("tel: " + numberString));//��������
		startActivity(intent);//ͨ����ͼ��������Ӧ�Ļ
	}
	/*
	 * �����ڲ���ʵ��OnlickListener�ӿڡ�
	 * */
	private final class ClickButton implements OnClickListener {

		@Override
		public void onClick(View v) {
			callMethod();

		}
	}
	/*
	 * ����¼���4��ʵ��
	 * 1.������ʵ�ֽӿڹ���
	 * 2.�����ڲ���ʵ�ֽӿڹ���
	 * 3.����ʵ�ֽӿڹ��ܣ���this����ʵ�֡�
	 * */
	
}
