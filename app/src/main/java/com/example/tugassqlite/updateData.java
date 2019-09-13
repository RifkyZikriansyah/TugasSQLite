package com.example.tugassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class updateData extends AppCompatActivity implements View.OnClickListener{
    EditText nomor,nama,TL,JK,alamat;
    LinearLayout simpan;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        DataBaseHelper db = new DataBaseHelper(context);
        PersonBean currentPerson = new PersonBean();
        nomor.setText(currentPerson.getNO());
        nama.setText(currentPerson.getNAME());
        TL.setText(currentPerson.getTL());
        JK.setText(currentPerson.getJK());
        alamat.setText(currentPerson.getALAMAT());
        db.selectUserData();
    }
    public void onClick(View v) {
        if (v.getId() == R.id.simpan){
            DataBaseHelper db = new DataBaseHelper(context);
            PersonBean currentPerson = new PersonBean();
            currentPerson.setNO(nomor.getText().toString());
            currentPerson.setNAME(nama.getText().toString());
            currentPerson.setTL(TL.getText().toString());
            currentPerson.setJK(JK.getText().toString());
            currentPerson.setALAMAT(alamat.getText().toString());
            db.update(currentPerson);
        }
    }
}
