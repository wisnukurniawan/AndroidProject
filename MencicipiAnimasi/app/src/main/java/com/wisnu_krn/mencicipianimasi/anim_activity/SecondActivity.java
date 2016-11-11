package com.wisnu_krn.mencicipianimasi.anim_activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wisnu_krn.mencicipianimasi.BaseActivity;
import com.wisnu_krn.mencicipianimasi.R;
import com.wisnu_krn.mencicipianimasi.ToolbarHelper;

public class SecondActivity extends BaseActivity {
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToolbarHelper.getInstance().set(this).setBack();
        setContentView(R.layout.activity_second);
    }

    @Override public void finish() {
        super.finish();

    }
}
