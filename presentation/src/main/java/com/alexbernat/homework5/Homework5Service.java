package com.alexbernat.homework5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Александр on 05.08.2017.
 */

public class Homework5Service extends Service {

    final String LOG_TAG = "Homework5Service";
    public static final String KEY_WIFI_STATUS = "status";
    public static final String WIFI_ON = "Wifi ON";
    public static final String WIFI_OFF = "Wifi OFF";
    WifiReceiver wifiReceiver;
    boolean isWifiConnected;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        /* create and register receiver to get wifi status */
        wifiReceiver = new WifiReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(wifiReceiver, filter);
        Log.e(LOG_TAG, "onCreate() Service - register receiver");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(wifiReceiver);
        Log.e(LOG_TAG, "onDestroy() - unregister receiver");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class WifiReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            /* check wifi connection and send it to the main activity */
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                Log.e(LOG_TAG, "onReceive() - WIFI CONNECTED!");
                isWifiConnected = true;
            } else {
                Log.e(LOG_TAG, "onReceive() - WIFI DISCONNECTED!");
                isWifiConnected = false;
            }

            Intent intentToActivity = new Intent(Homework5Activity.HOMEWORK5_ACTION);
            intentToActivity.putExtra(KEY_WIFI_STATUS, isWifiConnected);
            sendBroadcast(intentToActivity);

        }
    }
}

