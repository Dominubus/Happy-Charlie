package com.example.happycharlie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class PonerHora2 extends AppCompatActivity {

    private TextView horaRegistrada3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocar_hora2);

    }

    public void irCalculadora(View view) {
        Intent irCalculadora = new Intent(this, calculadora.class);
        startActivity(irCalculadora);
    }

    public void irResultados3(View view) {

        horaRegistrada3 = (TextView) findViewById(R.id.hora_propuesta3);
        Intent ir = new Intent(this, CalculadoraResultados.class);
        ir.putExtra("dato3","3");
        ir.putExtra("hora3", horaRegistrada3.getText().toString());
        startActivity(ir);
    }

}
