package com.alexbernat.domain.interaction;

import com.alexbernat.data.entity.Profile;
import com.alexbernat.domain.entity.ProfileModel;
import com.alexbernat.domain.entity.ProfileId;
import com.alexbernat.domain.interaction.base.UseCase;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by Александр on 11.08.2017.
 */
public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {

    @Override
    protected Observable<ProfileModel> buildUseCase() {

        //запрос к слою data , где будет осуществлсять запрос на сервер (базу данных)

        //создаем объект Profile который лежит в дата слое
        // это для теста, в будущем этот объект нам вернет слой дата
        Profile profile = new Profile();
        profile.setAge(28);
        profile.setName("Sasha");
        profile.setSurname("Bernat");

        return Observable.just(profile)
                .filter(new Predicate<Profile>() {
                    @Override
                    public boolean test(@NonNull Profile profile) throws Exception {
                        return profile.getName() != null;
                    }
                })
                .map(new Function<Profile, ProfileModel>() { //преобразуем то, что пришло со слоя дата в то, что пойдет в слой презентер
                    @Override
                    public ProfileModel apply(@NonNull Profile profile) throws Exception {
                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setAge(profile.getAge());
                        profileModel.setName(profile.getName());
                        profileModel.setSurname(profile.getSurname());
                        return profileModel;
                    }
                })
                .delay(3, TimeUnit.SECONDS);
    }
}
