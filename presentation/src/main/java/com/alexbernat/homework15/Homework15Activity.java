package com.alexbernat.homework15;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Spinner;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityHomework15Binding;

/**
 * Created by Александр on 09.09.2017.
 */
public class Homework15Activity extends BaseActivity {

    Spinner mSpinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        ActivityHomework15Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework15);

        Homework15ActivityViewModel viewModel = new Homework15ActivityViewModel(this);
        binding.setViewModel(viewModel);
        this.viewModel = viewModel;

        mSpinner = binding.homework15Spinner;
        super.onCreate(savedInstanceState);
    }
}
