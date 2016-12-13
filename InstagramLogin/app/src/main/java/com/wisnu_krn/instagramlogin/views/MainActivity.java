package com.wisnu_krn.instagramlogin.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.wisnu_krn.instagramlogin.R;
import com.wisnu_krn.instagramlogin.presenter.MainPresenter;
import com.wisnu_krn.instagramlogin.utils.InstagramConfig;
import com.wisnu_krn.instagramlogin.utils.PreferencesUtils;
import com.wisnu_krn.instagramlogin.views.feed.FeedUserActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private static final int AUTH_INSTAGRAM = 1;

    private MainPresenter presenter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new MainPresenter(this);
    }

    @OnClick(R.id.btn_authorize) public void btnOnClick() {
        if (!TextUtils.isEmpty(
                PreferencesUtils.getDataStringFromSP(this, PreferencesUtils.INSTAGRAM_TOKEN, ""))) {
            startActivity(new Intent(this, FeedUserActivity.class));
        } else {
            startActivityForResult(new Intent(this, AuthInstagramActivity.class), AUTH_INSTAGRAM);
            startActivity(new Intent(this, AuthInstagramActivity.class));
        }
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AUTH_INSTAGRAM) {
            if (resultCode == RESULT_OK) {
                Timber.i("data di main actiivty : " + data.getStringExtra("code"));
                presenter.getToken(InstagramConfig.CLIENT_ID, InstagramConfig.CLIENT_SECRET,
                        InstagramConfig.CALLBACK_URL, data.getStringExtra("code"));
            }
        }
    }
}
