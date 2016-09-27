package com.wisnu_krn.intentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }
    private Intent mIntent;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                mIntent = new Intent(this, ServiceExample.class);
                startService(mIntent);
                break;
            case R.id.button2:
                mIntent = new Intent(this, ServiceExample.class);
                stopService(mIntent);
                break;
        }

    }
}
