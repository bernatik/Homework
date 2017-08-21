package com.alexbernat.homework11;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alexbernat.base.BaseViewModel;
import com.alexbernat.domain.entity.Homework11ProfileModel;
import com.alexbernat.domain.interaction.Homework11CreateProfileUseCase;
import com.alexbernat.domain.interaction.Homework11GetProfileByIdUseCase;
import com.alexbernat.domain.interaction.Homework11UpdateProfileUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

import static com.alexbernat.homework11.Homework11DetailActivityViewModel.STATE.EDIT;
import static com.alexbernat.homework11.Homework11DetailActivityViewModel.STATE.SAVE;

/**
 * Created by Александр on 19.08.2017.
 */
public class Homework11DetailActivityViewModel implements BaseViewModel {

    public static final String KEY_ITEM_TO_EDIT = "item_id";

    public enum STATE {EDIT, ADD, SAVE}

    public ObservableField<STATE> state = new ObservableField<>(STATE.ADD);

    /* fields to map profile model */
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableField<String> age = new ObservableField<>("");
    public ObservableField<String> objectId = new ObservableField<>("");

    private Activity mActivity;

    private Homework11CreateProfileUseCase createProfileUseCase = new Homework11CreateProfileUseCase();
    private Homework11GetProfileByIdUseCase getProfileByIdUseCase = new Homework11GetProfileByIdUseCase();
    private Homework11UpdateProfileUseCase updateProfileUseCase = new Homework11UpdateProfileUseCase();

    public Homework11DetailActivityViewModel(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void init() {
        Intent intent = mActivity.getIntent();
        if (intent != null && intent.hasExtra(KEY_ITEM_TO_EDIT)) {
            state.set(EDIT);
            objectId.set(intent.getStringExtra(KEY_ITEM_TO_EDIT));
            Log.e("AAA", "Click on item " + objectId.get());
        }
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {
        getProfileById();
    }

    @Override
    public void pause() {

    }

    public void doAction(View view){

        /* check all fields to have a value */
        if (hasEmptyFields()) {
            Toast.makeText(mActivity, "Fill all fields!", Toast.LENGTH_LONG).show();
            return;
        }

        /* create a profile model to put into retrofit query */
        final Homework11ProfileModel profileModel = new Homework11ProfileModel();
        profileModel.setName(name.get());
        profileModel.setSurname(surname.get());
        profileModel.setAge(Integer.valueOf(age.get()));
        profileModel.setStringId(objectId.get());

        switch (state.get()){
            case ADD:

                createNewProfile(profileModel);
                break;

            case EDIT:

                state.set(SAVE); //make edit enabled
                return;

            case SAVE:

                updateCurrentProfile(profileModel);
                break;
        }

        mActivity.startActivity(new Intent(mActivity, Homework11MainActivity.class));
        mActivity.finish();
    }

    private void getProfileById(){
        getProfileByIdUseCase.execute(objectId.get(), new DisposableObserver<Homework11ProfileModel>() {
            @Override
            public void onNext(@NonNull Homework11ProfileModel homework11ProfileModel) {
                name.set(homework11ProfileModel.getName());
                surname.set(homework11ProfileModel.getSurname());
                age.set(String.valueOf(homework11ProfileModel.getAge()));
                Log.e("AAA", "name is " + homework11ProfileModel.getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    private void createNewProfile(Homework11ProfileModel profileModel){
        createProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.e("AAAA", "Create new profile");
                Toast.makeText(mActivity.getApplicationContext(), "Profile created", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    private void updateCurrentProfile(final Homework11ProfileModel profileModel){
        updateProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.e("AAA", "Update profile with objectId: " + profileModel.getStringId());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private boolean hasEmptyFields(){
        if (TextUtils.isEmpty(name.get())||
                TextUtils.isEmpty(surname.get()) ||
                TextUtils.isEmpty(age.get()))
            return true;
        return false;
    }

}
