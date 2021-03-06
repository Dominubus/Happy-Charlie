package com.example.happycharlie;

import android.content.ComponentName;
import android.content.Intent;
import android.content.Context;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;

import com.example.happycharlie.AudioService.SoundBinder;


public class ruido extends AppCompatActivity {
    AudioService myService;
    private Intent playIntent;
    private boolean soundBound;
    AudioManager amgr;
    private ImageView icon;
    ImageView btnTempo;

    private static long tiempoSet = 3600000;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long tiempoLeft;
    private long tiempoEnd;
    private long tiempoStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruido);
        amgr = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if(amgr.isStreamMute(AudioManager.STREAM_MUSIC))
        {
            icon = (ImageView) findViewById(R.id.volumeOn);
            icon.setVisibility(View.INVISIBLE);
            icon = (ImageView) findViewById(R.id.volumeOff);
            icon.setVisibility(View.VISIBLE);
        }
        else
        {
            icon = (ImageView) findViewById(R.id.volumeOn);
            icon.setVisibility(View.VISIBLE);
            icon = (ImageView) findViewById(R.id.volumeOff);
            icon.setVisibility(View.INVISIBLE);
        }
        btnTempo =findViewById(R.id.timerIcon);

        btnTempo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {startActivity(new Intent(ruido.this, PopupTemporizador.class));}
        });
    }

    protected void onStart() {
        super.onStart();
        if(playIntent==null){
            playIntent = new Intent(this, AudioService.class);
            bindService(playIntent, soundConnection, Context.BIND_AUTO_CREATE);
            startService(playIntent);
        }
    }

    private ServiceConnection soundConnection = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            SoundBinder binder = (SoundBinder) service;
            myService = binder.getService();
            soundBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            soundBound = false;
        }
    };

    public void playFire(View v){
        myService.setSource("fire");
        myService.playSound();
        onPlay();
    }

    public void playForest(View v){
        myService.setSource("forest");
        myService.playSound();
        onPlay();
    }

    public void playRain(View v){
        myService.setSource("rain");
        myService.playSound();
        onPlay();
    }

    public void playSea(View v){
        myService.setSource("sea");
        myService.playSound();
        onPlay();
    }

    public void playWaterfall(View v){
        myService.setSource("waterfall");
        myService.playSound();
        onPlay();
    }

    public void playWind(View v){
        myService.setSource("wind");
        myService.playSound();
        onPlay();
    }

    public void onPlay(){
        if(!myService.sameSound()) {
            icon = (ImageView) findViewById(R.id.playIcon);
            icon.setVisibility(View.INVISIBLE);
            icon = (ImageView) findViewById(R.id.pauseIcon);
            icon.setVisibility(View.VISIBLE);
            icon = (ImageView) findViewById(R.id.continueIcon);
            icon.setVisibility(View.INVISIBLE);
            startTimer();
        }
    }

    public void pause(View v) {
            icon = (ImageView) findViewById(R.id.pauseIcon);
            icon.setVisibility(View.INVISIBLE);
            icon = (ImageView) findViewById(R.id.continueIcon);
            icon.setVisibility(View.VISIBLE);
            myService.pauseSound();
            mCountDownTimer.cancel();
            setTimer(tiempoEnd - System.currentTimeMillis());

    }

    public void resume(View v){
        icon = (ImageView) findViewById(R.id.pauseIcon);
        icon.setVisibility(View.VISIBLE);
        icon = (ImageView) findViewById(R.id.continueIcon);
        icon.setVisibility(View.INVISIBLE);
        myService.continueSound();
        startTimer();
    }

    public void stop(){
        myService.stopSound();
        setTimer(3600000);
    }

    public void mute(View v) {
        amgr = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        amgr.adjustVolume(AudioManager.ADJUST_MUTE,AudioManager.FLAG_SHOW_UI);
        icon = (ImageView) findViewById(R.id.volumeOn);
        icon.setVisibility(View.INVISIBLE);
        icon = (ImageView) findViewById(R.id.volumeOff);
        icon.setVisibility(View.VISIBLE);
    }

    public void unmute(View v) {
        amgr = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        amgr.adjustVolume(AudioManager.ADJUST_UNMUTE,AudioManager.FLAG_SHOW_UI);
        icon = (ImageView) findViewById(R.id.volumeOn);
        icon.setVisibility(View.VISIBLE);
        icon = (ImageView) findViewById(R.id.volumeOff);
        icon.setVisibility(View.INVISIBLE);
    }

    public void setTimer(long t){
        tiempoSet = t;
    }

    public long getTimer(){
        return tiempoSet;
    }

    public void startTimer(){
        if (mTimerRunning) {
            mCountDownTimer.cancel();
        }
        icon = (ImageView) findViewById(R.id.timerIcon);
        icon.setClickable(false);
        mCountDownTimer = new CountDownTimer(getTimer(), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                icon = (ImageView) findViewById(R.id.playIcon);
                icon.setVisibility(View.VISIBLE);
                icon = (ImageView) findViewById(R.id.continueIcon);
                icon.setVisibility(View.INVISIBLE);
                icon = (ImageView) findViewById(R.id.pauseIcon);
                icon.setVisibility(View.INVISIBLE);
                mTimerRunning = false;
                icon = (ImageView) findViewById(R.id.timerIcon);
                icon.setClickable(true);
                stop();
            }
        }.start();
        tiempoStart = System.currentTimeMillis();
        tiempoEnd =  tiempoStart + getTimer();
        mTimerRunning = true;
    }

    @Override
    protected void onStop() {
        setTimer(3600000);
        super.onStop();
    }

    @Override
    public void onDestroy(){
        stopService(playIntent);
        myService = null;
        super.onDestroy();
    }

    public void volverLobby(View view) {
        finish();
    }

}
