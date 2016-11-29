package com.wisnu_krn.recyclerviewexample2;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.wisnu_krn.recyclerviewexample2.adapter.MainAdapter;
import com.wisnu_krn.recyclerviewexample2.helper.DivideItemDecorator;
import com.wisnu_krn.recyclerviewexample2.helper.RecyclerItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.recyclerview) RecyclerView recyclerView;

    private String[] listMenu = {
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan",
            "wisnu kurniawan"
    };

    private MainAdapter stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        stringArrayAdapter = new MainAdapter(listMenu, this);

        RecyclerView.LayoutManager layoutManagerVertical = new LinearLayoutManager(this);

        //setup recycler view
        recyclerView.setLayoutManager(layoutManagerVertical);
        recyclerView.setAdapter(stringArrayAdapter);
        recyclerView.addItemDecoration(new DivideItemDecorator(this, DivideItemDecorator.VERTICAL_LIST));

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(MainActivity.this, "Toast " + position, Toast.LENGTH_SHORT).show();
            }
        }));

    }
}
