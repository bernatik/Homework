package com.alexbernat.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.alexbernat.classwork2.Classwork2Activity;
import com.alexbernat.classwork3.Classwork3Activity;
import com.alexbernat.classwork4.Classwork4Activity;
import com.alexbernat.classwork5.Classwork5Activity;
import com.alexbernat.homework.R;
import com.alexbernat.homework1.Homework1Activity;
import com.alexbernat.homework2.Homework2Activity;
import com.alexbernat.homework3.Homework3Activity;
import com.alexbernat.homework4.Homework4Activity;
import com.alexbernat.homework5.Homework5Activity;

/**
 * Created by Александр on 26.07.2017.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHomework1 = (Button)findViewById(R.id.button_homework1);
        btnHomework1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Homework1Activity.class);
                startActivity(intent);
            }
        });

        Button btnClasswork2 = (Button)findViewById(R.id.button_classwork2);
        btnClasswork2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Classwork2Activity.class));
            }
        });

        Button btnHomework2 = (Button)findViewById(R.id.button_homework2);
        btnHomework2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework2Activity.class));
            }
        });

        Button btnClasswork3 = (Button)findViewById(R.id.button_classwork3);
        btnClasswork3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Classwork3Activity.class));
            }
        });

        Button btnHomework3 = (Button)findViewById(R.id.button_homework3);
        btnHomework3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework3Activity.class));
            }
        });

        Button btnClasswork4 = (Button)findViewById(R.id.button_classwork4);
        btnClasswork4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Classwork4Activity.class));
            }
        });

        Button btnHomework4 = (Button)findViewById(R.id.button_homework4);
        btnHomework4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework4Activity.class));
            }
        });

        Button btnClasswork5 = (Button)findViewById(R.id.button_classwork5);
        btnClasswork5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Classwork5Activity.class));
            }
        });

        Button btnHomework5 = (Button)findViewById(R.id.button_homework5);
        btnHomework5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework5Activity.class));
            }
        });
    }
}
