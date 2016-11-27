package com.wisnu_krn.retrofit2.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by private on 25/11/2016.
 */
//body untuk ngepost
public class LoginRequestModel {
    @SerializedName("username")
    public String username;

    @SerializedName("password")
    public String password;

    @SerializedName("pushbots_token")
    public String pushbotsToken;

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

    public String getPushbotsToken() {
        return pushbotsToken;
    }

    public void setPushbotsToken(String pushbotsToken) {
        this.pushbotsToken = pushbotsToken;
    }
}
