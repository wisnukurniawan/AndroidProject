package com.wisnu_krn.cumanjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textViewPesan = (TextView) findViewById(R.id.textView_pesan);
        String receivePesan = getIntent().getStringExtra("pesan");
        textViewPesan.setText(receivePesan);
    }
}
