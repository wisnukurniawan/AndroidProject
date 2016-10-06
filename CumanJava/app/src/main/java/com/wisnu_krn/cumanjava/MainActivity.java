package com.wisnu_krn.cumanjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {
    private int banyaknyaKopi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButtonTambah = (Button) findViewById(R.id.tambah);
        mButtonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
            }
        });

        Button mButtonKurang = (Button) findViewById(R.id.kurang);
        mButtonKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
            }
        });

        Button mButtonSentuh = (Button) findViewById(R.id.sentuh);
        mButtonSentuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitPesanan();
            }
        });

    }

    public void submitPesanan(){
        CheckBox cokelat1 = (CheckBox) findViewById(R.id.cokelat1);
        boolean hasCokelat1 = cokelat1.isChecked();

        CheckBox cokelat2 = (CheckBox) findViewById(R.id.cokelat2);
        boolean hasCokelat2 = cokelat2.isChecked();

        CheckBox cokelat3 = (CheckBox) findViewById(R.id.cokelat3);
        boolean hasCokelat = cokelat3.isChecked();

        int harga = hitungHarga(hasCokelat1, hasCokelat2, hasCokelat);
        displayHarga(harga);

    }

    private int hitungHarga(boolean hasCokelat1, boolean hasCokelat2, boolean hasCokelat3) {
        int hargaBiasa = 10000;
        if(hasCokelat1) hargaBiasa = hargaBiasa + 2000;
        if(hasCokelat2) hargaBiasa = hargaBiasa + 4000;
        if(hasCokelat3) hargaBiasa = hargaBiasa + 6000;

        return banyaknyaKopi * hargaBiasa;
    }

    public void increment(){
        if (banyaknyaKopi == 100) {
            return;
        }
        banyaknyaKopi++;
        display(banyaknyaKopi);
    }

    public void decrement(){
        if (banyaknyaKopi == 0) {
            return;
        }
        banyaknyaKopi--;
        display(banyaknyaKopi);
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
