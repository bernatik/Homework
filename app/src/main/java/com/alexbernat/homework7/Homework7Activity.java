package com.alexbernat.homework7;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ActivityHomework7Binding;

public class Homework7Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHomework7Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework7);

        User user = new User(
                "https://img0.etsystatic.com/109/1/6221024/il_340x270.971295056_qc51.jpg",
                "Alexander",
                "Bernat",
                28,
                0);

        binding.setUser(user);

    }
}
