/**
 * EvaluacionActivity
 * Activity para cargar todas las preguntas de la evaluacion
 * creando una nueva activity para cada pregunta
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia;

import com.tesis.gtgrafia.estructura.Evaluacion;

import android.app.Activity;
import android.os.Bundle;

public class EvaluacionActivity extends Activity {
	
	/**
	 * Variable usada para almacenar el idUsuario de la aplicación
	 */
	private static int VAR_USUARIO = 0;
	/**
	 * Variable usada para almacenar el nivel a evaluar
	 */
	private static int VAR_IDNIVEL = 0;
	
	/**
	 * Metodo que carga la pantalla de la evaluacion
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluacion);
	}
	
	/**
	 * Metodo que redirige las preguntas de la evaluacion
	 */
	public void realizarEvaluacion() {		
		//Llenar evaluacion
		Evaluacion eval = this.getEvaluacion();
				
		//Enviar evaluacion a Activity
		
	}
	
	public Evaluacion getEvaluacion() {
		Evaluacion eval = new Evaluacion();	
		
		return eval;
	}
	
}
