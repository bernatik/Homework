package com.alexbernat.homework1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alexbernat.homework.R;

public class Homework1Activity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvUp, tvDown;
    private Button btnChange;
    private View.OnClickListener varListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             changeText();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_homework1);

        tvUp = (TextView)findViewById(R.id.text_up);
        tvDown = (TextView)findViewById(R.id.text_down);
        btnChange = (Button)findViewById(R.id.button_change);

        /* click as a variable */
        tvUp.setOnClickListener(varListener);
        /* click as an interface implemented by activity */
        tvDown.setOnClickListener(this);
        /* click as an anonymous class */
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText();
            }
        });
    }

    private void changeText(){
        String tempUp = String.valueOf(tvUp.getText());
        String tempDown = String.valueOf(tvDown.getText());
        tvUp.setText(tempDown);
        tvDown.setText(tempUp);
    }

    @Override
    public void onClick(View v) {
        changeText();
    }
}
