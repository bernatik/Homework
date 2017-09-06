package com.alexbernat.domain.interaction;

import android.content.Context;

import com.alexbernat.data.database.DatabaseManager;
import com.alexbernat.data.dbentity.Country;
import com.alexbernat.domain.entity.User;
import com.alexbernat.domain.interaction.base.UseCase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Александр on 06.09.2017.
 */
public class AddUserToDatabaseUseCase extends UseCase<User, String>{

    private Context mContext;

    @Override
    protected Observable<String> buildUseCase(final User param) {

        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                DatabaseManager databaseManager = new DatabaseManager(mContext);
                databaseManager.open(true);
                User user = new User();
                databaseManager.insertUser(convertUser(user));
                databaseManager.close();
            }
        }).just("OK");
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    private com.alexbernat.data.dbentity.User convertUser(User user){
        com.alexbernat.data.dbentity.User dbUser = new com.alexbernat.data.dbentity.User();
        dbUser.setId(user.getId());
        dbUser.setName(user.getName());
        dbUser.setAge(user.getAge());
        dbUser.setCountry(convertCountry(user.getCountry()));
        return dbUser;
    }

    private Country convertCountry(com.alexbernat.domain.entity.Country country){
        Country dbCountry = new Country();
        dbCountry.setId(country.getId());
        dbCountry.setName(country.getName());
        return dbCountry;
    }
}
