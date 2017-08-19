package com.alexbernat.homework11;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.alexbernat.base.BaseViewModel;

/**
 * Created by Александр on 19.08.2017.
 */
public class Homework11MainActivityViewModel implements BaseViewModel {

    public enum STATE {DATA, PROGRESS};
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Activity mActivity;

    public Homework11MainActivityViewModel(Activity activity) {
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

    public void openActivityToAddProfile(View view){
        Intent intent = new Intent(mActivity, Homework11DetailActivity.class);
        intent.putExtra(Homework11DetailActivityViewModel.KEY_STATUS, true);
        mActivity.startActivity(intent);
    }
}
