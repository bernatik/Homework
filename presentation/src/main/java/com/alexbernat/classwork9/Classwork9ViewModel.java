package com.alexbernat.classwork9;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.alexbernat.base.BaseViewModel;
import com.alexbernat.domain.entity.ProfileId;
import com.alexbernat.domain.entity.ProfileModel;
import com.alexbernat.domain.interaction.ProfileUseCase;
import com.alexbernat.domain.interaction.SaveProfileUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Александр on 11.08.2017.
 */
public class Classwork9ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    public ObservableField<String> name = new ObservableField<>("Hello");
    public ObservableField<String> surname = new ObservableField<>("Hello");
    public ObservableInt age = new ObservableInt(28);

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    public Activity activity;

    private ProfileUseCase useCase = new ProfileUseCase();
    private SaveProfileUseCase saveUseCase = new SaveProfileUseCase();

    public Classwork9ViewModel(Activity activity) {
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
        ProfileId profileId = new ProfileId();
        profileId.setId("123");
        useCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profile) {
                name.set(profile.getName());
                surname.set(profile.getSurname());
                age.set(profile.getAge());
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", "error = " + e);
            }

            @Override
            public void onComplete() {

            }
        });

        ProfileModel profileModel = new ProfileModel();
        profileModel.setAge(28);
        profileModel.setName("Sasha");
        profileModel.setSurname("Bernat");
        saveUseCase.execute(profileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.e("AAA", "OK");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", "error = " + e);
            }

            @Override
            public void onComplete() {
                Log.e("AAA", "Profile Saved");
            }
        });


    }

    @Override
    public void pause() {
        useCase.dispose();
        saveUseCase.dispose();
    }

}
