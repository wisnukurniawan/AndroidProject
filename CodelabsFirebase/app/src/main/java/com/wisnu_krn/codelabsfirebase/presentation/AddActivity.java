package com.wisnu_krn.codelabsfirebase.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wisnu_krn.codelabsfirebase.R;

public class AddActivity extends AppCompatActivity {
    private EditText etInputLink;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etInputLink = (EditText) findViewById(R.id.addLink);
        btnSave = (Button) findViewById(R.id.btnAddSave);

        Intent intent = getIntent();
        String aksi = intent.getAction();
        String tipe = intent.getType();

        if (Intent.ACTION_SEND.equals(aksi) && tipe != null){
            if ("text/plain".equals(tipe)){
                handleSHarelableLink(intent);
            }
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    private void handleSHarelableLink(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        //sharedtext.notnull

        if (sharedText != null) {
            if(!TextUtils.isEmpty(etInputLink.getText().toString())){
                etInputLink.setText("");
            }
            etInputLink.setText(sharedText);
        }
    }
}
