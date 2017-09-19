package com.alexbernat.datainjection;

import android.content.Context;

import com.alexbernat.classwork17.Gson;
import com.alexbernat.classwork17.OkHttp;
import com.alexbernat.classwork17.Rest;
import com.alexbernat.classwork17.SharedPrefs;
import com.alexbernat.classwork17.UseCase1;
import com.alexbernat.domain.interaction.Homework11CreateProfileUseCase;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Александр on 11.09.2017.
 */

//формируем все зависимости
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    @Named("a")
    public UseCase1 provideUseCase1(Rest rest, SharedPrefs prefs){
        return new UseCase1(rest, prefs);
    }

    @Provides
    @Singleton
    @Named("b")
    public UseCase1 provideUseCase12(Rest rest, SharedPrefs prefs){
        return new UseCase1(rest, prefs);
    }

    @Provides
    public OkHttp provideOkHttp(){
        return new OkHttp();
    }

    @Provides
    public Gson provideGson(){
       return new Gson();
    }

    @Provides
    public Rest provideRest(OkHttp okHttp, Gson gson){
        return new Rest(okHttp, gson);
    }

    @Provides
    public SharedPrefs provideSharedPrefs(){
        return new SharedPrefs();
    }

    @Provides
    public Homework11CreateProfileUseCase provideHomework11CreateProfileUseCase(){
        return new Homework11CreateProfileUseCase();
    }


}
