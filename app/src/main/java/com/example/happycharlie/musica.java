package com.example.happycharlie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.happycharlie.R.*;

public class musica extends AppCompatActivity {

        MediaPlayer mediaPlayer;
        String numCan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_musica);
        mediaPlayer=null;
        numCan= null;
    }

    public void volverLobby(View view) {
        //Intent anterior = new Intent(this, lobby.class);
        //startActivity(anterior);
        finish();
    }

    public void Reproduccion(View view){
        switch (view.getId()){
            case R.id.cancion1:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, raw.a1_dont_stop_me_now);
                }
                mediaPlayer.start();
                Toast.makeText(this, "Don't Stop Me Now",Toast.LENGTH_SHORT).show();
                numCan= "0";

                break;
            case R.id.cancion2:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, raw.a2_dancing_queen);
                }
                mediaPlayer.start();
                Toast.makeText(this, "Dancing Queen",Toast.LENGTH_SHORT).show();
                numCan= "1";
                break;
            case R.id.cancion3:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, raw.a3_good_vibrations);
                }
                mediaPlayer.start();
                Toast.makeText(this, "Good Vibrations",Toast.LENGTH_SHORT).show();
                numCan= "2";
                break;
            case R.id.cancion4:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, raw.a4_uptown_girl);
                }
                mediaPlayer.start();
                Toast.makeText(this, "Uptown Girl",Toast.LENGTH_SHORT).show();
                numCan= "3";
                break;
            case R.id.cancion5:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, raw.a5_eye_of_the_tiger);
                }
                mediaPlayer.start();
                Toast.makeText(this, "Eye Of The Tiger",Toast.LENGTH_SHORT).show();
                numCan= "4";
                break;
            case R.id.cancion6:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, raw.a6_im_a_believer);
                }
                mediaPlayer.start();
                Toast.makeText(this, "I'm a Believer",Toast.LENGTH_SHORT).show();
                numCan= "5";
                break;
            case R.id.cancion7:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, raw.a7_girls_just_want_to_have_fun);
                }
                mediaPlayer.start();
                Toast.makeText(this, "Girls Just Want To Have Fun",Toast.LENGTH_SHORT).show();
                numCan= "6";
                break;
            case R.id.cancion8:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, raw.a8_livin_on_a_prayer);
                }
                mediaPlayer.start();
                Toast.makeText(this, "Living On A Prayer",Toast.LENGTH_SHORT).show();
                numCan= "7";
                break;
            case R.id.cancion9:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, raw.a9_i_will_survive);
                }
                Toast.makeText(this, "I Will Survive",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                numCan= "8";
                break;
            case R.id.cancion10:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, raw.a10_walking_on_sunshine);
                }
                mediaPlayer.start();
                Toast.makeText(this, "Walking On Sunshine",Toast.LENGTH_SHORT).show();
                numCan= "9";
                break;
        }
        Intent pasarPantalla = new Intent(this, Pantalla_Reproductor.class);
        pasarPantalla.putExtra ("dato",numCan);
        startActivity(pasarPantalla);

    }
}

