package com.wisnu_krn.mencicipianimasi.anim_activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wisnu_krn.mencicipianimasi.BaseActivity;
import com.wisnu_krn.mencicipianimasi.R;
import com.wisnu_krn.mencicipianimasi.ToolbarHelper;

public class LastActivity extends BaseActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        ToolbarHelper.getInstance().set(this).setBack();
    }

    @Override public void finish() {
        super.finish();
        overridePendingTransition(R.anim.enter_anim, R.anim.close_anim);
    }
}
