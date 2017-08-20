package com.alexbernat.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Александр on 20.08.2017.
 */
public class Homework11Profile implements DataModel {

    @SerializedName("name")
    private String name;

    @SerializedName("surname")
    private String surname;

    @SerializedName("age")
    private int age;

    @SerializedName("objectId")
    private String stringId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }
}
