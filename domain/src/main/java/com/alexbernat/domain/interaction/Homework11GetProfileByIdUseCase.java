package com.alexbernat.domain.interaction;

import com.alexbernat.data.entity.Homework11Profile;
import com.alexbernat.data.net.Homework11RestService;
import com.alexbernat.domain.entity.Homework11ProfileModel;
import com.alexbernat.domain.interaction.base.UseCase;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Александр on 20.08.2017.
 */
public class Homework11GetProfileByIdUseCase extends UseCase<String, Homework11ProfileModel> {

    @Override
    protected Observable<Homework11ProfileModel> buildUseCase(String s) {
        return Homework11RestService.getInstance().getProfileById(s)
                .map(new Function<Homework11Profile, Homework11ProfileModel>() {
                    @Override
                    public Homework11ProfileModel apply(@NonNull Homework11Profile profile) throws Exception {
                        Homework11ProfileModel profileModel = new Homework11ProfileModel();
                        profileModel.setName(profile.getName());
                        profileModel.setSurname(profile.getSurname());
                        profileModel.setAge(profile.getAge());
                        profileModel.setStringId(profile.getStringId());
                        return profileModel;
                    }
                });
    }
}
