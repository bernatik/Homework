package com.alexbernat.homework11;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityHomework11MainBinding;

public class Homework11MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Homework11MainActivityViewModel viewModel = new Homework11MainActivityViewModel(this);
        this.viewModel = viewModel;

        ActivityHomework11MainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework11_main);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
