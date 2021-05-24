package com.example.happycharlie;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import android.content.Intent;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MotionEventCompat;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class inicio extends AppCompatActivity {

    private TextView tv;
    Handler mHideHandler = new Handler();
    Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
                finish();
        }
    };
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "mensajesDeAnimo", null, 1);
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);
        if (action==MotionEvent.ACTION_DOWN){
            mHideHandler.removeCallbacks(mHideRunnable);

        }
        return super.onTouchEvent(event);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        mHideHandler.postDelayed(mHideRunnable, 20000);
        iniciar();
        tv = (TextView)findViewById(R.id.textView2);
        tv.setText(BuscarCodigo());

        ImageButton btnClose = (ImageButton) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbarRB);
        setSupportActionBar(toolbar);
    }


    public void SiguientePantalla(View view) {
        mHideHandler.removeCallbacks(mHideRunnable);
        Intent siguiente = new Intent(this, lobby.class);
        startActivity(siguiente);
    }

    //Genera numero random y lo convierte en String
    public String generarNroRandom(){
        Random miRandom = new Random();
        return String.valueOf(miRandom.nextInt(115)+1);
    }

    //Metodo para buscar codigo del mensaje en la BD con un numero random
    public String BuscarCodigo() {
        //AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "mensajesDeAnimo", null, 1);
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
    private void iniciar(){
        if (tamanhoRegistros() == 0) {
            System.out.println("creando");
            String[] texto = leerArchivo();
            SQLiteDatabase db = admin.getWritableDatabase();
            db.beginTransaction();
            for (int i = 0; i < texto.length; i++) {
                String[] linea = texto[i].split(";");
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", linea[0]);
                contentValues.put("tipoMensaje", linea[1]);
                contentValues.put("mensaje", linea[2]);
                db.insert("mensajesDeAnimo", null, contentValues);
            }
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
            db.setTransactionSuccessful();
            db.endTransaction();
        }
    }
    private long tamanhoRegistros(){
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
