package com.example.happycharlie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
        private EditText etCodigo, etTipo, etMensaje;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_de_datos);

        etCodigo=(EditText)findViewById(R.id.etCodigoMe);
        etTipo=(EditText)findViewById(R.id.etTipoMe);
        etMensaje=(EditText)findViewById(R.id.etMensajeMe);


    }

    // metodo para registrar los mensajes
    public void guardarMensaje(View view){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "BDMensajes",  null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString();
        String tipo= etTipo.getText().toString();
        String mensaje= etMensaje.getText().toString();

        if(!codigo.isEmpty() && !tipo.isEmpty() && !mensaje.isEmpty()){
            ContentValues registro= new ContentValues();
            registro.put ("codigo", codigo);
            registro.put ("tipo", tipo);
            registro.put ("mensaje", mensaje);

            BaseDeDatos.insert("mensajesAnimo", null, registro);

            BaseDeDatos.close();
            etCodigo.setText("");
            etTipo.setText("");
            etMensaje.setText("");
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText( this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

    // ver mensaje
    public void MostrarMensaje(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BDMensajes",  null,  1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery("select Mensaje from mensajesAnimo where cod=" + codigo,  null);

            if (fila.moveToFirst()){
                etMensaje.setText(fila.getString(0));
                BaseDeDatos.close();

            }else{
                Toast.makeText(this, "No existe Mensaje", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }

        }else{
            Toast.makeText(this, "número de codigo aleatorio", Toast.LENGTH_SHORT).show();
        }
    }
}

