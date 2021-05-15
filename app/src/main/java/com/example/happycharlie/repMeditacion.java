package com.example.happycharlie;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class repMeditacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_meditacion);
        ConstraintLayout layout = findViewById(R.id.repMeditacion);
        Intent rm = getIntent();
        TextView tv;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        int i = rm.getIntExtra("bg", 1);
        switch(i) {
            case 1:
                layout.setBackgroundResource(R.drawable.skymedbg);
                tv =(TextView) findViewById(R.id.textView8);
                tv.setText(R.string.guia_para_principiantes);
                tv.setTextColor(Color.parseColor("#6C35A6"));
                tv =(TextView) findViewById(R.id.textView11);
                tv.setText(R.string.meditacion1);
                tv.setTextColor(Color.parseColor("#6C35A6"));
                break;
            case 2:
                layout.setBackgroundResource(R.drawable.beachmedbg);
                tv =(TextView) findViewById(R.id.textView8);
                tv.setText(R.string.guia_relajacion);
                tv.setTextColor(Color.parseColor("#000000"));
                tv =(TextView) findViewById(R.id.textView11);
                tv.setText(R.string.meditacion2);
                tv.setTextColor(Color.parseColor("#000000"));
                break;
            case 3:
                layout.setBackgroundResource(R.drawable.salarmedbg);
                tv =(TextView) findViewById(R.id.textView8);
                tv.setText(R.string.guia_paz);
                tv.setTextColor(Color.parseColor("#000000"));
                tv =(TextView) findViewById(R.id.textView11);
                tv.setText(R.string.meditacion3);
                tv.setTextColor(Color.parseColor("#000000"));
                break;
            default:
                break;

        }
    }
    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void retoceder(View view){

    }

    public void adelantar(View view){

    }
    public void reproducir(View view){
        ImageButton btn = (ImageButton)findViewById(R.id.btn_play_pause);
        if(btn.getBackground().equals(R.drawable.btn_play)){
            pause();
        }else{
            if(btn.getBackground().equals(R.drawable.btn_pause)){
                play();
            }
        }
    }
    public void play(){

    }
    public void pause(){

    }

}
