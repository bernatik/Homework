package com.alexbernat.homework14;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityHomework14Binding;

public class Homework14Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActivityHomework14Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework14);

        Homework14ViewModel viewModel = new Homework14ViewModel(this);
        binding.setViewModel(viewModel);
        this.viewModel = viewModel;

        super.onCreate(savedInstanceState);
    }
}
