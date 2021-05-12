package com.example.happycharlie;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.RelativeLayout;

public class repMeditacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_meditacion);
        ConstraintLayout layout = findViewById(R.id.repMeditacion);
        Intent rm = getIntent();
        int i = rm.getIntExtra("bg", 1);
        switch(i) {
            case 1:
                layout.setBackgroundResource(R.drawable.skymedbg);
                break;
            case 2:
                layout.setBackgroundResource(R.drawable.beachmedbg);
                break;
            case 3:
                layout.setBackgroundResource(R.drawable.salarmedbg);
                break;
            default:
                break;

        }
    }

    public void retoceder(View view){

    }

    public void adelantar(View view){

    }
    public void reproducir(View view){
        play();
        pause();
    }
    public void play(){

    }
    public void pause(){

    }

}
