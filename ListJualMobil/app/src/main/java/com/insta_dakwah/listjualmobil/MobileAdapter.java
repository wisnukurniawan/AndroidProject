package com.insta_dakwah.listjualmobil;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by private on 09/12/2016.
 */

public class MobileAdapter extends BaseAdapter {
    ArrayList listItem;
    Activity mActivity;

    public MobileAdapter(ArrayList listItem, Activity activity) {
        this.listItem = listItem;
        mActivity = activity;
    }



    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list, null);
            viewHolder.txtHarga = (TextView) view.findViewById(R.id.tv_item_harga);
            viewHolder.txtLokasi = (TextView) view.findViewById(R.id.tv_item_lokasi);
            viewHolder.txtTitle = (TextView) view.findViewById(R.id.tv_item_title);
            viewHolder.imgItem = (ImageView) view.findViewById(R.id.iv_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        MobileModel mobile = (MobileModel) getItem(i);
        viewHolder.txtTitle.setText(mobile.getTitle());
        viewHolder.txtHarga.setText(mobile.getHarga());
        viewHolder.txtLokasi.setText(mobile.getLokasi());
        Picasso.with(mActivity).load(mobile.getImage()).into(viewHolder.imgItem);
        return view;
    }

    static class ViewHolder {
        ImageView imgItem;
        TextView txtTitle, txtHarga, txtLokasi;
    }
}
