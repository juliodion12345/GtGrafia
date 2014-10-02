/**
 * Pregunta
 * Clase que se encarga de almacenar los campos de una pregunta
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia.estructura;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class Pregunta implements Parcelable {

	/**
	 * Variable usada para almacenar el idPregunta
	 */
	private int idPregunta;
	/**
	 * Variable usada para almacenar el enunciado
	 */
	private String enunciado;
	/**
	 * Variable usada para almacena la respuesta
	 */
	private String respuesta;
	/**
	 * Variable usada para almacena la respuesta del usuario
	 */
	private String respuestaUsuario;
	/**
	 * Variable usada para almacenar el tipoPregunta
	 */
	private int tipoPregunta;
	/**
	 * Variable usada para almacenar las opciones
	 */
	private ArrayList<Opcion> opciones = null;

	/**
	 * Etiqueta usada para almacenar el tipoPregunta "Selección multiple"
	 */
	public static final int TIPO_SELECCION_MULTIPLE = 1;
	/**
	 * Etiqueta usada para almacenar el tipoPregunta "Escrita"
	 */
	public static final int TIPO_SELECCION_ESCRITA = 2;
	
	///////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////////
	
	/**
	 * Constructor principal
	 */
	public Pregunta() {
		this.idPregunta 		= 0;
		this.enunciado 			= "";
		this.respuesta 			= "";
		this.respuestaUsuario 	= "";
		this.tipoPregunta 		= 0;
		this.opciones 			= new ArrayList<Opcion>();
	}
	
	/////////////////////////////////////////GET-SET///////////////////////////////////////////////

	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getRespuestaUsuario() {
		return respuestaUsuario;
	}
	public void setRespuestaUsuario(String respuestaUsuario) {
		this.respuestaUsuario = respuestaUsuario;
	}
	public int getTipoPregunta() {
		return tipoPregunta;
	}
	public void setTipoPregunta(int tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}
	public ArrayList<Opcion> getOpciones() {
		return opciones;
	}
	public void setOpciones(ArrayList<Opcion> opciones) {
		this.opciones = opciones;
	}
	
	/**
	 * Metodo que inserta una Opción
	 * 
	 * @param o La Opción a insertar
	 */
	public void insertOpcion(Opcion o) {
		this.opciones.add(o);		
	}
	
	/**
	 * Metodo que devuelve la opción segun el indice
	 * 
	 * @param index Indice de la opción
	 * @return La opción segun el indice
	 */
	public Opcion getOpcion(int index) {		
		return this.opciones.get(index);
	}
	
	/**
	 * Metodo que devuelve la cantidad de opciones de la pregunta
	 * 
	 * @return La cantidad de opciones de la pregunta
	 */
	public int getCountOpciones() {
		return this.opciones.size();
	}
	
	/**
	 * Metodo que devuelve las opciones como Array de String
	 * 
	 * @return Devuelve las opciones como Array de String
	 */
	public String[] getOpcionesArray() {
		int conteo = this.getCountOpciones();
		String[] array = new String[conteo];
		
		for (int i=0; i<conteo; i++) {
			array[i] = this.getOpcion(i).getOpcion();
		}
		
		return array;
	}
	
	/////////////////////////////////////////PARCEL////////////////////////////////////////////////
	
	/**
	 * Describe contenido
	 * 
	 * @return id
	 */
	@Override
	public int describeContents() {
		return 0;
	}
	
	/**
	 * Escribe el nuevo objeto
	 * 
	 * @param dest Destino del Parcel
	 * @param flags Etiquetas
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		//Escribir los valores
		dest.writeInt(idPregunta);
		dest.writeString(enunciado);
		dest.writeString(respuesta);
		dest.writeString(respuestaUsuario);
		dest.writeInt(tipoPregunta);
		dest.writeTypedList(opciones);
	}
	
	/**
	 * Lee el nuevo objeto
	 * 
	 * @param in Parcel de entrada
	 */
	private void readFromParcel(Parcel in) {
		//Leer los valores
		this.idPregunta = in.readInt();
		this.enunciado = in.readString();
		this.respuesta = in.readString();
		this.respuestaUsuario = in.readString();
		this.tipoPregunta = in.readInt();
		
		//Leer el ArrayList de tipo Opcion
		in.readTypedList(opciones, Opcion.CREATOR);
	}
	
	/**
	 * Constructor que facilita la creación de nuevos Parcel
	 * 
	 * @param in Parcel de entrada
	 */
	public Pregunta(Parcel in) {
		//Inicializar objeto
		this();
		
		readFromParcel(in);
	}
	
	/**
	 * CREATOR que facilita la creación de nuevos elementos
	 */
	public static final Parcelable.Creator<Pregunta> CREATOR
		= new Parcelable.Creator<Pregunta>() {
		public Pregunta createFromParcel(Parcel in) {
			return new Pregunta(in);
		}
	
		public Pregunta[] newArray(int size) {
			return new Pregunta[size];
		}
	};
	
}
