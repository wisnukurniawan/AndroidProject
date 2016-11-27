package com.wisnu_krn.retrofit2.network;

import com.google.gson.Gson;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.wisnu_krn.retrofit2.BuildConfig.BASEURL;

/**
 * Created by private on 25/11/2016.
 */

public class ApiRestClient {
    private ApiInterface mApiInterface;

    public ApiRestClient(Context context){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        mApiInterface = retrofit.create(ApiInterface.class);
    }

    public ApiInterface getService(){
        return mApiInterface;
    }
}
