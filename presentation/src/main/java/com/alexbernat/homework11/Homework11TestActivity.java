package com.alexbernat.homework11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alexbernat.data.entity.Homework11Profile;
import com.alexbernat.data.net.Homework11RestService;
import com.alexbernat.homework.R;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class Homework11TestActivity extends AppCompatActivity {

    TextView name, surname, age;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework11_test);


        name = (TextView)findViewById(R.id.name);
        surname = (TextView)findViewById(R.id.surname);
        age = (TextView)findViewById(R.id.age);


        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Homework11Profile profile = new Homework11Profile();
//                profile.setName(name.getText().toString());
//                profile.setSurname(surname.getText().toString());
//                profile.setAge(Integer.parseInt(age.getText().toString()));

                Homework11RestService.getInstance().getListProfiles()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(new DisposableObserver<List<Homework11Profile>>() {
                            @Override
                            public void onNext(@NonNull List<Homework11Profile> homework11Profiles) {
                                StringBuilder builder = new StringBuilder();
                for (Homework11Profile profileModel: homework11Profiles){
                                    builder.append(profileModel.getName());
                                }
                                name.setText(builder.toString());
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                }
        });
    }
}
