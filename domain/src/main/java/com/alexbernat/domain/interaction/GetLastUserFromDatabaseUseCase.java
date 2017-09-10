package com.alexbernat.domain.interaction;

import android.content.Context;
import android.util.Log;

import com.alexbernat.data.database.DatabaseManager;
import com.alexbernat.data.dbentity.Country;
import com.alexbernat.domain.entity.User;
import com.alexbernat.domain.interaction.base.UseCase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Александр on 09.09.2017.
 */
public class GetLastUserFromDatabaseUseCase extends UseCase<Integer, User> {

    private Context mContext;

    @Override
    protected Observable<User> buildUseCase(final Integer id) {
        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<User> e) throws Exception {
                Log.e("subscribe", "inside method");
                DatabaseManager databaseManager = new DatabaseManager(mContext);
                databaseManager.open(false);

                com.alexbernat.data.dbentity.User dbUser = databaseManager.getUserById(id);
                databaseManager.close();
                if (dbUser != null) {
                    Log.e("emitter", "user != null");
                    e.onNext(convertUser(dbUser));
                    e.onComplete();
                }
                else {
                    Log.e("emitter", "user = null");
                    e.onError(new Throwable("user with id = " + id + " is not found"));
                }
            }
        });
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    private User convertUser(com.alexbernat.data.dbentity.User user){
        User domainUser = new User();
        domainUser.setId(user.getId());
        domainUser.setName(user.getName());
        domainUser.setAge(user.getAge());
        domainUser.setCountry(convertCountry(user.getCountry()));
        return domainUser;
    }

    private com.alexbernat.domain.entity.Country convertCountry(Country country){
        com.alexbernat.domain.entity.Country domainCountry = new com.alexbernat.domain.entity.Country();
        domainCountry.setCode(country.getCode());
//        domainCountry.setName(country.getName());
        return domainCountry;
    }
}
