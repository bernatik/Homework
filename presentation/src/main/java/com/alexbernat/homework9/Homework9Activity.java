package com.alexbernat.homework9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityHomework9Binding;

public class Homework9Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Homework9ActivityViewModel viewModel = new Homework9ActivityViewModel(this); //create viewModel for itself

        this.viewModel = viewModel; //field from BaseActivity (viewModel attached to view)

        ActivityHomework9Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework9); //connect xml layout to this activity

        binding.setViewModel(viewModel); //connect this Activity with ViewModel (needs to be declared as variable in xml/data)

        super.onCreate(savedInstanceState); //start creating activity after viewModel was being attached
    }
}
