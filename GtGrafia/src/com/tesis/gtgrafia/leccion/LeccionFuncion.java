package com.tesis.gtgrafia.leccion;

import java.util.ArrayList;

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
		//Variable que devolvera el idUsuario
		String nombre = "";
						
		//La consulta para obtener el idEvaluacion
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

}
