package com.wisnu_krn.gambarbulat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

public class MainActivity extends AppCompatActivity {
    private String url = "https://cdn-images-1.medium.com/fit/c/100/100/1*_Lm5zgfjlNN3RBCCe6rSwA.jpeg";

    private Context context = MainActivity.this;

    private ImageView drawProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawProfil = (ImageView) findViewById(R.id.iv_profil);
        //setupImageRounded();
        setUpImageRoundedUsingGlide();
    }

    public void setupImageRounded() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.profil_image);

        RoundedBitmapDrawable rounded = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        rounded.setCornerRadius(bitmap.getWidth());

        ImageView drawProfil = (ImageView) findViewById(R.id.iv_profil);
        drawProfil.setImageDrawable(rounded);
    }

    public void setUpImageRoundedUsingGlide(){
        Glide.with(context).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(drawProfil) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable rounded =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                rounded.setCircular(true);
                drawProfil.setImageDrawable(rounded);
            }
        });
    }
}
