package com.example.happycharlie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class lobby extends AppCompatActivity {
    int actual = 2;
    TextView tv2;
    TextView tv12;
    TextView tv13;
    TextView tv14;
    TextView tv15;
    TextView tv16;
    TextView tv17;

    Handler mHideHandler = new Handler();
    Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            estadoNormal();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        tv2 = findViewById(R.id.textView2);
        tv12 = findViewById(R.id.textView12);
        tv13 = findViewById(R.id.textView13);
        tv14 = findViewById(R.id.textView14);
        tv15 = findViewById(R.id.textView15);
        tv16 = findViewById(R.id.textView16);
    super.onResume();
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FONDO_INICIO", MODE_PRIVATE);
        int key = sp.getInt("key", 1);
        ConstraintLayout layout = findViewById(R.id.lobby);
        switch(key) {
            case 1:
                layout.setBackgroundResource(R.drawable.bghuellitas2);
                break;
            case 2:
                layout.setBackgroundResource(R.drawable.bghuellitas3);
                break;

            case 3:
                layout.setBackgroundResource(R.drawable.bgabstracto);
                break;
            default:
                layout.setBackgroundResource(R.drawable.bghuellitas2);
                break;
        }
        TextView mensaje=findViewById(R.id.textView2);
        sp = getSharedPreferences("COLOR_MENSAJE", MODE_PRIVATE);
        key = sp.getInt("key", 1);
        switch(key) {
            case 1:
                mensaje.setTextColor(Color.parseColor("#000000"));
                break;
            case 2:
                mensaje.setTextColor(Color.parseColor("#D2691E"));
                break;

            case 3:
                mensaje.setTextColor(Color.parseColor("#0000FF"));
                break;
            case 4:
                mensaje.setTextColor(Color.parseColor("#DC143C"));
                break;
            case 5:
                mensaje.setTextColor(Color.parseColor("#8B008B"));
                break;
            case 6:
                mensaje.setTextColor(Color.parseColor("#008000"));
                break;
            default:
                mensaje.setTextColor(Color.parseColor("#000000"));
                break;
        }

        SharedPreferences sp1 = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key1 = sp1.getInt("keyf", 1);

        tv2 = findViewById(R.id.textView2);
        tv12 = findViewById(R.id.textView12);
        tv13 = findViewById(R.id.textView13);
        tv14 = findViewById(R.id.textView14);
        tv15 = findViewById(R.id.textView15);
        tv16 = findViewById(R.id.textView16);
        tv17 = findViewById(R.id.textView17);
        switch(key1) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_b.ttf");

                tv2.setTypeface(nom_fuen);
                tv12.setTypeface(nom_fuen);
                tv13.setTypeface(nom_fuen);
                tv14.setTypeface(nom_fuen);
                tv15.setTypeface(nom_fuen);
                tv16.setTypeface(nom_fuen);
                tv17.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_italic.ttf");

                tv2.setTypeface(nom_fue);
                tv12.setTypeface(nom_fue);
                tv13.setTypeface(nom_fue);
                tv14.setTypeface(nom_fue);
                tv15.setTypeface(nom_fue);
                tv16.setTypeface(nom_fue);
                tv17.setTypeface(nom_fue);
                break;
        }
    }

    public void pantallaAnimo(View view) {
        Intent siguiente = new Intent(this, animo.class);
        startActivity(siguiente);
    }
    public void pantallaRuido(View view) {
        Intent siguiente = new Intent(this, ruido.class);
        startActivity(siguiente);
    }
    public void pantallaMusica(View view) {
        Intent siguiente = new Intent(this, musica.class);
        startActivity(siguiente);
    }
    public void pantallaMeditacion(View view) {
        Intent siguiente = new Intent(this, meditacion.class);
        startActivity(siguiente);
    }
    public void pantallaCalculadora(View view) {
        Intent siguiente = new Intent(this, calculadora.class);
        startActivity(siguiente);
    }
    public void pantallaConfiguracion(View view) {
        Intent siguiente = new Intent(this, configuracion.class);
        startActivity(siguiente);
    }
    public void estadoNormal(){
        GifImageView charlie = (GifImageView) findViewById(R.id.charlie);
        charlie.setImageResource(R.drawable.pug_tv);
    }

    public void cambioEmocion(View view) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, 20000);
        GifImageView charlie = (GifImageView) findViewById(R.id.charlie);
        int random2 = new Random().nextInt(1) + 1;
        if(actual==5){
            actual = new Random().nextInt(2) + 2;
            switch(actual){
                case 2:
                    charlie.setImageResource(R.drawable.pug_dish);
                    break;
                case 3:
                    charlie.setImageResource(R.drawable.pug_gym);
                    break;
                case 4:
                    charlie.setImageResource(R.drawable.pug_book);
                    break;
                default:
                    break;
            }

        }else {
            int random = new Random().nextInt(3) + 2;
            if (random == actual) {
                actual+=random2;
            }else{
                actual=random;
            }
            switch(actual){
                    case 2:
                        charlie.setImageResource(R.drawable.pug_dish);
                        break;
                    case 3:
                        charlie.setImageResource(R.drawable.pug_gym);
                        break;
                    case 4:
                        charlie.setImageResource(R.drawable.pug_book);
                        break;
                    case 5:
                        charlie.setImageResource(R.drawable.pug_belly);
                        break;
                    default:
                        charlie.setImageResource(R.drawable.pug_belly);
                        actual=5;
                        break;
            }

        }

    }

    public void volverLobby(View view) {
        finish();
    }
}
