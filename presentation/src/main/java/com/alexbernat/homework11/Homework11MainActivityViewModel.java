package com.alexbernat.homework11;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.alexbernat.base.BaseViewModel;
import com.alexbernat.domain.entity.Homework11ProfileModel;
import com.alexbernat.domain.interaction.Homework11GetProfileListUseCase;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Александр on 19.08.2017.
 */
public class Homework11MainActivityViewModel implements BaseViewModel {

    public enum STATE {DATA, PROGRESS};
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Homework11GetProfileListUseCase getProfileListUseCase = new Homework11GetProfileListUseCase();

    public Homework11Adapter adapter = new Homework11Adapter();

    private Activity mActivity;

    public Homework11MainActivityViewModel(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {
        getProfileListUseCase.dispose();
    }

    @Override
    public void resume() {
        getProfileListUseCase.execute(null, new DisposableObserver<List<Homework11ProfileModel>>() {
            @Override
            public void onNext(@NonNull List<Homework11ProfileModel> homework11ProfileModels) {
                adapter.setItems(homework11ProfileModels);
                adapter.notifyDataSetChanged();
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void pause() {

    }

    public void openActivityToAddProfile(View view){
        Intent intent = new Intent(mActivity, Homework11DetailActivity.class);
        intent.putExtra(Homework11DetailActivityViewModel.KEY_STATUS, true);
        mActivity.startActivity(intent);
    }

    public Homework11Adapter getAdapter() {
        return adapter;
    }
}
