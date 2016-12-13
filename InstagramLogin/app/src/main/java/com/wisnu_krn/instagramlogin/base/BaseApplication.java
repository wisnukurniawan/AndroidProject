package com.wisnu_krn.instagramlogin.base;

import android.app.Application;

import com.wisnu_krn.instagramlogin.BuildConfig;

import timber.log.Timber;

/**
 * Created by private on 07/12/2016.
 */

public class BaseApplication extends Application {
    @Override public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }
}