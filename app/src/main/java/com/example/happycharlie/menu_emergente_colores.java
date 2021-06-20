package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

public class menu_emergente_colores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_emergente_colores);

        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);


        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int)(ancho * 0.90), (int)(alto * 0.30));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;

        getWindow().setAttributes(params);
    }

    public void setColor1(View v){
        SharedPreferences sp = getSharedPreferences("COLOR_MENSAJE", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("key",1);
        edit.apply();
        finish();
    }
    public void setColor2(View v){
        SharedPreferences sp = getSharedPreferences("COLOR_MENSAJE", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("key",2);
        edit.apply();
        finish();
    }
    public void setColor3(View v){
        SharedPreferences sp = getSharedPreferences("COLOR_MENSAJE", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("key",3);
        edit.apply();
        finish();
    }
    public void setColor4(View v){
        SharedPreferences sp = getSharedPreferences("COLOR_MENSAJE", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("key",4);
        edit.apply();
        finish();
    }
    public void setColor5(View v){
        SharedPreferences sp = getSharedPreferences("COLOR_MENSAJE", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("key",5);
        edit.apply();
        finish();
    }
    public void setColor6(View v){
        SharedPreferences sp = getSharedPreferences("COLOR_MENSAJE", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("key",6);
        edit.apply();
        finish();
    }
}