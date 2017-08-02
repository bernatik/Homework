package com.alexbernat.homework4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alexbernat.homework.R;

public class Homework4Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4);

        Button btnNewActivity = (Button)findViewById(R.id.button_homework4_start_new_activity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homework4Activity.this, Homework4TempActivity.class));
                overridePendingTransition(R.anim.appearance, R.anim.disappearance);
            }
        });
    }
}
