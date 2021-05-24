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

}
