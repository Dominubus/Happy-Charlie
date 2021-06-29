package com.example.happycharlie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.concurrent.TimeUnit;
//MediaStore.Audio;

public class repMeditacion extends AppCompatActivity {

    private MediaPlayer mp = null;
    private boolean reproduciendo;
    protected Handler mHandler = new Handler();
    private SeekBar barra;
    private int tiempo = 15000;
    private Runnable runnable;
    private Handler handler;
    private Intent rm;
    private TextView text_temp;
    private TextView t8;
    private TextView t11;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_meditacion);
        ConstraintLayout layout = findViewById(R.id.repMeditacion);
        rm = getIntent();
        TextView tv;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        i = rm.getIntExtra("bg", 1);
        reproduciendo = false;

        t8 = (TextView)findViewById(R.id.textView8);
        t11 = (TextView)findViewById(R.id.textView11);
        text_temp =(TextView) findViewById(R.id.texView_temp);
        text_temp.setText(R.string.temp);
        switch(i) {
            case 1:
                layout.setBackgroundResource(R.drawable.skymedbg);
                tv =(TextView) findViewById(R.id.textView8);
                tv.setText(R.string.guia_para_principiantes);
                tv.setTextColor(Color.parseColor("#ffffff"));
                tv =(TextView) findViewById(R.id.textView11);
                tv.setText(R.string.meditacion1);
                tv.setTextColor(Color.parseColor("#ffffff"));
                mp = MediaPlayer.create(this, R.raw.sencilla);
                break;
            case 2:
                layout.setBackgroundResource(R.drawable.beachmedbg);
                tv =(TextView) findViewById(R.id.textView8);
                tv.setText(R.string.guia_relajacion);
                tv.setTextColor(Color.parseColor("#ffffff"));
                tv =(TextView) findViewById(R.id.textView11);
                tv.setText(R.string.meditacion2);
                tv.setTextColor(Color.parseColor("#ffffff"));
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
                ImageButton boton = (ImageButton) findViewById(R.id.imageButton);
                boton.setImageResource(R.drawable.round_arrow_back_black_48);
                boton = (ImageButton) findViewById(R.id.btn_play_pause);
                boton.setImageResource(R.drawable.round_play_arrow_black_48);
                boton = (ImageButton) findViewById(R.id.btn_retroceder);
                boton.setImageResource(R.drawable.round_restore_black_48dp);
                boton = (ImageButton) findViewById(R.id.btn_adelantar);
                boton.setImageResource(R.drawable.round_update_black_48dp);
                tv=findViewById(R.id.texView_temp);
                tv.setTextColor(Color.parseColor("#000000"));
                mp = MediaPlayer.create(this, R.raw.paz_interior);
                break;
            default:
                break;

        }

        barra = (SeekBar) findViewById(R.id.seekBar);
        barra.setMax(mp.getDuration());
        handler = new Handler();
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mp.seekTo(progress);
                    seekBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                int currPos=mp.getCurrentPosition();
                barra.setProgress(currPos);
                ImageButton btn = (ImageButton)findViewById(R.id.btn_play_pause);
                if(i==3){
                    btn.setImageResource(R.drawable.round_play_arrow_black_48);
                }else {
                    btn.setImageResource(R.drawable.round_play_arrow_white_48dp);
                }
                reproduciendo = false;
            }
        });
    }
    public void updateSB(){
        int currPos=mp.getCurrentPosition();
        barra.setProgress(currPos);
        runnable = new Runnable() {
            @Override
            public void run() {
                updateSB();
            }
        };
        int m,s;
        //int seconds = (int) (currPos / 1000) % 60 ;
        //int minutes = (int) ((currPos / (1000*60)) % 60);
        //int hours = (int) ((currPos / (1000*60*60)) % 24);
        String t = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(currPos), TimeUnit.MILLISECONDS.toSeconds(currPos) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currPos)) );
        text_temp.setText(t);
        handler.postDelayed(runnable,1000);
    }

    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mp.stop();
    }
    @Override
    protected void onPause() {
            ImageButton btn = (ImageButton)findViewById(R.id.btn_play_pause);
            reproduciendo = false;
            mp.pause();
        if(i==3){
            btn.setImageResource(R.drawable.round_play_arrow_black_48);
        }else {
            btn.setImageResource(R.drawable.round_play_arrow_white_48dp);
        }
        super.onPause();
    }

    public void retoceder(View view){
        int currentPosition = mp.getCurrentPosition();
        if (currentPosition - tiempo >= 0) {
            mp.seekTo(currentPosition - tiempo);
        } else {
            mp.seekTo(0);
        }

    }

    public void adelantar(View view){
        int currentPosition = mp.getCurrentPosition();
        if (currentPosition + tiempo <= mp.getDuration()) {
            mp.seekTo(currentPosition + tiempo);
        } else {
            mp.seekTo(mp.getDuration());
        }
    }
    public void reproducir(View view){
        ImageButton btn = (ImageButton)findViewById(R.id.btn_play_pause);
        if(reproduciendo){
            reproduciendo = false;
            mp.pause();
            if(i==3){
                btn.setImageResource(R.drawable.round_play_arrow_black_48);
            }else {
                btn.setImageResource(R.drawable.round_play_arrow_white_48dp);
            }
        }else{
            reproduciendo = true;
            mp.start();
            updateSB();
            if(i==3){
                btn.setImageResource(R.drawable.round_pause_black_48);
            }else {
                btn.setImageResource(R.drawable.round_pause_white_48dp);
            }
        }
    }
    public void volverLobby(View view) {
        //Intent anterior = new Intent(this, lobby.class);
        //startActivity(anterior);
        finish();
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        t8 = (TextView)findViewById(R.id.textView8);
        t11 = (TextView)findViewById(R.id.textView11);

        switch(key) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_regular.ttf");
                t8.setTypeface(nom_fuen);
                t11.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_bold.ttf");
                t8.setTypeface(nom_fue);
                t11.setTypeface(nom_fue);
                break;
        }
    }
}
