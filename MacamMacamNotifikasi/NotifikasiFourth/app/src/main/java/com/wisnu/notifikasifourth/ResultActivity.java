package com.wisnu.notifikasifourth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String message = getIntent().getStringExtra(CommonConstants.EXTRA_MESSAGE);
        TextView text = (TextView) findViewById(R.id.result_message);
        text.setText(message);
    }

    public void onSnoozeClick(View v) {
        Intent intent = new Intent(getApplicationContext(), NotificationService.class);
        intent.setAction(CommonConstants.ACTION_SNOOZE);
        startService(intent);
        finish();
    }

    public void onDismissClick(View v) {
        Intent intent = new Intent(getApplicationContext(), NotificationService.class);
        intent.setAction(CommonConstants.ACTION_DISMISS);
        startService(intent);
        finish();
    }
}
