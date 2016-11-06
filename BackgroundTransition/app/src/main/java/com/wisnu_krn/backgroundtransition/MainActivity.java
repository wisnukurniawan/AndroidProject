package com.wisnu_krn.backgroundtransition;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable mAnimationDrawable;
    private RelativeLayout mRelativeLayout;
    private int limaDetik = 5000;
    private int duaDetik = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        mAnimationDrawable = (AnimationDrawable) mRelativeLayout.getBackground();
        mAnimationDrawable.setEnterFadeDuration(limaDetik);
        mAnimationDrawable.setExitFadeDuration(duaDetik);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAnimationDrawable != null && !mAnimationDrawable.isRunning()){
            mAnimationDrawable.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAnimationDrawable != null && !mAnimationDrawable.isRunning()){
            mAnimationDrawable.stop();
        }
    }
}
