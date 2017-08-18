package com.alexbernat.classwork12;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alexbernat.base.BaseItemViewHolder;
import com.alexbernat.domain.entity.ProfileModel;
import com.alexbernat.homework.databinding.ItemClasswork12Binding;

/**
 * Created by Александр on 18.08.2017.
 */
public class ProfileItemViewHolder extends BaseItemViewHolder<ProfileModel,
                                                    ProfileItemViewModel,
                                                    ItemClasswork12Binding> {


    public ProfileItemViewHolder(ItemClasswork12Binding dataBinding, ProfileItemViewModel viewModel) {
        super(dataBinding, viewModel);
        dataBinding.setViewModel(viewModel);
    }

    public static ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent, ProfileItemViewModel viewModel){
        ItemClasswork12Binding binding = ItemClasswork12Binding.inflate(inflater, parent, false);
        return new ProfileItemViewHolder(binding, viewModel);
    }

}
