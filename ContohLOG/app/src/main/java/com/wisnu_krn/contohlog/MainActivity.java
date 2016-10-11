package com.wisnu_krn.contohlog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButton;
    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;

    final String TAG = "Lihat nilai : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.see_log_button);
        mTextView1 = (TextView) findViewById(R.id.menu_item_1);
        mTextView2 = (TextView) findViewById(R.id.menu_item_2);
        mTextView3 = (TextView) findViewById(R.id.menu_item_3);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.see_log_button :
                //metode
                seeLog();
                break;
        }
    }

    void seeLog(){
        String text1 = mTextView1.getText().toString();
        String text2 = mTextView2.getText().toString();
        String text3 = mTextView3.getText().toString();
        Log.v(TAG, text1);
        Log.v(TAG, text2);
        Log.v(TAG, text3);
        Log.i("EnterpriseActivity.java", "Captain's Log, Stardate 43125.8. We have entered a spectacular binary star system in the Kavis Alpha sector on a most critical mission of astrophysical research.");
    }
}
