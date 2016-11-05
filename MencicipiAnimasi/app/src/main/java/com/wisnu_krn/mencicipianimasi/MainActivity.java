package com.wisnu_krn.mencicipianimasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.kliktest) void clickAnim(){
        createAlpha();
    }

    private Animation createAlpha(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setDuration(1000);
        return alphaAnimation;
    }

    //    private Animation createTranslate(){
    //        TranslateAnimation
    //    }
    //  rotate
    //  scale
    //  set
}

