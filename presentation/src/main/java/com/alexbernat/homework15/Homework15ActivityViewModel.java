package com.alexbernat.homework15;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alexbernat.base.BaseViewModel;
import com.alexbernat.domain.entity.Country;
import com.alexbernat.domain.entity.User;
import com.alexbernat.domain.interaction.AddUserToDatabaseUseCase;
import com.alexbernat.domain.interaction.GetLastUserFromDatabaseUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Александр on 09.09.2017.
 */
public class Homework15ActivityViewModel  implements BaseViewModel {

    Homework15Activity activity;

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> country = new ObservableField<>();
    public ObservableField<String> age = new ObservableField<>();

    private AddUserToDatabaseUseCase addUserUseCase = new AddUserToDatabaseUseCase();
    private GetLastUserFromDatabaseUseCase getLastUserUseCase = new GetLastUserFromDatabaseUseCase();

    public Homework15ActivityViewModel(Homework15Activity activity) {
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


    }

    @Override
    public void pause() {

    }

    public void addUserToDatabase(View view){
        /* read User from edit text fields*/
        User user = new User();
        user.setName(name.get());
        user.setAge(Integer.parseInt(age.get()));
        Country country = new Country();
        country.setName(country.getName());
        user.setCountry(country);

        addUserUseCase.setContext(activity);
        addUserUseCase.execute(user, new DisposableObserver<Long>() {
            @Override
            public void onNext(@NonNull Long aLong) {
                Toast.makeText(activity, "User saved. Id = " + aLong, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getUserFromDatabase(View view){
        Log.e("onClick", "load user");
        getLastUserUseCase.setContext(activity);
        getLastUserUseCase.execute(4, new DisposableObserver<User>() {
            @Override
            public void onNext(@NonNull User user) {
                Log.e("onNext", "user name = " + user.getName());
                if (user != null) {
                    name.set(user.getName());
                    age.set(String.valueOf(user.getAge()));
                    country.set(user.getCountry().getName());
                }
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
