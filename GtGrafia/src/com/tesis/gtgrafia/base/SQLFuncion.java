package com.tesis.gtgrafia.base;

import android.content.Context;
import android.database.Cursor;

/**
 * SQLFuncion
 * Clase estatica que se encarga de juntar algunas funciones necesarias para la base de datos
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
public class SQLFuncion {

	/**
	 * Metodo que devuelve un cursor con la consulta ejecutada
	 * 
	 * @param context El contexto de la actividad
	 * @param consulta La consulta a realizar
	 * @param args SelectionArgs usados para reemplazar los ?
	 * 
	 * @return El cursor de la consulta
	 */
	public static Cursor getConsulta(Context context, String consulta, String[] args) {
		SQLHelper bd = new SQLHelper(context.getApplicationContext(), SQLHelper.DATABASE_VERSION);
		//Abrir la base de datos
		bd.abrir();
			
		//Consultar
		Cursor cursor = bd.Select(consulta, args);
				
		//Cerrar la base de datos
		bd.cerrar();
		
		//Retornar el cursor
		return cursor;
	}
	
	/**
	 * Metodo que inserta un usuario en la base de datos
	 * 
	 * @param context El contexto de la aplicación
	 * @param nombre Nombre del usuario
	 * 
	 * @return El id del usuario insertado
	 */ 
	public static int insertUsuario(Context context, String nombre){
		SQLHelper bd = new SQLHelper(context.getApplicationContext(), SQLHelper.DATABASE_VERSION);
		//Abrir la base de datos
		bd.abrir();
		
		//Insertar al usuario
		int idUsuario = bd.insertUsuario(nombre);
		
		//Cerrar la base de datos
		bd.cerrar();
		
		return idUsuario;
	}
	
	/**
	 * Metodo que inserta un UsuarioNivel en la base de datos
	 * 
	 * @param context El contexto de la aplicación
	 * @param idUsuario ID del usuario
	 * @param idNivel ID del nivel
	 */ 
	public static void insertUsuarioNivel(Context context, int idUsuario, int idNivel){
		SQLHelper bd = new SQLHelper(context.getApplicationContext(), SQLHelper.DATABASE_VERSION);
		//Abrir la base de datos
		bd.abrir();
		
		//Insertar al usuario en UsuarioNivel
		bd.insertUsuarioNivel(idUsuario, idNivel);
		
		//Cerrar la base de datos
		bd.cerrar();
	}
	
	/**
	 * Metodo que inserta una evaluacion en la base de datos
	 * 
	 * @param context El contexto de la aplicación
	 * @param idPregunta ID de la pregunta
	 * @param idUsuario ID del usuario
	 */
	public static void insertEvaluacion(Context context, int idPregunta, int idUsuario){
		SQLHelper bd = new SQLHelper(context.getApplicationContext(), SQLHelper.DATABASE_VERSION);
		//Abrir la base de datos
		bd.abrir();
		
		//Insertar al usuario
		bd.insertEvaluacion(idPregunta, idUsuario);
		
		//Cerrar la base de datos
		bd.cerrar();
	}
	
}
