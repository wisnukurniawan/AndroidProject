package com.wisnu_krn.sampleintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSub1, btnSub2, btnDial;
    private String strIntent;
    private EditText txtIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSub1 = (Button) findViewById(R.id.btn_activity_sub_1);
        btnSub2 = (Button) findViewById(R.id.btn_activity_sub_2);
        btnDial = (Button) findViewById(R.id.btn_activity_dial);

        txtIntent = (EditText) findViewById(R.id.text_Intent);

        btnSub1.setOnClickListener(this);
        btnSub2.setOnClickListener(this);
        btnDial.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_activity_sub_1:
                Intent intent = new Intent(MainActivity.this, Sub1Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_activity_sub_2:
                strIntent = txtIntent.getText().toString();
                Intent intent2 = new Intent(MainActivity.this, Sub2Activity.class);
                intent2.putExtra(Sub2Activity.KEY_DATA, strIntent);
                startActivityForResult(intent2, 0);
                break;
            case R.id.btn_activity_dial:
                Intent intent3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:082121212093"));
                startActivity(intent3);
                break;
        }
    }
}
