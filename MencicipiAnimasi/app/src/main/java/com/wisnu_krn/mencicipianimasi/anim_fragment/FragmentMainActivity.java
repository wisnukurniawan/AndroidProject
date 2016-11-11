package com.wisnu_krn.mencicipianimasi.anim_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.wisnu_krn.mencicipianimasi.BaseActivity;
import com.wisnu_krn.mencicipianimasi.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentMainActivity extends BaseActivity{

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.one) void one(){
        setFragmentAnimation(new FragmentOne());
    }

    @OnClick(R.id.two) void two(){
        setFragmentAnimation(new FragmentTwo());
    }

    private void setFragmentAnimation(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_anim, R.anim.close_anim)
                .replace(R.id.container, fragment)
                .commit();
    }
}