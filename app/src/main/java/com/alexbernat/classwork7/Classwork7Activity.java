package com.alexbernat.classwork7;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;

import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityClasswork7Binding;

public class Classwork7Activity extends Activity {

    public ObservableField<String> myText = new ObservableField<>("initial text"); //переменная, котрую можно отслеживать из xml кода

    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityClasswork7Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_classwork7);

        binding.setActivity(this); //в переменную activity в xml заносим эту активити



    }

    @Override
    protected void onResume() {
        super.onResume();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<10; i++){
                    final int a = i;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            myText.set(String.valueOf(a));
                        }
                    });
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
