/**
 * EvaluacionActivity
 * Activity para cargar todas las preguntas de la evaluacion
 * creando una nueva activity para la evaluacion
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia.evaluacion;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.estructura.Evaluacion;
import com.tesis.gtgrafia.pregunta.PreguntaActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class EvaluacionActivity extends Activity {
	
	/**
	 * Variable usada para almacenar el idUsuario de la aplicación
	 */
	private int idUsuario = 2;
	/**
	 * Variable usada para almacenar el nivel a evaluar
	 */
	private int idNivel = 1;
	/**
	 * Etiqueta usada para almacenar los datos de la pregunta
	 */
	private int VAR_PREGUNTA = 7;
	
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
		if (EvaluacionFuncion.comprobarEvaluacion(this, idUsuario, idNivel)==true) {
			
			//Llenar evaluacion
			Evaluacion eval = EvaluacionFuncion.getEvaluacion(this, idUsuario, idNivel);			
			
			//Enviar evaluacion a Activity
			Intent intent = new Intent(this, PreguntaActivity.class);    
			intent.putExtra("Evaluacion", eval);
			
			startActivityForResult(intent, VAR_PREGUNTA);
		}
		else {			
			this.getMensaje("Aun no puede realizar esta evaluación");
		}		
		
	}	
	
	/**
	 * Metodo que devuelve un mensaje corto de tipo Toast
	 * 
	 * @param texto El texto a mostrar
	 */
	private void getMensaje(String texto) {
		int duracion = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(this.getApplicationContext(), texto, duracion);
		toast.show();
	}
	
	@Override 
	public void onActivityResult(int requestCode, int resultCode, Intent data) {     
		super.onActivityResult(requestCode, resultCode, data); 
		
		if (requestCode == VAR_PREGUNTA) { 
			if (resultCode == Activity.RESULT_OK) {						
				//TODO: Saber que datos recibir				
			} 
		} 
	}
	
}
