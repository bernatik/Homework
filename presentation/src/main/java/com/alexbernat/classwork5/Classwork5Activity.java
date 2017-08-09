package com.alexbernat.classwork5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alexbernat.homework.R;

public class Classwork5Activity extends Activity {

    private TextView text;
    private TextView textNumber;
    private Button btnGetNumber;
    private int i;

    MyService boundService;
    boolean isBound = false;

    private BroadcastReceiver receiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {

            i++;
            text.setText("i = " + i);
            Log.e("Classwork5Activity", "onReceive()");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork5);
        text = (TextView)findViewById(R.id.text_classwork5);
        textNumber = (TextView)findViewById(R.id.text_classwork5_number);
        btnGetNumber = (Button)findViewById(R.id.button_claswork5);

//        startService(new Intent(this, MyService.class));

        Intent intentForIntentService = new Intent(Classwork5Activity.this, MyIntentService.class);
        intentForIntentService.putExtra(MyIntentService.KEY_ACTION, "Задание 0");
        startService(intentForIntentService);
        Intent intentForIntentService2 = new Intent(Classwork5Activity.this, MyIntentService.class);
        intentForIntentService2.putExtra(MyIntentService.KEY_ACTION, "Задание 1");
        startService(intentForIntentService2);
        Intent intentForIntentService3 = new Intent(Classwork5Activity.this, MyIntentService.class);
        intentForIntentService3.putExtra(MyIntentService.KEY_ACTION, "Задание 2");
        startService(intentForIntentService3);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                stopService(new Intent(Classwork5Activity.this, MyService.class));
            }
        });

        btnGetNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound){
                    int num = boundService.getRandomNumber();
                    textNumber.setText(String.valueOf(num));
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        /* subscribe to some connectivity action sent by broadcast */
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(MyIntentService.MY_ACTION);

        LocalBroadcastManager localBroadcastManager =
                LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(receiver, intentFilter);

        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager localBroadcastManager =
                LocalBroadcastManager.getInstance(this);
        localBroadcastManager.unregisterReceiver(receiver);

        if (isBound) {
            unbindService(serviceConnection);
            isBound = false;
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("CLASSWORK5", "onServiceConnected()");
            MyService.MyBinder binder = (MyService.MyBinder)service;
            boundService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("CLASSWORK5", "onServiceDisconnected()");
            isBound = false;
        }
    };
}
