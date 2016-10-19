package com.wisnu_krn.firebasecrudv1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisnu_krn.firebasecrudv1.DetailActivity;
import com.wisnu_krn.firebasecrudv1.R;
import com.wisnu_krn.firebasecrudv1.helper.ItemClickListener;
import com.wisnu_krn.firebasecrudv1.helper.MyHolder;
import com.wisnu_krn.firebasecrudv1.model.User;

import java.util.ArrayList;

/**
 * Created by private on 19/10/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MyHolder> {

    private static final String TAG ="OPEN Activity" ;
    private static final String TAG2 ="ITEM CLICK" ;
    private static final String TAG3 ="BIND" ;
    Context c;
    ArrayList<User> users;

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    public RecyclerAdapter(Context c, ArrayList<User> users) {
        this.c = c;
        this.users = users;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        final String firstName = users.get(position).getFirstName();
        final String lastName = users.get(position).getLastName();
        final String dob = users.get(position).getDob();
        final String zip = users.get(position).getZipCode();
        final String key = users.get(position).getKey();
        Log.i(TAG, "onBindViewHolder: "+ key);

        holder.firstNameText.setText(firstName + " " + lastName);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Log.i(TAG2, "onItemClick:checking item click ");

                openDetailActivity(firstName, lastName, dob, zip, pos,key);

            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    private void openDetailActivity(String firstName, String lastName, String dob, String zipCode, int pos, String Key) {
        Intent i = new Intent(c, DetailActivity.class);

        //PACK DATA
        i.putExtra("FNAME_KEY", firstName);
        i.putExtra("LNAME_KEY", lastName);
        i.putExtra("DOB_KEY", dob);
        i.putExtra("ZIP_KEY", zipCode);
        i.putExtra("POS_KEY", pos);
        i.putExtra("KEY_KEY", Key);
        Log.i(TAG, "openDetailActivity: In opendetailActivity method");
        c.startActivity(i);

    }
}
