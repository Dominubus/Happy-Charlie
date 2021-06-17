package com.example.happycharlie;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class configuracion extends AppCompatActivity {

    Button btnbg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        btnbg =findViewById(R.id.botonBG);

        btnbg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {startActivity(new Intent(configuracion.this, menu_emergente_fondos.class));}
        });
    }

}
