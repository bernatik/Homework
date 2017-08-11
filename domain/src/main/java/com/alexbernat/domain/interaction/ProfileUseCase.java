package com.alexbernat.domain.interaction;

import com.alexbernat.domain.entity.Profile;
import com.alexbernat.domain.entity.ProfileId;
import com.alexbernat.domain.interaction.base.UseCase;

/**
 * Created by Александр on 11.08.2017.
 */
public class ProfileUseCase extends UseCase<ProfileId, Profile> {

    @Override
    protected Profile buildUseCase() {

        Profile profile = new Profile();
        profile.setAge(28);
        profile.setName("Sasha");
        profile.setSurname("Bernat");

        return profile;
    }
}
