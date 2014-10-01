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

	///////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////////
	
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
	
	/////////////////////////////////////////PARCEL////////////////////////////////////////////////
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(idPregunta);
		dest.writeString(enunciado);
		dest.writeString(respuesta);
		dest.writeString(respuestaUsuario);
		dest.writeInt(tipoPregunta);
		dest.writeTypedList(opciones);
	}
	
	private void readFromParcel(Parcel in) {
		this.idPregunta = in.readInt();
		this.enunciado = in.readString();
		this.respuesta = in.readString();
		this.respuestaUsuario = in.readString();
		this.tipoPregunta = in.readInt();
		in.readTypedList(opciones, Opcion.CREATOR);
	}
	
	public Pregunta(Parcel in) {
		this();
	
		readFromParcel(in);
	}
	
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
