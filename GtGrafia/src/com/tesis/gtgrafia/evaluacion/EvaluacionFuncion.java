package com.tesis.gtgrafia.evaluacion;

import android.content.Context;
import android.database.Cursor;

import com.tesis.gtgrafia.base.SQLFuncion;
import com.tesis.gtgrafia.estructura.Evaluacion;
import com.tesis.gtgrafia.pregunta.PreguntaFuncion;

/**
 * EvaluacionFuncion
 * Clase estatica que se encarga de juntar algunas funciones necesarias para Evaluacion
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
public class EvaluacionFuncion {
	
	/**
	 * Metodo que comprueba si el usuario puede acceder al nivel
	 * 
	 * @param context El contexto de la actividad
	 * @param idUsuario El idUsuario a evaluar
	 * @param idNivel El idNivel a evaluar
	 * 
	 * @return La comprobación de acceso al nivel
	 */
	public static boolean comprobarEvaluacion(Context context, int idUsuario, int idNivel) {
		//Variable que devolvera la comprobación
		boolean resultado = false;
		
		//La consulta a realizar
		String consulta = 	"SELECT idUsuario FROM UsuarioNivel " +
							"WHERE idUsuario = ? AND " +
							"idNivel = ?" ;
		
		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(idUsuario), String.valueOf(idNivel)};
		
		//Consultar
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, args);
		
		//Verificar que no sea nulo
		if (cursor != null) {
			
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				resultado = true;				
			}
			
			cursor.close();
		}

		//Retornar la comprobación
		return resultado;
	}
	
	/**
	 * Metodo que devuelve la evaluación a realizar
	 * Se necesita obtener idEvaluacion, idUsuario, idNivel, tipoEvaluacion
	 * nombreNivel y preguntas (listado)
	 * 
	 * @return La evaluación a realizar
	 */
	public static Evaluacion getEvaluacion(Context context, int idUsuario, int idNivel) {
		//Variable que devolvera la evaluacion
		Evaluacion eval = new Evaluacion();	
				
		//Colocar valor idEvaluacion
		eval.setIdEvaluacion(getIdEvaluacion(context));	
		
		//Colocar valor idUsuario
		eval.setIdUsuario(idUsuario);
		
		//Colocar valor idNivel
		eval.setIdNivel(idNivel);
		
		//Colocar valor tipoEvaluacion
		eval.setTipoEvaluacion(getTipoEvaluacion(context, idNivel));
		
		//Colocar valor nombreNivel
		eval.setNombreNivel(getNombreNivel(context, idNivel));
		
		//Colocar valor preguntas
		eval.setPreguntas(PreguntaFuncion.getPreguntas(context, idUsuario, idNivel, 10));
		
		//Retornar la evaluación	
		return eval;
	}
	
	/**
	 * Metodo que devuelve el idEvaluacion
	 * 
	 * @param context El contexto de la actividad
	 * 
	 * @return El ultimo + 1 idEvaluacion
	 */
	public static int getIdEvaluacion(Context context) {
		//Variable que devolvera el idEvaluacion
		int idEvaluacion = -1;
						
		//La consulta para obtener el idEvaluacion
		String consulta = 	"SELECT MAX(idEvaluacion) as 'ultimo' " +
							"FROM Evaluacion" ;

		//Consultar
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, null);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Colocar ultimo valor
				idEvaluacion = cursor.getInt(cursor.getColumnIndex("ultimo")) + 1;
			}
			else {
				//Colocar valor inicial
				idEvaluacion = 1;
			}
			
			cursor.close();
		}
			
		//Retorna el idEvaluacion
		return idEvaluacion;
	}
	
	/**
	 * Metodo que devuelve el tipoEvaluacion
	 * 
	 * @param context El contexto de la actividad
	 * @param idNivel El idNivel del nivel
	 * 
	 * @return El tipo de evaluación
	 */
	public static int getTipoEvaluacion(Context context, int idNivel) {
		//Variable que devolvera el idTipoPregunta
		int tipoEvaluacion = -1;
						
		//La consulta para obtener el idEvaluacion
		String consulta = 	"SELECT idTipoPregunta " +
							"FROM Pregunta " +
							"WHERE idnivel = ? " +
							"LIMIT 1" ;

		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(idNivel)};
		
		//Consultar
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, args);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Asigna el resultado
				tipoEvaluacion = cursor.getInt(cursor.getColumnIndex("idTipoPregunta"));
			}
			
			cursor.close();
		}
			
		//Retorna el idTipoPregunta
		return tipoEvaluacion;
	}
	
	/**
	 * Metodo que devuelve el nombre del nivel
	 * 
	 * @param context El contexto de la actividad
	 * @param idNivel El idNivel del nivel
	 * 
	 * @return El nombre del nivel
	 */
	public static String getNombreNivel(Context context, int idNivel) {
		//Variable que devolvera el idEvaluacion
		String nombreNivel = "";
						
		//La consulta para obtener el idEvaluacion
		String consulta = 	"SELECT nombre " +
							"FROM Nivel " +
							"WHERE idNivel = ?" ;

		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(idNivel)};
		
		//Consultar
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, args);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Asigna el resultado
				nombreNivel = cursor.getString(cursor.getColumnIndex("nombre"));
			}
			
			cursor.close();
		}
				
		//Retorna el nombreNivel
		return nombreNivel;
	}
	
}
