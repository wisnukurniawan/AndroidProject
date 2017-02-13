package io.wisnukr.simplegridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class DetailImageActivity extends AppCompatActivity {
    private ImageView mImageViewDetail;
    public static String KEY_IMAGE = "image";
    private String imageUrl;
    private PhotoViewAttacher mPhotoViewAttacher = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_image);
        getSupportActionBar().hide();

        mImageViewDetail = (ImageView) findViewById(R.id.iv_image_detail);
        imageUrl = getIntent().getStringExtra(KEY_IMAGE);
        mPhotoViewAttacher = new PhotoViewAttacher(mImageViewDetail);

        Picasso.with(DetailImageActivity.this).load(imageUrl).into(mImageViewDetail);

    }
    public static void toDetailImageActivity(Activity activity, String imageUrl){
        Intent intent = new Intent(activity, DetailImageActivity.class);
        intent.putExtra(KEY_IMAGE, imageUrl);
        activity.startActivityForResult(intent, 0);
    }
}
