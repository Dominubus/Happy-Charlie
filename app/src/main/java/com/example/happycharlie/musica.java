package com.example.happycharlie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.happycharlie.R.id.cancion1;
import static com.example.happycharlie.R.id.cancion10;
import static com.example.happycharlie.R.id.cancion2;
import static com.example.happycharlie.R.id.cancion3;
import static com.example.happycharlie.R.id.cancion4;
import static com.example.happycharlie.R.id.cancion5;
import static com.example.happycharlie.R.id.cancion6;
import static com.example.happycharlie.R.id.cancion7;
import static com.example.happycharlie.R.id.cancion8;
import static com.example.happycharlie.R.id.cancion9;

public class musica extends AppCompatActivity {
    String numCan;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        numCan="";
        b1 =findViewById(cancion1);
        b2 =findViewById(cancion2);
        b3 =findViewById(cancion3);
        b4 =findViewById(cancion4);
        b5 =findViewById(cancion5);
        b6 =findViewById(cancion6);
        b7 =findViewById(cancion7);
        b8 =findViewById(cancion8);
        b9 =findViewById(cancion9);
        b10 =findViewById(cancion10);
    }

    public void irLobby(View view) {
        Intent irLobby = new Intent(this, lobby.class);
        startActivity(irLobby);

    }



    @SuppressLint("NonConstantResourceId")
    public void IrPantallaReproductor(View view){

        switch (view.getId()){
            case R.id.cancion1:
                Toast.makeText(this, "Don't Stop Me Now",Toast.LENGTH_SHORT).show();
                numCan="0";
                break;

            case R.id.cancion2:
                Toast.makeText(this, "Dancing Queen",Toast.LENGTH_SHORT).show();
                numCan="1";
                break;

            case R.id.cancion3:
                Toast.makeText(this, "Good Vibrations",Toast.LENGTH_SHORT).show();
                numCan="2";
                break;
            case R.id.cancion4:
                Toast.makeText(this, "Uptown Girl",Toast.LENGTH_SHORT).show();
                numCan="3";
                break;

            case R.id.cancion5:
                Toast.makeText(this, "Eye Of The Tiger",Toast.LENGTH_SHORT).show();
                numCan="4";
                break;

            case R.id.cancion6:
                Toast.makeText(this, "I'm a Believer",Toast.LENGTH_SHORT).show();
                numCan="5";
                break;

            case R.id.cancion7:
                Toast.makeText(this, "Girls Just Want To Have Fun",Toast.LENGTH_SHORT).show();
                numCan="6";
                break;

            case R.id.cancion8:
                Toast.makeText(this, "Living On A Prayer",Toast.LENGTH_SHORT).show();
                numCan="7";
                break;

            case R.id.cancion9:
                Toast.makeText(this, "I Will Survive",Toast.LENGTH_SHORT).show();
                numCan="8";
                break;

            case R.id.cancion10:
                Toast.makeText(this, "Walking On Sunshine",Toast.LENGTH_SHORT).show();
                numCan="9";
                break;

               }

        Intent pasarpantalla = new Intent(this, Pantalla_Reproductor.class);
        pasarpantalla.putExtra("dato",numCan);
        startActivity(pasarpantalla);
        finish();

    }
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        b1 =findViewById(cancion1);
        b2 =findViewById(cancion2);
        b3 =findViewById(cancion3);
        b4 =findViewById(cancion4);
        b5 =findViewById(cancion5);
        b6 =findViewById(cancion6);
        b7 =findViewById(cancion7);
        b8 =findViewById(cancion8);
        b9 =findViewById(cancion9);
        b10 =findViewById(cancion10);

        switch(key) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_italic.ttf");
                b1.setTypeface(nom_fuen);
                b2.setTypeface(nom_fuen);
                b3.setTypeface(nom_fuen);
                b4.setTypeface(nom_fuen);
                b5.setTypeface(nom_fuen);
                b6.setTypeface(nom_fuen);
                b7.setTypeface(nom_fuen);
                b8.setTypeface(nom_fuen);
                b9.setTypeface(nom_fuen);
                b10.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_italic.ttf");
                b1.setTypeface(nom_fue);
                b2.setTypeface(nom_fue);
                b3.setTypeface(nom_fue);
                b4.setTypeface(nom_fue);
                b5.setTypeface(nom_fue);
                b6.setTypeface(nom_fue);
                b7.setTypeface(nom_fue);
                b8.setTypeface(nom_fue);
                b9.setTypeface(nom_fue);
                b10.setTypeface(nom_fue);
                break;
        }
    }
}
