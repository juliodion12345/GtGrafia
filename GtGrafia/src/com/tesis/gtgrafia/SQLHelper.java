package com.tesis.gtgrafia;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

public class SQLHelper extends SQLiteOpenHelper {
	
	/**
	 * Etiqueta que almacena el nombre de la base de datos
	 */
	private static final String DATABASE_NAME = "PROYECTO";
	/**
	 * Etiqueta que almacena la version de la base de datos
	 */
	private static final int DATABASE_VERSION = 1;
	
	/**
	 * Variable que almacena el script de la base de datos
	 */
	private Script script = new Script();
	Context contexto ;
	
	/**
	 * Constructor que crea el SqlHelper
	 * 
	 * @param contexto Contexto de la aplicación
	 * @param version Version de la base de datos 
	 */
	public SQLHelper(Context contexto, int version) {
		super(contexto, DATABASE_NAME, null, version);
		this.contexto = contexto;
		script = new Script();
	}
    
	/**
	 * Metodo que crea la base de datos
	 * 
	 * @param db La base de datos
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {     
		db.execSQL(script.create_usuario);
		db.execSQL(script.create_tipo_pregunta);
		db.execSQL(script.create_nivel);
		db.execSQL(script.create_pregunta);
		db.execSQL(script.create_opcion);
		db.execSQL(script.create_usuario_nivel);
		db.execSQL(script.create_evaluacion);
		//llenar base de datos!
		
		InputStream is = null;
	    try {
	         is = contexto.getAssets().open("ScriptInsert.sql");
	         if (is != null) {
	             db.beginTransaction();
	             BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	             String line = reader.readLine();
	             while (!TextUtils.isEmpty(line)) {
	                 db.execSQL(line);
	                 line = reader.readLine();
	             }
	             db.setTransactionSuccessful();
	         }
	    } catch (Exception ex) {
	        System.out.println(ex);            
	    } finally {
	        db.endTransaction();
	        if (is != null) {
	            try {
	                is.close();
	            } catch (IOException e) {
	                // Muestra log
	            }                
	        }
	    }
		
	}
 
    /**
	 * Metodo que actualiza la base de datos
	 * 
	 * @param db La base de datos
	 * @param versionAnterior Versión anterior de la base de datos
	 * @param versionNueva Versión nueva de la base de datos
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
       
		db.execSQL("DROP TABLE IF EXISTS usuario");
		db.execSQL("DROP TABLE IF EXISTS tipo_pregunta");
		db.execSQL("DROP TABLE IF EXISTS nivel");
		db.execSQL("DROP TABLE IF EXISTS pregunta");
		db.execSQL("DROP TABLE IF EXISTS opcion");
		db.execSQL("DROP TABLE IF EXISTS usuario_nivel");
		db.execSQL("DROP TABLE IF EXISTS evaluacion");
 
		//Se crea la nueva versi�n de la tablas
		onCreate(db);
    }
    	
	/**
	 * Metodo que abre la base de datos
	 */
	public void abrir(){
		this.getWritableDatabase();
	}
    
	/**
	 * Metodo que cierra la base de datos
	 */
	public void cerrar(){
		this.close();
	}    
	
	/**
	 * Metodo que devuelve un cursor con la consulta enviada
	 * 
	 * @param consulta Consulta a la base de datos
	 * @return El cursor con la consulta realizada
	 */    
	public Cursor Select(String consulta){
    	
		//Cursor que obtiene la consulta
		Cursor c = this.getReadableDatabase().rawQuery(consulta, null);
		
		//Mueve el cursor al inicio
		if (c!= null && c.getCount()>0){
			c.moveToFirst();
		}
		
		//Retorna el cursor
		return c;		
	}
	
	/**
	 * Metodo que devuelve un cursor con la consulta enviada
	 * 
	 * @param consulta Consulta a la base de datos
	 * @param args SelectionArgs usados para reemplazar los ?
	 * @return El cursor con la consulta realizada
	 */    
	public Cursor Select(String consulta, String[] args){
    	
		//Cursor que obtiene la consulta
		Cursor c = this.getReadableDatabase().rawQuery(consulta, args);
		
		//Mueve el cursor al inicio
		if (c!= null && c.getCount()>0){
			c.moveToFirst();
		}
		
		//Retorna el cursor
		return c;		
	}
    
	/**
	 * Metodo que inserta un usuario en la base de datos
	 * 
	 * @param nombre Nombre del usuario
	 */ 
	public void InsertUsuario (String nombre){
		//Iniciar la transaccion
		this.getWritableDatabase().beginTransaction();
		
		//Crear el contenedor de valores
		ContentValues valores = new ContentValues();
		
		//Insertar valores en el contenedor
		valores.put("Nombre", nombre);
		
		//Realizar la inserción y verificar
		if (this.getWritableDatabase().insert("usuario", null, valores) >=0){
			
			//Colocar la transacción como exitosa
			this.getWritableDatabase().setTransactionSuccessful();
		}
		
		//Finalizar la transacción
		this.getWritableDatabase().endTransaction();
	}
    
	/**
	 * Metodo que inserta un usuario_nivel en la base de datos
	 * 
	 * @param idUsuario ID del usuario
	 * @param idNivel ID del nivel
	 */ 
	public void InsertUsuario_Nivel (int idUsuario, int idNivel){
		//Iniciar la transaccion
		this.getWritableDatabase().beginTransaction();
		
		//Crear el contenedor de valores
		ContentValues valores = new ContentValues();
		
		//Insertar valores en el contenedor
		valores.put("Usuario_id", idUsuario);
		valores.put("idNivel", idNivel);
		
		//Realizar la inserción y verificar
		if (this.getWritableDatabase().insert("usuario_nivel", null, valores) >=0){
			
			//Colocar la transacción como exitosa
			this.getWritableDatabase().setTransactionSuccessful();
		}
		
		//Finalizar la transacción
		this.getWritableDatabase().endTransaction();
	}
	
	/**
	 * Metodo que inserta una evaluacion en la base de datos
	 * 
	 * @param idEvaluacion ID de la evaluacion
	 * @param idPregunta ID de la pregunta
	 * @param idUsuario ID del usuario
	 */ 
	public void InsertEvaluacion (int idEvaluacion, int idPregunta, int idUsuario){
		//Iniciar la transaccion
		this.getWritableDatabase().beginTransaction();
		
		//Crear el contenedor de valores
		ContentValues valores = new ContentValues();
		
		//Insertar valores en el contenedor
		valores.put("idEvaluacion", idEvaluacion);
		valores.put("idPregunta", idPregunta);
		valores.put("Usuario_id", idUsuario);
		
		//Realizar la inserción y verificar
		if (this.getWritableDatabase().insert("evaluacion", null, valores) >=0){
			
			//Colocar la transacción como exitosa
			this.getWritableDatabase().setTransactionSuccessful();
		}
		
		//Finalizar la transacción
		this.getWritableDatabase().endTransaction();
	}	
    
}
