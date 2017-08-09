package com.alexbernat.homework3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.alexbernat.homework.BuildConfig;
import com.alexbernat.homework.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Александр on 28.07.2017.
 */

public class Homework3Activity extends Activity {

    private boolean isShowMode = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework3);

        final EditText etLink = (EditText)findViewById(R.id.edit_text_homework3);
        etLink.setText(BuildConfig.API_ENDPOINT);
        final ImageView ivPicture = (ImageView)findViewById(R.id.image_view_homework3);
        final Button btnShowImage = (Button)findViewById(R.id.button_show_homework3);
        btnShowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShowMode) {
                    btnShowImage.setText(getResources().getString(R.string.button_homework3_hide));
                    Glide.with(getApplicationContext())
                            .load(etLink.getText().toString())
                            /* add circle form and placeholder if current image wasn't loaded */
                            .apply(RequestOptions.circleCropTransform())
                            .apply(RequestOptions.errorOf(R.drawable.money))
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
