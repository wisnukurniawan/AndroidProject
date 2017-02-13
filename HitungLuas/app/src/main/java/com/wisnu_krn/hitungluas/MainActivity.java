package com.wisnu_krn.hitungluas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edittext_panjang, edittext_lebar;
    private Button button_hitung;
    private TextView textview_hasil;

    // ada int panjang
    // ada int luas
    // ada hasil = panjang x luas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext_panjang = (EditText) findViewById(R.id.edit_panjang);
        edittext_lebar = (EditText) findViewById(R.id.edit_lebar);
        button_hitung = (Button) findViewById(R.id.button_hitung);
        textview_hasil = (TextView) findViewById(R.id.text_hasil);

        button_hitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_hitung:
                String panjang = edittext_panjang.getText().toString().trim();
                String lebar = edittext_lebar.getText().toString().trim();
//                try {
//                    if (TextUtils.isEmpty(panjang) || TextUtils.isEmpty(lebar)) {
//                        String text = "exception error! input ada yang kosong";
//                        int duration = Toast.LENGTH_LONG;
//
//                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
//                        toast.show();
//                    } else {
                if (!validate()) {
                    Toast toast = Toast.makeText(MainActivity.this, "Input tidak boleh kosong", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);

                double luas = p * l;

                textview_hasil.setText("Luas : " + luas);
//                    }
//                } catch (Exception e) {
//                    CharSequence text = "exception error! check your input";
//                    int duration = Toast.LENGTH_LONG;
//
//                    Toast toast = Toast.makeText(MainActivity.this, text, duration);
//                    toast.show();
//                    e.printStackTrace();
//                }
                break;
        }
    }

    public boolean validate() {
        if (edittext_panjang.getText().toString().trim().equals(""))
            return false;
        if (edittext_lebar.getText().toString().trim().equals(""))
            return false;
        return true;
    }

}
