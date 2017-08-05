package com.alexbernat.homework5;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.alexbernat.homework.R;

/**
 * Created by Александр on 03.08.2017.
 */

public class Homework5Activity extends Activity {

    final String LOG_TAG = "Homework5Activity";
    Intent serviceIntent;
    boolean isBound;
    TextView tvWifi;

    /* messenger to send the first request from activity to service */
    Messenger msgService;
    /* our messenger that will receive messages from the service */
    Messenger replyMessenger = new Messenger(new HandlerReplyMsg());

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isBound = true;
            msgService = new Messenger(service);
            sendMessage();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);
        serviceIntent = new Intent(this, Homework5Service.class);

        tvWifi = (TextView) findViewById(R.id.text_homework5);

    }

    @Override
    protected void onStart() {
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
        Log.e(LOG_TAG, "Service Started and bind to it!");
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
        stopService(serviceIntent);
        Log.e(LOG_TAG, "Service unbind!");
    }

    public void sendMessage() {
        if (isBound) {
            try {
                /* create a message to the service */
                Message message = Message.obtain(null, Homework5Service.MESSAGE, 1, 1);
                /* "register" this activity as a receiver for replies */
                message.replyTo = replyMessenger;
                /* send message to the service */
                msgService.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    class HandlerReplyMsg extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String receivedMessage = msg.obj.toString(); //msg received from service
            tvWifi.setText(receivedMessage);
        }
    }

}
