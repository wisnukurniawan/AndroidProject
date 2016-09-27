package com.wisnu_krn.intentstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        if(v == mButton){
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }
}
