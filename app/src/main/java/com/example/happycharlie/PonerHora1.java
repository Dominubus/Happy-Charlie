package com.example.happycharlie;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import static android.app.AlertDialog.THEME_HOLO_LIGHT;


public class PonerHora1 extends AppCompatActivity {

    private int  hour, minute;
    private String cal;
    TextView  tv_time;
    Button  time,b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj1);

        tv_time = findViewById(R.id.tv_time);
        time = findViewById(R.id.time);
        b1 = findViewById(R.id.boton_calcular);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(PonerHora1
                        .this, THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker,  int hour, int minute) {
                        if(minute<10 && minute>=0) {
                            tv_time.setText(hour+":0"+minute);
                        }else{
                            tv_time.setText(hour+":"+minute);
                        }

                    }
                }, hour, minute, true);

                timePickerDialog.setTitle("Coloca la hora");
                timePickerDialog.show();
            }
        });

    }


    public void irAcalculadora(View view){
        finish();
    }



    public void irResultados2(View view) {

        if(!tv_time.getText().toString().isEmpty()){
                Intent sg = new Intent(this, CalculadoraResultados2.class);
                sg.putExtra("hora2", tv_time.getText().toString());
                startActivity(sg);
                finish();
        }else {
            Toast.makeText(this, "Debes escoger una hora para continuar o cancelar para retroceder", Toast.LENGTH_LONG).show();
        }
        finish();
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key = sp.getInt("keyf", 1);
        tv_time = findViewById(R.id.tv_time);
        time = findViewById(R.id.time);
        b1 = findViewById(R.id.boton_calcular);

        switch(key) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_regular.ttf");
                time.setTypeface(nom_fuen);
                b1.setTypeface(nom_fuen);
                tv_time.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_bold.ttf");
                time.setTypeface(nom_fue);
                b1.setTypeface(nom_fue);
                tv_time.setTypeface(nom_fue);
                break;
        }
    }

}