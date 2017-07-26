package com.alexbernat.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.alexbernat.homework.R;
import com.alexbernat.homework1.Homework1Activity;

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
    }
}
