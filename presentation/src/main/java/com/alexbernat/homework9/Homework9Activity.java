package com.alexbernat.homework9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityHomework9Binding;

public class Homework9Activity extends BaseActivity {

    ItemViewModel mItemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Homework9ActivityViewModel viewModel = new Homework9ActivityViewModel(this); //create viewModel for itself
        mItemViewModel = new ItemViewModel(); //create viewModel for adapter items
        mItemViewModel.init();

        this.viewModel = viewModel; //field from BaseActivity (viewModel attached to view)

        ActivityHomework9Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework9); //connect xml layout to this activity

        binding.setViewModel(viewModel); //connect this Activity with ViewModel (needs to be declared as variable in xml/data)

        binding.rvHomework9.setLayoutManager(new GridLayoutManager(this, 2)); //"install" recycler view
        binding.rvHomework9.setAdapter(new Homework9Adapter(mItemViewModel));

        super.onCreate(savedInstanceState); //start creating activity after viewModel was being attached
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mItemViewModel.release();
    }
}
