package com.alexbernat.homework3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.alexbernat.homework.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Александр on 28.07.2017.
 */

public class Homework3Activity extends Activity {

    private static final String PICTURE_URL = "https://goo.gl/yFz6m4";
    private boolean isShowMode = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework3);

        EditText etLink = (EditText)findViewById(R.id.edit_text_homework3);
        etLink.setText(PICTURE_URL);
        final ImageView ivPicture = (ImageView)findViewById(R.id.image_view_homework3);
        final Button btnShowImage = (Button)findViewById(R.id.button_show_homework3);
        btnShowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShowMode) {
                    btnShowImage.setText(getResources().getString(R.string.button_homework3_hide));
                    Glide.with(getApplicationContext())
                            .load(PICTURE_URL)
                            /* add circle form */
                            .apply(RequestOptions.circleCropTransform())
                            .into(ivPicture);
                    ivPicture.setVisibility(View.VISIBLE);
                    isShowMode = true;
                }
                else {
                    btnShowImage.setText(getResources().getString(R.string.button_homework3_load));
                    ivPicture.setVisibility(View.INVISIBLE);
                    isShowMode = false;
                }
            }
        });

    }
}