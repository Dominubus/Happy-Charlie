package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class animo extends AppCompatActivity {
    int actual = 2;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animo);
        tv = (TextView)findViewById(R.id.textView4);
        tv.setText(BuscarCodigo());
    }

    public void volverLobby(View view) {
        //Intent anterior = new Intent(this, lobby.class);
        //startActivity(anterior);
        finish();
    }
    //Genera numero random y lo convierte en String
    public String generarNroRandom(){
        Random miRandom = new Random();
        return String.valueOf(miRandom.nextInt(115)+1);
    }

    //Metodo para buscar codigo del mensaje en la BD con un numero random
    public String BuscarCodigo() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "mensajesDeAnimo", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String men = "";
        String codigo = generarNroRandom();
        Cursor fila = BaseDeDatos.rawQuery("select mensaje from mensajesDeAnimo where id =" + codigo, null);
        if(fila.moveToFirst()){
            men = fila.getString(0);
            BaseDeDatos.close();
        }
        return men;
    }

    //Metodo para mandar mensaje al TextView
    public void mandarMensaje(View view){
        String mensajeAleatoreo = BuscarCodigo();
        tv.setText(mensajeAleatoreo);
    }
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("COLOR_MENSAJE", MODE_PRIVATE);
        int key = sp.getInt("key", 1);
        switch (key) {
            case 1:
                tv.setTextColor(Color.parseColor("#000000"));
                break;
            case 2:
                tv.setTextColor(Color.parseColor("#D2691E"));
                break;
            case 3:
                tv.setTextColor(Color.parseColor("#0000FF"));
                break;
            case 4:
                tv.setTextColor(Color.parseColor("#DC143C"));
                break;
            case 5:
                tv.setTextColor(Color.parseColor("#8B008B"));
                break;
            case 6:
                tv.setTextColor(Color.parseColor("#008000"));
                break;
            default:
                tv.setTextColor(Color.parseColor("#000000"));
                break;
        }

        SharedPreferences sp1 = getSharedPreferences("FUENTE_SISTEMA", MODE_PRIVATE);
        int key1 = sp1.getInt("keyf", 1);
        tv = (TextView)findViewById(R.id.textView4);
        switch(key1) {
            case 1:
                Typeface nom_fuen = Typeface.createFromAsset(getAssets(), "font/merriweather_regular.ttf");
                tv.setTypeface(nom_fuen);
                break;
            case 2:
                Typeface nom_fue = Typeface.createFromAsset(getAssets(), "font/raleway_italic.ttf");
                tv.setTypeface(nom_fue);
                break;
        }
    }

}
