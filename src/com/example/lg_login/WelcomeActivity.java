package com.example.lg_login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;

public class WelcomeActivity extends Activity{
    /** Called when the activity is first created. */

	private Handler mHandler;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        initView();
    }
    
    public void initView()
    {
    	mHandler = new Handler();
    	if (Info.sp.getBoolean(Info.str_auto_login, false))
    	{
    		mHandler.postDelayed(new Runnable() {
    			@Override
    			public void run() {
    				connectToLogin();
    			}
        	}, 1000);
    	}
    	else {
    		mHandler.postDelayed(new Runnable() {
    			@Override
    			public void run() {
    				goLoginActivity();
    			}
    		}, 1000);
    	}
    }
    
    public void goLoginActivity()
    {
    	Intent intent = new Intent();
    	intent.setClass(this, LoginActivity.class);		
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	startActivity(intent);
    	finish();
    }

    public void connectToLogin(){
    	String user=Info.sp.getString(Info.str_user, "");
    	String password=Info.sp.getString(Info.str_password, "");
    	Network.login(user, password);
    }
    
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		finish();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
}