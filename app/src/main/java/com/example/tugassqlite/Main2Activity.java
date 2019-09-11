package com.example.tugassqlite;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout btnAwal1;
    RelativeLayout btnAwal2;
    RelativeLayout btnAwal3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnAwal1 = (RelativeLayout) findViewById(R.id.btnAwal1);
        btnAwal1.setOnClickListener((View.OnClickListener) this);

        btnAwal2 = (RelativeLayout) findViewById(R.id.btnAwal2);
        btnAwal2.setOnClickListener((View.OnClickListener) this);

        btnAwal3 = (RelativeLayout) findViewById(R.id.btnAwal3);
        btnAwal3.setOnClickListener((View.OnClickListener) this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAwal1:
                Intent btnAwal1 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(btnAwal1);
                break;

            case R.id.btnAwal2:
                Intent btnAwal2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.w3schools.com"));
                startActivity(btnAwal2);
                break;

            case R.id.btnAwal3:
                Intent btnAwal3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com"));
                startActivity(btnAwal3);
                break;

            default:
                break;
        }
    }
}
