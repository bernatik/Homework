package com.alexbernat.classwork18;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.alexbernat.homework.R;

/**
 * Created by Александр on 13.09.2017.
 */
public class Classwork18Activity extends AppCompatActivity {

    View mView;
    Button mButton1, mButton2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork18);

        Toolbar toolbar = (Toolbar)findViewById(R.id.classwork18_toolbar);

        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.leak_canary_icon);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.classwork18_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
