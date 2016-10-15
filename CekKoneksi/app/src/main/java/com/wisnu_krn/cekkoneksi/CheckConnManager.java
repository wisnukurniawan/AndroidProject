package com.wisnu_krn.cekkoneksi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;

/**
 * Created by private on 15/10/2016.
 */
public class CheckConnManager extends BroadcastReceiver {
    private static final String TAG = CheckConnManager.class.getSimpleName();

    public static final String PREF_NAME = "connection";
    public static final String PREF_CONN_BOOL = "connected";

    public CheckConnManager(){}

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            Log.d(TAG, "Connectivity changed");
        }
    }
}
