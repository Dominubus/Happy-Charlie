package com.example.happycharlie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        Intent anterior = new Intent(this, lobby.class);
        startActivity(anterior);
    }
    //Genera numero random y lo convierte en String
    public String generarNroRandom(){
        Random miRandom = new Random();
        return String.valueOf(miRandom.nextInt(10));
    }

    //Metodo para buscar codigo del mensaje en la BD con un numero random
    public String BuscarCodigo() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String men = "";
        String codigo = generarNroRandom();
        Cursor fila = BaseDeDatos.rawQuery("select mensaje from mensajes where codigo =" + codigo, null);
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
    public void cambioEmocion(View view) {
        ImageButton charlie = (ImageButton) findViewById(R.id.charlie);
        int random2 = new Random().nextInt(1) + 1;
        if (actual == 5) {
            actual = new Random().nextInt(2) + 2;
            switch (actual) {
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

        } else {
            int random = new Random().nextInt(3) + 2;
            if (random == actual) {
                actual += random2;
            } else {
                actual = random;
            }
            switch (actual) {
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
                    actual = 5;
                    break;
            }

        }
        tv.setText(BuscarCodigo());
    }
}
