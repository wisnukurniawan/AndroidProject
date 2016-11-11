package com.wisnu_krn.mencicipianimasi.anim_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisnu_krn.mencicipianimasi.R;

/**
 * Created by private on 11/11/2016.
 */

public class FragmentOne extends Fragment {

    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }
}
