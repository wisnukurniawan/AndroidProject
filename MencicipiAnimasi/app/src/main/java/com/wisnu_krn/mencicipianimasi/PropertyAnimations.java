package com.wisnu_krn.mencicipianimasi;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PropertyAnimations extends AppCompatActivity {

    @BindView(R.id.alpha)
    Button alpha;
    @BindView(R.id.translate) Button translate;
    @BindView(R.id.rotate) Button rotate;
    @BindView(R.id.scale) Button scale;
    @BindView(R.id.set) Button set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animations);
        ButterKnife.bind(this);
        ToolbarHelper.getInstance().set(this).setTitle("Property Animation").setBack();

        setAnimation(alpha, createFade(alpha));
        setAnimation(translate, createMove(translate));
        setAnimation(rotate, createRotate(rotate));
        setAnimation(scale, createScale(scale));
        setAnimation(set, createCombo());
    }

    private void setAnimation(View view, final Animator animator){
        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                animator.start();
            }
        });
    }

    private ObjectAnimator createFade(View view) {
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(view, View.ALPHA, 0);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(ValueAnimator.REVERSE);
        return alphaAnimation;
    }

    private ObjectAnimator createMove(View view) {
        ObjectAnimator translateAnimation = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, 800);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setRepeatMode(ValueAnimator.REVERSE);
        return translateAnimation;
    }

    private ObjectAnimator createScale(View view) {
        PropertyValuesHolder phx = PropertyValuesHolder.ofFloat(View.SCALE_X, 2);
        PropertyValuesHolder phy = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2);
        ObjectAnimator scaleAnimation = ObjectAnimator.ofPropertyValuesHolder(view, phx, phy);
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(ValueAnimator.REVERSE);
        return scaleAnimation;
    }

    private ObjectAnimator createRotate(View view) {
        ObjectAnimator rotateAnimation = ObjectAnimator.ofFloat(view, View.ROTATION, 360);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setRepeatMode(ValueAnimator.REVERSE);
        return rotateAnimation;
    }

    private AnimatorSet createCombo() {
        AnimatorSet animationSet = new AnimatorSet();
        animationSet.play(createScale(scale))
                .after(createRotate(rotate))
                .after(createMove(translate))
                .after(createFade(alpha));
        return animationSet;
    }
}

