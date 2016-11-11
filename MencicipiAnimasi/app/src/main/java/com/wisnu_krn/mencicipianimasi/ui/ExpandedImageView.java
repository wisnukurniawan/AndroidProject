package com.wisnu_krn.mencicipianimasi.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wisnu_krn.mencicipianimasi.R;

/**
 * Created by private on 11/11/2016.
 */

public class ExpandedImageView extends View {
    private boolean expanded = false;

    private LinearLayout.LayoutParams mDefaultParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
    private LinearLayout.LayoutParams mExpandedParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 220);

    public ExpandedImageView(Context context) {
        super(context);
        setLayoutParams(mDefaultParams);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(mDefaultParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.truck_x);
        setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                setLayoutParams(expanded ? mDefaultParams : mExpandedParams);
                expanded = !expanded;
                requestLayout();
            }
        });
    }
}
