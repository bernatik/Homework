package com.alexbernat.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.alexbernat.classwork14.Classwork14Activity;
import com.alexbernat.homework.R;
import com.alexbernat.homework1.Homework1Activity;
import com.alexbernat.homework10.Homework10Activity;
import com.alexbernat.homework11.Homework11MainActivity;
import com.alexbernat.homework14.Homework14Activity;
import com.alexbernat.homework15.Homework15Activity;
import com.alexbernat.homework2.Homework2Activity;
import com.alexbernat.homework3.Homework3Activity;
import com.alexbernat.homework4.Homework4Activity;
import com.alexbernat.homework5.Homework5Activity;
import com.alexbernat.homework6.Homework6Activity;
import com.alexbernat.homework7.Homework7Activity;
import com.alexbernat.homework9.Homework9Activity;

/**
 * Created by Александр on 26.07.2017.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClasswork = (Button)findViewById(R.id.button_classwork);
        btnClasswork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Classwork14Activity.class));
            }
        });

        Button btnHomework1 = (Button)findViewById(R.id.button_homework1);
        btnHomework1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Homework1Activity.class);
                startActivity(intent);
            }
        });

        Button btnHomework2 = (Button)findViewById(R.id.button_homework2);
        btnHomework2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework2Activity.class));
            }
        });

        Button btnHomework3 = (Button)findViewById(R.id.button_homework3);
        btnHomework3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework3Activity.class));
            }
        });

        Button btnHomework4 = (Button)findViewById(R.id.button_homework4);
        btnHomework4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework4Activity.class));
            }
        });

        Button btnHomework5 = (Button)findViewById(R.id.button_homework5);
        btnHomework5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework5Activity.class));
            }
        });

        Button btnHomework6 = (Button)findViewById(R.id.button_homework6);
        btnHomework6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework6Activity.class));
            }
        });

        Button btnHomework7 = (Button)findViewById(R.id.button_homework7);
        btnHomework7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework7Activity.class));
            }
        });

        Button btnHomework9 = (Button)findViewById(R.id.button_homework9);
        btnHomework9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework9Activity.class));
            }
        });

        Button btnHomework10 = (Button)findViewById(R.id.button_homework10);
        btnHomework10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework10Activity.class));
            }
        });

        Button btnHomework11 = (Button)findViewById(R.id.button_homework11);
        btnHomework11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework11MainActivity.class));
            }
        });

        Button btnHomework14 = (Button)findViewById(R.id.button_homework14);
        btnHomework14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework14Activity.class));
            }
        });

        Button btnHomework15 = (Button)findViewById(R.id.button_homework15);
        btnHomework15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Homework15Activity.class));
            }
        });
    }
}
