package com.tesis.gtgrafia.nivel;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;

import com.tesis.gtgrafia.base.SQLFuncion;

/**
 * NivelFuncion
 * Clase estatica que se encarga de juntar algunas funciones necesarias para Nivel
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
public class NivelFuncion {
	
	/**
	 * Metodo que devuelve un listado de elementos String[]
	 * necesario para colocar el gridView de la pantalla.
	 * 
	 * @param context El contexto de la actividad
	 * @param idUsuario El id del usuario
	 * 
	 * @return Arreglo de String[] con los elementos de los niveles
	 */
	public static ArrayList<String> getNiveles(Context context, int idUsuario) {
		ArrayList<String> lista = new ArrayList<String>();
			
		//La consulta a realizar
		String consulta = 	"SELECT N.nombre as 'nombre' " +
							"FROM Nivel N " +
							"INNER JOIN UsuarioNivel UN ON (N.idNivel = UN.idNivel) " +
							"WHERE UN.idUsuario = ? " +
							"ORDER BY N.idNivel";
		
		String[] args = {String.valueOf(idUsuario)};
		
		//Tomar nombres de la base de datos		
		Cursor niveles = SQLFuncion.getConsulta(context, consulta, args);
		
		//Verificar que no sea nulo
		if (niveles != null) {
			
			//Verificar por al menos un resultado
			if (niveles.getCount() > 0) {
				niveles.moveToFirst();
				
				boolean mover = true;
				while(mover==true) {					
					//Agregar al ArrayList
					lista.add(niveles.getString(niveles.getColumnIndex("nombre")));
					mover = niveles.moveToNext();
				}
			}
		}
		
		return lista;				
	}
	
	/**
	 * Metodo que devuelve el idUsuario
	 * 
	 * @param context El contexto de la actividad
	 * @param nobre El nombre del nivel
	 * 
	 * @return El id del nivel
	 */
	public static int getIdNivel(Context context, String nombre) {
		//Variable que devolvera el idNivel
		int idNivel = -1;
						
		//La consulta para obtener el idNivel
		String consulta = 	"SELECT idNivel " +
							"FROM Nivel " +
							"WHERE nombre LIKE ?" ;
		
		String[] args = {nombre};

		//Consultar
		Cursor cursor = SQLFuncion.getConsulta(context, consulta, args);
				
		//Verificar que no sea nulo
		if (cursor != null) {
					
			//Verificar por al menos un resultado
			if (cursor.getCount() > 0) {
				//Colocar ultimo valor
				idNivel = cursor.getInt(cursor.getColumnIndex("idNivel"));
			}
			
			cursor.close();
		}
		
		//Retorna el idNivel
		return idNivel;
	}

}
