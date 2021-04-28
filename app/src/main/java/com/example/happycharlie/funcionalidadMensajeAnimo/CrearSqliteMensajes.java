package com.example.happycharlie.funcionalidadMensajeAnimo;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import android.content.Context;

import androidx.annotation.Nullable;

public class CrearSqliteMensajes extends SQLiteOpenHelper{


    public CrearSqliteMensajes(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("CREATE TABLE mensajesDeAnimo (id int PRIMARY KEY , tipoMensaje TEXT, mensaje TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAntigua, int versionNueva) {
        bd.execSQL("DROP TABLE mensajesDeAnimo");
        onCreate(bd);
    }
}
