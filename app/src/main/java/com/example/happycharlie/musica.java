package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

public class musica extends AppCompatActivity {
    String numCan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        numCan="";
    }

    public void irLobby(View view) {
        Intent irLobby = new Intent(this, lobby.class);
        startActivity(irLobby);
        finish();
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
}
