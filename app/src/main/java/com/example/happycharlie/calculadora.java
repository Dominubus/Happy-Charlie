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


public class calculadora extends AppCompatActivity {

    TextView hora;
    Button b1, b2, b3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        //obtener hora
        b1 = findViewById(R.id.boton_dormirNow);
        b2 = findViewById(R.id.boton_Aquehoradormir);
        b3 = findViewById(R.id.boton_Aquehoradespertar);
        hora = findViewById(R.id.text_hora);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat h = new SimpleDateFormat("hh:mm a");
        hora.setText(h.format(new Date()));
    }

    public void irLobbyC(View view) {
        finish();
    }

    public void irAdormirAhora(View v) {
        Toast.makeText(this, "Si duermo ahora, voy a despertar a la siguiente hora",Toast.LENGTH_LONG).show();
        Intent sig= new Intent(this, CalculadoraResultados1.class);
        sig.putExtra("dato1","1");
        startActivity(sig);
    }

    public void irAdormir(View v) {
        Toast.makeText(this, "Para despertar a esa hora, debo dormir en este momento",Toast.LENGTH_LONG).show();
        Intent sig= new Intent(this, PonerHora1.class);
        sig.putExtra("dato2","2");
        startActivity(sig);
    }

    public void irADespertar(View v) {
        Toast.makeText(this, "Si me acuestó a esta hora, ¿Cuándo despertaré? ",Toast.LENGTH_LONG).show();
        Intent sig= new Intent(this,PonerHora2.class);
        sig.putExtra("dato3","3");
        startActivity(sig);
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        b1 = findViewById(R.id.boton_dormirNow);
        b2 = findViewById(R.id.boton_Aquehoradormir);
        b3 = findViewById(R.id.boton_Aquehoradespertar);
        hora = findViewById(R.id.text_hora);
        switch(key) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_regular.ttf");
                b1.setTypeface(nom_fuen);
                b2.setTypeface(nom_fuen);
                b3.setTypeface(nom_fuen);
                hora.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_bold.ttf");
                b1.setTypeface(nom_fue);
                b2.setTypeface(nom_fue);
                b3.setTypeface(nom_fue);
                hora.setTypeface(nom_fue);
                break;
        }
    }
}