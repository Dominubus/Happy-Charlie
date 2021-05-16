package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class musica extends AppCompatActivity {

        MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        mediaPlayer=null;
    }

    @SuppressLint("NonConstantResourceId")
    public void Reproduccion(View view){
        switch (view.getId()){
            case R.id.cancion1:
                Toast.makeText(this, "Don't Stop Me Now",Toast.LENGTH_SHORT).show();
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.a1_dont_stop_me_now);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Stop();
                    }
                });
                mediaPlayer.start();

                Intent siguiente = new Intent(this, Pantalla_Reproductor.class);
                startActivity(siguiente);

                break;
            case R.id.cancion2:
                Toast.makeText(this, "Dancing Queen",Toast.LENGTH_SHORT).show();
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.a2_dancing_queen);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Stop();
                    }
                });
                mediaPlayer.start();
                Intent siguiente = new Intent(this, Pantalla_Reproductor.class);
                startActivity(siguiente);
                break;
            case R.id.cancion3:
                Toast.makeText(this, "Good Vibrations",Toast.LENGTH_SHORT).show();
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.a3_good_vibrations);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Stop();
                    }
                });
                mediaPlayer.start();
                Intent siguiente = new Intent(this, Pantalla_Reproductor.class);
                startActivity(siguiente);
                break;
            case R.id.cancion4:
                Toast.makeText(this, "Uptown Girl",Toast.LENGTH_SHORT).show();
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.a4_uptown_girl);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Stop();
                    }
                });
                mediaPlayer.start();
                Intent siguiente = new Intent(this, Pantalla_Reproductor.class);
                startActivity(siguiente);
                break;
            case R.id.cancion5:
                Toast.makeText(this, "Eye Of The Tiger",Toast.LENGTH_SHORT).show();
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.a5_eye_of_the_tiger);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Stop();
                    }
                });
                mediaPlayer.start();
                Intent siguiente = new Intent(this, Pantalla_Reproductor.class);
                startActivity(siguiente);
                break;
            case R.id.cancion6:
                Toast.makeText(this, "I'm a Believer",Toast.LENGTH_SHORT).show();
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.a6_im_a_believer);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Stop();
                    }
                });
                mediaPlayer.start();
                Intent siguiente = new Intent(this, Pantalla_Reproductor.class);
                startActivity(siguiente);
                break;
            case R.id.cancion7:
                Toast.makeText(this, "Girls Just Want To Have Fun",Toast.LENGTH_SHORT).show();
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.a7_girls_just_want_to_have_fun);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Stop();
                    }
                });
                mediaPlayer.start();
                Intent siguiente = new Intent(this, Pantalla_Reproductor.class);
                startActivity(siguiente);
                break;
            case R.id.cancion8:
                Toast.makeText(this, "Living On A Prayer",Toast.LENGTH_SHORT).show();
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.a8_livin_on_a_prayer);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Stop();
                    }
                });
                mediaPlayer.start();
                Intent siguiente = new Intent(this, Pantalla_Reproductor.class);
                startActivity(siguiente);
                break;
            case R.id.cancion9:
                Toast.makeText(this, "I Will Survive",Toast.LENGTH_SHORT).show();
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.a9_i_will_survive);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Stop();
                    }
                });
                mediaPlayer.start();
                Intent siguiente = new Intent(this, Pantalla_Reproductor.class);
                startActivity(siguiente);
                break;
            case R.id.cancion10:
                Toast.makeText(this, "Walking On Sunshine",Toast.LENGTH_SHORT).show();
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.a10_walking_on_sunshine);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Stop();
                    }
                });
                mediaPlayer.start();
                Intent siguiente = new Intent(this, Pantalla_Reproductor.class);
                startActivity(siguiente);
                break;
        }
    }
    private void Stop() {
        mediaPlayer.release();
        mediaPlayer = null;
    }
    @Override
    protected void onStop(){
        super.onStop();
        Stop();
    }
}

