package com.wisnu_krn.basketskor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView_hasil = (TextView) findViewById(R.id.textView_hasil);
        ImageView imageView_pemenang = (ImageView) findViewById(R.id.imageView_pemenang);

        String hasil = getIntent().getStringExtra("hasil");
        String winner = getIntent().getStringExtra("winner");

        checkWinner(imageView_pemenang, winner);
        textView_hasil.setText(hasil);
    }

    private void checkWinner(ImageView imageView_pemenang, String winner) {
        if (winner.equals("a")) {
            imageView_pemenang.setImageResource(R.drawable.cleveland);
        } else if (winner.equals("b")) {
            imageView_pemenang.setImageResource(R.drawable.miami_heat);
        }
    }
}
