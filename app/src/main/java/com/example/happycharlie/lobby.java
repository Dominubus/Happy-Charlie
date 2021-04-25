package com.example.happycharlie;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class lobby extends AppCompatActivity {
    int actual = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);



    }

    public void pantallaAnimo(View view) {
        Intent siguiente = new Intent(this, animo.class);
        startActivity(siguiente);
    }

    public void cambioEmocion(View view) {
        ImageButton charlie = (ImageButton)findViewById(R.id.charlie);
        int random2 = new Random().nextInt(1) + 1;
        if(actual==5){
            actual = new Random().nextInt(2) + 2;
            switch(actual){
                case 2:
                    charlie.setImageResource(R.drawable.pug2);
                    break;
                case 3:
                    charlie.setImageResource(R.drawable.pug3);
                    break;
                case 4:
                    charlie.setImageResource(R.drawable.pug4);
                    break;
                default:
                    break;
            }

        }else {
            int random = new Random().nextInt(3) + 2;
            if (random == actual) {
                actual+=random2;
            }else{
                actual=random;
            }
            switch(actual){
                    case 2:
                        charlie.setImageResource(R.drawable.pug2);
                        break;
                    case 3:
                        charlie.setImageResource(R.drawable.pug3);
                        break;
                    case 4:
                        charlie.setImageResource(R.drawable.pug4);
                        break;
                    case 5:
                        charlie.setImageResource(R.drawable.pug5);
                        break;
                    default:
                        charlie.setImageResource(R.drawable.pug5);
                        actual=5;
                        break;
            }

        }
    }

}
