package io.wisnukr.simplegridview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by wisnu on 19/01/2017.
 */

public class ItemGridAdapter extends BaseAdapter {
    String[] items;
    Context context;

    public ItemGridAdapter(String[] items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder = null;

        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_grid, null);
            holder.mImageView = (ImageView) view.findViewById(R.id.item_image_grid);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Log.d("Item ke "+position,items[position]);
        Picasso.with(context).load(items[position]).placeholder(ContextCompat.getDrawable(context, R.drawable.placeholder))
                .into(holder.mImageView);
        return view;
    }

    public class ViewHolder{
        ImageView mImageView;
    }
}
