package com.wisnu_krn.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import static com.wisnu_krn.sharedpreferenceexample.Constants.DEFAULT_STRING;
import static com.wisnu_krn.sharedpreferenceexample.Constants.PREF_FILE;

public class MainActivity extends AppCompatActivity {
    private EditText komentarField;

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komentarField = (EditText) findViewById(R.id.komentar);
        loadString();
    }

    @Override
    protected void onPause() {
        super.onPause();
        String komentar = komentarField.getText().toString();
        saveString(komentar);
    }

    public void saveString(String value) {
        mSharedPreferences = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("Data", value);
        editor.apply();
    }
    public void loadString() {
        mSharedPreferences = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        String savedValue = mSharedPreferences.getString("Data", DEFAULT_STRING);
        if (savedValue.equals(DEFAULT_STRING)){
            //Toast.makeText(getApplicationContext(), "Nilai KOSONG", Toast.LENGTH_LONG).show();
        }else {
            komentarField.setText(savedValue);
            komentarField.setSelection(komentarField.getText().length());
        }
    }
}
