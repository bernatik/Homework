package com.alexbernat.classwork8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.alexbernat.base.BaseActivity;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityClasswork8Binding;

public class Classwork8Activity extends BaseActivity {

    public static void show(Activity activity){
        Intent intent = new Intent(activity, Classwork8Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Classwork8ViewModel viewModel = new Classwork8ViewModel(this);
        this.viewModel = viewModel;

        ActivityClasswork8Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_classwork8);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
