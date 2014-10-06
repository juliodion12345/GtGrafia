package com.tesis.gtgrafia.leccion;

import android.content.Context;
import android.database.Cursor;

import com.tesis.gtgrafia.base.SQLFuncion;

/**
 * LeccionFuncion
 * Clase estatica que se encarga de juntar algunas funciones necesarias para Leccion
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
public class LeccionFuncion {
	
	/**
	 * Metodo que devuelve el nombre del nivel
	 * 
	 * @param context El contexto de la actividad
	 * @param idNivel El id del nivel
	 * 
	 * @return El id del nivel
	 */
	public static String getNombreNivel(Context context, int idNivel) {
		//Variable que devolvera el nombre
		String nombre = "";
						
		//La consulta para obtener el nombre
		String consulta = 	"SELECT nombre " +
							"FROM Nivel " +
							"WHERE idNivel = ?" ;
		
		String[] args = {String.valueOf(idNivel)};

		//Consultar
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, args);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Colocar ultimo valor
				nombre = cursor.getString(cursor.getColumnIndex("nombre"));
			}
			
			cursor.close();
		}
		
		//Retorna el nombre
		return nombre;
	}
	
	/**
	 * Metodo que devuelve el nombre del archivo
	 * 
	 * @param context El contexto de la actividad
	 * @param nobre El nombre del nivel
	 * 
	 * @return El id del nivel
	 */
	public static String getArchivo(Context context, int idNivel) {
		//Variable que devolvera el archivo
		String archivo = "";
						
		//La consulta para obtener el archivo
		String consulta = 	"SELECT archivo " +
							"FROM Nivel " +
							"WHERE idNivel = ?" ;
		
		String[] args = {String.valueOf(idNivel)};

		//Consultar
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, args);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Colocar ultimo valor
				archivo = cursor.getString(cursor.getColumnIndex("archivo"));
			}
			
			cursor.close();
		}
		
		//Retorna el nombre del archivo
		return archivo;
	}

}
