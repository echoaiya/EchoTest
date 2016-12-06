package com.example.test.fragment;

import com.example.test.R;

import android.app.Application;

public class MyApplication extends Application{

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		getApplicationContext().setTheme(R.style.MyTheme);
	}
}
