/**
 * EvaluacionActivity
 * Activity para cargar todas las preguntas de la evaluacion
 * creando una nueva activity para cada pregunta
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia.evaluacion;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.estructura.Evaluacion;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class EvaluacionActivity extends Activity {
	
	/**
	 * Variable usada para almacenar el idUsuario de la aplicación
	 */
	private int VAR_USUARIO = 0;
	/**
	 * Variable usada para almacenar el nivel a evaluar
	 */
	private int VAR_IDNIVEL = 0;
	
	/**
	 * Metodo que carga la pantalla de la evaluacion
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluacion);
		this.realizarEvaluacion();
	}
	
	/**
	 * Metodo que redirige las preguntas de la evaluacion
	 */
	public void realizarEvaluacion() {	
		//Comprobar usuario para el nivel de evaluacion
		if (EvaluacionFuncion.comprobarEvaluacion(this, VAR_USUARIO, VAR_IDNIVEL)==true) {
			
			//Llenar evaluacion
			Evaluacion eval = EvaluacionFuncion.getEvaluacion(this, VAR_IDNIVEL);
					
			//Enviar evaluacion a Activity
		}
		else {
			//TODO: Mostrar mensaje de error
			this.getMensaje("No puede realizar la evaluación");
		}		
		
	}	
	
	/**
	 * Metodo que devuelve un mensaje corto de tipo Toast
	 * 
	 * @param texto El texto a mostrar
	 */
	public void getMensaje(String texto) {
		int duracion = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(this.getApplicationContext(), texto, duracion);
		toast.show();
	}
	
}
