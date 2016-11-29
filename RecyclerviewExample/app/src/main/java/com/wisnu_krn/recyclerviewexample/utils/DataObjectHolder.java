package com.wisnu_krn.recyclerviewexample.utils;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wisnu_krn.recyclerviewexample.R;

/**
 * Created by private on 27/11/2016.
 */

public class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView label;
    public TextView value;

    public DataObjectHolder(View itemView) {
        super(itemView);
        label = (TextView) itemView.findViewById(R.id.name_course);
        value = (TextView) itemView.findViewById(R.id.textView2);
        Log.i("Test", "Adding Listener");
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
