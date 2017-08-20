package com.alexbernat.domain.interaction;

import com.alexbernat.data.entity.Homework11Profile;
import com.alexbernat.data.net.Homework11RestService;
import com.alexbernat.domain.entity.Homework11ProfileModel;
import com.alexbernat.domain.interaction.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Александр on 20.08.2017.
 */
public class Homework11GetProfileListUseCase extends UseCase<Void, List<Homework11ProfileModel>> {

    @Override
    protected Observable<List<Homework11ProfileModel>> buildUseCase(Void aVoid) {
        return Homework11RestService.getInstance().getListProfiles()
                .map(new Function<List<Homework11Profile>, List<Homework11ProfileModel>>() {
                    @Override
                    public List<Homework11ProfileModel> apply(@NonNull List<Homework11Profile> homework11Profiles) throws Exception {
                        List<Homework11ProfileModel> newList = new ArrayList<Homework11ProfileModel>();
                        for (Homework11Profile profile: homework11Profiles){
                            Homework11ProfileModel profileModel = new Homework11ProfileModel();
                            profileModel.setName(profile.getName());
                            profileModel.setSurname(profile.getSurname());
                            profileModel.setAge(profile.getAge());
                            newList.add(profileModel);
                        }
                        return newList;
                    }
                });
    }
}
