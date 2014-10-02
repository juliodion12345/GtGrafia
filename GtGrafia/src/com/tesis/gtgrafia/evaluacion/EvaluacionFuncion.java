/**
 * EvaluacionFuncion
 * Clase estatica que se encarga de juntar algunas funciones necesarias para Evaluacion
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia.evaluacion;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import com.tesis.gtgrafia.SQLHelper;
import com.tesis.gtgrafia.estructura.Evaluacion;
import com.tesis.gtgrafia.estructura.Opcion;
import com.tesis.gtgrafia.estructura.Pregunta;

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
		String consulta = 	"SELECT Usuario_id FROM usuario_nivel " +
							"WHERE Usuario_id = ? AND " +
							"idNivel = ?" ;
		
		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(idUsuario), String.valueOf(idNivel)};
		
		//Consultar
		Cursor cursor = getCursor(context, consulta, args);
		
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
		eval.setPreguntas(getPreguntas(context, idUsuario, idNivel, 10));
		
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
		int idEvaluacion = 0;
						
		//La consulta para obtener el idEvaluacion
		String consulta = 	"SELECT MAX(idEvaluacion) as 'Ultimo' " +
							"FROM evaluacion" ;

		//Consultar
		Cursor cursor = getCursor(context, consulta, null);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Colocar ultimo valor
				idEvaluacion = cursor.getInt(cursor.getColumnIndex("Ultimo")) + 1;
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
		int tipoEvaluacion = 0;
						
		//La consulta para obtener el idEvaluacion
		String consulta = 	"SELECT idtipo_pregunta " +
							"FROM pregunta " +
							"WHERE idnivel = ? " +
							"LIMIT 1" ;

		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(idNivel)};
		
		//Consultar
		Cursor cursor = getCursor(context, consulta, args);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Asigna el resultado
				tipoEvaluacion = cursor.getInt(cursor.getColumnIndex("idtipo_pregunta"));
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
		String consulta = 	"SELECT Nombre " +
							"FROM nivel " +
							"WHERE idNivel = ?" ;

		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(idNivel)};
		
		//Consultar
		Cursor cursor = getCursor(context, consulta, args);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Asigna el resultado
				nombreNivel = cursor.getString(cursor.getColumnIndex("Nombre"));
			}
			
			cursor.close();
		}
				
		//Retorna el nombreNivel
		return nombreNivel;
	}
	
	/**
	 * Metodo que devuelve las preguntas de la evaluación
	 * @param context El contexto de la actividad
	 * @param idUsuario El idUsuario del usuario
	 * @param idNivel El idNivel del nivel
	 * @param count Cantidad de preguntas
	 * 
	 * @return Un ArrayList con las preguntas de la evaluación
	 */
	public static ArrayList<Pregunta> getPreguntas(Context context, 
													int idUsuario, 
													int idNivel, 
													int count) {
		
		ArrayList<Pregunta> preguntas = new  ArrayList<Pregunta>();
		
		//La consulta para obtener las preguntas
		String consulta = 	"SELECT idPregunta, enunciado, respuesta, idtipo_pregunta, idNivel " +
							"FROM pregunta " +
							"WHERE idNivel = ? " +
							"ORDER BY RANDOM() " +
							"LIMIT ?" ;

		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(idNivel), String.valueOf(count)};
		
		Cursor cursor = getCursor(context, consulta, args);
		
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				cursor.moveToFirst();
				
				boolean mover = true;
				while(mover==true) {
					Pregunta p = new Pregunta();
					//Colocar atributos
					p.setIdPregunta(cursor.getInt(cursor.getColumnIndex("idPregunta")));
					p.setEnunciado(cursor.getString(cursor.getColumnIndex("enunciado")));
					p.setRespuesta(cursor.getString(cursor.getColumnIndex("respuesta")));
					p.setTipoPregunta(cursor.getInt(cursor.getColumnIndex("idtipo_pregunta")));
					
					if(p.getTipoPregunta()==1) {
						p.setOpciones(getOpciones(context, p.getIdPregunta()));						
					}
					
					//Agregar al ArrayList
					preguntas.add(p);
					mover = cursor.moveToNext();
				}

			}
			
			cursor.close();
		}
		
		return preguntas;
	}
	
	/**
	 * Metodo que devuelve las preguntas de la evaluación
	 * @param context El contexto de la actividad
	 * @param idPregunta El idPregunta de las opciones
	 * 
	 * @return Un ArrayList con las opciones de la pregunta
	 */
	public static ArrayList<Opcion> getOpciones(Context context, int idPregunta) {
		
		ArrayList<Opcion> opciones = new  ArrayList<Opcion>();
		
		//La consulta para obtener el idEvaluacion
		String consulta = 	"SELECT idOpcion, palabra " +
							"FROM opcion " +
							"WHERE idPregunta = ?" ;

		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(idPregunta)};
		
		Cursor cursor = getCursor(context, consulta, args);
		
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				cursor.moveToFirst();
				
				boolean mover = true;
				while(mover==true) {
					Opcion o = new Opcion();
					//Colocar atributos
					o.setIdOpcion(cursor.getInt(cursor.getColumnIndex("idOpcion")));
					o.setOpcion(cursor.getString(cursor.getColumnIndex("palabra")));
					
					//Agregar al ArrayList
					opciones.add(o);
					mover = cursor.moveToNext();
				}
			}
			
			cursor.close();
		}
		
		return opciones;		
	}
	
	/**
	 * Metodo que devuelve un cursor con la consulta ejecutada
	 * 
	 * @param context El contexto de la actividad
	 * @param consulta La consulta a realizar
	 * @param args SelectionArgs usados para reemplazar los ?
	 * 
	 * @return El cursor de la consulta
	 */
	public static Cursor getCursor(Context context, String consulta, String[] args) {
		SQLHelper bd = new SQLHelper(context.getApplicationContext(), SQLHelper.DATABASE_VERSION);
		bd.abrir();
			
		//Consultar
		Cursor cursor = bd.Select(consulta, args);
				
		//Cerrar la base de datos
		bd.cerrar();
		
		//Retornar el cursor
		return cursor;
	}
	
}
