package com.example.happycharlie;

import android.content.Intent;
import android.media.Image;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import android.widget.ImageView;

public class ruido extends AppCompatActivity {
    MediaPlayer player;
    AudioManager amgr;
    private ImageView icon;
    ImageView btnTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruido);
        amgr = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if(amgr.isStreamMute(amgr.getMode()))
        {
            icon = (ImageView) findViewById(R.id.volumeOn);
            icon.setVisibility(View.VISIBLE);
            icon = (ImageView) findViewById(R.id.volumeOff);
            icon.setVisibility(View.INVISIBLE);
        }
        else
        {
            icon = (ImageView) findViewById(R.id.volumeOn);
            icon.setVisibility(View.INVISIBLE);
            icon = (ImageView) findViewById(R.id.volumeOff);
            icon.setVisibility(View.VISIBLE);
        }
        btnTempo =findViewById(R.id.timerIcon);

        btnTempo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(ruido.this, PopupTemporizador.class));
            }
        });

    }

    public void volverLobby(View view) {
        finish();
        stopPlayer();
    }
    public void playFire(View v) {
        if (player != null)
            stopPlayer();
        player = MediaPlayer.create(getApplicationContext(),R.raw.fire);
        play(v);
        //player.setLooping(true);
        //player.start();
    }
    public void playWind(View v) {
        if (player != null)
            stopPlayer();
        player = MediaPlayer.create(this,R.raw.wind);
        play(v);
        //player.setLooping(true);
        //player.start();
    }
    public void playRain(View v) {
        if (player != null)
            stopPlayer();
        player = MediaPlayer.create(this,R.raw.rain);
        play(v);
        //player.setLooping(true);
        //player.start();
    }
    public void playWaterfall(View v) {
        if (player != null)
            stopPlayer();
        player = MediaPlayer.create(this,R.raw.waterfall);
        play(v);
        //player.setLooping(true);
        //player.start();
    }
    public void playForest(View v) {
        if (player != null)
            stopPlayer();
        player = MediaPlayer.create(this,R.raw.forest);
        play(v);
        //player.setLooping(true);
        //player.start();
    }
    public void playSea(View v) {
        if (player != null)
            stopPlayer();
        player = MediaPlayer.create(this,R.raw.sea);
        play(v);
        //player.setLooping(true);
        //player.start();
    }
    public void play(View v) {
        player.setLooping(true);
        //player.prepareAsync();
        player.start();
        onPlay(v);
    }
    public void onPlay(View v){
        icon = (ImageView) findViewById(R.id.pauseIcon);
        icon.setVisibility(View.VISIBLE);
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
            icon = (ImageView) findViewById(R.id.pauseIcon);
            icon.setVisibility(View.INVISIBLE);
            icon = (ImageView) findViewById(R.id.playIcon);
            icon.setVisibility(View.VISIBLE);
        }
    }
    public void resume(View v){
        icon = (ImageView) findViewById(R.id.pauseIcon);
        icon.setVisibility(View.VISIBLE);
        icon = (ImageView) findViewById(R.id.playIcon);
        icon.setVisibility(View.INVISIBLE);
        player.start();
    }
    public void stop(View v) {

        stopPlayer();
    }
    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            icon = (ImageView) findViewById(R.id.playIcon);
            icon.setVisibility(View.INVISIBLE);
            icon = (ImageView) findViewById(R.id.pauseIcon);
            icon.setVisibility(View.INVISIBLE);
        }
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

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

}
