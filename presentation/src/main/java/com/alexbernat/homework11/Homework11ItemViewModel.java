package com.alexbernat.homework11;

import android.databinding.ObservableField;

import com.alexbernat.base.BaseItemViewModel;
import com.alexbernat.domain.entity.Homework11ProfileModel;

/**
 * Created by Александр on 20.08.2017.
 */
public class Homework11ItemViewModel extends BaseItemViewModel<Homework11ProfileModel>{

    public ObservableField<String> name = new ObservableField<>("");

    @Override
    public void setItem(Homework11ProfileModel item, int position) {
        name.set(item.getName());
    }
}
