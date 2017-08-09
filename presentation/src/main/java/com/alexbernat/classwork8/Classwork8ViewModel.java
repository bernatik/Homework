package com.alexbernat.classwork8;

import android.app.Activity;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.util.Log;

import com.alexbernat.base.BaseViewModel;

/**
 * Created by Александр on 09.08.2017.
 */
public class Classwork8ViewModel implements BaseViewModel{

    public ObservableField<String> helloText = new ObservableField<>("Hello");

    public Activity activity;

    public Classwork8ViewModel(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {

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

    public void onSuperButtonClick(){
        Log.e("VIEW MODEL", "Click Button");
        Classwork8Activity.show(activity);
    }

    public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //UI поток До вызова doInBackground()
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //выполняется в UI потоке
            //нужно самостоятельно вызывать из doInBackground()
        }

        @Override
        protected Void doInBackground(Void... params) {
            // отдельный поток
            publishProgress(20); //вызвать метод onProgressUpdate
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // UI поток, после doInBackground()
        }
    }

}
