package com.alexbernat.homework10;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityHomework10Binding;

public class Homework10Activity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Homework10ViewModel homework10ViewModel = new Homework10ViewModel(this);
        this.viewModel = homework10ViewModel;

        ActivityHomework10Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework10);

        binding.setViewModel(homework10ViewModel);

        super.onCreate(savedInstanceState);
    }
}
