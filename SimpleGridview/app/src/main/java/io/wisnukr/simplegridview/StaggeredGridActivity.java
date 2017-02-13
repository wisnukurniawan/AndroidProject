package io.wisnukr.simplegridview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;

public class StaggeredGridActivity extends AppCompatActivity {
    private StaggeredGridView staggeredGridView;
    private String[] items = new String[]{
            "http://cdn.zonarutoppuden.com/ns/peliculas-naruto-shippuden.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/5d/a0/8d/5da08d24bc4c7d2847ee5dfa1604b114.jpg",
            "http://2.bp.blogspot.com/-429eiwuJJnc/USsLW0HG0nI/AAAAAAAAAE8/rstDEyZM2NA/s1600/sasuke_susanoo_v2_by_iai3-d4f9j4b.png.jpg",
            "http://weknowyourdreams.com/images/naruto/naruto-02.jpg",
            "http://scontent-b-fra.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10932142_330866587116424_1327271556_n.jpg",
            "http://scontent-b-fra.cdninstagram.com/hphotos-xfa1/t51.2885-15/s306x306/e15/10932410_1544715455813452_1107632347_n.jpg",
            "http://scontent-a-fra.cdninstagram.com/hphotos-xfp1/t51.2885-15/s306x306/e15/891516_579817258815508_1989379587_n.jpg",
            "http://scontent-b-fra.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/1922172_719849754801056_911351010_n.jpg",
            "http://scontent-b-fra.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10914370_1519297625009641_722250486_n.jpg",
            "http://scontent-a-fra.cdninstagram.com/hphotos-xaf1/t51.2885-15/s306x306/e15/10903746_368501953321344_2002746420_n.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);
        getSupportActionBar().setTitle("Star Wars");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        staggeredGridView = (StaggeredGridView) findViewById(R.id.gv_staggered);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(items, StaggeredGridActivity.this);
        staggeredGridView.setAdapter(itemGridAdapter);
        staggeredGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailImageActivity.toDetailImageActivity(StaggeredGridActivity.this, items[position]);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void toStaggeredGridActivity(Context context){
        context.startActivity(new Intent(context, StaggeredGridActivity.class));
    }
}
