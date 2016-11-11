package com.wisnu_krn.mencicipianimasi;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BasicAnimations extends BaseActivity {
    @BindView(R.id.alpha) Button alpha;
    @BindView(R.id.translate) Button translate;
    @BindView(R.id.rotate) Button rotate;
    @BindView(R.id.scale) Button scale;
    @BindView(R.id.set) Button set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_animations);
        ButterKnife.bind(this);
        ToolbarHelper.getInstance().set(this).setBack().setTitle("Basic Animation");

        // Set Animation from java object
        //setAnimation(alpha, createAlpha());
        //setAnimation(translate, createTranslate());
        //setAnimation(rotate, createRotate());
        //setAnimation(scale, createScale());
        //setAnimation(set, createSet());

        // Set Animation from resource object
        setAnimationRescourse(alpha, R.anim.alpha_anim);
        setAnimationRescourse(translate, R.anim.translate_anim);
        setAnimationRescourse(rotate, R.anim.rotate_anim);
        setAnimationRescourse(scale, R.anim.scale_anim);
        setAnimationRescourse(set, R.anim.set_anim);
    }

    private void setAnimation(View view, final Animation animation){
        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                v.startAnimation(animation);
            }
        });
    }

    private void setAnimationRescourse(View view, final int anmitaionId){
        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), anmitaionId));
            }
        });
    }

    private Animation createAlpha(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(1000);
        return alphaAnimation;
    }

    private Animation createTranslate(){
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_PARENT, 1, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 100);
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }

    private Animation createScale(){
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2);
        scaleAnimation.setDuration(1000);
        return scaleAnimation;
    }

    private Animation createRotate(){
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        rotateAnimation.setDuration(1000);
        return rotateAnimation;
    }

    private Animation createSet(){
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(createAlpha());
        animationSet.addAnimation(createTranslate());
        animationSet.addAnimation(createRotate());
        animationSet.addAnimation(createScale());
        return animationSet;
    }
}
