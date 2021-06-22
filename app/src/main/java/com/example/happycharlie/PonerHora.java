package com.example.happycharlie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class PonerHora extends AppCompatActivity {

        private TextView horaRegistrada2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocar_hora);

    }

    public void irCalculadora(View view) {
        Intent irCalculadora = new Intent(this, calculadora.class);
        startActivity(irCalculadora);
    }

    public void irResultados2(View view) {

            horaRegistrada2 = (TextView) findViewById(R.id.hora_propuesta2);
            Intent ir = new Intent(this, CalculadoraResultados.class);
            ir.putExtra("dato2","2");
            ir.putExtra("hora2", horaRegistrada2.getText().toString());
            startActivity(ir);
    }

}
