package com.alexbernat.homework11;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityHomework11Binding;

public class Homework11Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Homework11ViewModel viewModel = new Homework11ViewModel(this);
        this.viewModel = viewModel;

        ActivityHomework11Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework11);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
