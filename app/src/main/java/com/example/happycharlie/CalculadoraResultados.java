package com.example.happycharlie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class CalculadoraResultados extends AppCompatActivity {

        private String dato;
        private String horaPropuesta;
        TextView ciclo1,ciclo2,ciclo3,ciclo4,ciclo5,ciclo6,des;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_dos);
        des = (TextView)findViewById(R.id.TextAclaracion);
        ciclo1 = (TextView)findViewById(R.id.text1ciclo);
        ciclo2 = (TextView)findViewById(R.id.text2ciclo);
        ciclo3 = (TextView)findViewById(R.id.text3ciclo);
        ciclo4 = (TextView)findViewById(R.id.text4ciclo);
        ciclo5 = (TextView)findViewById(R.id.text5ciclo);
        ciclo6 = (TextView)findViewById(R.id.text6ciclo);
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


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void calcularCiclos() throws ParseException {
        dato = getIntent().getStringExtra("dato");
        if(dato.equals("0")){

            Date date = new Date();

            //determina 1° ciclo de sueño
            Calendar hora1 = Calendar.getInstance();
            hora1.setTime(date);
            hora1.add(Calendar.MINUTE, 90);
            hora1.getTime();
            ciclo1 = (TextView)findViewById(R.id.text1ciclo);
            SimpleDateFormat h1 = new SimpleDateFormat("hh:mm a");
            String sciclo1= h1.format(hora1.getTime());
            ciclo1.setText("El 1° ciclo dura hasta las "+ sciclo1);

            //determina 2° ciclo de sueño
            Calendar hora2 = Calendar.getInstance();
            hora2.setTime(date);
            hora2.add(Calendar.MINUTE, 180);
            hora2.getTime();
            ciclo2 = (TextView) findViewById(R.id.text2ciclo);
            SimpleDateFormat h2 = new SimpleDateFormat("hh:mm a");
            String sciclo2= h2.format(hora2.getTime());
            ciclo2.setText("El 2° ciclo dura hasta las "+ sciclo2);

            //determina 3° ciclo de sueño
            Calendar hora3 = Calendar.getInstance();
            hora3.setTime(date);
            hora3.add(Calendar.MINUTE, 270);
            hora3.getTime();
            ciclo3 = (TextView) findViewById(R.id.text3ciclo);
            SimpleDateFormat h3 = new SimpleDateFormat("hh:mm a");
            String sciclo3= h3.format(hora3.getTime());
            ciclo3.setText("El 3° ciclo dura hasta las "+ sciclo3);

            //determina 4° ciclo de sueño
            Calendar hora4 = Calendar.getInstance();
            hora4.setTime(date);
            hora4.add(Calendar.MINUTE, 360);
            hora4.getTime();
            ciclo4 = (TextView) findViewById(R.id.text4ciclo);
            SimpleDateFormat h4 = new SimpleDateFormat("hh:mm a");
            String sciclo4= h4.format(hora4.getTime());
            ciclo4.setText("El 4° ciclo dura hasta las "+ sciclo4);

            //determina 5° ciclo de sueño
            Calendar hora5 = Calendar.getInstance();
            hora5.setTime(date);
            hora5.add(Calendar.MINUTE, 450);
            hora5.getTime();
            ciclo5 = (TextView) findViewById(R.id.text5ciclo);
            SimpleDateFormat h5 = new SimpleDateFormat("hh:mm a");
            String sciclo5= h5.format(hora5.getTime());
            ciclo5.setText("El 5° ciclo dura hasta las "+ sciclo5);

            //determina 6° ciclo de sueño
            Calendar hora6 = Calendar.getInstance();
            hora6.setTime(date);
            hora6.add(Calendar.MINUTE, 540);
            hora6.getTime();
            ciclo6 = (TextView) findViewById(R.id.text6ciclo);
            SimpleDateFormat h6 = new SimpleDateFormat("hh:mm a");
            String sciclo6= h6.format(hora6.getTime());
            ciclo6.setText("El 6° ciclo dura hasta las "+ sciclo6);

        }
        else if(dato.equals("1")){

            SimpleDateFormat hs = new SimpleDateFormat("hh:mm a");
            horaPropuesta = getIntent().getStringExtra("date");
            Date varhora = hs.parse(horaPropuesta);

            //determina 1° ciclo de sueño
            Calendar hora1 = Calendar.getInstance();
            hora1.setTime(varhora);
            hora1.add(Calendar.MINUTE, -90);
            hora1.getTime();
            ciclo1 = (TextView)findViewById(R.id.text1ciclo);
            SimpleDateFormat h1 = new SimpleDateFormat("hh:mm a");
            String sciclo1= h1.format(hora1.getTime());
            ciclo1.setText("Dormir a las "+ sciclo1+" para llegar al 1° ciclo.");

            //determina 2° ciclo de sueño
            Calendar hora2 = Calendar.getInstance();
            hora2.setTime(varhora);
            hora2.add(Calendar.MINUTE, -180);
            hora2.getTime();
            ciclo2 = (TextView) findViewById(R.id.text2ciclo);
            SimpleDateFormat h2 = new SimpleDateFormat("hh:mm a");
            String sciclo2= h2.format(hora2.getTime());
            ciclo2.setText("Dormir a las "+ sciclo2+" para llegar al 2° ciclo.");

            //determina 3° ciclo de sueño
            Calendar hora3 = Calendar.getInstance();
            hora3.setTime(varhora);
            hora3.add(Calendar.MINUTE, -270);
            hora3.getTime();
            ciclo3 = (TextView) findViewById(R.id.text3ciclo);
            SimpleDateFormat h3 = new SimpleDateFormat("hh:mm a");
            String sciclo3= h3.format(hora3.getTime());
            ciclo3.setText("Dormir a las "+ sciclo3+" para llegar al 3° ciclo.");

            //determina 4° ciclo de sueño
            Calendar hora4 = Calendar.getInstance();
            hora4.setTime(varhora);
            hora4.add(Calendar.MINUTE, -360);
            hora4.getTime();
            ciclo4 = (TextView) findViewById(R.id.text4ciclo);
            SimpleDateFormat h4 = new SimpleDateFormat("hh:mm a");
            String sciclo4= h4.format(hora4.getTime());
            ciclo4.setText("Dormir a las "+ sciclo4+" para llegar al 4° ciclo.");

            //determina 5° ciclo de sueño
            Calendar hora5 = Calendar.getInstance();
            hora5.setTime(varhora);
            hora5.add(Calendar.MINUTE, -450);
            hora5.getTime();
            ciclo5 = (TextView) findViewById(R.id.text5ciclo);
            SimpleDateFormat h5 = new SimpleDateFormat("hh:mm a");
            String sciclo5= h5.format(hora5.getTime());
            ciclo5.setText("Dormir a las "+ sciclo5+" para llegar al 5° ciclo.");

            //determina 6° ciclo de sueño
            Calendar hora6 = Calendar.getInstance();
            hora6.setTime(varhora);
            hora6.add(Calendar.MINUTE, -540);
            hora6.getTime();
            ciclo6 = (TextView) findViewById(R.id.text6ciclo);
            SimpleDateFormat h6 = new SimpleDateFormat("hh:mm a");
            String sciclo6= h6.format(hora6.getTime());
            ciclo6.setText("Dormir a las "+ sciclo6+" para llegar al 6° ciclo.");

        }else if(dato.equals("2")){
            SimpleDateFormat hs = new SimpleDateFormat("hh:mm a");
            horaPropuesta = getIntent().getStringExtra("date");
            Date varhora = hs.parse(horaPropuesta);

            //determina 1° ciclo de sueño
            Calendar hora1 = Calendar.getInstance();
            hora1.setTime(varhora);
            hora1.add(Calendar.MINUTE, 90);
            hora1.getTime();
            ciclo1 = (TextView)findViewById(R.id.text1ciclo);
            SimpleDateFormat h1 = new SimpleDateFormat("hh:mm a");
            String sciclo1= h1.format(hora1.getTime());
            ciclo1.setText("El 1° ciclo dura hasta las "+ sciclo1);

            //determina 2° ciclo de sueño
            Calendar hora2 = Calendar.getInstance();
            hora2.setTime(varhora);
            hora2.add(Calendar.MINUTE, 180);
            hora2.getTime();
            ciclo2 = (TextView) findViewById(R.id.text2ciclo);
            SimpleDateFormat h2 = new SimpleDateFormat("hh:mm a");
            String sciclo2= h2.format(hora2.getTime());
            ciclo2.setText("El 2° ciclo dura hasta las "+ sciclo2);

            //determina 3° ciclo de sueño
            Calendar hora3 = Calendar.getInstance();
            hora3.setTime(varhora);
            hora3.add(Calendar.MINUTE, 270);
            hora3.getTime();
            ciclo3 = (TextView) findViewById(R.id.text3ciclo);
            SimpleDateFormat h3 = new SimpleDateFormat("hh:mm a");
            String sciclo3= h3.format(hora3.getTime());
            ciclo3.setText("El 3° ciclo dura hasta las "+ sciclo3);

            //determina 4° ciclo de sueño
            Calendar hora4 = Calendar.getInstance();
            hora4.setTime(varhora);
            hora4.add(Calendar.MINUTE, 360);
            hora4.getTime();
            ciclo4 = (TextView) findViewById(R.id.text4ciclo);
            SimpleDateFormat h4 = new SimpleDateFormat("hh:mm a");
            String sciclo4= h4.format(hora4.getTime());
            ciclo4.setText("El 4° ciclo dura hasta las "+ sciclo4);

            //determina 5° ciclo de sueño
            Calendar hora5 = Calendar.getInstance();
            hora5.setTime(varhora);
            hora5.add(Calendar.MINUTE, 450);
            hora5.getTime();
            ciclo5 = (TextView) findViewById(R.id.text5ciclo);
            SimpleDateFormat h5 = new SimpleDateFormat("hh:mm a");
            String sciclo5= h5.format(hora5.getTime());
            ciclo5.setText("El 5° ciclo dura hasta las "+ sciclo5);

            //determina 6° ciclo de sueño
            Calendar hora6 = Calendar.getInstance();
            hora6.setTime(varhora);
            hora6.add(Calendar.MINUTE, 540);
            hora6.getTime();
            ciclo6 = (TextView) findViewById(R.id.text6ciclo);
            SimpleDateFormat h6 = new SimpleDateFormat("hh:mm a");
            String sciclo6= h6.format(hora6.getTime());
            ciclo6.setText("El 6° ciclo dura hasta las "+ sciclo6);
        }
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        des = (TextView)findViewById(R.id.TextAclaracion);
        ciclo1 = (TextView)findViewById(R.id.text1ciclo);
        ciclo2 = (TextView)findViewById(R.id.text2ciclo);
        ciclo3 = (TextView)findViewById(R.id.text3ciclo);
        ciclo4 = (TextView)findViewById(R.id.text4ciclo);
        ciclo5 = (TextView)findViewById(R.id.text5ciclo);
        ciclo6 = (TextView)findViewById(R.id.text6ciclo);

        switch(key) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_italic.ttf");
                des.setTypeface(nom_fuen);
                ciclo1.setTypeface(nom_fuen);
                ciclo2.setTypeface(nom_fuen);
                ciclo3.setTypeface(nom_fuen);
                ciclo4.setTypeface(nom_fuen);
                ciclo5.setTypeface(nom_fuen);
                ciclo6.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_italic.ttf");
                des.setTypeface(nom_fue);
                ciclo1.setTypeface(nom_fue);
                ciclo2.setTypeface(nom_fue);
                ciclo3.setTypeface(nom_fue);
                ciclo4.setTypeface(nom_fue);
                ciclo5.setTypeface(nom_fue);
                ciclo6.setTypeface(nom_fue);
                break;
        }
    }
}


