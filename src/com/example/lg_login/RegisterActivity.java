package com.example.lg_login;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener{

	private Button mBtnRegister;
	public EditText tv_user,tv_password,tv_name,tv_intro,tv_password_again;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		
		setContentView(R.layout.register);
		
		initView();
	}
	
	public void initView()
	{
		mBtnRegister = (Button) findViewById(R.id.register_btn);
		mBtnRegister.setOnClickListener(this);
		
		tv_user=(EditText)findViewById(R.id.registerUser);
		tv_password=(EditText)findViewById(R.id.registerPswd);
		tv_name=(EditText)findViewById(R.id.registerName);
		tv_intro=(EditText)findViewById(R.id.registerIntro);
		tv_password_again=(EditText)findViewById(R.id.registerPswd2);
	}
	
	public void back(View v)
	{
		finish();
	}

	@SuppressLint("ShowToast")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.register_btn:
			
			String user=(String) tv_user.getText().toString();
			String password=(String) tv_password.getText().toString();
			String name=(String) tv_name.getText().toString();
			String intro=(String) tv_intro.getText().toString();
			String password_again=(String) tv_password_again.getText().toString();
			
			if (user.equals("")||password.equals("")||name.equals("")||intro.equals("")) {
				Toast.makeText(RegisterActivity.this, "请完善个人信息", Toast.LENGTH_SHORT).show();
				return;
			}
			if (!password.equals(password_again)) {
				Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
				return;
			}
			
			password=Info.MD5(password);
			
			String[] strArray=new String[]{user,password,name,intro};
			Network.register(strArray);
			
			//finish();
			break;
			default:
				break;
		}
	}
}
