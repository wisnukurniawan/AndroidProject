package com.wisnu_krn.cekkoneksi;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_1) TextView mTextView;
    @BindView(R.id.text_2) TextView mTextView2;
    @BindView(R.id.text_3) TextView mTextView3;

    @BindView(R.id.button_1)
    Button mButton;

    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTV();
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
                boolean isWifi = false;
                mTextView.setText("is Conected?" + String.valueOf(isConnected));

                if (isConnected && networkInfo.getType() == connectivityManager.TYPE_WIFI){
                    isWifi = true;
                    Ping ping = new Ping(new Ping.PingCallback() {
                        @Override
                        public void getConnection(Boolean isConnected) {
                            mTextView3.setText("Really connected wifi? " + String.valueOf(isConnected));
                        }
                    });
                    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD){
                        ping.execute();
                    } else {
                        ping.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    }
                }
                mTextView2.setText("is Wifi? "+ String.valueOf(isWifi));
            }
        });
//            String hasil;
//            connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//            networkInfo = connectivityManager.getActiveNetworkInfo();
//            if (networkInfo != null && networkInfo.isConnectedOrConnecting()){
//                hasil = "tersambung";
//            } else {
//                hasil = "terputus";
//            }
//            mTextView.setText(hasil);

    }

    private void resetTV() {
        mTextView.setText("");
        mTextView2.setText("");
        mTextView3.setText("");
    }

}
