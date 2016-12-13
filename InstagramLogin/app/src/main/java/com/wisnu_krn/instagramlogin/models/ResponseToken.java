package com.wisnu_krn.instagramlogin.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by private on 07/12/2016.
 */

public class ResponseToken {
    @SerializedName("access_token") private String token;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
