package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Pantalla_Reproductor extends AppCompatActivity {

    private String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__reproductor);

        dato = getIntent().getStringExtra("dato");
    }
}