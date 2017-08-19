package com.alexbernat.homework11;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityHomework11DetailBinding;

/**
 * Created by Александр on 19.08.2017.
 */
public class Homework11DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Homework11DetailActivityViewModel viewModel = new Homework11DetailActivityViewModel(this);
        this.viewModel = viewModel;

        ActivityHomework11DetailBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework11_detail);
        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
