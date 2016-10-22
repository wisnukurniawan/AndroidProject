package com.wisnu.notificationsecond;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.normal).setOnClickListener(this);
        findViewById(R.id.aksi).setOnClickListener(this);
        findViewById(R.id.bigview).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.normal:
                showNormalNotifikasi(this);
                break;
            case  R.id.aksi:
                showNotifikasiWithAksi();
                break;
            case R.id.bigview:
                showNotifikasiBigView();
                break;
        }
    }

    private void showNotifikasiBigView() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Judul");
        builder.setContentText("Deskripsi");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        NotificationCompat.InboxStyle inboxStyle = new android.support.v4.app.NotificationCompat.InboxStyle();
        String[] events = new String[6];
        events[0] = new String("First line....");
        events[1] = new String("Second line...");
        events[2] = new String("Third line...");
        events[3] = new String("4th line...");
        events[4] = new String("5th line...");
        events[5] = new String("6th line...");

        inboxStyle.setBigContentTitle("Judul BIG");

        for (int i=0;i<events.length;i++){
            inboxStyle.addLine(events[i]);
        }

        builder.setStyle(inboxStyle);
        NotificationManagerCompat.from(this).notify(3, builder.build());


    }

    private void showNotifikasiWithAksi() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Judul");
        builder.setContentText("Deskripsi");

        Intent intent = new Intent(this, ActionActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
        NotificationCompat.Action action = new android.support.v4.app.NotificationCompat.Action(R.mipmap.ic_launcher, "Open Action", pendingIntent);
        builder.addAction(action);

        Intent intent1 = new Intent(this,SettingActivity.class);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 0, intent1, 0);
        builder.setContentIntent(pendingIntent1);

        NotificationManagerCompat.from(this).notify(2, builder.build());

    }

    private void showNormalNotifikasi(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Judul");
        builder.setContentText("Deskripsi");

        NotificationManagerCompat.from(context).notify(1, builder.build());
    }


}
