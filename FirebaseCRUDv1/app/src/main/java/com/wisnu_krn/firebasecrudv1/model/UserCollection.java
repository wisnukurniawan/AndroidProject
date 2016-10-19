package com.wisnu_krn.firebasecrudv1.model;

import java.util.ArrayList;

/**
 * Created by private on 19/10/2016.
 */

public class UserCollection {

    public static ArrayList<User> getUsers() {
        return users;
    }

    static ArrayList<User> users = new ArrayList<>();

}
