package com.example.happycharlie;

import android.app.Service;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;

public class AudioService extends Service{
    static MediaPlayer myPlayer;
    private final IBinder soundBind = new SoundBinder();
    static String soundName = null;
    private boolean isPlaying = false;

    @Override
    public void onCreate() {
        super.onCreate();
        myPlayer = new MediaPlayer();
    }

    @Override
    public void onStart(Intent intent, int startid) {
        myPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        myPlayer.setAudioAttributes(new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build());
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
        stopSound();
        return false;
    }

    public void setSource(String s) {
        if (s != soundName) {
            if (myPlayer != null)
                myPlayer.reset();
            switch (s) {
                case "fire":
                    myPlayer = MediaPlayer.create(this, R.raw.fire);
                    break;
                case "forest":
                    myPlayer = MediaPlayer.create(this, R.raw.forest);
                    break;
                case "sea":
                    myPlayer = MediaPlayer.create(this, R.raw.sea);
                    break;
                case "rain":
                    myPlayer = MediaPlayer.create(this, R.raw.rain);
                    break;
                case "waterfall":
                    myPlayer = MediaPlayer.create(this, R.raw.waterfall);
                    break;
                case "wind":
                    myPlayer = MediaPlayer.create(this, R.raw.wind);
                    break;
            }
            soundName = s;
            isPlaying = false;
        }
        else
            isPlaying = true;
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

    public void stopSound(){
        if(myPlayer != null) {
            myPlayer.stop();
            myPlayer.release();
            myPlayer = null;
            soundName = null;
        }
    }

    public boolean sameSound() {
        return isPlaying;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}

