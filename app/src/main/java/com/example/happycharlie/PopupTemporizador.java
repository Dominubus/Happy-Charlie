package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class PopupTemporizador extends AppCompatActivity {
    ruido ruido = new ruido();
    private Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_temporizador);
        b1 = findViewById(R.id.botonOne);
        b2 = findViewById(R.id.botonTwo);
        b3 = findViewById(R.id.botonThree);
        b4 = findViewById(R.id.botonFour);

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

    public void setT15(View v){
        Toast.makeText(this, "Establecido en 15 min", Toast.LENGTH_SHORT).show();
        ruido.setTimer(900000);
        finish();
    }

    public void setT30(View v){
        Toast.makeText(this, "Establecido en 30 min", Toast.LENGTH_SHORT).show();
        ruido.setTimer(1800000);
        finish();
    }

    public void setT60(View v){
        Toast.makeText(this, "Establecido en 1 hora", Toast.LENGTH_SHORT).show();
        ruido.setTimer(3600000);
        finish();
    }

    public void setT180(View v){
        Toast.makeText(this, "Establecido en 3 horas", Toast.LENGTH_SHORT).show();
        ruido.setTimer(10800000);
        finish();
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        b1 = findViewById(R.id.botonOne);
        b2 = findViewById(R.id.botonTwo);
        b3 = findViewById(R.id.botonThree);
        b4 = findViewById(R.id.botonFour);
        switch(key) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_regular.ttf");
                b1.setTypeface(nom_fuen);
                b2.setTypeface(nom_fuen);
                b3.setTypeface(nom_fuen);
                b4.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_bold.ttf");
                b1.setTypeface(nom_fue);
                b2.setTypeface(nom_fue);
                b3.setTypeface(nom_fue);
                b4.setTypeface(nom_fue);
                break;
        }
    }
}