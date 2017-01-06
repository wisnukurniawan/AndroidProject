package com.wisnu.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText komentarField;
    private SharedPreferences mSharedPreferences;
    public static final String PREF_FILE = "data";
    public static final String DEFAULT_STRING = "";

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
        Log.v("asa", "asdsa");
    }

    public void loadString() {
        mSharedPreferences = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        String savedValue = mSharedPreferences.getString("Data", DEFAULT_STRING);
        if (savedValue.equals(DEFAULT_STRING)) {
            //Toast.makeText(getApplicationContext(), "Nilai KOSONG", Toast.LENGTH_LONG).show();
        } else {
            komentarField.setText(savedValue);
            komentarField.setSelection(komentarField.getText().length());
        }
    }

    @Override
    public void onClick(View v) {
        //code program pindah aplikasi

    }
}
