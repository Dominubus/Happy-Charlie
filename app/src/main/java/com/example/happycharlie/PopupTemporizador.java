package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class PopupTemporizador extends AppCompatActivity {
    ruido ruido = new ruido();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_temporizador);

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
}