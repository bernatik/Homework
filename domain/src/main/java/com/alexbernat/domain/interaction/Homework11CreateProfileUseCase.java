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
public class Homework11CreateProfileUseCase extends UseCase<Homework11ProfileModel, String> {

    @Override
    protected Observable<String> buildUseCase(Homework11ProfileModel homework11ProfileModel) {

        Homework11Profile profile = new Homework11Profile();
        profile.setName(homework11ProfileModel.getName());
        profile.setSurname(homework11ProfileModel.getSurname());
        profile.setAge(homework11ProfileModel.getAge());

        return Homework11RestService.getInstance().createProfile(profile)
                .map(new Function<Void, String>() {
                    @Override
                    public String apply(@NonNull Void aVoid) throws Exception {
                        return "User created";
                    }
                });
    }
}
