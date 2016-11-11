package com.wisnu_krn.mencicipianimasi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wisnu_krn.mencicipianimasi.R;

import java.util.Date;
import java.util.Random;

/**
 * Created by private on 11/11/2016.
 */

public class ExpandedView extends LinearLayout {

    private boolean expanded = false;

    private LinearLayout.LayoutParams mDefaultParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 60);
    private LinearLayout.LayoutParams mExpandedParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    private TextView time;
    private TextView message_text;

    public ExpandedView(Context context, final String message) {
        super(context);

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.START);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.message_layout, this, true);

        time = (TextView) findViewById(R.id.time);
        message_text = (TextView) findViewById(R.id.message_text);

        message_text.setText(message);

        Random rnd = new Random();
        int color = Color.argb(200, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        setBackgroundColor(color);
        setPadding(5, 5, 5, 5);

        setLayoutParams(mDefaultParams);
        setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                setLayoutParams(expanded ? mDefaultParams : mExpandedParams);
                message_text.setLines(expanded ? 1 : 10);
                expanded = !expanded;
                requestLayout();
            }
        });

        setOnLongClickListener(new OnLongClickListener() {
            @Override public boolean onLongClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setMessage("Delete message " + message)
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override public void onClick(DialogInterface dialog, int which) {
                                setVisibility(GONE);
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
                return false;
            }
        });

        setTime();
    }

    private void setTime() {
        java.text.DateFormat timeFormat = DateFormat.getTimeFormat(getContext());// .getTimeFormat(getContext());
        time.setText(timeFormat.format(new Date()));
    }
}
