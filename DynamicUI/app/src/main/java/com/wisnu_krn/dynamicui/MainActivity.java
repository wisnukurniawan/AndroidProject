package com.wisnu_krn.dynamicui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupClickListener(R.id.dynamicUiBook);
        setupClickListener(R.id.android4NewBook);
        setupClickListener(R.id.androidSysDevBook);
        setupClickListener(R.id.androidEngineBook);
        setupClickListener(R.id.androidDbProgBook);
    }

    private void setupClickListener(int childViewId) {
        View childView = findViewById(childViewId);
        childView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int bookDescriptionResourceId = 0;

        switch (id) {
            case R.id.dynamicUiBook:
                bookDescriptionResourceId = R.string.dynamicUIDescription ;
                break;
            case R.id.android4NewBook:
                bookDescriptionResourceId = R.string.android4NewDescription ;
                break;
            case R.id.androidSysDevBook:
                bookDescriptionResourceId = R.string.androidSysDevDescription ;
                break;
            case R.id.androidEngineBook:
                bookDescriptionResourceId = R.string.androidEngineDescription ;
                break;
            case R.id.androidDbProgBook:
                bookDescriptionResourceId = R.string.androidDbProgDescription ;
                break;
        }
        if(bookDescriptionResourceId != 0) {
            TextView bookDescriptionTextView = (TextView) findViewById(R.id.bookDescription);
            bookDescriptionTextView.setText(bookDescriptionResourceId);
        }
    }
}
