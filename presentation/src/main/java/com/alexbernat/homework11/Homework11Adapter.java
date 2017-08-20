package com.alexbernat.homework11;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alexbernat.base.BaseAdapter;
import com.alexbernat.base.BaseItemViewHolder;
import com.alexbernat.domain.entity.Homework11ProfileModel;

/**
 * Created by Александр on 20.08.2017.
 */
public class Homework11Adapter extends BaseAdapter<Homework11ProfileModel, Homework11ItemViewModel> {

    @Override
    public BaseItemViewHolder<Homework11ProfileModel, Homework11ItemViewModel, ?> onCreateViewHolder(ViewGroup parent, int viewType) {
        Homework11ItemViewModel itemViewModel = new Homework11ItemViewModel();
        return Homework11ItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}
