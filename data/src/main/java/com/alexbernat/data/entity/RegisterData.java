package com.alexbernat.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Александр on 19.09.2017.
 */
public class RegisterData implements DataModel {

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
