package com.alexbernat.homework15;

import android.content.res.AssetManager;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alexbernat.base.BaseViewModel;
import com.alexbernat.domain.entity.Country;
import com.alexbernat.domain.entity.User;
import com.alexbernat.domain.interaction.AddUserToDatabaseUseCase;
import com.alexbernat.domain.interaction.GetLastUserFromDatabaseUseCase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Александр on 09.09.2017.
 */
public class Homework15ActivityViewModel  implements BaseViewModel {

    Homework15Activity activity;
    private SpinnerAdapter adapter;
    private ArrayList<Country> countries = new ArrayList<>();

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> age = new ObservableField<>();

    private AddUserToDatabaseUseCase addUserUseCase = new AddUserToDatabaseUseCase();
    private GetLastUserFromDatabaseUseCase getLastUserUseCase = new GetLastUserFromDatabaseUseCase();

    public Homework15ActivityViewModel(Homework15Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {
        String jsonString = getStringFromJson();
        try {
            JSONArray countriesArray = new JSONArray(jsonString);
            for (int i = 0; i<countriesArray.length(); i++){
                JSONObject jsonCountry = countriesArray.getJSONObject(i);
                Country country = new Country();
                country.setName(jsonCountry.getString("name"));
                country.setCode(jsonCountry.getString("code"));
                countries.add(country);
            }
        } catch (JSONException e){
            //NOP
        }

        adapter = new SpinnerAdapter(activity, countries);
        activity.mSpinner.setAdapter(adapter);
    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {


    }

    @Override
    public void pause() {

    }

    public void addUserToDatabase(View view){
        /* read User from edit text fields*/
        User user = new User();
        user.setName(name.get());
        user.setAge(Integer.parseInt(age.get()));

        /* get country from spinner */
        int countryPos = activity.mSpinner.getSelectedItemPosition();
        Country country = new Country();
        country.setCode(countries.get(countryPos).getCode());
        country.setName(countries.get(countryPos).getName());

        user.setCountry(country);

        addUserUseCase.setContext(activity);
        addUserUseCase.execute(user, new DisposableObserver<Long>() {
            @Override
            public void onNext(@NonNull Long aLong) {
                Toast.makeText(activity, "User saved. Id = " + aLong, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getUserFromDatabase(View view){
        Log.e("onClick", "load user");
        getLastUserUseCase.setContext(activity);
        getLastUserUseCase.execute(1, new DisposableObserver<User>() {
            @Override
            public void onNext(@NonNull User user) {
                if (user != null) {
                    Log.e("onNext", "user name = " + user.getName());
                    name.set(user.getName());
                    age.set(String.valueOf(user.getAge()));

                    Country country = getCountryByCode(user.getCountry().getCode());

                    if (country != null) {
                        for (int i = 0; i < countries.size(); i++) {
                            if (countries.get(i).getName().equals(country.getName())) {
                                activity.mSpinner.setAdapter(adapter);
                                activity.mSpinner.setSelection(i, true);
                                Log.e("loop", "selected position is " + i);
                                break;
                            }
                        }
                    }
                } else {
                    Log.e("onNext", "user is null");
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("onError", e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private String getStringFromJson(){
        AssetManager assetManager = activity.getAssets();
        String jsonString = "";
        try {
            InputStream stream = assetManager.open("countries.json");
            jsonString = convertStreamToString(stream);
            stream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return jsonString;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private Country getCountryByCode(String code){
        for (Country country: countries){
            if (country.getCode().equals(code))
                return country;
        }
        return null;
    }

    public SpinnerAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(SpinnerAdapter adapter) {
        this.adapter = adapter;
    }
}
