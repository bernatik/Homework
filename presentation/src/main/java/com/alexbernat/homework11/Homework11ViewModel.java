package com.alexbernat.homework11;

import android.app.Activity;
import android.databinding.ObservableField;

import com.alexbernat.base.BaseViewModel;

/**
 * Created by Александр on 19.08.2017.
 */
public class Homework11ViewModel implements BaseViewModel {

    public enum STATE {DATA, PROGRESS};
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Activity mActivity;

    public Homework11ViewModel(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void init() {

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
