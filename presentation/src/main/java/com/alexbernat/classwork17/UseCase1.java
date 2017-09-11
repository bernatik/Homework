package com.alexbernat.classwork17;

/**
 * Created by Александр on 11.09.2017.
 */
public class UseCase1 {

    private Rest rest;
    private SharedPrefs sharedPrefs;

    public UseCase1(Rest rest, SharedPrefs sharedPrefs) {
        this.rest = rest;
        this.sharedPrefs = sharedPrefs;
    }

    public String getRestData(){
        return "";
    }
}
