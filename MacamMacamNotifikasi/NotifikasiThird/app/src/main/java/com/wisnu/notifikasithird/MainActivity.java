package com.wisnu.notifikasithird;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    int counter =0;
    Handler handler;
    Timer timer;
    TimerTask checkTask;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new Timer();
        handler = new Handler();
        checkDeviceStatus();
    }

    private void checkDeviceStatus() {
        timer = new Timer();
        handler = new Handler();

        checkTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        str="";
                        if (isScreenOn())
                            str+=" screen is on";
                        else
                            str+=" screen is off";
                        if (isKeyguardLocked())
                            str+=" on lockscreen";
                        else
                            str+=" not on lockscreen";
                        Log.d(TAG, "checkDeviceStatus() "+str);
                    }
                });
            }
        };
        timer.schedule(checkTask, 500, 500);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        checkTask.cancel();
        Log.d(TAG, "onDestroy()");
    }

    public boolean isScreenOn() {
        boolean retVal = false;
        retVal = ((PowerManager) getSystemService(Context.POWER_SERVICE)).isScreenOn();
        return retVal;
    }

    public boolean isKeyguardLocked() {
        boolean retVal = false;
        KeyguardManager kgMgr = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        retVal = kgMgr.inKeyguardRestrictedInputMode();
        return retVal;
    }

    public void createNotificationOnClick(View v){
        Log.d(TAG, "createNotificationOnClick()");
        if (counter<0){
            counter = 0;
        }
        //CREATE THE INTENT WITH INTENt EXTRAS
        Intent intent = new Intent(this, NotifikasiActivity.class);
        intent.putExtra(NotifikasiActivity.EXTRA_KEY1, "today is friday");
        PendingIntent pendingIntent = NotifikasiUtil.getSamplePendingIntent(this, intent, 99);
        createNotification("title:"+counter, "description:"+counter, counter, R.mipmap.ic_launcher);
        counter++;
    }

    private void createNotification(String title, String description, int notificationId, int smallIcon) {
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        //CREATE THE INTENT TO START WHEN THE NOTIFICATION IS CLICKED
        Intent intent = new Intent(this, NotifikasiActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(NotifikasiActivity.EXTRA_KEY1, "today is the day ("+notificationId+")");
        intent.putExtra(NotifikasiUtil.NOTIFICATION_ID, notificationId);

        //CREATE THE PENDING INTENT
        PendingIntent pIntent = PendingIntent.getActivity(this, counter, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Build notification
        // Actions are just fake
        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(description)
                .setSmallIcon(smallIcon)
                .setContentIntent(pIntent);
        Notification notification = notificationBuilder.build();
        // Hide the notification after its selected
        //noti.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.flags |=Notification.DEFAULT_VIBRATE;
        notification.flags |=Notification.DEFAULT_SOUND;
        notification.flags |=Notification.DEFAULT_LIGHTS;
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(notificationId, notification);
    }

    public void removeNotificationOnClick(View v){
        Log.d(TAG, "removeNotificationOnClick()");
        counter--;
        removeNotification(counter);
    }

    private void removeNotification(int notificationId) {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(notificationId);
    }


}
