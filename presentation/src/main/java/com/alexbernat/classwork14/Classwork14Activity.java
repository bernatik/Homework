package com.alexbernat.classwork14;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alexbernat.homework.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Classwork14Activity extends AppCompatActivity {

    @BindView(R.id.classwork14_button)
    Button mButton;

    @BindView(R.id.classwork14_editText)
    EditText mEditText;

    SharedPreferences preferences;
    private static final String SHARED_PREF_NAME = "name";
    private static final String SHARED_PREF_KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork14);

        ButterKnife.bind(this);

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE); //название файла и приватность

        String string = preferences.getString(SHARED_PREF_KEY, null);
        mEditText.setText(string);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save
                preferences.edit()
                        .putString(SHARED_PREF_KEY, mEditText.getText().toString())
                        .apply();
            }
        });

    }
}
