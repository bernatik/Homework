package com.alexbernat.classwork12;

import android.databinding.ObservableField;

import com.alexbernat.base.BaseItemViewModel;
import com.alexbernat.domain.entity.ProfileModel;

/**
 * Created by Александр on 18.08.2017.
 */
public class ProfileItemViewModel extends BaseItemViewModel<ProfileModel>{

    public ObservableField<String> name = new ObservableField<>("");

    @Override
    public void setItem(ProfileModel item, int position) {
        name.set(item.getName());
    }
}
