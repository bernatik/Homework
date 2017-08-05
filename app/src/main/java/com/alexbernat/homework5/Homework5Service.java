package com.alexbernat.homework5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alexbernat.homework.R;

/**
 * Created by Александр on 05.08.2017.
 */

public class Homework5Service extends Service {

    /* id for message from an activity */
    public static final int MESSAGE = 1;
    final String LOG_TAG = "Homework5Service";
    WifiReceiver wifiReceiver;
    boolean isWifiConnected;
    /* messenger to send wifi status to bounded activity */
    Messenger replyMessenger;
    /* to receive incoming messages */
    Messenger messenger = new Messenger(new IncomingHandler());

    @Override
    public void onCreate() {
        super.onCreate();

        /* create and register receiver to get wifi status */
        wifiReceiver = new WifiReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(wifiReceiver, filter);

        Log.e(LOG_TAG, "onCreate() Service - register receiver");
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(wifiReceiver);
        Log.e(LOG_TAG, "onDestroy() - unregister receiver");
        super.onDestroy();
    }

    private void sendWifiStatusToActivity() {

        if (replyMessenger != null)
            try {
                Message message = new Message();
                String wifiStatus;
                if (isWifiConnected)
                    wifiStatus = getResources().getString(R.string.text_homework5_on);
                else
                    wifiStatus = getResources().getString(R.string.text_homework5_off);
                message.obj = wifiStatus;
                replyMessenger.send(message);//replying / sending msg to activity
            } catch (RemoteException e) {
                e.printStackTrace();
            }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
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
                sendWifiStatusToActivity();
            } else {
                Log.e(LOG_TAG, "onReceive() - WIFI DISCONNECTED!");
                isWifiConnected = false;
                sendWifiStatusToActivity();
            }
        }
    }

    /* This class handle messages from activity (it needs to obtain a reference to
        activity messenger)
     */
    class IncomingHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {

            if (msg.what == MESSAGE) {
                replyMessenger = msg.replyTo; //"register" activity Messenger as a receiver for
                sendWifiStatusToActivity(); //need to send the first message to show text view in activity
            }
        }
    }
}

