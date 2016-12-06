package com.example.test;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.test.service.Receiver1;
import com.example.test.service.Receiver2;
import com.example.test.service.Service1;
import com.example.test.service.Service2;
import com.marswin89.marsdaemon.DaemonApplication;
import com.marswin89.marsdaemon.DaemonClient;
import com.marswin89.marsdaemon.DaemonConfigurations;

/**
 * Implementation 2<br/>
 * if you have to extends other Application, use this method.<br/>
 *
 * Created by Mars on 12/24/15.
 */
public class MyApplication2 extends Application {

    private DaemonClient mDaemonClient;
    
    @Override
    public void onCreate() {
    	// TODO Auto-generated method stub
    	super.onCreate();
    	Log.i("wangxu", "Application created.");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mDaemonClient = new DaemonClient(createDaemonConfigurations());
        mDaemonClient.onAttachBaseContext(base);
    }



    private DaemonConfigurations createDaemonConfigurations(){
        DaemonConfigurations.DaemonConfiguration configuration1 = new DaemonConfigurations.DaemonConfiguration(
                "com.example.test:process1",
                Service1.class.getCanonicalName(),
                Receiver1.class.getCanonicalName());
        DaemonConfigurations.DaemonConfiguration configuration2 = new DaemonConfigurations.DaemonConfiguration(
                "com.example.test:process2",
                Service2.class.getCanonicalName(),
                Receiver2.class.getCanonicalName());
        DaemonConfigurations.DaemonListener listener = new MyDaemonListener();
        //return new DaemonConfigurations(configuration1, configuration2);//listener can be null
        return new DaemonConfigurations(configuration1, configuration2, listener);
    }


    class MyDaemonListener implements DaemonConfigurations.DaemonListener{
        @Override
        public void onPersistentStart(Context context) {
        	Log.i("wangxu", "onPersistentStart......");
        }

        @Override
        public void onDaemonAssistantStart(Context context) {
        	Log.i("wangxu", "onDaemonAssistantStart......");
        }

        @Override
        public void onWatchDaemonDaed() {
        	Log.i("wangxu", "onWatchDaemonDaed......");
        }
    }
}
