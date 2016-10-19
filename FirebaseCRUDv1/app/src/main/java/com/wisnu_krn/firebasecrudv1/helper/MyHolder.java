package com.wisnu_krn.firebasecrudv1.helper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wisnu_krn.firebasecrudv1.R;

/**
 * Created by private on 19/10/2016.
 */

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView firstNameText;
    ItemClickListener itemClickListener;
    public MyHolder(View itemView) {

        super(itemView);
        firstNameText = (TextView) itemView.findViewById(R.id.nameTxt);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener (ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(view, getLayoutPosition());
    }
}
