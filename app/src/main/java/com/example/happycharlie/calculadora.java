package com.example.happycharlie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;

import static com.example.happycharlie.R.id.boton_dormirNow;

public class calculadora extends AppCompatActivity {

        TextView hora;
        String tipoCalculo;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        tipoCalculo="";

        //obtener hora
        hora = findViewById(R.id.text_hora);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat h = new SimpleDateFormat("hh:mm a");
        String shora= h.format(new Date());
        hora.setText(shora);
    }

    public void irLobbyC(View view) {
        Intent irLobbyC = new Intent(this, lobby.class);
        startActivity(irLobbyC);
    }

    public void irSiguientePantalla(View v) {

            switch (v.getId()){
                case R.id.boton_dormirNow:
                    Toast.makeText(this, "Cuando se cumplen los ciclos",Toast.LENGTH_LONG).show();
                    tipoCalculo="0";
                    break;

                case R.id.boton_Aquehoradormir:
                    Toast.makeText(this, "Cuando comienzan los ciclos",Toast.LENGTH_LONG).show();
                    tipoCalculo="1";
                    break;
                default:
                    Toast.makeText(this, "Cuando comienzan los ciclos",Toast.LENGTH_LONG).show();
                    tipoCalculo="2";
                    break;
            }

            if(tipoCalculo.equals("0")){
                Intent sig= new Intent(this,CalculadoraResultados.class);
                sig.putExtra("dato",tipoCalculo);
                startActivity(sig);
            }else{
                Intent sig= new Intent(this,PonerHora.class);
//            irPonerHora.putExtra("dato",tipoCalculo);
                startActivity(sig);

            }

    }

}