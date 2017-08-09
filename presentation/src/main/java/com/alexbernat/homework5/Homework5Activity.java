package com.alexbernat.homework5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alexbernat.homework.R;

/**
 * Created by Александр on 03.08.2017.
 */

public class Homework5Activity extends Activity {

    public static final String HOMEWORK5_ACTION = "com.alexbernat.homework5.HOMEWORK5_ACTION";
    Intent serviceIntent;
    MyActionBroadcast broadcast;
    boolean isWifiConnected;
    TextView tvWifi;

    public class MyActionBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            isWifiConnected = intent.getBooleanExtra(Homework5Service.KEY_WIFI_STATUS, false);
            if (isWifiConnected)
                tvWifi.setText("Wifi ON");
            else
                tvWifi.setText("Wifi OFF");
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);
        serviceIntent = new Intent(this, Homework5Service.class);

        tvWifi = (TextView) findViewById(R.id.text_homework5);

        broadcast = new MyActionBroadcast();

    }

    @Override
    protected void onStart() {
        startService(serviceIntent);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Homework5Activity.HOMEWORK5_ACTION);
        registerReceiver(broadcast, filter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(serviceIntent);
        unregisterReceiver(broadcast);
    }

}
