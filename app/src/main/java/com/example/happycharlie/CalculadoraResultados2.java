package com.example.happycharlie;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculadoraResultados2 extends AppCompatActivity {

        private TextView ciclo1,ciclo2,ciclo3,ciclo4,ciclo5,ciclo6,tA;
        private String  mensaje2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculadora_re2);
            ciclo1 =(TextView)findViewById(R.id.text1ciclo2);
            ciclo2 =(TextView)findViewById(R.id.text2ciclo2);
            ciclo3 =(TextView)findViewById(R.id.text3ciclo2);
            ciclo4 =(TextView)findViewById(R.id.text4ciclo2);
            ciclo5 =(TextView)findViewById(R.id.text5ciclo2);
            ciclo6 =(TextView)findViewById(R.id.text6ciclo2);
            tA =(TextView)findViewById(R.id.TextAclaracion);

            mensaje2 = getIntent().getStringExtra("hora2");
            irAdormir();
        }

    public void irAdormir(){

        Date date = null;

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("hh:mm");
        try {
            date = simpleDateFormat.parse(mensaje2); //
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //determina 1° ciclo de sueño
        Calendar t1 = Calendar.getInstance();
        t1.setTime(date);
        t1.add(Calendar.MINUTE, -90);
        t1.getTime();
        ciclo1 = (TextView)findViewById(R.id.text1ciclo2);
        SimpleDateFormat h1 = new SimpleDateFormat("hh:mm a");
        ciclo1.setText("Debes dormir a las "+ h1.format(t1.getTime())+ " " +"para terminar el 1° ciclo.");

        //determina 2° ciclo de sueño
        Calendar t2 = Calendar.getInstance();
        t2.setTime(date);
        t2.add(Calendar.MINUTE, -180);
        t2.getTime();
        ciclo2 = (TextView)findViewById(R.id.text2ciclo2);
        SimpleDateFormat h2 = new SimpleDateFormat("hh:mm a");
        ciclo2.setText("Debes dormir a las "+ h2.format(t2.getTime())+ " " +"para terminar el 2° ciclo.");

        //determina 3° ciclo de sueño
        Calendar t3 = Calendar.getInstance();
        t3.setTime(date);
        t3.add(Calendar.MINUTE, -270);
        t3.getTime();
        ciclo3 = (TextView)findViewById(R.id.text3ciclo2);
        SimpleDateFormat h3 = new SimpleDateFormat("hh:mm a");
        ciclo3.setText("Debes dormir a las "+ h3.format(t3.getTime())+ " " +"para terminar el 3° ciclo.");

        //determina 4° ciclo de sueño
        Calendar t4 = Calendar.getInstance();
        t4.setTime(date);
        t4.add(Calendar.MINUTE, -360);
        t4.getTime();
        ciclo4 = (TextView)findViewById(R.id.text4ciclo2);
        SimpleDateFormat h4 = new SimpleDateFormat("hh:mm a");
        ciclo4.setText("Debes dormir a las "+ h4.format(t4.getTime())+ " " +"para terminar el 4° ciclo.");

        //determina 5° ciclo de sueño
        Calendar t5 = Calendar.getInstance();
        t5.setTime(date);
        t5.add(Calendar.MINUTE, -450);
        t5.getTime();
        ciclo5 = (TextView)findViewById(R.id.text5ciclo2);
        SimpleDateFormat h5 = new SimpleDateFormat("hh:mm a");
        ciclo5.setText("Debes dormir a las "+ h5.format(t5.getTime())+ " " +"para terminar el 5° ciclo y tendrás un sueño reparador.");

        //determina 6° ciclo de sueño
        Calendar t6 = Calendar.getInstance();
        t6.setTime(date);
        t6.add(Calendar.MINUTE, -540);
        t6.getTime();
        ciclo6 = (TextView)findViewById(R.id.text6ciclo2);
        SimpleDateFormat h6 = new SimpleDateFormat("hh:mm a");
        ciclo6.setText("Debes dormir a las "+ h6.format(t6.getTime())+ " " +"para terminar el 6° ciclo y tendrás un sueño reparador.");

    }


    public void irCalculadora(View view) {
        finish();
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        ciclo1 =(TextView)findViewById(R.id.text1ciclo2);
        ciclo2 =(TextView)findViewById(R.id.text2ciclo2);
        ciclo3 =(TextView)findViewById(R.id.text3ciclo2);
        ciclo4 =(TextView)findViewById(R.id.text4ciclo2);
        ciclo5 =(TextView)findViewById(R.id.text5ciclo2);
        ciclo6 =(TextView)findViewById(R.id.text6ciclo2);
        tA =(TextView)findViewById(R.id.TextAclaracion);
        switch(key) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_regular.ttf");
                ciclo1.setTypeface(nom_fuen);
                ciclo2.setTypeface(nom_fuen);
                ciclo3.setTypeface(nom_fuen);
                ciclo4.setTypeface(nom_fuen);
                ciclo5.setTypeface(nom_fuen);
                ciclo6.setTypeface(nom_fuen);
                tA.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_bold.ttf");
                ciclo1.setTypeface(nom_fue);
                ciclo2.setTypeface(nom_fue);
                ciclo3.setTypeface(nom_fue);
                ciclo4.setTypeface(nom_fue);
                ciclo5.setTypeface(nom_fue);
                ciclo6.setTypeface(nom_fue);
                tA.setTypeface(nom_fue);
                break;
        }
    }
}


