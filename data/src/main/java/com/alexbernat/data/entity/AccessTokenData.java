package com.alexbernat.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Александр on 19.09.2017.
 */
public class AccessTokenData implements DataModel {

    @SerializedName("access-token")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
