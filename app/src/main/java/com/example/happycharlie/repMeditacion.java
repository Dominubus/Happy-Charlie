package com.example.happycharlie;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.File;

import android.provider.MediaStore.Audio.Media;
//MediaStore.Audio;

public class repMeditacion extends AppCompatActivity {

    private MediaPlayer mp = null;
    private boolean reproduciendo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_meditacion);
        ConstraintLayout layout = findViewById(R.id.repMeditacion);
        Intent rm = getIntent();
        TextView tv;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        int i = rm.getIntExtra("bg", 1);
        reproduciendo = false;
        switch(i) {
            case 1:
                layout.setBackgroundResource(R.drawable.skymedbg);
                tv =(TextView) findViewById(R.id.textView8);
                tv.setText(R.string.guia_para_principiantes);
                tv.setTextColor(Color.parseColor("#6C35A6"));
                tv =(TextView) findViewById(R.id.textView11);
                tv.setText(R.string.meditacion1);
                tv.setTextColor(Color.parseColor("#6C35A6"));
                mp = MediaPlayer.create(this, R.raw.sencilla);
                break;
            case 2:
                layout.setBackgroundResource(R.drawable.beachmedbg);
                tv =(TextView) findViewById(R.id.textView8);
                tv.setText(R.string.guia_relajacion);
                tv.setTextColor(Color.parseColor("#000000"));
                tv =(TextView) findViewById(R.id.textView11);
                tv.setText(R.string.meditacion2);
                tv.setTextColor(Color.parseColor("#000000"));
                mp = MediaPlayer.create(this, R.raw.relajar_cuerpo_mente);
                break;
            case 3:
                layout.setBackgroundResource(R.drawable.salarmedbg);
                tv =(TextView) findViewById(R.id.textView8);
                tv.setText(R.string.guia_paz);
                tv.setTextColor(Color.parseColor("#000000"));
                tv =(TextView) findViewById(R.id.textView11);
                tv.setText(R.string.meditacion3);
                tv.setTextColor(Color.parseColor("#000000"));
                mp = MediaPlayer.create(this, R.raw.paz_interior);
                break;
            default:
                break;

        }
    }
    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void retoceder(View view){

    }

    public void adelantar(View view){

    }
    public void reproducir(View view){
        ImageButton btn = (ImageButton)findViewById(R.id.btn_play_pause);
        if(reproduciendo){
            reproduciendo = false;
            mp.pause();
            btn.setImageResource(R.drawable.round_pause_black_48);
        }else{
            reproduciendo = true;
            mp.start();
            btn.setImageResource(R.drawable.round_play_arrow_black_48);
        }
    }

}
