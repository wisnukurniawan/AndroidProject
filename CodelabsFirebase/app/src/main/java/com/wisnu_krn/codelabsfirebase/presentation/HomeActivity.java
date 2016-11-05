package com.wisnu_krn.codelabsfirebase.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wisnu_krn.codelabsfirebase.R;

public class HomeActivity extends AppCompatActivity {

    private FloatingActionButton fabHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabHome = (FloatingActionButton) findViewById(R.id.fabHome);
        fabHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 05/11/2016  navigate add activity
                //startActivityForResult(new Intent(HomeActivity.this, AddActivity.class), 1);

            }
        });
    }
}

//html parser jsoup