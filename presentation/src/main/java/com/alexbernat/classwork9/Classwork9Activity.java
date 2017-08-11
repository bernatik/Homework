package com.alexbernat.classwork9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityClasswork9Binding;

public class Classwork9Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Classwork9ViewModel viewModel = new Classwork9ViewModel(this);
        this.viewModel = viewModel;

        ActivityClasswork9Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_classwork9);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
