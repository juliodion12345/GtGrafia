package com.tesis.gtgrafia.base;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

/**
 * SQLHelper
 * Clase que se encarga de comunicarse a la base de datos
 * 
 * @author Andrea
 * @version 0.1
 * 
 */
public class SQLHelper extends SQLiteOpenHelper {
	
	/**
	 * Etiqueta que almacena el nombre de la base de datos
	 */
	private static final String DATABASE_NAME = "PROYECTO";
	/**
	 * Etiqueta que almacena la version de la base de datos
	 */
	public static final int DATABASE_VERSION = 3;	
	/**
	 * Variable que almacena el script de la base de datos
	 */
	private Script script = null;	
	/**
	 * Variable que almacena el contexto de la aplicación
	 */
	private Context contexto = null;
	
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
		
		//Insertar los datos iniciales
		insertarDatosIniciales(db);		
	}
	
	/**
	 * Metodo que inserta los datos iniciales a la base de datos
	 * 
	 * @param db La base de datos
	 */
	private void insertarDatosIniciales(SQLiteDatabase db) {
		
		try {
			
			//Leer Archivo desde Assets usando el contexto
			InputStream is = contexto.getAssets().open("ScriptInsert.sql");
			
			//Si encontró el archivo
			if (is != null) {
				
				//Iniciar la transacción
				db.beginTransaction();
				
				//Leer linea por linea
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				String line = reader.readLine();
				
				//Ejecutar cada linea si no esta vacia
				while (!TextUtils.isEmpty(line)) {
					db.execSQL(line);
					line = reader.readLine();
				}
				
				//Marcar la transacción como exitosa
				db.setTransactionSuccessful();
				
				//Cerrar el archivo
				is.close();
			}			
			
		} 
		catch (Exception ex) {
			System.out.println(ex);            
		} 
		finally {
			//Finalizar la transacción
			db.endTransaction();
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
       
		db.execSQL("DROP TABLE IF EXISTS Usuario");
		db.execSQL("DROP TABLE IF EXISTS TipoPregunta");
		db.execSQL("DROP TABLE IF EXISTS Nivel");
		db.execSQL("DROP TABLE IF EXISTS Pregunta");
		db.execSQL("DROP TABLE IF EXISTS Opcion");
		db.execSQL("DROP TABLE IF EXISTS UsuarioNivel");
		db.execSQL("DROP TABLE IF EXISTS Evaluacion");
 
		//Se crea la nueva versión de la base de datos
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
	public void insertUsuario(String nombre){
		//Iniciar la transaccion
		this.getWritableDatabase().beginTransaction();
		
		//Crear el contenedor de valores
		ContentValues valores = new ContentValues();
		
		//Insertar valores en el contenedor
		valores.put("nombre", nombre);
		
		//Realizar la inserción y verificar
		if (this.getWritableDatabase().insert("Usuario", null, valores) >=0){
			
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
	public void insertUsuarioNivel(int idUsuario, int idNivel){
		//Iniciar la transaccion
		this.getWritableDatabase().beginTransaction();
		
		//Crear el contenedor de valores
		ContentValues valores = new ContentValues();
		
		//Insertar valores en el contenedor
		valores.put("idUsuario", idUsuario);
		valores.put("idNivel", idNivel);
		
		//Realizar la inserción y verificar
		if (this.getWritableDatabase().insert("UsuarioNivel", null, valores) >=0){
			
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
	public void insertEvaluacion(int idEvaluacion, int idPregunta, int idUsuario){
		//Iniciar la transaccion
		this.getWritableDatabase().beginTransaction();
		
		//Crear el contenedor de valores
		ContentValues valores = new ContentValues();
		
		//Insertar valores en el contenedor
		valores.put("idEvaluacion", idEvaluacion);
		valores.put("idPregunta", idPregunta);
		valores.put("idUsuario", idUsuario);
		
		//Realizar la inserción y verificar
		if (this.getWritableDatabase().insert("Evaluacion", null, valores) >=0){
			
			//Colocar la transacción como exitosa
			this.getWritableDatabase().setTransactionSuccessful();
		}
		
		//Finalizar la transacción
		this.getWritableDatabase().endTransaction();
	}	
    
}
