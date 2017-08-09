package com.alexbernat.classwork5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyService extends Service {

    private final IBinder binder = new MyBinder();

    private final Random generator = new Random();

    public class MyBinder extends Binder {
        MyService getService(){
            return MyService.this;
        }
    }
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MY_SERVICE", "I am in onCreate()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MY_SERVICE", "I am in onBind()");
        return binder;
    }

    public int getRandomNumber(){
        return generator.nextInt(100);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("MY_SERVICE", "I am in onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("MY_SERVICE", "I am in onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("MY_SERVICE", "I am in onDestroy()");
        super.onDestroy();
    }
}
