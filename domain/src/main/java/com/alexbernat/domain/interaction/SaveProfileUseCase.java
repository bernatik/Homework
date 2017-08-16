package com.alexbernat.domain.interaction;

import com.alexbernat.data.entity.Profile;
import com.alexbernat.data.net.RestService;
import com.alexbernat.domain.entity.ProfileModel;
import com.alexbernat.domain.interaction.base.UseCase;

import io.reactivex.Observable;

/**
 * Created by Александр on 11.08.2017.
 */
public class SaveProfileUseCase extends UseCase<ProfileModel, Void> {

    @Override
    protected Observable<Void> buildUseCase(ProfileModel param) {

        Profile profileData = new Profile();
        profileData.setName(param.getName());
        profileData.setSurname(param.getSurname());
        profileData.setAge(param.getAge());

        return RestService.getInstance().saveProfile(profileData); // Приходит Observable из Retrofit

    }
}
