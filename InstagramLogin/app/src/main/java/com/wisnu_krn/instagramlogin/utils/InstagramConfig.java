package com.wisnu_krn.instagramlogin.utils;

/**
 * Created by private on 07/12/2016.
 */

public class InstagramConfig {
    public static final String CLIENT_ID = "CLIENT_ID";
    public static final String CLIENT_SECRET = "CLIENT_SECRET";
    public static final String CALLBACK_URL = "http://callback.id";
    public static final String INSTA_AUTHORIZATION_URL =
            "https://instagram.com/oauth/authorize/?"
                    + "client_id=" + CLIENT_ID
                    + "&redirect_uri=" + CALLBACK_URL
                    + "&response_type=code"
                    + "&scope=likes+comments";
}