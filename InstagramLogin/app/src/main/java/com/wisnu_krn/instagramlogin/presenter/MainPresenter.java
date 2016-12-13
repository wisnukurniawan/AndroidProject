package com.wisnu_krn.instagramlogin.presenter;

import android.content.Context;

import com.wisnu_krn.instagramlogin.models.ResponseToken;
import com.wisnu_krn.instagramlogin.network.InstagramService;
import com.wisnu_krn.instagramlogin.utils.PreferencesUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by private on 07/12/2016.
 */

public class MainPresenter {
    private Context context;
    private InstagramService api;

    public MainPresenter(Context context) {
        this.context = context;
        api = new InstagramService();
    }

    public void getToken(String clientID, String clientSecret, String redirectUri, String code) {
        api.getApi()
                .getToken(clientID, clientSecret, "authorization_code", redirectUri, code)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseToken>() {
                    @Override public void onCompleted() {
                        Timber.i("completed");
                    }

                    @Override public void onError(Throwable e) {
                        Timber.e("error : " + e.getMessage());
                    }

                    @Override public void onNext(ResponseToken responseToken) {
                        Timber.i("response : " + responseToken.getToken());
                        PreferencesUtils.setDataStringToSP(context, PreferencesUtils.INSTAGRAM_TOKEN,
                                responseToken.getToken());

                        PreferencesUtils.setDataStringToSP(context, PreferencesUtils.USER_ID,
                                responseToken.getUser().getId());

                    }
                });
    }


}