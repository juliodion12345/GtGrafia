package com.tesis.gtgrafia.evaluacion;

import java.util.Locale;

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
		eval.setPreguntas(PreguntaFuncion.getPreguntas(context, idUsuario, idNivel));
		
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
		int idTipoPregunta = -1;
						
		//La consulta para obtener el idTipoPregunta
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
				idTipoPregunta = cursor.getInt(cursor.getColumnIndex("idTipoPregunta"));
			}
			
			cursor.close();
		}
			
		//Retorna el idTipoPregunta
		return idTipoPregunta;
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
		//Variable que devolvera el nombre
		String nombre = "";
						
		//La consulta para obtener el nombre
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
				nombre = cursor.getString(cursor.getColumnIndex("nombre"));
			}
			
			cursor.close();
		}
				
		//Retorna el nombre
		return nombre;
	}
	
	/**
	 * Metodo que devuelve el avance de la evaluacion
	 * 
	 * @param context El contexto de la actividad
	 * @param idUsuario El id del usuario
	 * @param idNivel El id del nivel
	 * 
	 * @return El avance de la evaluación
	 */
	public static String getAvance(Context context, int idUsuario, int idNivel) {
		//Variable que devolvera el nombre
		String avance = "";
		
		//Obtener los totales
		avance = String.valueOf(getTotalPreguntasUsuario(context, idUsuario, idNivel));
		avance = avance.concat("/");
		avance = avance.concat(String.valueOf(getTotalPreguntas(context, idNivel)));
				
		//Retorna el nombre
		return avance;
	}
	
	/**
	 * Metodo que devuelve el total de preguntas de la evaluación del usuario
	 * 
	 * @param context El contexto de la actividad
	 * @param idUsuario El id del usuario
	 * @param idNivel El id del nivel
	 * 
	 * @return El avance de la evaluación
	 */
	public static int getTotalPreguntasUsuario(Context context, int idUsuario, int idNivel) {
		int total = 0;
		
		//La consulta para obtener el total del usuario
		String consulta = 	"SELECT COUNT(1) as 'totalUsuario' " +
							"FROM Evaluacion E " +
							"INNER JOIN Pregunta P ON (E.idPregunta = P.idPregunta) " +
							"WHERE P.idNivel = ? " +
							"AND E.idUsuario = ?" ;
				
		//Sustitución de parametros ?
		String[] argsUsuario = 	{String.valueOf(idNivel), String.valueOf(idUsuario)};
		
		//Consultar
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, argsUsuario);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Asigna el resultado
				total = cursor.getInt(cursor.getColumnIndex("totalUsuario"));
			}
			
			cursor.close();
		}
		
		return total;
	}
	
	/**
	 * Metodo que devuelve el total de preguntas de la evaluación
	 * 
	 * @param context El contexto de la actividad
	 * @param idNivel El id del nivel
	 * 
	 * @return El avance de la evaluación
	 */
	public static int getTotalPreguntas(Context context, int idNivel) {
		int total = 0;
		
		//La consulta para obtener el total del usuario
		String consulta = 	"SELECT COUNT(1) as 'total' " +
							"FROM Pregunta " +
							"WHERE idNivel = ?" ;
				
		//Sustitución de parametros ?
		String[] argsUsuario = 	{String.valueOf(idNivel)};
		
		//Consultar
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, argsUsuario);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Asigna el resultado
				total = cursor.getInt(cursor.getColumnIndex("total"));
			}
			
			cursor.close();
		}
		
		return total;
	}
	
	/**
	 * Metodo que devuelve la comprobación de la respuesta
	 * 
	 * @param respuesta La respuesta correcta
	 * @param respuestaUsuario La respuesta del usuario
	 * 
	 * @return La comprobación de la respuesta
	 */
	public static boolean comprobarRespuesta(String respuesta, String respuestaUsuario) {
		boolean comprobacion = false;
		
		//A minusculas
		respuesta  = respuesta.toLowerCase(Locale.US);
		respuestaUsuario = respuestaUsuario.toLowerCase(Locale.US);
		
		//Comprobar
		if (respuesta.equals(respuestaUsuario)) {
			comprobacion = true;
		}
		
		//Retornar el resultado
		return comprobacion;
	}

	/**
	 * Metodo que inserta la respuesta correcta
	 * 
	 * @param context El contexto de la actividad
	 * @param idPregunta El id de la pregunta
	 * @param idUsuario El id del usuario
	 */
	public static void insertarRespuestaCorrecta(Context context, int idPregunta, int idUsuario) {
		
	}
	
}
