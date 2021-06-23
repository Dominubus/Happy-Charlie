package com.example.happycharlie;

import android.annotation.SuppressLint;
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
        @SuppressLint("SimpleDateFormat") SimpleDateFormat h = new SimpleDateFormat("hh:mm a");
        hora.setText(h.format(new Date()));
    }

    public void irLobbyC(View view) {
        Intent irLobbyC = new Intent(this, lobby.class);
        startActivity(irLobbyC);
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
}