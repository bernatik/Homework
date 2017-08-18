package com.alexbernat.domain.interaction

import com.alexbernat.data.entity.Profile
import com.alexbernat.data.net.RestService
import com.alexbernat.domain.entity.ProfileModel
import com.alexbernat.domain.interaction.base.UseCase
import io.reactivex.Observable

/**
 * Created by Александр on 18.08.2017.
 */
class GetProfileListUseCase : UseCase<Void, List<ProfileModel>>() {

    override fun buildUseCase(aVoid: Void?): Observable<List<ProfileModel>> {
        return RestService.getInstance().profiles.map {
            it.map {
                convert(it)
            }
        }
    }

    private fun convert(dataModel: Profile): ProfileModel {
        val profileModel = ProfileModel();
        profileModel.name = dataModel.name
        profileModel.surname = dataModel.surname
        profileModel.age = dataModel.age
        return profileModel
    }

}
