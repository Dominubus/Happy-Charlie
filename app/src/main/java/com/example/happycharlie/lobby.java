package com.example.happycharlie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FONDO_INICIO", MODE_PRIVATE);
        int key = sp.getInt("key", 1);
        ConstraintLayout layout = findViewById(R.id.lobby);
        switch(key) {
            case 1:
                layout.setBackgroundResource(R.drawable.bghuellitas);
                break;
            case 2:
                layout.setBackgroundResource(R.drawable.bg2);
                break;

            case 3:
                layout.setBackgroundResource(R.drawable.bg3);
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

}
