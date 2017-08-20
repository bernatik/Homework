package com.alexbernat.data.net;

import com.alexbernat.data.entity.Homework11Profile;
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
import retrofit2.http.Body;
import retrofit2.http.Query;

/**
 * Created by Александр on 20.08.2017.
 */
public class Homework11RestService implements Homework11RestApi {

    private static final Homework11RestService instance = new Homework11RestService();

    private Homework11RestApi restApi;

    private Homework11RestService(){
        init();
    }

    public static Homework11RestService getInstance(){
        return instance;
    }

    private void init(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/B01F8453-331C-7929-FF78-8926FB02B100/364307A4-AB5D-87D3-FF7B-E18E07AA8200/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build();

        restApi = retrofit.create(Homework11RestApi.class);
    }



    @Override
    public Observable<List<Homework11Profile>> getListProfiles() {
        return restApi.getListProfiles();
    }

    @Override
    public Observable<Homework11Profile> getProfileById(@Query("id") String id) {
        return restApi.getProfileById(id);
    }

    @Override
    public Observable<Void> createProfile(@Body Homework11Profile profile) {
        return restApi.createProfile(profile);
    }

    @Override
    public Observable<Void> editProfile(@Query("id") String objectId, @Body Homework11Profile profile) {
        return restApi.editProfile(objectId, profile);
    }
}
