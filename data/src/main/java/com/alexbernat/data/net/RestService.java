package com.alexbernat.data.net;

import com.alexbernat.data.entity.AccessTokenData;
import com.alexbernat.data.entity.Profile;
import com.alexbernat.data.entity.RegisterData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Александр on 16.08.2017.
 */
public class RestService {

    private static final RestService instance = new RestService();

    private RestApi restApi;

    private RestService(){
        init();
    }

    public static RestService getInstance(){
        return instance;
    }

    private void init(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(); //для логов при запросах
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient okHttpClient = new OkHttpClient.Builder() //низкоуровневый клиент
                .readTimeout(10, TimeUnit.SECONDS)  //время для чтения запроса
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        Gson gson = new GsonBuilder().create(); //парсер json

        Retrofit retrofit = new Retrofit.Builder()
                /* базовая ссылка для запроса (одинаковая для разных запросов к одному и тому же серверу */
                .baseUrl("https://api.backendless.com/70E26EEB-3ACD-601D-FF12-541F239F8800/FDBEBFDC-2C3B-E045-FF00-D718E4134700/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //в каком виде должны приходить данные (в виде RxJava)
                .addConverterFactory(GsonConverterFactory.create(gson)) //чем будем конертировать данные
                .client(okHttpClient)//какой http-клиент используем
                .build();

        restApi = retrofit.create(RestApi.class); //создание объекта, который будет осуществлять все запросы к серверу
    }

    public Observable<List<Profile>> getProfiles(){
        return restApi.getProfiles();
    }

    public Observable<Void> saveProfile(Profile profile){
        return restApi.saveProfile(profile);
    }

    public Observable<AccessTokenData> register(RegisterData registerData){

        //TODO: change to real request
        AccessTokenData accessTokenData = new AccessTokenData();
        accessTokenData.setAccessToken("my lovely token");
        return Observable.just(accessTokenData);
    }
}
