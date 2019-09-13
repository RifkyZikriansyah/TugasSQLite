package com.example.tugassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class detailData extends AppCompatActivity  {
    EditText nomor,nama,TL,JK,alamat;
    LinearLayout simpan;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        nomor = findViewById(R.id.nomor);
        nama = findViewById(R.id.nama);
        TL = findViewById(R.id.TL);
        JK = findViewById(R.id.JK);
        alamat = findViewById(R.id.alamat);
        simpan = findViewById(R.id.simpan);
        DataBaseHelper db = new DataBaseHelper(context);
        PersonBean currentPerson = new PersonBean();
        nomor.setText(currentPerson.getNO());
        nama.setText(currentPerson.getNAME());
        TL.setText(currentPerson.getTL());
        JK.setText(currentPerson.getJK());
        alamat.setText(currentPerson.getALAMAT());

    }



}
