package com.alexbernat.data.net;

import com.alexbernat.data.entity.Profile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Александр on 16.08.2017.
 */
public interface RestApi {

    @GET("data/profile") //эта часть прибавится к базовому URL для осуществления запроса
    Observable<List<Profile>> getProfiles(); //{id} сверху принимает нашу строку id

    @POST("data/profile")
    Observable<Void> saveProfile(@Body Profile profile); //body означает , что профиль конвертируется в json и отправляется в теле запроса
}
