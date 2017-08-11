package com.alexbernat.classwork9;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.alexbernat.base.BaseViewModel;
import com.alexbernat.domain.entity.Profile;
import com.alexbernat.domain.entity.ProfileId;
import com.alexbernat.domain.interaction.ProfileUseCase;

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
        Profile profile = useCase.execute(profileId);

        name.set(profile.getName());
        surname.set(profile.getSurname());
        age.set(profile.getAge());

        state.set(STATE.DATA);
    }

    @Override
    public void pause() {

    }

}
