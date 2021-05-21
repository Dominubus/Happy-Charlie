package com.example.happycharlie;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.File;

import android.provider.MediaStore.Audio.Media;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_meditacion);
        ConstraintLayout layout = findViewById(R.id.repMeditacion);
        rm = getIntent();
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
                btn.setImageResource(R.drawable.round_play_arrow_black_48);
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
            btn.setImageResource(R.drawable.round_play_arrow_black_48);
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
            btn.setImageResource(R.drawable.round_play_arrow_black_48);
        }else{
            reproduciendo = true;
            mp.start();
            updateSB();
            btn.setImageResource(R.drawable.round_pause_black_48);
        }
    }


}
