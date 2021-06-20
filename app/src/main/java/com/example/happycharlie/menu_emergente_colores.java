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
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("COLOR_MENSAJE", MODE_PRIVATE);
        int key = sp.getInt("key", 1);
        ImageButton view;
        switch (key) {
            case 1:
                view=findViewById(R.id.button2);
                break;
            case 2:
                view=findViewById(R.id.button3);
                break;

            case 3:
                view=findViewById(R.id.button4);
                break;
            case 4:
                view=findViewById(R.id.button5);
                break;
            case 5:
                view=findViewById(R.id.button6);
                break;
            case 6:
                view=findViewById(R.id.button7);
                break;
            default:
                view=findViewById(R.id.button2);
                break;
        }
        view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        view.setBackgroundColor(Color.parseColor("#820000"));
        view.setPadding(10,10,10,10);
    }
}