package com.wisnu_krn.cekkoneksi;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by private on 15/10/2016.
 */
public class Ping extends AsyncTask<Void, Void, Boolean>{

    private PingCallback mCallback;

    public Ping(PingCallback callback){
        mCallback = callback;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        String urlRoute = "https://www.google.co.id";
        HttpsURLConnection httpsURLConnection = null;
        try {
            URL url = new URL(urlRoute);
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.connect();
            int status = httpsURLConnection.getResponseCode();
            return status == HttpsURLConnection.HTTP_OK && urlRoute.equals(httpsURLConnection.getURL().toString());

        } catch (IOException e) {
            return false;
        } finally {
            if (httpsURLConnection != null){
                httpsURLConnection.disconnect();
            }
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        mCallback.getConnection(aBoolean);
    }

    public interface PingCallback {
        void getConnection(Boolean isConnected);
    }
}
