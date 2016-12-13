package com.insta_dakwah.listjualmobil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[][] data = new String[][]{
            {"Toyota, Avanza, G 1.3 A/t 2009",
                    "https://static.carmudi.co.id/vrcjY08L2LKVxIQvBFa0KwPVjV0=/fit-in/800x444/filters:watermark(http://static.carmudi.co.id/ZZVwF9qyYqYIIp2ObDDuoqMMDp0=/200x0/WATERMARK/carmudi-watermark.png,-18,-18,30)/listing_images/ID/upload_5844f74c807d66.17168954.jpg",
                    "Rp. 102.000.000", "Tangerang, Banten"},
            {"Toyota, Camry 2.4 V A/t 2007",
                    "https://s-media-cache-ak0.pinimg.com/736x/fa/a7/8a/faa78a27e2ae99624db8d141e023aab4.jpg","Rp. 170.000.000", "Tangerang, Banten"},
            {"Mercedez Benz, E Class E 200 Kompressor 2009",
                    "https://www.lamborghini.com/en-en/sites/en-en/files/DAM/it/models_gateway/blocks/special.png","Rp. 180.000.000", "Jakarta Timur"},
            {"Honda, Jazz, A 1.5 M/T, 2015",
                    "http://pictures.topspeed.com/IMG/crop/201608/2014-ferrari-laferrari-26_600x0w.jpg","Rp. 207.500.000", "Jakarta Barat"},
            {"Mitsubishi, Outlander, Sport PX, 2015",
                    "https://i.ytimg.com/vi/M9XYxAv_N8g/maxresdefault.jpg","Call", "Tangerang"}
    };

    private ListView lvItem;
    private ArrayList listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem = (ListView) findViewById(R.id.lv_item);
        listItem = new ArrayList<>();

        MobileModel mobile = null;

        for (int i = 0; i < data.length; i++) {
            mobile = new MobileModel();
            mobile.setTitle(data[i][0]);
            mobile.setImage(data[i][1]);
            mobile.setHarga(data[i][2]);
            mobile.setLokasi(data[i][3]);

            listItem.add(mobile);
        }

        MobileAdapter adapter = new MobileAdapter(listItem, MainActivity.this);
        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MobileModel mbl = (MobileModel) listItem.get(position);

                Intent intent = new Intent(MainActivity.this, DetailMobilActivity.class);
                intent.putExtra(DetailMobilActivity.KEY_ITEM, mbl);
                startActivityForResult(intent, 0);
            }
        });

    }
}



