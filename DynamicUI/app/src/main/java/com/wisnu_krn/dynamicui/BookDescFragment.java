package com.wisnu_krn.dynamicui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by private on 16/11/2016.
 */

public class BookDescFragment extends Fragment {
    public BookDescFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewHierarchy = inflater.inflate(R.layout.fragment_book_desc, container, false);
        return viewHierarchy;
    }
}
