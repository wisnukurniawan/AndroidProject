package com.wisnu.notifikasithird;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by private on 19/06/2016.
 */
public class NotifikasiUtil {
    public static final String NOTIFICATION_ID = "notificationId";
    public static void createNotification(
            Activity activity,
            int notificationIdTag,
            String title,
            String message,
            int notificationIconDrawable,
            PendingIntent pendingIntent){
        //get notifikasi manager
        NotificationManager notificationManager = (NotificationManager) activity.getSystemService(Activity.NOTIFICATION_SERVICE);

        //membangun notifikasi
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(activity)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(notificationIconDrawable)
                .setContentIntent(pendingIntent);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();

        notification.flags |=Notification.DEFAULT_VIBRATE;
        notification.flags |=Notification.DEFAULT_SOUND;
        notification.flags |=Notification.DEFAULT_LIGHTS;
        notification.flags |=Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(notificationIdTag, notification);
    }

    public static void removeNotification(Activity activity, int notificationIdTag){
        NotificationManager notificationManager = (NotificationManager) activity.getSystemService(Activity.NOTIFICATION_SERVICE);
        notificationManager.cancel(notificationIdTag);
    }

    public static PendingIntent getSamplePendingIntent(Activity activity, Intent intent, int requestCode){
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(activity, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }
}
