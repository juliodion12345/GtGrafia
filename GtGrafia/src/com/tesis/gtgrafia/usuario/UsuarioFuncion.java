package com.tesis.gtgrafia.usuario;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;

import com.tesis.gtgrafia.base.SQLFuncion;

/**
 * UsuarioFuncion
 * Clase estatica que se encarga de juntar algunas funciones necesarias para Inicio
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
public class UsuarioFuncion {
	
	/**
	 * Metodo que devuelve un listado de elementos String[]
	 * necesario para colocar el listView de la pantalla.
	 * 
	 * @return Arreglo de String[] con los elementos de los usuarios
	 */
	public static ArrayList<String> getUsuarios(Context context) {
		ArrayList<String> lista = new ArrayList<String>();
			
		//La consulta a realizar
		String consulta = 	"SELECT nombre " +
							"FROM Usuario " +
							"ORDER BY idUsuario";
		
		//Tomar nombres de la base de datos		
		Cursor usuario = SQLFuncion.getConsulta(context, consulta, null);
		
		//Verificar que no sea nulo
		if (usuario != null) {
			
			//Verificar por al menos un resultado
			if (usuario.getCount() > 0) {
				usuario.moveToFirst();
				
				boolean mover = true;
				while(mover==true) {					
					//Agregar al ArrayList
					lista.add(usuario.getString(usuario.getColumnIndex("nombre")));
					mover = usuario.moveToNext();
				}
			}
		}
		
		return lista;				
	}
	
	/**
	 * Metodo que devuelve el idUsuario
	 * 
	 * @param context El contexto de la actividad
	 * @param nobre El nombre del usuario
	 * 
	 * @return El id del usuario
	 */
	public static int getIdUsuario(Context context, String nombre) {
		//Variable que devolvera el idUsuario
		int idUsuario = -1;
						
		//La consulta para obtener el idUsuario
		String consulta = 	"SELECT idUsuario " +
							"FROM Usuario " +
							"WHERE nombre LIKE ?" ;
		
		String[] args = {nombre};

		//Consultar
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, args);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Colocar ultimo valor
				idUsuario = cursor.getInt(cursor.getColumnIndex("idUsuario"));
			}
			
			cursor.close();
		}
		
		//Retorna el idUsuario
		return idUsuario;
	}

}
