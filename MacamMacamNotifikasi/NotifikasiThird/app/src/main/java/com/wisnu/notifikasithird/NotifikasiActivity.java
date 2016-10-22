package com.wisnu.notifikasithird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotifikasiActivity extends AppCompatActivity {
    public static final String TAG = "NotificationActivity";
    TextView textView ;
    public static final String EXTRA_KEY1 = "extraKey1";
    String tag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        textView = (TextView) findViewById(R.id.texView);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (getIntent()!=null &&
                (getIntent().getStringExtra(NotifikasiActivity.EXTRA_KEY1)!=null
                        && getIntent().getStringExtra(NotifikasiActivity.EXTRA_KEY1).equalsIgnoreCase("")==false)){
            tag = getIntent().getStringExtra(NotifikasiActivity.EXTRA_KEY1);
            textView.setText("intent extra: [id:"+getIntent().getIntExtra(NotifikasiUtil.NOTIFICATION_ID, -1)+" key:"+NotifikasiActivity.EXTRA_KEY1+" value:"+tag+"]");
        } else {
            textView.setText("intent extra: [id:"+getIntent().getIntExtra(NotifikasiUtil.NOTIFICATION_ID, -1)+" key:"+NotifikasiActivity.EXTRA_KEY1+" value:null/empty]");
        }

    }
}
