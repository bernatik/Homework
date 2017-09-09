package com.alexbernat.classwork16;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alexbernat.homework.R;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;

/**
 * Created by Александр on 08.09.2017.
 */
public class Classwork16Activity extends Activity{

    private Realm realm;
    private EditText mEditText;
    private TextView mTextView;
    private Button mButton;
    private UserDb user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork16);

        mButton = (Button)findViewById(R.id.classwork16_button);
        mEditText = (EditText)findViewById(R.id.classwork16_editText);
        mTextView = (TextView)findViewById(R.id.classwork16_text);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        realm = Realm.getDefaultInstance();
        loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (user != null) user.removeAllChangeListeners();
        realm.close();
    }

    private void saveData(){
        if (user == null){
            user = new UserDb();
            user.setId(10);
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(user);
            realm.commitTransaction();
        }

        // save user into database as one transaction
        realm.beginTransaction();
        user.setName(mEditText.getText().toString());
        realm.commitTransaction();
    }

    private void loadData(){

        user = realm.where(UserDb.class)
                .equalTo("id", 10)
                .findFirst();

        if (user != null){
            mEditText.setText(user.getName());

            // loaded user made observable
            user.addChangeListener(new RealmChangeListener<RealmModel>() {
                @Override
                public void onChange(RealmModel realmModel) {
                    Log.e("AAAA", "user changed");
                    mEditText.setText(user.getName());
                }
            });
        }
    }
}
