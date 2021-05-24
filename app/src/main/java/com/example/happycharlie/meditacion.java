package com.example.happycharlie;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class meditacion extends AppCompatActivity {

    Toast t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditacion);
        t=Toast.makeText(this, "Escoge una de estas fabulosas guías", Toast.LENGTH_SHORT);
    }

    public void mostrarMensaje(View v){
        if(!t.getView().isShown()) {
            int yOffset = v.getHeight();
            View view = t.getView();
            TextView text = (TextView) view.findViewById(android.R.id.message);
            text.setTextAppearance(R.style.toastTextStyle);
            LinearLayout layout = (LinearLayout) t.getView();
            if (layout.getChildCount() > 0) {
                TextView tv = (TextView) layout.getChildAt(0);
                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                t.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, -yOffset);
            }
            t.show();
        }
    }

    public void pasarAReproducir1(View view) {
        Intent siguiente = new Intent(this, repMeditacion.class);
        siguiente.putExtra("bg",1);
        startActivity(siguiente);
    }
    public void pasarAReproducir2(View view) {
        Intent siguiente = new Intent(this, repMeditacion.class);
        siguiente.putExtra("bg",2);
        startActivity(siguiente);
    }
    public void pasarAReproducir3(View view) {
        Intent siguiente = new Intent(this, repMeditacion.class);
        siguiente.putExtra("bg",3);
        startActivity(siguiente);
    }

    public void volverLobby(View view) {
        finish();
    }
    public void onDestroy() {
        t.cancel();
        super.onDestroy();
    }
}
