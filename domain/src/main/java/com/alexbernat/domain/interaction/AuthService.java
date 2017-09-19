package com.alexbernat.domain.interaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.alexbernat.domain.entity.AuthState;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Александр on 19.09.2017.
 */

@Singleton
public class AuthService {

    private Context context;

    private static final String KEY_ACCESS_TOKEN = "accessToken";
    private static final String SHARED_PREFERENCE = "sharedPrefs";

    private BehaviorSubject<AuthState> state = BehaviorSubject
            .createDefault(new AuthState(false));

    @Inject
    public AuthService(Context context){
        restoreAccessToken();
        this.context = context;
    }

    private void restoreAccessToken() {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE);

        String token = sharedPreferences.getString(KEY_ACCESS_TOKEN, null);

        if (!TextUtils.isEmpty(token))
            state.onNext(new AuthState(true));
        else
            state.onNext(new AuthState(false));
    }

    void saveAccessToken(String accessToken){
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE);

        sharedPreferences.edit()
                .putString(KEY_ACCESS_TOKEN, accessToken)
                .apply();

        state.onNext(new AuthState(true));
    }

    void removeAccessToken(){
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE);

        sharedPreferences.edit()
                .remove(KEY_ACCESS_TOKEN)
                .apply();

        state.onNext(new AuthState(false));
    }

    public Observable<AuthState> observeState(){
        return state;
    }



}
