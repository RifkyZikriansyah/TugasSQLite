package com.example.tugassqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Main3Activity extends AppCompatActivity {
    LinearLayout opsi;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        opsi = findViewById(R.id.opsi);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        opsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                showDialog();
            }
        });
    }
    private void showDialog() {
        final String[] menu = {"Lihat data","Update data","hapus data"};
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setItems(menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                switch (i) {
                    case 0:
                        Intent btnLihat = new Intent(Main3Activity.this, Main2Activity.class);
                        startActivity(btnLihat);
                        break;

                    case 1:
                        Intent btnUpdate = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com"));
                        startActivity(btnUpdate);
                        break;

                    case 2:
                        Intent btnHapus =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://w3.schools.com"));
                        startActivity(btnHapus);
                        break;

                    default:
                        break;
                }
            }

        }).setCancelable(false);
        alertDialogBuilder.show();

    }
}
