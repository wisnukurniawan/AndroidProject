package com.wisnu_krn.mencicipianimasi.anim_activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.wisnu_krn.mencicipianimasi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by private on 11/11/2016.
 */

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.translate_activity)
    Button translate_activity;
    @BindView(R.id.scaluUp) Button scaluUp;
    @BindView(R.id.thumbnail)
    ImageView thumbnailImage;

    private Bitmap thumbnailBitmap;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);

        thumbnailBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thumbnail);
        thumbnailImage.setImageBitmap(thumbnailBitmap);
    }

    @OnClick(R.id.default_transition) void defaultAnimation(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick(R.id.translate_activity) void translateOpen(){
        Intent intent = new Intent(this, LastActivity.class);
        Bundle translateBundle =
                ActivityOptions.makeCustomAnimation(this,
                        R.anim.enter_anim, R.anim.close_anim).toBundle();
        startActivity(intent, translateBundle);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick(R.id.scaluUp) void setScaluUp(){
        Intent intent = new Intent(this, SecondActivity.class);
        Bundle scaleUpBunddle =
                ActivityOptionsCompat.makeScaleUpAnimation(scaluUp, 0, 0,
                        scaluUp.getWidth(), scaluUp.getHeight()).toBundle();
        startActivity(intent, scaleUpBunddle);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick(R.id.thumbnail) void setThumbnailImage(){
        Intent intent = new Intent(this, SecondActivity.class);
        Bundle scaleBundle = ActivityOptionsCompat.makeThumbnailScaleUpAnimation(thumbnailImage,
                thumbnailBitmap, 0, 0).toBundle();
        startActivity(intent, scaleBundle);
    }

}