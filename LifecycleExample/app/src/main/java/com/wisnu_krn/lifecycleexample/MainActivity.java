package com.wisnu_krn.lifecycleexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pemberitahuan("OnCreate Jalan", 0, 50);
    }

    @Override
    protected void onStart() {
        super.onStart();
        pemberitahuan("OnStart Jalan", 0, 100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pemberitahuan("OnResume Jalan", 0, 150);
    }

    @Override
    protected void onPause() {
        super.onPause();
        pemberitahuan("OnPause Jalan", 0, 200);
    }

    @Override
    protected void onStop() {
        super.onStop();
        pemberitahuan("OnStop Jalan", 0, 250);
    }

    @Override
    protected void onDestroy() {
        super.onStop();
        pemberitahuan("OnDestroy Jalan", 0, 300);
    }

    private void pemberitahuan(String pesan, int posX, int posY) {
        Toast toast = Toast.makeText(this, pesan,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, posX, posY);
        toast.show();
    }
}
