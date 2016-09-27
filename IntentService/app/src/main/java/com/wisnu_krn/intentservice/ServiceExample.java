package com.wisnu_krn.intentservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by private on 27/09/2016.
 */

public class ServiceExample extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"Service Dibuat",300).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"task perform di service", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
