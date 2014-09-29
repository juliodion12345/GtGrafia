package com.tesis.gtgrafia;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
 
public class AndroidBaseDatos extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
 
        //Abrimos la base de datos 'BDD' en modo escritura
        BaseDDatos bdd = new BaseDDatos(this, "BDD", null, 1);
 
        SQLiteDatabase db = bdd.getWritableDatabase();
 
        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
            //Insertar
         
 
            //Cerrar        
        	/* ejemplo query
            String query = "select * from Usuarios;";
            Cursor c = db.rawQuery(query, null);
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                     String codigo= c.getString(0);
                     String nombre = c.getString(1);
                     System.out.println(codigo + " " + nombre);
                } while(c.moveToNext());
           }*/
            db.close();
        }
    }
}