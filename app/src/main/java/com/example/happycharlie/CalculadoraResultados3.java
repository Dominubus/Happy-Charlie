package com.example.happycharlie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculadoraResultados3 extends AppCompatActivity {

        private TextView ciclo1,ciclo2,ciclo3,ciclo4,ciclo5,ciclo6;
        private String  mensaje3;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculadora_re3);

            mensaje3="";
            mensaje3 = getIntent().getStringExtra("hora3");
            despertar();
        }

        public void despertar(){

            Date date = new Date();

            SimpleDateFormat simpleDateFormat= new SimpleDateFormat("hh:mm aa");
            try {
                date = simpleDateFormat.parse(mensaje3);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //determina 1° ciclo de sueño
            Calendar t1 = Calendar.getInstance();
            t1.setTime(date);
            t1.add(Calendar.MINUTE, +90);
            t1.getTime();
            ciclo1 = (TextView)findViewById(R.id.text1ciclo3);
            SimpleDateFormat h1 = new SimpleDateFormat("hh:mm aa");
            ciclo1.setText("El 1° ciclo termina a las "+ h1.format(t1.getTime()));

            //determina 2° ciclo de sueño
            Calendar t2 = Calendar.getInstance();
            t2.setTime(date);
            t2.add(Calendar.MINUTE, +180);
            t2.getTime();
            ciclo2 = (TextView)findViewById(R.id.text2ciclo3);
            SimpleDateFormat h2 = new SimpleDateFormat("hh:mm aa");
            ciclo2.setText("El 2° ciclo termina a las "+ h2.format(t2.getTime()));

            //determina 3° ciclo de sueño
            Calendar t3 = Calendar.getInstance();
            t3.setTime(date);
            t3.add(Calendar.MINUTE, +270);
            t3.getTime();
            ciclo3 = (TextView)findViewById(R.id.text3ciclo3);
            SimpleDateFormat h3 = new SimpleDateFormat("hh:mm aa");
            ciclo3.setText("El 3° ciclo termina a las "+ h3.format(t3.getTime()));

            //determina 4° ciclo de sueño
            Calendar t4 = Calendar.getInstance();
            t4.setTime(date);
            t4.add(Calendar.MINUTE, +360);
            t4.getTime();
            ciclo4 = (TextView)findViewById(R.id.text4ciclo3);
            SimpleDateFormat h4 = new SimpleDateFormat("hh:mm aa");
            ciclo4.setText("El 4° ciclo termina a las "+ h4.format(t4.getTime()));

            //determina 5° ciclo de sueño
            Calendar t5 = Calendar.getInstance();
            t5.setTime(date);
            t5.add(Calendar.MINUTE, +450);
            t5.getTime();
            ciclo5 = (TextView)findViewById(R.id.text5ciclo3);
            SimpleDateFormat h5 = new SimpleDateFormat("hh:mm aa");
            ciclo5.setText("El 5° ciclo termina a las "+ h5.format(t5.getTime()));

            //determina 6° ciclo de sueño
            Calendar t6 = Calendar.getInstance();
            t6.setTime(date);
            t6.add(Calendar.MINUTE, +540);
            t6.getTime();
            ciclo6 = (TextView)findViewById(R.id.text6ciclo3);
            SimpleDateFormat h6 = new SimpleDateFormat("hh:mm aa");
            ciclo6.setText("El 6° ciclo termina a las "+ h6.format(t6.getTime()));

        }


    public void irCalculadora(View view) {
        Intent irCalculadora = new Intent(this, calculadora.class);
        startActivity(irCalculadora);
        finish();
    }

}