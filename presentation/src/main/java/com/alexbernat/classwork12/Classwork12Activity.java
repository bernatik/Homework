package com.alexbernat.classwork12;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityClasswork12Binding;

public class Classwork12Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActivityClasswork12Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_classwork12);

        Classwork12ViewModel viewModel = new Classwork12ViewModel(this);
        this.viewModel = viewModel;

        binding.setViewModel(viewModel);
        binding.classwork12RecyclerView.setLayoutManager(new LinearLayoutManager(this));

        super.onCreate(savedInstanceState);
    }
}
