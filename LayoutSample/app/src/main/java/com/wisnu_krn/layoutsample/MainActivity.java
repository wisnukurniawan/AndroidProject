package com.wisnu_krn.layoutsample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;


public class MainActivity extends AppCompatActivity {

    private ImageView drawProfil;
    private Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hotel Hilton");
        getSupportActionBar().setSubtitle("Isla Nublar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawProfil = (ImageView) findViewById(R.id.iv_profil);
        setUpImageRoundedUsingGlide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void setupImageRounded() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.profil_image);

        RoundedBitmapDrawable rounded = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        rounded.setCornerRadius(bitmap.getWidth());

        ImageView drawProfil = (ImageView) findViewById(R.id.iv_profil);
        drawProfil.setImageDrawable(rounded);
    }

    public void setUpImageRoundedUsingGlide(){

        Glide.with(context).load(R.drawable.profil_image).asBitmap().centerCrop().into(new BitmapImageViewTarget(drawProfil) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable rounded =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                rounded.setCircular(true);

                drawProfil.setImageDrawable(rounded);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_bookmark) {
            return true;
        }

        if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}