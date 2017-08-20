package com.alexbernat.homework11;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alexbernat.base.BaseItemViewHolder;
import com.alexbernat.domain.entity.Homework11ProfileModel;
import com.alexbernat.homework.databinding.ItemHomework11Binding;

/**
 * Created by Александр on 20.08.2017.
 */
public class Homework11ItemViewHolder extends BaseItemViewHolder <Homework11ProfileModel, Homework11ItemViewModel , ItemHomework11Binding> {


    public Homework11ItemViewHolder(ItemHomework11Binding dataBinding, Homework11ItemViewModel viewModel) {
        super(dataBinding, viewModel);
        dataBinding.setViewModel(viewModel);
    }

    public static Homework11ItemViewHolder create(LayoutInflater layoutInflater, ViewGroup parent, Homework11ItemViewModel viewModel){
        ItemHomework11Binding binding = ItemHomework11Binding.inflate(layoutInflater, parent, false);
        return new Homework11ItemViewHolder(binding, viewModel);
    }
}
