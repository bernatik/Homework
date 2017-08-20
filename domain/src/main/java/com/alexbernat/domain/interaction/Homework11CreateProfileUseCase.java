package com.alexbernat.domain.interaction;

import com.alexbernat.data.entity.Homework11Profile;
import com.alexbernat.data.net.Homework11RestService;
import com.alexbernat.domain.entity.Homework11ProfileModel;
import com.alexbernat.domain.interaction.base.UseCase;

import io.reactivex.Observable;

/**
 * Created by Александр on 20.08.2017.
 */
public class Homework11CreateProfileUseCase extends UseCase<Homework11ProfileModel, Void> {

    @Override
    protected Observable<Void> buildUseCase(Homework11ProfileModel homework11ProfileModel) {

        Homework11Profile profile = new Homework11Profile();
        profile.setName(homework11ProfileModel.getName());
        profile.setSurname(homework11ProfileModel.getSurname());
        profile.setAge(homework11ProfileModel.getAge());

        return Homework11RestService.getInstance().createProfile(profile);
    }
}
