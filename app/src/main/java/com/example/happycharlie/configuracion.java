package com.example.happycharlie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class configuracion extends AppCompatActivity {

    Button btnbg;
    Button btncl;
    Button btnft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        btnbg =findViewById(R.id.botonBG);
        btncl = findViewById(R.id.botonCL);
        btnft = findViewById(R.id.botonFT);

        btnbg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {startActivity(new Intent(configuracion.this, menu_emergente_fondos.class));}
        });

        btncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(configuracion.this, menu_emergente_colores.class));
            }
        });

        btnft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(configuracion.this, menu_emergente_fuente.class));
            }
        });
    }



    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        btnbg =findViewById(R.id.botonBG);
        btncl = findViewById(R.id.botonCL);
        btnft = findViewById(R.id.botonFT);

        switch(key) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_regular.ttf");
                btnbg.setTypeface(nom_fuen);
                btncl.setTypeface(nom_fuen);
                btnft.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_bold.ttf");
                btnbg.setTypeface(nom_fue);
                btncl.setTypeface(nom_fue);
                btnft.setTypeface(nom_fue);
                break;
        }
    }

    public void volverLobby(View view) {
        finish();
    }
}
