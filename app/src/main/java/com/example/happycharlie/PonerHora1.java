package com.example.happycharlie;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import static android.app.AlertDialog.THEME_HOLO_LIGHT;


public class PonerHora1 extends AppCompatActivity {

    private int  hour, minute;
    TextView  tv_time;
    Button time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj1);

        tv_time = findViewById(R.id.tv_time);
        time = findViewById(R.id.time);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(PonerHora1.this, THEME_HOLO_LIGHT,  new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int min) {
                        String meridiano;
                        if(hour>12){
                            hour= hour-12;
                            meridiano="p.m.";
                        }else{
                            meridiano="a.m.";
                        }
                        tv_time.setText(hour + ":" + min + " " + meridiano);
                    }
                }, hour, minute, true);

                timePickerDialog.setTitle("Coloca la hora para acostarte");
                timePickerDialog.show();
                tv_time.setVisibility(View.VISIBLE);
            }
        });

    }

    public void irAcalculadora(View view) {
        Intent irCalculadora = new Intent(this, calculadora.class);
        startActivity(irCalculadora);
        finish();
    }

    public void irResultados2(View view) {

        Intent sg = new Intent(this, CalculadoraResultados2.class);
        sg.putExtra("hora2", tv_time.getText().toString());
        startActivity(sg);
        finish();
    }
}

