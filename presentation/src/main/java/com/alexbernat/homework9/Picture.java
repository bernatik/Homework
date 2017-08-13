package com.alexbernat.homework9;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Александр on 13.08.2017.
 */
public class Picture extends BaseObservable{

    public String url;

    public Picture(String url){
        this.url = url;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
