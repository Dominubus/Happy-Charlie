package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;

public class PopupTemporizador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_temporizador);

        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);


        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int)(ancho * 1), (int)(alto * 0.18));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.x =0;
        params.y = +200;

        getWindow().setAttributes(params);


    }
}
