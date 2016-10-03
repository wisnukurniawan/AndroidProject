package com.wisnu_krn.numberpicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //ambil widget dari xml
//        final TextView textView = (TextView) findViewById(R.id.tv);
//        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.np);
//
//        //ubah warna text jadi hitam
//        textView.setTextColor(Color.parseColor("#000000"));
//
//        //set minimum angkanya
//        numberPicker.setMinValue(0);
//        //set maksimum
//        numberPicker.setMaxValue(100);
//
//        numberPicker.setWrapSelectorWheel(true);
//
//        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                textView.setText("Angka terpilih: "+newVal);
//            }
//        });
        
    }
}
