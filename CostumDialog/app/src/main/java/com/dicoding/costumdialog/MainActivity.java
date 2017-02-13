package com.dicoding.costumdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button showDialogButton;
    private Button showButtomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialogButton = (Button) findViewById(R.id.button_show_dialog);

        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
        showButtomSheet = (Button) findViewById(R.id.button_show_about);
        showButtomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAbout();
            }
        });
    }

    private void showAbout() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.view_bottom_sheet_about, null);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        //Mengeset judul dialog
        dialog.setTitle("Add person");

        //Mengeset layout
        dialog.setContentView(R.layout.view_custom_dialog);

        //Membuat agar dialog tidak hilang saat di click di area luar dialog
         dialog.setCanceledOnTouchOutside(false);

        //Membuat dialog agar berukuran responsive
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        dialog.getWindow().setLayout((6 * width) / 7, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button cancelButton = (Button) dialog.findViewById(R.id.button_cancel);
        Button saveButton = (Button) dialog.findViewById(R.id.button_save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        //Menampilkan custom dialog
        dialog.show();
    }
}
