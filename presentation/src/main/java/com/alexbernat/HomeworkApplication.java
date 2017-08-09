package com.alexbernat;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Александр on 30.07.2017.
 */

public class HomeworkApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }
}
