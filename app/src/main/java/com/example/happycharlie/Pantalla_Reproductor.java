package com.example.happycharlie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Pantalla_Reproductor extends AppCompatActivity {

    private String dato;
    Button play_pause;
    MediaPlayer mp;
    ImageView iv;
    TextView tv;
    int posicion = 0;
    int aux1 = 0;
    MediaPlayer vectormp [] = new MediaPlayer[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__reproductor);

        dato = getIntent().getStringExtra("dato");

        play_pause = (Button)findViewById(R.id.btn_play);
        iv = (ImageView)findViewById(R.id.imageView);
        tv = (TextView)findViewById(R.id.nomb_cancion);
        int aux = AsignarCanciones();

        posicion = Integer.valueOf(dato);

        int id = 0;
        switch (posicion){
            case 0:
                id = getResources().getIdentifier("cancion1", "drawable", getPackageName());
                tv.setText("Don’t Stop Me Now – Queen");
                break;
            case 1:
                id = getResources().getIdentifier("cancion2", "drawable", getPackageName());
                tv.setText("Dancing Queen – Abba");
                break;
            case 2:
                id = getResources().getIdentifier("cancion3", "drawable", getPackageName());
                tv.setText("Good Vibrations – The Beach Boys");
                break;
            case 3:
                id = getResources().getIdentifier("cancion4", "drawable", getPackageName());
                tv.setText("Uptown Girl – Billy Joel");
                break;
            case 4:
                id = getResources().getIdentifier("cancion5", "drawable", getPackageName());
                tv.setText("Eye Of The Tiger – Survivor");
                break;
            case 5:
                id = getResources().getIdentifier("cancion6", "drawable", getPackageName());
                tv.setText("I’m a Believer – The Monkees");
                break;
            case 6:
                id = getResources().getIdentifier("cancion7", "drawable", getPackageName());
                tv.setText("Girls Just Wanna Have Fun – Cyndi Lauper");
                break;
            case 7:
                id = getResources().getIdentifier("cancion8", "drawable", getPackageName());
                tv.setText("Livin’ On A Prayer – Bon Jovi");
                break;
            case 8:
                id = getResources().getIdentifier("cancion9", "drawable", getPackageName());
                tv.setText("I Will Survive – Gloria Gaynor");
                break;
            case 9:
                id = getResources().getIdentifier("cancion10", "drawable", getPackageName());
                tv.setText("Walking on Sunshine–Katrina & The Waves");
                break;
        }
        iv.setImageResource(id);
        vectormp[posicion].start();
        vectormp[posicion].setLooping(true);
    }

    //Metodo auxiliar para asignar posicion a las canciones
    public int AsignarCanciones(){
        vectormp [0] = MediaPlayer.create(this,R.raw.a1_dont_stop_me_now);
        vectormp [1] = MediaPlayer.create(this,R.raw.a2_dancing_queen);
        vectormp [2] = MediaPlayer.create(this,R.raw.a3_good_vibrations);
        vectormp [3] = MediaPlayer.create(this,R.raw.a4_uptown_girl);
        vectormp [4] = MediaPlayer.create(this,R.raw.a5_eye_of_the_tiger);
        vectormp [5] = MediaPlayer.create(this,R.raw.a6_im_a_believer);
        vectormp [6] = MediaPlayer.create(this,R.raw.a7_girls_just_want_to_have_fun);
        vectormp [7] = MediaPlayer.create(this,R.raw.a8_livin_on_a_prayer);
        vectormp [8] = MediaPlayer.create(this,R.raw.a9_i_will_survive);
        vectormp [9] = MediaPlayer.create(this,R.raw.a10_walking_on_sunshine);
        return 0;
    }

    //Metodo auxiliar para asignar imagenes y nombres a las canciones
    public int AsignarImagNomb(){
        switch (posicion){
            case 0:
                iv.setImageResource(R.drawable.cancion1);
                tv.setText("Don’t Stop Me Now – Queen");
                break;
            case 1:
                iv.setImageResource(R.drawable.cancion2);
                tv.setText("Dancing Queen – Abba");
                break;
            case 2:
                iv.setImageResource(R.drawable.cancion3);
                tv.setText("Good Vibrations – The Beach Boys");
                break;
            case 3:
                iv.setImageResource(R.drawable.cancion4);
                tv.setText("Uptown Girl – Billy Joel");
                break;
            case 4:
                iv.setImageResource(R.drawable.cancion5);
                tv.setText("Eye Of The Tiger – Survivor");
                break;
            case 5:
                iv.setImageResource(R.drawable.cancion6);
                tv.setText("I’m a Believer – The Monkees");
                break;
            case 6:
                iv.setImageResource(R.drawable.cancion7);
                tv.setText("Girls Just Wanna Have Fun – Cyndi Lauper");
                break;
            case 7:
                iv.setImageResource(R.drawable.cancion8);
                tv.setText("Livin’ On A Prayer – Bon Jovi");
                break;
            case 8:
                iv.setImageResource(R.drawable.cancion9);
                tv.setText("I Will Survive – Gloria Gaynor");
                break;
            case 9:
                iv.setImageResource(R.drawable.cancion10);
                tv.setText("Walking on Sunshine–Katrina & The Waves");
                break;
        }
        return 0;
    }

    //Metodo para el boton PlayPause
    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.btn_play_1);
        } else {
            vectormp[posicion].start();
            int aux1 = AsignarImagNomb();
            play_pause.setBackgroundResource(R.drawable.btn_pause_1);
        }
    }

    //Metodo para el boton Stop
    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();
            int aux1 = AsignarCanciones();
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.btn_play_1);
            iv.setImageResource(R.drawable.portada1);
        }
    }

    //Metodo para ir a la siguiente cancion
    public void Siguiente(View view){
        if(posicion < vectormp.length -1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
                int aux2 = AsignarImagNomb();
            } else {
                posicion++;
                int aux2 = AsignarImagNomb();
            }
        } else {
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                int aux3 = AsignarCanciones();
                vectormp[posicion].start();
                Toast.makeText(this, "Ultima Cancion", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Ultima Cancion", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Metodo para la anterior Cancion
    public void Anterior(View view){
        if(posicion >= 1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                int aux3 = AsignarCanciones();
                posicion--;
                int aux4 = AsignarImagNomb();
                vectormp[posicion].start();
            } else {
                posicion--;
                int aux4 = AsignarImagNomb();
            }
        } else {
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                int aux3 = AsignarCanciones();
                vectormp[posicion].start();
                Toast.makeText(this, "Primera Cancion", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Primera Cancion", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Metodo para cancion aleatorea
    public void Aleatoreo(View view){
        int nr = generarNroRandom();
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].stop();
            int aux3 = AsignarCanciones();
            posicion = nr;
            int aux4 = AsignarImagNomb();
            vectormp[posicion].start();
        } else {
            posicion = nr;
            int aux4= AsignarImagNomb();
        }
    }

    //Genera numero random
    public int generarNroRandom(){
        Random miRandom = new Random();
        int rn = miRandom.nextInt(10);
        if(rn != posicion){
            return rn;
        } else {
            int aux = generarNroRandom();
            return aux;
        }
    }

    //Metodo para el boton atras
    public void atras(View view){
        vectormp[posicion].stop();
        vectormp[posicion].release();
        Intent atras = new Intent(this, musica.class);
        startActivity(atras);

    }

    @Override
    public void onBackPressed(){
        vectormp[posicion].stop();
        vectormp[posicion].release();
        Intent atras = new Intent(this, musica.class);
        startActivity(atras);
        finish();
    }
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        tv = (TextView)findViewById(R.id.nomb_cancion);

        switch(key) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_italic.ttf");
                tv.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_italic.ttf");
                tv.setTypeface(nom_fue);
                break;
        }
    }
}
