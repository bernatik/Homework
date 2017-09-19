package com.alexbernat.classwork21;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alexbernat.classwork18.Classwork18Activity;
import com.alexbernat.homework.R;

/**
 * Created by Александр on 19.09.2017.
 */
public class RegisterActivity extends AppCompatActivity implements RegisterView{

    private RegisterBasePresenter presenter;
    private ProgressBar progressBar;
    private Button registerButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_classwork21);

        presenter = new RegisterPresenter(this);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        registerButton = (Button)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRegisterButtonClick("username", "password");
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(this, Classwork18Activity.class);
        startActivity(intent);
    }
}
