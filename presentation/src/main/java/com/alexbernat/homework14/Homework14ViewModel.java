package com.alexbernat.homework14;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.util.Log;

import com.alexbernat.base.BaseViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Александр on 09.09.2017.
 */
public class Homework14ViewModel implements BaseViewModel{

    private Homework14Activity activity;
    private ArrayList<Country> countries = new ArrayList<>();
    private SpinnerAdapter adapter;
    public static final String KEY_COUNTRY = "country";
    public static final String PREFS_NAME = "myPrefs";
    SharedPreferences preferences;

    public Homework14ViewModel(Homework14Activity activity) {
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
    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        preferences = activity.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String savedCode = preferences.getString(KEY_COUNTRY, "default");
        //find country by code
        Country country = getCountryByCode(savedCode);
        String savedCountryName = country.getName();

        for (int i = 0; i < countries.size(); i++){
            if (countries.get(i).getName().equals(savedCountryName)) {
                activity.spinner.setAdapter(adapter);
                activity.spinner.setSelection(i, true);
                Log.e("loop", "selected position is " + i);
                break;
            }
        }

        Log.e("on Resume", "Open code = " + savedCode + "; country = " + country.getName());
    }

    @Override
    public void pause() {

        int position = activity.spinner.getSelectedItemPosition();
        preferences = activity.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_COUNTRY, countries.get(position).getCode());
        editor.apply();
        Log.e("onPause", "save code = " + countries.get(position).getCode());
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
