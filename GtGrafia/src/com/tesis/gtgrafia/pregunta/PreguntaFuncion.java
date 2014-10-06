package com.tesis.gtgrafia.pregunta;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;

import com.tesis.gtgrafia.base.SQLFuncion;
import com.tesis.gtgrafia.estructura.Opcion;
import com.tesis.gtgrafia.estructura.Pregunta;

/**
 * PreguntaFuncion
 * Clase estatica que se encarga de juntar algunas funciones necesarias para Pregunta
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
public class PreguntaFuncion {
	
	/**
	 * Metodo que devuelve las preguntas de la evaluación
	 * @param context El contexto de la actividad
	 * @param idUsuario El idUsuario del usuario
	 * @param idNivel El idNivel del nivel
	 * 
	 * @return Un ArrayList con las preguntas de la evaluación
	 */
	public static ArrayList<Pregunta> getPreguntas(Context context, 
													int idUsuario, 
													int idNivel) {
		
		ArrayList<Pregunta> preguntas = new  ArrayList<Pregunta>();
		
		//La consulta para obtener las preguntas
		String consulta = 	"SELECT idPregunta, enunciado, respuesta, idTipoPregunta, idNivel " +
							"FROM Pregunta P " +
							"WHERE P.idNivel = ?" +
							"AND NOT EXISTS (" +
							"	SELECT E.idPregunta " +
							"	FROM Evaluacion E " +
							"	WHERE E.idUsuario = ? " +
							"	AND P.idPregunta = E.idPregunta " +
							") " +
							"ORDER BY RANDOM() " ;

		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(idNivel), String.valueOf(idUsuario)};
		
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, args);
		
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
					p.setTipoPregunta(cursor.getInt(cursor.getColumnIndex("idTipoPregunta")));
					
					//Agregar las opciones si es de selección multiple
					if(p.getTipoPregunta()==Pregunta.TIPO_SELECCION_MULTIPLE) {
						p.setOpciones(PreguntaFuncion.getOpciones(context, p.getIdPregunta()));						
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
		
		//La consulta para obtener el idOpcion y palabra
		String consulta = 	"SELECT idOpcion, palabra " +
							"FROM Opcion " +
							"WHERE idPregunta = ?" ;

		//Sustitución de parametros ?
		String[] args = 	{String.valueOf(idPregunta)};
		
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, args);
		
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

}
