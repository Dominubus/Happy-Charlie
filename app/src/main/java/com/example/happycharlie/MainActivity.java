package com.example.happycharlie;

import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.example.happycharlie.funcionalidadMensajeAnimo.CrearSqliteMensajes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_de_datos);  //cambiar lugar de
        iniciar();
    }

    private void iniciar(){
        if (tamanhoRegistros() == 0) {
            String[] texto= leerArchivo();
            CrearSqliteMensajes admin= new CrearSqliteMensajes(this, "mensajesDeAnimo", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            db.beginTransaction();
            for (int i=0; i< texto.length; i++){
                String[] linea = texto[i].split(";");
                ContentValues contentValues= new ContentValues();
                contentValues.put("id", linea[0]);
                contentValues.put("tipoMensaje", linea[1]);
                contentValues.put("mensaje", linea[2]);
                db.insert("mensajesDeAnimo",null,contentValues);
            }
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
            db.setTransactionSuccessful();
            db.endTransaction();
        }else {
            Toast.makeText(this, "Tabla ya esta Registrada", Toast.LENGTH_SHORT).show();
        }
    }
    private long tamanhoRegistros(){
        CrearSqliteMensajes admin= new CrearSqliteMensajes(this, "mensajesDeAnimo",null, 1);
        SQLiteDatabase db= admin.getReadableDatabase();
        long cantidad =  DatabaseUtils.queryNumEntries(db,"mensajesDeAnimo" );
        db.close();
        return cantidad;
    }

    private String[] leerArchivo(){
        InputStream inputStream = getResources().openRawResource(R.raw.registros);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            int i= inputStream.read();
            while (i !=-1){
                byteArrayOutputStream.write(i);
                i= inputStream.read();
            }
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString().split("\n");
    }
}