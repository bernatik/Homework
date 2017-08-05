package com.alexbernat.homework5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.alexbernat.homework.R;

/**
 * Created by Александр on 03.08.2017.
 */

public class Homework5Activity extends Activity {

    Intent serviceIntent;
    final String LOG_TAG = "Homework5Activity";

    TextView tvWifi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);
        serviceIntent = new Intent(this, Homework5Service.class);

        tvWifi = (TextView)findViewById(R.id.text_homework5);

    }

    @Override
    protected void onStart() {
      startService(serviceIntent);
        Log.e(LOG_TAG, "Service Started and bind to it!");
        super.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
        stopService(serviceIntent);
        Log.e(LOG_TAG, "Service unbind!");
    }

    }
