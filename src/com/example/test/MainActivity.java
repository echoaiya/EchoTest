package com.example.test;

import com.example.test.service.Service1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//you have to start the service once.
        startService(new Intent(MainActivity.this, Service1.class));
	}
}