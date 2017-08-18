package com.alexbernat.classwork12;

import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import com.alexbernat.base.BaseViewModel;
import com.alexbernat.domain.entity.ProfileModel;
import com.alexbernat.domain.interaction.GetProfileListUseCase;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Александр on 18.08.2017.
 */
public class Classwork12ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private GetProfileListUseCase getProfileListUseCase = new GetProfileListUseCase();

    private Activity activity;

    public ProfileAdapter adapter = new ProfileAdapter(activity);

    public Classwork12ViewModel(Activity activity){
        this.activity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        getProfileListUseCase.execute(null, new DisposableObserver<List<? extends ProfileModel>>() {
            @Override
            public void onNext(@NonNull List<? extends ProfileModel> profileModels) {
                Log.e("AAA", "items = " + profileModels.size());
                adapter.setItems((List<ProfileModel>) profileModels);
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


}
