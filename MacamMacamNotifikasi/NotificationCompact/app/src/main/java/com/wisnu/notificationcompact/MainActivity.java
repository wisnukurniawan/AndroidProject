package com.wisnu.notificationcompact;

import android.app.Activity;
import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NOTIF_ID = 465023;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSmall = (Button) findViewById(R.id.buttonSmall);
        Button buttonLarge = (Button) findViewById(R.id.buttonLarge);
        Button buttonAction = (Button) findViewById(R.id.buttonAction);
        Button buttonSound = (Button) findViewById(R.id.buttonSound);
        Button buttonBigTextStyle = (Button) findViewById(R.id.buttonBigTextStyle);
        Button buttonBigPictureStyle = (Button) findViewById(R.id.buttonBigPictureStyle);
        Button buttonInboxStyle = (Button) findViewById(R.id.buttonInboxStyle);
        Button buttonMediaStyle = (Button) findViewById(R.id.buttonMediaStyle);

        buttonSmall.setOnClickListener(this);
        buttonLarge.setOnClickListener(this);
        buttonAction.setOnClickListener(this);
        buttonSound.setOnClickListener(this);
        buttonBigTextStyle.setOnClickListener(this);
        buttonBigPictureStyle.setOnClickListener(this);
        buttonInboxStyle.setOnClickListener(this);
        buttonMediaStyle.setOnClickListener(this);
    }

    private Activity getActivity(){
        return this;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSmall:
                sendNotificationSmallIcon(getActivity());
                break;
            case R.id.buttonLarge:
                sendNotificationLargeIcon(getActivity());
                break;
            case R.id.buttonAction:
                sendNotificationWithAction(getActivity());
                break;
            case R.id.buttonSound:
                sendNotificationWithSound(getActivity());
                break;
            case R.id.buttonBigTextStyle:
                sendNotificationBigTextStyle(getActivity());
                break;
            case R.id.buttonBigPictureStyle:
                sendNotificationBigPictureStyle(getActivity());
                break;
            case R.id.buttonInboxStyle:
                sendNotificationInboxStyle(getActivity());
                break;
            case R.id.buttonMediaStyle:
                break;
        }
    }

    private void sendNotificationBigPictureStyle(Activity activity) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        Bitmap bitmap = BitmapFactory.decodeResource(
                activity.getResources(), R.drawable.profile_luz
        );

        Bitmap big = BitmapFactory.decodeResource(
                activity.getResources(),
                R.drawable.big_picture
        );

        NotificationCompat.BigPictureStyle style = new android.support.v4.app.NotificationCompat.BigPictureStyle();
        style.bigPicture(big);
        style.setBigContentTitle("gambar baru dari Luz");
        style.setSummaryText("Science luar biasa");
        style.bigLargeIcon(bitmap);
        builder.setStyle(style);

        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIF_ID+6,notification);

    }

    private void sendNotificationInboxStyle(Activity activity) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        Bitmap profil = BitmapFactory.decodeResource(activity.getResources(),
                R.drawable.profile_manual);
        builder.setLargeIcon(profil);

        NotificationCompat.InboxStyle inboxStyle = new android.support.v4.app.NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("manuel");
        String messages = "Bro!, today Armin in Mamacona\n" +
                "State of trance, fucking holy madness\n" +
                "Goooooooooooo!";
        if (!messages.isEmpty()){
            String[] lines = messages.split("\\n");
            for (int i=0;i<lines.length;i++){
                inboxStyle.addLine(lines[i]);
            }
            inboxStyle.setSummaryText(lines.length+" new messages");
        }
        builder.setStyle(inboxStyle);
        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIF_ID+5, notification);
    }

    private void sendNotificationBigTextStyle(Activity activity) {
        Bitmap profilPicture = BitmapFactory.decodeResource(
                activity.getResources(), R.drawable.profile_carl_sagan);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        builder.setLargeIcon(profilPicture);

        NotificationCompat.BigTextStyle bigTextStyle = new android.support.v4.app.NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("Carl Sagan");
        bigTextStyle.setSummaryText("Quote of the Day");
        bigTextStyle.bigText("Science is much more than a body of knowledge.\" +\n" +
                "                \" It is a way of thinking. This is central to its success.\" +\n" +
                "                \" Science invites us to let the facts in, even when they don’t conform to our preconceptions.");
        builder.setStyle(bigTextStyle);

        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIF_ID+4, notification);

    }

    private void sendNotificationWithSound(Activity activity) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        builder.setContentTitle("Zayn");
        builder.setContentText("Out of One D");

        Bitmap bitmap = BitmapFactory.decodeResource(
                activity.getResources(), R.drawable.zayn_makik
        );
        builder.setLargeIcon(bitmap);

        Uri notifSOund = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(notifSOund);

        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIF_ID+3, notification);
    }

    private void sendNotificationWithAction(Activity activity) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        builder.setContentTitle("Minum air");
        builder.setContentText("hey wisnu jangan minum air pas puasa");

        Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.drink_water);
        builder.setLargeIcon(bitmap);

        builder.addAction(new NotificationCompat.Action(
           R.drawable.ic_notifications_off_black_24dp,"off notifikasi", null
        ));

        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIF_ID+2, notification);
    }

    private void sendNotificationLargeIcon(Activity activity) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        builder.setContentTitle("wisnu kurniawan");
        builder.setContentText("Hey, udah sahur?");
        Bitmap profil = BitmapFactory.decodeResource(activity.getResources(), R.drawable.profile_picture);
        builder.setLargeIcon(profil);
        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIF_ID+1, notification);
    }

    private void sendNotificationSmallIcon(Activity activity) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.drawable.ic_whatshot_black_24dp);
        builder.setContentTitle("Backup");
        String text  = "Waktunya nge-backup";
        builder.setContentText(text);
        Notification notification = builder.build();
        NotificationManagerCompat.from(activity).notify(NOTIF_ID, notification);
    }
}
