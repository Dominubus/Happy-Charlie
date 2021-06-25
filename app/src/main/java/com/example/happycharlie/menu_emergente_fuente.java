package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class menu_emergente_fuente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_emergente_fuente);

        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);


        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int)(ancho * 0.90), (int)(alto * 0.30));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;

        getWindow().setAttributes(params);
    }

    public void setfont1(View v){
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("keyf",1);
        edit.apply();
        finish();
    }

    public void setfont2(View v){
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("keyf",2);
        edit.apply();
        finish();
    }
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        ImageButton view;
        switch (key) {
            case 1:
                view=findViewById(R.id.button8);
                break;
            case 2:
                view=findViewById(R.id.button9);
                break;
            default:
                view=findViewById(R.id.button8);
                break;
        }
        view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        view.setBackgroundColor(Color.parseColor("#820000"));
        view.setPadding(2,5,2,5);
    }
}