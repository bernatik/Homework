package com.alexbernat.classwork12;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alexbernat.base.BaseAdapter;
import com.alexbernat.base.BaseItemViewHolder;
import com.alexbernat.domain.entity.ProfileModel;

/**
 * Created by Александр on 18.08.2017.
 */
public class ProfileAdapter extends BaseAdapter<ProfileModel, ProfileItemViewModel> {

    @Override
    public BaseItemViewHolder<ProfileModel, ProfileItemViewModel, ?> onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
        return ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }


}
