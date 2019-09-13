package com.example.tugassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class inputData extends AppCompatActivity implements View.OnClickListener {
    EditText nomor,nama,TL,JK,alamat;
    LinearLayout simpan;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
        nomor = findViewById(R.id.nomor);
        nama = findViewById(R.id.nama);
        TL = findViewById(R.id.TL);
        JK = findViewById(R.id.JK);
        alamat = findViewById(R.id.alamat);
        simpan = findViewById(R.id.simpan);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.simpan){
            DataBaseHelper db = new DataBaseHelper(context);
            PersonBean currentPerson = new PersonBean();
            currentPerson.setNO(nomor.getText().toString());
            currentPerson.setNAME(nama.getText().toString());
            currentPerson.setTL(TL.getText().toString());
            currentPerson.setJK(JK.getText().toString());
            currentPerson.setALAMAT(alamat.getText().toString());
            db.insert(currentPerson);
        }
    }
}
