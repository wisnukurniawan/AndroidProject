package com.wisnu_krn.simplelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView itemListView;
    private String[] footballClubs = new String[]{
            "Juventus", "Manchester United", "Liverpool",
            "Bayern Munchen", "Real Madrid", "Ajax Amsterdam",
            "Barcelona", "Arsenal", "Manchester City", "Ajax Amsterdam",
            "Inter Milan", "Ac Milan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemListView = (ListView) findViewById(R.id.lv_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, footballClubs);
        itemListView.setAdapter(adapter);

        itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Klik : " + footballClubs[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
