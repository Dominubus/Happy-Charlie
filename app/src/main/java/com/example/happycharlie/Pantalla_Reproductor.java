package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Pantalla_Reproductor extends AppCompatActivity {

    private String dato;
    Button play_pause;
    MediaPlayer mp;
    ImageView iv;
    TextView tv;
    int posicion = 0;
    MediaPlayer vectormp [] = new MediaPlayer[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__reproductor);

        /*if(vectormp[posicion].isPlaying()){
            vectormp[posicion].stop();
        }*/
        dato = getIntent().getStringExtra("dato");

        play_pause = (Button)findViewById(R.id.btn_play);
        iv = (ImageView)findViewById(R.id.imageView);
        tv = (TextView)findViewById(R.id.nomb_cancion);
        int aux = AsignarCanciones();
        posicion = Integer.valueOf(dato);

        int id = 0;
        switch (posicion){
            case 0:
                id = getResources().getIdentifier("img_cancion_1", "drawable", getPackageName());
                tv.setText("Don’t Stop Me Now – Queen");
                break;
            case 1:
                id = getResources().getIdentifier("img_cancion_2", "drawable", getPackageName());
                tv.setText("Dancing Queen – Abba");
                break;
            case 2:
                id = getResources().getIdentifier("img_cancion_3", "drawable", getPackageName());
                tv.setText("Good Vibrations – The Beach Boys");
                break;
            case 3:
                id = getResources().getIdentifier("img_cancion_4", "drawable", getPackageName());
                tv.setText("Uptown Girl – Billy Joel");
                break;
            case 4:
                id = getResources().getIdentifier("img_cancion_5", "drawable", getPackageName());
                tv.setText("Eye Of The Tiger – Survivor");
                break;
            case 5:
                id = getResources().getIdentifier("img_cancion_6", "drawable", getPackageName());
                tv.setText("I’m a Believer – The Monkees");
                break;
            case 6:
                id = getResources().getIdentifier("img_cancion_7", "drawable", getPackageName());
                tv.setText("Girls Just Wanna Have Fun – Cyndi Lauper");
                break;
            case 7:
                id = getResources().getIdentifier("img_cancion_8", "drawable", getPackageName());
                tv.setText("Livin’ On A Prayer – Bon Jovi");
                break;
            case 8:
                id = getResources().getIdentifier("img_cancion_9", "drawable", getPackageName());
                tv.setText("I Will Survive – Gloria Gaynor");
                break;
            case 9:
                id = getResources().getIdentifier("img_cancion_10", "drawable", getPackageName());
                tv.setText("Walking on Sunshine – Katrina & The Waves");
                break;
        }
        iv.setImageResource(id);
        vectormp[posicion].start();

    }

    //Metodo auxiliar para asignar posicion a las canciones
    public int AsignarCanciones(){
        vectormp [0] = MediaPlayer.create(this,R.raw.cancion_1);
        vectormp [1] = MediaPlayer.create(this,R.raw.cancion_2);
        vectormp [2] = MediaPlayer.create(this,R.raw.cancion_3);
        vectormp [3] = MediaPlayer.create(this,R.raw.cancion_4);
        vectormp [4] = MediaPlayer.create(this,R.raw.cancion_5);
        vectormp [5] = MediaPlayer.create(this,R.raw.cancion_6);
        vectormp [6] = MediaPlayer.create(this,R.raw.cancion_7);
        vectormp [7] = MediaPlayer.create(this,R.raw.cancion_8);
        vectormp [8] = MediaPlayer.create(this,R.raw.cancion_9);
        vectormp [9] = MediaPlayer.create(this,R.raw.cancion_10);
        return 0;
    }

    //Metodo auxiliar para asignar imagenes y nombres a las canciones
    public int AsignarImagNomb(){
        switch (posicion){
            case 0:
                iv.setImageResource(R.drawable.img_cancion_1);
                tv.setText("Don’t Stop Me Now – Queen");
                break;
            case 1:
                iv.setImageResource(R.drawable.img_cancion_2);
                tv.setText("Dancing Queen – Abba");
                break;
            case 2:
                iv.setImageResource(R.drawable.img_cancion_3);
                tv.setText("Good Vibrations – The Beach Boys");
                break;
            case 3:
                iv.setImageResource(R.drawable.img_cancion_4);
                tv.setText("Uptown Girl – Billy Joel");
                break;
            case 4:
                iv.setImageResource(R.drawable.img_cancion_5);
                tv.setText("Eye Of The Tiger – Survivor");
                break;
            case 5:
                iv.setImageResource(R.drawable.img_cancion_6);
                tv.setText("I’m a Believer – The Monkees");
                break;
            case 6:
                iv.setImageResource(R.drawable.img_cancion_7);
                tv.setText("Girls Just Wanna Have Fun – Cyndi Lauper");
                break;
            case 7:
                iv.setImageResource(R.drawable.img_cancion_8);
                tv.setText("Livin’ On A Prayer – Bon Jovi");
                break;
            case 8:
                iv.setImageResource(R.drawable.img_cancion_9);
                tv.setText("I Will Survive – Gloria Gaynor");
                break;
            case 9:
                iv.setImageResource(R.drawable.img_cancion_10);
                tv.setText("Walking on Sunshine – Katrina & The Waves");
                break;
        }
        return 0;
    }

    //Metodo para el boton PlayPause
    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.btn_play);
        } else {
            vectormp[posicion].start();
            int aux1 = AsignarImagNomb();
            play_pause.setBackgroundResource(R.drawable.btn_pause);
        }
    }

    //Metodo para el boton Stop
    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();
            int aux1 = AsignarCanciones();
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.btn_play);
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

}