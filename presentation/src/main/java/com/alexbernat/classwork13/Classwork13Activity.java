package com.alexbernat.classwork13;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.alexbernat.homework.R;

public class Classwork13Activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork13);

        showFragment(getSupportFragmentManager(), Classwork13Fragment.newInstance(getSupportFragmentManager(), "lol"), false);

        Button btn1 = (Button) findViewById(R.id.classwork13_button1);
        Button btn2 = (Button) findViewById(R.id.classwork13_button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(), Classwork13Fragment.newInstance(getSupportFragmentManager(), "lol"), true);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(), new Classwork13FragmentTwo(), true);
            }
        });
    }

    public static void showFragment(FragmentManager manager, Fragment fragment, boolean addToBackStack){

        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.classwork13_container, fragment, fragment.getClass().getName());
        if (addToBackStack)fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
