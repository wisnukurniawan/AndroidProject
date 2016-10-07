package com.wisnu_krn.retrofitexample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wisnu_krn.retrofitexample.Models.Models;
import com.wisnu_krn.retrofitexample.RestApi.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //URL sumber data API
    public static final String ROOT_URL = "http://api.teknorial.com/";

    //pendefinisian
    private TextView txt_id;
    private TextView txt_nama;
    private TextView txt_email;
    private TextView txt_alamat;
    private TextView txt_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //apiari.io keyword blueprint

        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_nama = (TextView) findViewById(R.id.txt_nama);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_status = (TextView) findViewById(R.id.txt_status);
        txt_alamat = (TextView) findViewById(R.id.txt_alamat);

        getData();
    }

    private void getData() {
        final ProgressDialog load = ProgressDialog.show(this, "Loading", "Loading...", false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestApi service = retrofit.create(RestApi.class);
        Call<Models> call = service.getDataAdmin();
        call.enqueue(new Callback<Models>() {
            @Override
            public void onResponse(Call<Models> call, Response<Models> response) {
                try {
                    load.dismiss();
                    String id = response.body().getAdmin().getId().toString();
                    String nama = response.body().getAdmin().getNama();
                    String email = response.body().getAdmin().getEmail();
                    String status = response.body().getAdmin().getStatus();
                    String alamat = response.body().getAdmin().getAlamat();

                    txt_id.setText(id);
                    txt_nama.setText(nama);
                    txt_email.setText(email);
                    txt_status.setText(status);
                    txt_alamat.setText(alamat);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Models> call, Throwable t) {

            }
        });
    }
}
