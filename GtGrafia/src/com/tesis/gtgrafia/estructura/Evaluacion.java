/**
 * Evaluacion
 * Clase que se encarga de almacenar los campos de una evaluacion
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia.estructura;

import java.util.ArrayList;

public class Evaluacion {
	
	/**
	 * Variable usada para almacenar el idEvaluacion
	 */
	public int idEvaluacion = 0;
	/**
	 * Variable usada para almacenar el idUsuario
	 */
	public int idUsuario	= 0;
	/**
	 * Variable usada para almacenar el idNivel
	 */
	public int idNivel = 0;
	/**
	 * Variable usada para almacenar el tipoEvaluacion
	 */
	public int tipoEvaluacion = 0;	
	/**
	 * Variable usada para almacenar el tipoEvaluacion
	 */
	public String nombreNivel = "";
	/**
	 * Variable usada para almacenar las preguntas
	 */
	public ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();

	
	
	/////////////////////////////////////////GET-SET///////////////////////////////////////////////

	public int getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}
	public int getTipoEvaluacion() {
		return tipoEvaluacion;
	}
	public void setTipoEvaluacion(int tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
	public String getNombreNivel() {
		return nombreNivel;
	}
	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}		

}
