package com.alexbernat.homework4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.alexbernat.homework.R;

public class Homework4TempActivity extends Activity {

    AnimationDrawable sovaAnimation;
    private boolean isAnimationActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4_temp);

        ImageView ivSova = (ImageView)findViewById(R.id.image_sova);
        ivSova.setBackgroundResource(R.drawable.sova_drawable_animation);
        sovaAnimation = (AnimationDrawable)ivSova.getBackground();

        ivSova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAnimationActive) {
                    sovaAnimation.stop();
                    isAnimationActive = false;
                } else {
                    sovaAnimation.start();
                    isAnimationActive = true;
                }
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        sovaAnimation.start();
        isAnimationActive = true;
    }
}
