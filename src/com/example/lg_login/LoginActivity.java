package com.example.lg_login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {

	private Button mBtnRegister;
	private Button mBtnLogin;

	private View mMoreView;
	private ImageView mMoreImage;
	private View mMoreMenuView;

	private EditText tv_user, tv_password;

	private boolean mShowMenu = false;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		setContentView(R.layout.login);

		initView();
	}

	public void initView() {
		
		mBtnRegister = (Button) findViewById(R.id.regist);
		mBtnRegister.setOnClickListener(this);

		mBtnLogin = (Button) findViewById(R.id.login);
		mBtnLogin.setOnClickListener(this);

		tv_user = (EditText) findViewById(R.id.loginUser);
		tv_password = (EditText) findViewById(R.id.loginPswd);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.regist:
			goRegisterActivity();
			break;
		case R.id.login:
			connectToLogin();
			break;
		default:
			break;
		}
	}

	public void goRegisterActivity() {
		Intent intent = new Intent();
		intent.setClass(this, RegisterActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}

	@SuppressLint("ShowToast")
	
	private void connectToLogin() {
		String user = (String) tv_user.getText().toString();
		String password = (String) tv_password.getText().toString();
		if (user.equals("") || password.equals("")) {
			Toast.makeText(this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
			return;
		}

		password=Info.MD5(password);
        Network.login(user, password);
	}

}
