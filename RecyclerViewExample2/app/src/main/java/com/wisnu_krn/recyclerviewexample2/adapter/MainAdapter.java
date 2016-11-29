package com.wisnu_krn.recyclerviewexample2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wisnu_krn.recyclerviewexample2.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by private on 29/11/2016.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private String[] listMenu;
    private Context mContext;

    public MainAdapter(String[] listMenu, Context context) {
        this.listMenu = listMenu;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(listMenu[position]);
    }

    @Override
    public int getItemCount() {
        return listMenu.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text) TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
