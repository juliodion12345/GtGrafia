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

public class Pregunta {

	/**
	 * Variable usada para almacenar el idPregunta
	 */
	public int idPregunta = 0;
	/**
	 * Variable usada para almacenar el enunciado
	 */
	public String enunciado = "";
	/**
	 * Variable usada para almacena la respuesta
	 */
	public String respuesta = "";
	/**
	 * Variable usada para almacena la respuesta del usuario
	 */
	public String respuestaUsuario = "";
	/**
	 * Variable usada para almacenar el tipoPregunta
	 */
	public String tipoPregunta = "";
	/**
	 * Variable usada para almacenar las opciones
	 */
	public ArrayList<String> opciones = new ArrayList<String>();

	
	
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
	public String getTipoPregunta() {
		return tipoPregunta;
	}
	public void setTipoPregunta(String tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}
	public ArrayList<String> getOpciones() {
		return opciones;
	}
	public void setOpciones(ArrayList<String> opciones) {
		this.opciones = opciones;
	}
	
}
