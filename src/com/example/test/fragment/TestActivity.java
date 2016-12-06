package com.example.test.fragment;


import com.example.test.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class TestActivity extends Activity implements OnClickListener{

	private FragmentManager manager;
    private FragmentTransaction transaction;
    private View mView;
    private static int flag = 0;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
//        getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
//        		| WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        
        setContentView(R.layout.activity_test);
        mView = findViewById(R.id.main);
        mView.setOnClickListener(this);
 
        manager = getFragmentManager();
 
    }
    
    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	switch(flag) {
    	case 0:
    		replaceFragment("sysFragment", new SysFragment());
    		flag = 1;
    		break;
    	case 1:
    		replaceFragment("fileFragment", new FileFragment());
    		flag = 2;
    		break;
    	case 2:
    		replaceFragment("productFragment", new ProductFragment());
    		flag = 0;
    		break;
    	}
    }
    
    private void replaceFragment(String tag, Fragment fragment) {
    	transaction = manager.beginTransaction();
    	transaction.replace(R.id.main, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
        Toast.makeText(this, "您点击了" + tag, Toast.LENGTH_SHORT).show();
    }
 
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
// 
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        transaction = manager.beginTransaction();
//        switch (item.getItemId()) {
//        /**
//         * 系统管理
//         */
//        case R.id.sys:
//            SysFragment sysFragment = new SysFragment();
//            transaction.replace(R.id.main, sysFragment, "sysFragment");
//            transaction.addToBackStack("sysFragment");
//            Toast.makeText(this, "您点击了系统管理", Toast.LENGTH_SHORT).show();
//            break;
//        /**
//         * 文件管理
//         */
//        case R.id.file:
//            FileFragment fileFragment = new FileFragment();
//            transaction.replace(R.id.main, fileFragment, "fileFragment");
//            transaction.addToBackStack("fileFragment");
//            Toast.makeText(this, "您点击了文件管理", Toast.LENGTH_SHORT).show();
//            break;
//        /**
//         * 产品管理
//         */
//        case R.id.product:
//            ProductFragment productFragment = new ProductFragment();
//            transaction.replace(R.id.main, productFragment, "productFragment");
//            transaction.addToBackStack("productFragment");
//            Toast.makeText(this, "您点击了产品管理", Toast.LENGTH_SHORT).show();
//            break;
//        }
//        transaction.commit();
//        return super.onOptionsItemSelected(item);
//    }
}
