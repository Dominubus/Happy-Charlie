package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class menu_emergente_fondos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_emergente_fondos);

        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);


        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int)(ancho * 0.90), (int)(alto * 0.30));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;

        getWindow().setAttributes(params);

    }

    public void setbackground1(View v){
        SharedPreferences sp = getSharedPreferences("FONDO_INICIO", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("key",1);
        edit.apply();
        finish();
    }

    public void setbackground2(View v){
        SharedPreferences sp = getSharedPreferences("FONDO_INICIO", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("key",2);
        edit.apply();
        finish();
    }

    public void setbackground3(View v){
        SharedPreferences sp = getSharedPreferences("FONDO_INICIO", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("key",3);
        edit.apply();
        finish();
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FONDO_INICIO", MODE_PRIVATE);
        int key = sp.getInt("key", 1);
        ImageButton view;
        switch (key) {
            case 1:
                view=findViewById(R.id.imageButton6);
                break;
            case 2:
                view=findViewById(R.id.imageButton5);
                break;

            case 3:
                view=findViewById(R.id.imageButton8);
                break;
            default:
                view=findViewById(R.id.imageButton6);
                break;
        }
        view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        view.setBackgroundColor(Color.parseColor("#820000"));
        view.setPadding(5,5,5,5);
    }

}