package com.example.happycharlie;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;

public class ruido extends AppCompatActivity {

    ImageView btnTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruido);

        btnTempo =findViewById(R.id.timerIcon);

        btnTempo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(ruido.this, PopupTemporizador.class));
            }
        });

    }

    public void volverLobby(View view) {
        finish();
    }

}
