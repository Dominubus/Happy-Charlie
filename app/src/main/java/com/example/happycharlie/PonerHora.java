package com.example.happycharlie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.DateTimePatternGenerator;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class PonerHora extends AppCompatActivity {

        EditText hora;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocar_hora);

        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);


        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int)(ancho * 1), (int)(alto * 0.20));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.x =0;
        params.y = +148;

        getWindow().setAttributes(params);

    }

    public void irCalculadora(View view) {

        Intent irCalculadora = new Intent(this, calculadora.class);
        startActivity(irCalculadora);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void irResultados(View view) {
        hora =(EditText) findViewById(R.id.hora_propuesta);
        SimpleDateFormat hs = new SimpleDateFormat("hh:mm a");
        String shora = hs.format(hora.getText());

        Intent irResultado = new Intent(this, CalculadoraResultados.class);
        irResultado.putExtra("date",shora);
        startActivity(irResultado);
    }
}
