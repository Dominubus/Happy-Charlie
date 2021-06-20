package com.example.happycharlie;


import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
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

    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("FONDO_INICIO", MODE_PRIVATE);
        int key = sp.getInt("key", 1);
        ConstraintLayout layout = findViewById(R.id.inicio);
        switch(key) {
            case 1:
                layout.setBackgroundResource(R.drawable.bghuellitas);
                break;
            case 2:
                layout.setBackgroundResource(R.drawable.bg2);
                break;

            case 3:
                layout.setBackgroundResource(R.drawable.bg3);
                break;
            default:
                layout.setBackgroundResource(R.drawable.bghuellitas);
                break;
        }
        TextView mensaje=findViewById(R.id.textView2);
        sp = getSharedPreferences("COLOR_MENSAJE", MODE_PRIVATE);
        key = sp.getInt("key", 1);
        switch(key) {
            case 1:
                mensaje.setTextColor(Color.parseColor("#000000"));
                break;
            case 2:
                mensaje.setTextColor(Color.parseColor("#D2691E"));
                break;

            case 3:
                mensaje.setTextColor(Color.parseColor("#0000FF"));
                break;
            case 4:
                mensaje.setTextColor(Color.parseColor("#DC143C"));
                break;
            case 5:
                mensaje.setTextColor(Color.parseColor("#8B008B"));
                break;
            case 6:
                mensaje.setTextColor(Color.parseColor("#008000"));
                break;
            default:
                mensaje.setTextColor(Color.parseColor("#000000"));
                break;
        }
    }
}
