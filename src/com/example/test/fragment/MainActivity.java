package com.example.test.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Toast.makeText(this, "Model: " + android.os.Build.MODEL, Toast.LENGTH_LONG).show();
		Log.i("wangxu", "Model: " + android.os.Build.MODEL);
		
        DisplayMetrics dm = new DisplayMetrics();   
//        getWindowManager().getDefaultDisplay().getMetrics(dm);   
//        String dmString = "屏幕分辨率为:"+dm.widthPixels+" * "+dm.heightPixels;
//        Toast.makeText(this, dmString, Toast.LENGTH_LONG).show();  
//        Log.i("wangxu", dmString);
//        
        String str = "";


        dm = this.getApplicationContext().getResources().getDisplayMetrics();

        int screenWidth = dm.widthPixels;

        int screenHeight = dm.heightPixels;

        float density = dm.density;

        float xdpi = dm.xdpi;

        float ydpi = dm.ydpi;

        str += "屏幕分辨率为:" + dm.widthPixels + " * " + dm.heightPixels + "\n";

        str += "绝对宽度:" + String.valueOf(screenWidth) + "pixels\n";

        str += "绝对高度:" + String.valueOf(screenHeight)

        + "pixels\n";

        str += "逻辑密度:" + String.valueOf(density)

        + "\n";

        str += "X 维 :" + String.valueOf(xdpi) + "像素每英尺\n";

        str += "Y 维 :" + String.valueOf(ydpi) + "像素每英尺\n";

        Log.i("wangxu", str);
	}
}
