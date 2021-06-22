package com.example.happycharlie;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;


public class calculadora extends AppCompatActivity {


    TextView hora;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        //obtener hora
        hora = findViewById(R.id.text_hora);
        SimpleDateFormat h = new SimpleDateFormat("hh:mm a");
        hora.setText(h.format(new Date()));
    }

    public void irLobbyC(View view) {
        Intent irLobbyC = new Intent(this, lobby.class);
        startActivity(irLobbyC);
    }

    public void irAdormirAhora(View v) {
        Toast.makeText(this, "Voy a despertar a la siguiente hora",Toast.LENGTH_LONG).show();
        Intent sig= new Intent(this,CalculadoraResultados.class);
        sig.putExtra("dato1","1");
        startActivity(sig);
    }
    public void irAdormir(View v) {
        Toast.makeText(this, "Tengo que dormir a esta hora",Toast.LENGTH_LONG).show();
        Intent sig= new Intent(this,PonerHora.class);
        startActivity(sig);
    }
    public void irADespertar(View v) {
        Toast.makeText(this, "Si me acuesto a esta hora despertaré",Toast.LENGTH_LONG).show();
        Intent sig= new Intent(this,PonerHora2.class);
        startActivity(sig);
    }
}