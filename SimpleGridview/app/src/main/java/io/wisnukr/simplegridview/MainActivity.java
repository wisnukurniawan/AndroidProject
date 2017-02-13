package io.wisnukr.simplegridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    private String[] images = new String[]{
            "http://scontent-a-fra.cdninstagram.com/hphotos-xpf1/t51.2885-15/s306x306/e15/10665483_429615813855717_1490926670_n.jpg",
            "http://scontent-b-fra.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10891026_694434897342602_1094773634_n.jpg",
            "http://scontent-a-fra.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10894920_1382218332084671_10354293_n.jpg",
            "http://scontent-b-fra.cdninstagram.com/hphotos-xfa1/t51.2885-15/s306x306/e15/10895429_768163716566132_692639371_n.jpg",
            "http://scontent-b-fra.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10899087_405295322969722_20422376_n.jpg",
            "http://scontent-a-fra.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10899123_922231267802027_1123900984_n.jpg",
            "http://scontent-a-fra.cdninstagram.com/hphotos-xfa1/t51.2885-15/s306x306/e15/10903214_589111004559561_1485881959_n.jpg",
            "http://scontent-a-fra.cdninstagram.com/hphotos-xfa1/t51.2885-15/s306x306/e15/10914479_770066599745785_704061869_n.jpg",
            "http://scontent-a-fra.cdninstagram.com/hphotos-xfa1/t51.2885-15/s306x306/e15/10914587_1580079332227764_829762970_n.jpg",
            "http://scontent-b-fra.cdninstagram.com/hphotos-xfa1/t51.2885-15/s306x306/e15/10919231_605000369644967_1578007175_n.jpg"

    };

    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Dinosaurs");
        mGridView = (GridView) findViewById(R.id.gv_item);

        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(images, MainActivity.this);
        mGridView.setAdapter(itemGridAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                DetailImageActivity.toDetailImageActivity(MainActivity.this, images[position]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_staggered) {
            // TODO: 19/01/2017 click here
            StaggeredGridActivity.toStaggeredGridActivity(MainActivity.this);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}


