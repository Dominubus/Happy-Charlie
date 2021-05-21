package com.example.happycharlie;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.widget.Toast;

public class AudioService extends Service{
    static MediaPlayer myPlayer;
    private final IBinder soundBind = new SoundBinder();
    static String soundName = null;

    @Override
    public void onCreate() {
        super.onCreate();
        myPlayer = new MediaPlayer();
    }

    @Override
    public void onStart(Intent intent, int startid) {
        myPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        myPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    public class SoundBinder extends Binder {
        AudioService getService() {
            return AudioService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return soundBind;
    }

    @Override
    public boolean onUnbind(Intent intent){
        myPlayer.stop();
        myPlayer.release();
        return false;
    }

    public void setSource(String s){
        if (myPlayer != null && s != soundName){
            myPlayer.stop();
            switch (s) {
                case "fire":
                    myPlayer = MediaPlayer.create(this,R.raw.fire);
                    break;
                case "forest":
                    myPlayer = MediaPlayer.create(this,R.raw.forest);
                    break;
                case "sea":
                    myPlayer = MediaPlayer.create(this,R.raw.sea);
                    break;
                case "rain":
                    myPlayer = MediaPlayer.create(this,R.raw.rain);
                    break;
                case "waterfall":
                    myPlayer = MediaPlayer.create(this,R.raw.waterfall);
                    break;
                case "wind":
                    myPlayer = MediaPlayer.create(this,R.raw.wind);
                    break;
            }
            soundName = s;
        }
    }

    public void playSound(){
        if (myPlayer != null) {
            myPlayer.setLooping(true);
            myPlayer.start();
        }
    }

    public void pauseSound(){
        myPlayer.pause();
    }

    public void continueSound(){
        myPlayer.start();
    }

    @Override
    public void onDestroy() {
        myPlayer.release();
        super.onDestroy();
        soundName = null;
    }

}

