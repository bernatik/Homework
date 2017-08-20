package com.alexbernat.data.net;

import com.alexbernat.data.entity.Homework11Profile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Александр on 20.08.2017.
 */
public interface Homework11RestApi {

    @GET("data/profiles")
    Observable<List<Homework11Profile>> getListProfiles();

    @GET("data/profiles/{id}")
    Observable<Homework11Profile> getProfileById(@Query("id") String id);

    @POST("data/profiles")
    Observable<Void> createProfile(@Body Homework11Profile profile);

    @POST("data/profiles/{id}")
    Observable<Void> editProfile(@Query("id") String objectId);
}
