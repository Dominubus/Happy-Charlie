package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pantalla_Musica extends AppCompatActivity {

    private String numCan = "";
    private int aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__musica);
    }

    //Metodo para enviar Numero de Cancion y Pasar a Pantalla Reproductor
    public void IrPantallaReproductor(View view){
        Intent pasarPantalla = new Intent(this, Pantalla_Reproductor.class);
        switch (view.getId()){
            case R.id.btn_mus_1:
                numCan = ""+1;
                pasarPantalla.putExtra("dato", numCan);
                startActivity(pasarPantalla);
                break;
            case R.id.btn_mus_2:
                numCan = ""+2;
                pasarPantalla.putExtra("dato", numCan);
                startActivity(pasarPantalla);
                break;
            case R.id.btn_mus_3:
                numCan = ""+3;
                pasarPantalla.putExtra("dato", numCan);
                startActivity(pasarPantalla);
        }
    }
}