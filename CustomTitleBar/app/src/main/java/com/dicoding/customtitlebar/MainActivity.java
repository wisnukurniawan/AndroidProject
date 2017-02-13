package com.dicoding.customtitlebar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind view
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbarTitle = (ImageView) findViewById(R.id.toolbar_title);

        //set toolbar
        setSupportActionBar(toolbar);

        //menghilangkan title bawaan
        if (toolbar != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }
}
