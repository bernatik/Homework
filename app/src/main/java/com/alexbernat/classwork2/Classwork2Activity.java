package com.alexbernat.classwork2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alexbernat.homework.R;
import com.alexbernat.homework1.Homework1Activity;

/**
 * Created by Александр on 26.07.2017.
 */

public class Classwork2Activity extends Activity {

    private EditText etName, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2);

        etName = (EditText)findViewById(R.id.edit_text_name);
        etPassword = (EditText)findViewById(R.id.edit_text_password);
        btnLogin = (Button)findViewById(R.id.button_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Classwork2Activity.this, Homework1Activity.class));
            }
        });
    }
}
