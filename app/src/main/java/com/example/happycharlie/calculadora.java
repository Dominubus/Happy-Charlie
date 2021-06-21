package com.example.happycharlie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;

import static com.example.happycharlie.R.id.boton_Aquehoradespertar;
import static com.example.happycharlie.R.id.boton_Aquehoradormir;
import static com.example.happycharlie.R.id.boton_dormirNow;

public class calculadora extends AppCompatActivity {

        TextView hora;
        Button b1;
        Button b2;
        Button b3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        //obtener hora
        hora = findViewById(R.id.text_hora);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat h = new SimpleDateFormat("hh:mm a");
        String shora= h.format(new Date());
        hora.setText(shora);
        b1 = findViewById(boton_dormirNow);
        b2 = findViewById(boton_Aquehoradormir);
        b3 = findViewById(boton_Aquehoradespertar);
    }

    public void irLobbyC(View view) {
        Intent irLobbyC = new Intent(this, lobby.class);
        startActivity(irLobbyC);
    }

    public void irSiguientePantalla1(View v) {
        Toast.makeText(this, "Cuando se cumplen los ciclos",Toast.LENGTH_LONG).show();
        Intent sig= new Intent(this,CalculadoraResultados.class);
        sig.putExtra("dato","0");
        startActivity(sig);
    }
    public void irSiguientePantalla2(View v) {
        Toast.makeText(this, "Cuando comienzan los ciclos",Toast.LENGTH_LONG).show();
        Intent sig= new Intent(this,PonerHora.class);
        sig.putExtra("dato","1");
        startActivity(sig);

    }
    public void irSiguientePantalla3(View v) {
        Toast.makeText(this, "Cuando comienzan los ciclos",Toast.LENGTH_LONG).show();
        Intent sig= new Intent(this,PonerHora.class);
        sig.putExtra("dato","2");
        startActivity(sig);
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        b1 = findViewById(boton_dormirNow);
        b2 = findViewById(boton_Aquehoradormir);
        b3 = findViewById(boton_Aquehoradespertar);

        switch(key) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_italic.ttf");
                b1.setTypeface(nom_fuen);
                b2.setTypeface(nom_fuen);
                b3.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_italic.ttf");
                b1.setTypeface(nom_fue);
                b2.setTypeface(nom_fue);
                b3.setTypeface(nom_fue);
                break;
        }
    }
}