package com.tesis.gtgrafia;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLHelper extends SQLiteOpenHelper {
	 
	private static final String DATABASE_NAME = "PROYECTO";
	   private static final int DATABASE_VERSION = 1;
	
	private Script script = new Script();   
    public SQLHelper(Context contexto,int version) {
        super(contexto, DATABASE_NAME, null, version);
        script = new Script();
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
     
        db.execSQL(script.create_usuario);
        db.execSQL(script.create_tipo_pregunta);
        db.execSQL(script.create_nivel);
        db.execSQL(script.create_pregunta);
        db.execSQL(script.create_opcion);
        db.execSQL(script.create_usuario_nivel);
        db.execSQL(script.create_evaluacion);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
       
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS tipo_pregunta");
        db.execSQL("DROP TABLE IF EXISTS nivel");
        db.execSQL("DROP TABLE IF EXISTS pregunta");
        db.execSQL("DROP TABLE IF EXISTS opcion");
        db.execSQL("DROP TABLE IF EXISTS usuario_nivel");
        db.execSQL("DROP TABLE IF EXISTS evaluacion");
 
        //Se crea la nueva versión de la tablas
        onCreate(db);
    }
    
    //aqui se crean todos los metodos para acceder a la base de datos
    
    
    public void abrir(){
 	   this.getWritableDatabase();
    }
    public void cerrar(){
 	   this.close();
    }
    
    public Cursor SelectUsuario(){
 	   Cursor c = this.getReadableDatabase().rawQuery("select * from usuario", null);
 	   if (c!= null && c.getCount()>0){
 		   c.moveToFirst();
 	   }
 	   return c;
    }
    public void InsertUsuario (int id, String nombre){
 	   this.getWritableDatabase().beginTransaction();
 	   ContentValues valores = new ContentValues();
 	   valores.put("Nombre", nombre);
 	   if (this.getWritableDatabase().insert("usuario", null, valores) >=0){
 		   this.getWritableDatabase().setTransactionSuccessful();
 	   }
 	   this.getWritableDatabase().endTransaction();
    }
}
