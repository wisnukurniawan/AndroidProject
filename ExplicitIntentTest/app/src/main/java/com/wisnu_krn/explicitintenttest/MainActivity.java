package com.wisnu_krn.explicitintenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton;
    private EditText mEditText;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1 :
                mEditText = (EditText) findViewById(R.id.editText);
                String pesan = mEditText.getText().toString();
                mIntent = new Intent(Intent.ACTION_SEND);
                mIntent.putExtra(Intent.EXTRA_TEXT, pesan);
                mIntent.setType("text/plain");
                startActivity(Intent.createChooser(mIntent,"Share via.."));
                break;
        }
    }
}
