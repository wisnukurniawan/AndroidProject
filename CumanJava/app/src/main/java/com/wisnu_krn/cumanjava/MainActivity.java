package com.wisnu_krn.cumanjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitPesanan(View view){
        int banyaknyaKopi = 3;

        display(banyaknyaKopi);
        displayHarga(banyaknyaKopi * 25000);
    }

    private void displayHarga(int harga){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        //membentuk format rupiah menggunakan kelas decimalformatsymbol
        formatRp.setCurrencySymbol("Rp. "); //ngebuat simbl RP
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.'); //pembagi untuk seribuan

        kursIndonesia.setDecimalFormatSymbols(formatRp); //menerapkan nilai format simbol ke kurs Indonesia

        TextView hargaTV = (TextView) findViewById(R.id.harga); //menyimpan view harga di hargaTV
        hargaTV.setText(kursIndonesia.format(harga)); //ngeset view sesuai harga dengan format yang udah di buat
    }

    private void display(int banyak) {
        TextView jumlahTV = (TextView) findViewById(R.id.banyak);
        jumlahTV.setText("" + banyak);
    }
}
