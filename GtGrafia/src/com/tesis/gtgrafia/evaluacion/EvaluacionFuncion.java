/**
 * EvaluacionFuncion
 * Clase estatica que se encarga de juntar algunas funciones necesarias para Evaluacion
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia.evaluacion;

import android.content.Context;
import android.database.Cursor;
import com.tesis.gtgrafia.SQLHelper;
import com.tesis.gtgrafia.estructura.Evaluacion;

public class EvaluacionFuncion {
	
	/**
	 * Metodo que comprueba si el usuario puede acceder al nivel
	 * 
	 * @param context El contexto de la actividad
	 * @param VAR_USUARIO El idUsuario a evaluar
	 * @param VAR_IDNIVEL El idNivel a evaluar
	 * 
	 * @return La comprobación de acceso al nivel
	 */
	public static boolean comprobarEvaluacion(Context context, int VAR_USUARIO, int VAR_IDNIVEL) {
		//Variable que devolvera la comprobación
		boolean resultado = false;
		
		//Obtener la base de datos, usando el contexto de la aplicación
		SQLHelper bd = new SQLHelper(context.getApplicationContext(), 1);
		bd.abrir();
		
		//La consulta a realizar
		String consulta = 	"SELECT Usuario_id FROM usuario_nivel " +
							"WHERE Usuario_id = ? AND " +
							"idNivel = ?" ;
		
		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(VAR_USUARIO), String.valueOf(VAR_IDNIVEL)};
		
		//Consultar
		Cursor cursor = bd.Select(consulta, args);
		
		//Verificar que no sea nulo
		if (cursor != null) {
			
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				resultado = true;
				cursor.close();
			}
		}
		
		//Cerrar la base de datos
		bd.cerrar();
		
		//Retornar la comprobación
		return resultado;
	}
	
	/**
	 * Metodo que devuelve la evaluacón a realizar
	 * 
	 * @return La evaluación a realizar
	 */
	public static Evaluacion getEvaluacion(Context context, int VAR_IDNIVEL) {
		//Variable que devolvera la evaluacion
		Evaluacion eval = new Evaluacion();	
		
		//Obtener la base de datos, usando el contexto de la aplicación
		SQLHelper bd = new SQLHelper(context.getApplicationContext(), 1);
		bd.abrir();
		
		//La consulta a realizar
		String consulta = 	"" ;
		
		//Sustitución de parametros ?
		String[] args = 	{ };
		
		//Consultar
		Cursor cursor = bd.Select(consulta, args);
		
		//Verificar que no sea nulo
		if (cursor != null) {
			
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//resultado = true;
				cursor.close();
			}
		}
		
		//Cerrar la base de datos
		bd.cerrar();
		
		//Retornar la evaluación	
		return eval;
	}

}
