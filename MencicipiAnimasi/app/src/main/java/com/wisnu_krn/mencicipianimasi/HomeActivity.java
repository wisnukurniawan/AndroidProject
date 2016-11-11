package com.wisnu_krn.mencicipianimasi;

import android.os.Bundle;

import com.wisnu_krn.mencicipianimasi.anim_activity.FirstActivity;
import com.wisnu_krn.mencicipianimasi.anim_fragment.FragmentMainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.basic) void clickBasic(){
        open(BasicAnimations.class);
    }

    @OnClick(R.id.property) void clickProperty(){
        open(PropertyAnimations.class);
    }

    @OnClick(R.id.layout_transition) void clickTansition(){
        open(LayoutTransitionActivity.class);
    }

    @OnClick(R.id.activity_transition) void clickActivity(){
        open(FirstActivity.class);
    }
    @OnClick(R.id.fragment_transition) void clickFragment(){
        open(FragmentMainActivity.class);
    }
}

