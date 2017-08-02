package com.alexbernat.classwork5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
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
        return null;
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
