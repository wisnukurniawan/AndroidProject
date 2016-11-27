package com.wisnu_krn.retrofit2.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wisnu_krn.retrofit2.R;
import com.wisnu_krn.retrofit2.model.request.LoginRequestModel;
import com.wisnu_krn.retrofit2.model.response.LoginResponseModel;
import com.wisnu_krn.retrofit2.network.ApiRestClient;
import com.wisnu_krn.retrofit2.ui.main.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText editUsername;
    private EditText editPassword;

    private ApiRestClient mRestClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLogin = (Button) findViewById(R.id.button_login);
        editUsername = (EditText) findViewById(R.id.edit_username);
        editPassword = (EditText) findViewById(R.id.edit_password);

        mRestClient = new ApiRestClient(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 25/11/2016 login here .....
                login();
            }
        });
    }

    private void login() {
        LoginRequestModel requestModel = new LoginRequestModel();
        requestModel.setUsername(editUsername.getText().toString());
        requestModel.setPassword(editPassword.getText().toString());
        requestModel.setPushbotsToken("12312343");

        mRestClient.getService().login(requestModel).enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                LoginResponseModel responseModel = response.body();

                if (responseModel.getError()) {
                    Log.d("info broo", responseModel.getMessage());
                } else {
                    SharedPreferences preferences = getSharedPreferences("YAC",0);
                    SharedPreferences.Editor editor  = preferences.edit();
                    editor.putString("token", "Bearer " + responseModel.getToken());
                    // bareer header auth
                    // penggunaan header
                    // interface kasi @header
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Log.d("Token ", responseModel.getToken());
                }
            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                Log.e("Error... ", t.getLocalizedMessage());
            }
        });
    }
}
