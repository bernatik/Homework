package com.alexbernat.homework11;

import android.app.Activity;

import com.alexbernat.base.BaseViewModel;

/**
 * Created by Александр on 19.08.2017.
 */
public class Homework11DetailActivityViewModel implements BaseViewModel {

    public static final String KEY_STATUS = "status";
    public boolean isAddStatus = false;

//    public enum STATE {EDIT, CREATE};
//    public ObservableField<STATE> state = new ObservableField<>(STATE.EDIT);

    private Activity mActivity;

    public Homework11DetailActivityViewModel(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void init() {
        isAddStatus = mActivity.getIntent().getBooleanExtra(KEY_STATUS, false);
    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
