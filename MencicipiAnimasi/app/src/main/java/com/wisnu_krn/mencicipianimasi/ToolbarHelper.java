package com.wisnu_krn.mencicipianimasi;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by private on 11/11/2016.
 */

public class ToolbarHelper {
    private static ToolbarHelper instance;
    private AppCompatActivity activity;

    public static ToolbarHelper getInstance() {
        instance = new ToolbarHelper();
        return instance;
    }

    public ToolbarHelper set(AppCompatActivity activity){
        this.activity = activity;
        return instance;
    }

    public ToolbarHelper setTitle(String title){
        instance.activity.getSupportActionBar().setTitle(title);
        return instance;
    }

    public ToolbarHelper setBack(){
        ActionBar ab = instance.activity.getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        return instance;
    }
}
