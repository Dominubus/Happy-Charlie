
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

public class PonerHora2 extends AppCompatActivity {

        private int  hour, minute;
        TextView  tv_time;
        Button  time;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_reloj2);

            tv_time = findViewById(R.id.tv_time);
            time = findViewById(R.id.time);

            time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final Calendar c = Calendar.getInstance();
                    hour = c.get(Calendar.HOUR_OF_DAY);
                    minute = c.get(Calendar.MINUTE);

                    TimePickerDialog timePickerDialog = new TimePickerDialog(PonerHora2.this, THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int hour, int min) {

                            tv_time.setText(hour+":"+ min);
                        }
                    }, hour, minute, true);

                    timePickerDialog.setTitle("Coloca la hora");
                    timePickerDialog.show();
                }
            });

        }

    public void irResultados3(View view){
        Intent sg = new Intent(PonerHora2.this, CalculadoraResultados3.class);
//        sg.putExtra("hora3", tv_time.getText().toString());
        startActivity(sg);
    }

    public void irAcalculadora(View view){
        Intent i = new Intent(this, calculadora.class);
        startActivity(i);
        finish();
    }
}