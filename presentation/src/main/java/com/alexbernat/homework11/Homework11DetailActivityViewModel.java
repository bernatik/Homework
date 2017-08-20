package com.alexbernat.homework11;

import android.app.Activity;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.Toast;

import com.alexbernat.base.BaseViewModel;
import com.alexbernat.domain.entity.Homework11ProfileModel;
import com.alexbernat.domain.interaction.Homework11CreateProfileUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Александр on 19.08.2017.
 */
public class Homework11DetailActivityViewModel implements BaseViewModel {

    public static final String KEY_STATUS = "status";
    public boolean isAddStatus = false;

    /* fields to map profile model */
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableField<String> age = new ObservableField<>("");

    private Activity mActivity;

    private Homework11CreateProfileUseCase createProfileUseCase = new Homework11CreateProfileUseCase();

    public Homework11DetailActivityViewModel(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void init() {
        isAddStatus = mActivity.getIntent().getBooleanExtra(KEY_STATUS, false);
    }

    @Override
    public void release() {
        createProfileUseCase.dispose();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void doAction(View view){
        Homework11ProfileModel profileModel = new Homework11ProfileModel();
        profileModel.setName(name.get());
        profileModel.setSurname(surname.get());
        profileModel.setAge(Integer.parseInt(age.get()));

        if (isAddStatus){
            createProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
                @Override
                public void onNext(@NonNull Void aVoid) {
                    Toast.makeText(mActivity, "Profile created", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(@NonNull Throwable e) {
                }

                @Override
                public void onComplete() {
                }
            });
        }
    }




}
