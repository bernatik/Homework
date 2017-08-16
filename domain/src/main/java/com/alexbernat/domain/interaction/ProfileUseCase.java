package com.alexbernat.domain.interaction;

import com.alexbernat.data.entity.Profile;
import com.alexbernat.data.net.RestService;
import com.alexbernat.domain.entity.ProfileId;
import com.alexbernat.domain.entity.ProfileModel;
import com.alexbernat.domain.interaction.base.UseCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Александр on 11.08.2017.
 */
public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {

    @Override
    protected Observable<ProfileModel> buildUseCase(ProfileId param) {

        return RestService.getInstance().getProfiles() // Приходит Observable из Retrofit
                .map(new Function<List<Profile>, ProfileModel>() { //преобразуем то, что пришло со слоя дата в то, что пойдет в слой презентер
                    @Override
                    public ProfileModel apply(@NonNull List<Profile> profiles) throws Exception {

                        Profile profileData = profiles.get(0);

                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setAge(profileData.getAge());
                        profileModel.setName(profileData.getName());
                        profileModel.setSurname(profileData.getSurname());
                        return profileModel;
                    }
                })
                .delay(3, TimeUnit.SECONDS);
    }
}
