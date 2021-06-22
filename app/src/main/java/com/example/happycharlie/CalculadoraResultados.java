package com.example.happycharlie;

import java.text.ParseException;
import  java.text.SimpleDateFormat;
import  java.util.Date;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class CalculadoraResultados extends AppCompatActivity {

    private String boton1;
    private String boton2;
    private String boton3;
    private String horaEnviada2;
    private String horaEnviada3;
    private TextView ciclo1,ciclo2,ciclo3,ciclo4,ciclo5,ciclo6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_dos);

        boton1 ="";
        boton2 ="";
        boton3 ="";
        horaEnviada2="";
        horaEnviada3="";

        boton1 = getIntent().getStringExtra("dato1");
        if(boton1.equals("1")){
            ahora();
        }

        boton2 = getIntent().getStringExtra("dato2");
        horaEnviada2 = getIntent().getStringExtra("hora2");
        if(boton2.equals("2")){
            Dormir();
        }

        boton3 = getIntent().getStringExtra("dato3");
        horaEnviada3 = getIntent().getStringExtra("hora3");
        if(boton3.equals("3")){
            despertar();
        }

    }

    public void ahora(){
            Date date= new Date();

            //determina 1° ciclo de sueño
            Calendar t1 = Calendar.getInstance();
            t1.setTime(date);
            t1.add(Calendar.MINUTE, +90);
            t1.getTime();
            ciclo1 = (TextView)findViewById(R.id.text1ciclo);
            SimpleDateFormat h1 = new SimpleDateFormat("hh:mm a");
            ciclo1.setText("El 1° ciclo termina a las "+ h1.format(t1.getTime()));

            //determina 2° ciclo de sueño
            Calendar t2 = Calendar.getInstance();
            t2.setTime(date);
            t2.add(Calendar.MINUTE, +180);
            t2.getTime();
            ciclo2 = (TextView)findViewById(R.id.text2ciclo);
            SimpleDateFormat h2 = new SimpleDateFormat("hh:mm a");
            ciclo2.setText("El 2° ciclo termina a las "+ h2.format(t2.getTime()));

            //determina 3° ciclo de sueño
            Calendar t3 = Calendar.getInstance();
            t3.setTime(date);
            t3.add(Calendar.MINUTE, +270);
            t3.getTime();
            ciclo3 = (TextView)findViewById(R.id.text3ciclo);
            SimpleDateFormat h3 = new SimpleDateFormat("hh:mm a");
            ciclo3.setText("El 3° ciclo termina a las "+ h3.format(t3.getTime()));

            //determina 4° ciclo de sueño
            Calendar t4 = Calendar.getInstance();
            t4.setTime(date);
            t4.add(Calendar.MINUTE, +360);
            t4.getTime();
            ciclo4 = (TextView)findViewById(R.id.text4ciclo);
            SimpleDateFormat h4 = new SimpleDateFormat("hh:mm a");
            ciclo4.setText("El 4° ciclo termina a las "+ h4.format(t4.getTime()));

            //determina 5° ciclo de sueño
            Calendar t5 = Calendar.getInstance();
            t5.setTime(date);
            t5.add(Calendar.MINUTE, +450);
            t5.getTime();
            ciclo5 = (TextView)findViewById(R.id.text5ciclo);
            SimpleDateFormat h5 = new SimpleDateFormat("hh:mm a");
            ciclo5.setText("El 5° ciclo termina a las "+ h5.format(t5.getTime()));

            //determina 6° ciclo de sueño
            Calendar t6 = Calendar.getInstance();
            t6.setTime(date);
            t6.add(Calendar.MINUTE, +540);
            t6.getTime();
            ciclo6 = (TextView)findViewById(R.id.text6ciclo);
            SimpleDateFormat h6 = new SimpleDateFormat("hh:mm a");
            ciclo6.setText("El 6° ciclo termina a las "+ h6.format(t6.getTime()));
    }

    public void Dormir(){
            SimpleDateFormat format= new SimpleDateFormat("hh:mm a");
            Date date2 = null;
        try {
            date2 = format.parse(horaEnviada2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //determina 1° ciclo de sueño
            Calendar t1 = Calendar.getInstance();
            t1.setTime(date2);
            t1.add(Calendar.MINUTE, -90);
            t1.getTime();
            ciclo1 = (TextView)findViewById(R.id.text1ciclo);
            SimpleDateFormat h1 = new SimpleDateFormat("hh:mm a");
            ciclo1.setText("Debes dormir a horas "+ h1.format(t1.getTime())+" para cumplir el 1° ciclo.");

            //determina 2° ciclo de sueño
            Calendar t2 = Calendar.getInstance();
            t2.setTime(date2);
            t2.add(Calendar.MINUTE, -180);
            t2.getTime();
            ciclo2 = (TextView)findViewById(R.id.text2ciclo);
            SimpleDateFormat h2 = new SimpleDateFormat("hh:mm a");
            ciclo2.setText("Debes dormir a horas "+ h2.format(t2.getTime())+" para cumplir el 2° ciclo.");

            //determina 3° ciclo de sueño
            Calendar t3 = Calendar.getInstance();
            t3.setTime(date2);
            t3.add(Calendar.MINUTE, -270);
            t3.getTime();
            ciclo3 = (TextView)findViewById(R.id.text3ciclo);
            SimpleDateFormat h3 = new SimpleDateFormat("hh:mm a");
            ciclo3.setText("Debes dormir a horas "+ h3.format(t3.getTime())+" para cumplir el 3° ciclo.");

            //determina 4° ciclo de sueño
            Calendar t4 = Calendar.getInstance();
            t4.setTime(date2);
            t4.add(Calendar.MINUTE, -360);
            t4.getTime();
            ciclo4 = (TextView)findViewById(R.id.text4ciclo);
            SimpleDateFormat h4 = new SimpleDateFormat("hh:mm a");
            ciclo4.setText("Debes dormir a horas "+ h4.format(t4.getTime())+" para cumplir el 4° ciclo.");

            //determina 5° ciclo de sueño
            Calendar t5 = Calendar.getInstance();
            t5.setTime(date2);
            t5.add(Calendar.MINUTE, -450);
            t5.getTime();
            ciclo5 = (TextView)findViewById(R.id.text5ciclo);
            SimpleDateFormat h5 = new SimpleDateFormat("hh:mm a");
            ciclo5.setText("Debes dormir a horas "+ h5.format(t5.getTime())+" para cumplir el 5° ciclo.");

            //determina 6° ciclo de sueño
            Calendar t6 = Calendar.getInstance();
            t6.setTime(date2);
            t6.add(Calendar.MINUTE, -540);
            t6.getTime();
            ciclo6 = (TextView)findViewById(R.id.text6ciclo);
            SimpleDateFormat h6 = new SimpleDateFormat("hh:mm a");
            ciclo6.setText("Debes dormir a horas "+ h6.format(t6.getTime())+" para cumplir el 6° ciclo.");

        }

    public void despertar() {

            SimpleDateFormat format= new SimpleDateFormat("hh:mm a");
            Date date3 = null;
        try {
            date3 = format.parse(horaEnviada3);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //determina 1° ciclo de sueño
            Calendar t1 = Calendar.getInstance();
            t1.setTime(date3);
            t1.add(Calendar.MINUTE, +90);
            t1.getTime();
            ciclo1 = (TextView)findViewById(R.id.text1ciclo);
            SimpleDateFormat h1 = new SimpleDateFormat("hh:mm a");
            ciclo1.setText("El 1° ciclo termina a las "+ h1.format(t1.getTime()));

            //determina 2° ciclo de sueño
            Calendar t2 = Calendar.getInstance();
            t2.setTime(date3);
            t2.add(Calendar.MINUTE, +180);
            t2.getTime();
            ciclo2 = (TextView)findViewById(R.id.text2ciclo);
            SimpleDateFormat h2 = new SimpleDateFormat("hh:mm a");
            ciclo2.setText("El 2° ciclo termina a las "+ h2.format(t2.getTime()));

            //determina 3° ciclo de sueño
            Calendar t3 = Calendar.getInstance();
            t3.setTime(date3);
            t3.add(Calendar.MINUTE, +270);
            t3.getTime();
            ciclo3 = (TextView)findViewById(R.id.text3ciclo);
            SimpleDateFormat h3 = new SimpleDateFormat("hh:mm a");
            ciclo3.setText("El 3° ciclo termina a las "+ h3.format(t3.getTime()));

            //determina 4° ciclo de sueño
            Calendar t4 = Calendar.getInstance();
            t4.setTime(date3);
            t4.add(Calendar.MINUTE, +360);
            t4.getTime();
            ciclo4 = (TextView)findViewById(R.id.text4ciclo);
            SimpleDateFormat h4 = new SimpleDateFormat("hh:mm a");
            ciclo4.setText("El 4° ciclo termina a las "+ h4.format(t4.getTime()));

            //determina 5° ciclo de sueño
            Calendar t5 = Calendar.getInstance();
            t5.setTime(date3);
            t5.add(Calendar.MINUTE, +450);
            t5.getTime();
            ciclo5 = (TextView)findViewById(R.id.text5ciclo);
            SimpleDateFormat h5 = new SimpleDateFormat("hh:mm a");
            ciclo5.setText("El 5° ciclo termina a las "+ h5.format(t5.getTime()));

            //determina 6° ciclo de sueño
            Calendar t6 = Calendar.getInstance();
            t6.setTime(date3);
            t6.add(Calendar.MINUTE, +540);
            t6.getTime();
            ciclo6 = (TextView)findViewById(R.id.text6ciclo);
            SimpleDateFormat h6 = new SimpleDateFormat("hh:mm a");
            ciclo6.setText("El 6° ciclo termina a las "+ h6.format(t6.getTime()));

        }


    public void irCalculadora(View view) {
        Intent irCalculadora = new Intent(this, calculadora.class);
        startActivity(irCalculadora);
    }
    @Override
    public void onBackPressed(){
        Intent atrasC = new Intent(this, calculadora.class);
        startActivity(atrasC);
        finish();
    }

}


