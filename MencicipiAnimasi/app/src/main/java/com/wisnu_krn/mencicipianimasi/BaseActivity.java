package com.wisnu_krn.mencicipianimasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by private on 11/11/2016.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void open(Class namaKelas){
        Intent intent = new Intent(this, namaKelas);
        startActivity(intent);
    }
}
