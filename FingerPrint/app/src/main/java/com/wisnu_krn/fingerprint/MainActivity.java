package com.wisnu_krn.fingerprint;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.multidots.fingerprintauth.AuthErrorCodes;
import com.multidots.fingerprintauth.FingerPrintAuthCallback;
import com.multidots.fingerprintauth.FingerPrintAuthHelper;
import com.multidots.fingerprintauth.FingerPrintUtils;

public class MainActivity extends AppCompatActivity implements FingerPrintAuthCallback, View.OnClickListener {
    private FingerPrintAuthHelper mFingerPrintAuthHelper;
    private EditText editTextPin;
    private ViewSwitcher mSwitcher;
    private Button buttonGoToSetting;
    private TextView textViewAuthMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGoToSetting = (Button) findViewById(R.id.go_to_settings_btn);
        buttonGoToSetting.setOnClickListener(this);

        mSwitcher = (ViewSwitcher) findViewById(R.id.main_switcher);
        textViewAuthMessage = (TextView) findViewById(R.id.auth_message_tv);

        editTextPin = (EditText) findViewById(R.id.pin_et);
        editTextPin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("1234")){
                    Toast.makeText(MainActivity.this, "Autentifikasi Sukses", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, ActivitySuccess.class));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mFingerPrintAuthHelper = FingerPrintAuthHelper.getHelper(this, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        buttonGoToSetting.setVisibility(View.GONE);

        textViewAuthMessage.setText("Scan your finger");
        mFingerPrintAuthHelper.startAuth();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFingerPrintAuthHelper.stopAuth();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.go_to_settings_btn:
                FingerPrintUtils.openSecuritySettings(MainActivity.this);
                break;
        }
    }


    @Override
    public void onNoFingerPrintHardwareFound() {
        textViewAuthMessage.setText("Your device does not have finger print scanner. Please type 1234 to authenticate.");
        mSwitcher.showNext();
    }

    @Override
    public void onNoFingerPrintRegistered() {
        textViewAuthMessage.setText("There are no finger prints registered on this device. Please register your finger from settings.");
        buttonGoToSetting.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBelowMarshmallow() {
        textViewAuthMessage.setText("You are running older version of android that does not support finger print authentication. Please type 1234 to authenticate.");
        mSwitcher.showNext();
    }

    @Override
    public void onAuthSuccess(FingerprintManager.CryptoObject cryptoObject) {
        Toast.makeText(MainActivity.this, "Authentication succeeded.", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, ActivitySuccess.class));
    }

    @Override
    public void onAuthFailed(int errorCode, String errorMessage) {
        switch (errorCode){
            case AuthErrorCodes.CANNOT_RECOGNIZE_ERROR:
                textViewAuthMessage.setText("Cannot recognize your finger print. Please try again.");
                break;
            case AuthErrorCodes.NON_RECOVERABLE_ERROR:
                textViewAuthMessage.setText("Cannot initialize finger print authentication. Please type 1234 to authenticate.");
                mSwitcher.showNext();
                break;
            case AuthErrorCodes.RECOVERABLE_ERROR:
                textViewAuthMessage.setText(errorMessage);
                break;
        }
    }
}
