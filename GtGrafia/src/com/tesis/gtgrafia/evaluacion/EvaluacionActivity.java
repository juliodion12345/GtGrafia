package com.tesis.gtgrafia.evaluacion;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.estructura.Evaluacion;
import com.tesis.gtgrafia.pregunta.PreguntaActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * EvaluacionActivity
 * Activity para cargar todas las preguntas de la evaluacion
 * creando una nueva activity para cada pregunta
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
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
	 * Variable usada para almacenar localmente el indice de la pregunta actual
	 */
	private int indexPregunta = 0;
	/**
	 * Variable usada para almacenar localmente la evaluación
	 */
	Evaluacion evaluacion = null;
	/**
	 * Etiqueta usada para reconocer la respuesta
	 */
	public static int RESPUESTA_OK = 1;
	
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
	 * Metodo que devuelve un mensaje corto de tipo Toast
	 * 
	 * @param texto El texto a mostrar
	 */
	private void getMensaje(String texto) {
		int duracion = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(this.getApplicationContext(), texto, duracion);
		toast.show();
	}
	
	/**
	 * Metodo que redirige las preguntas de la evaluacion
	 */
	private void realizarEvaluacion() {	
		//Comprobar usuario para el nivel de evaluacion
		if (EvaluacionFuncion.comprobarEvaluacion(this, idUsuario, idNivel)==true) {
			
			//Llenar evaluacion
			this.evaluacion = EvaluacionFuncion.getEvaluacion(this, idUsuario, idNivel);			
			
			//Llamar a las actividades
			this.indexPregunta = 0;
			this.llamarActividades(indexPregunta);			
			
		}
		else {			
			this.getMensaje("Aun no puede realizar esta evaluación");
		}		
		
	}	
	
	/**
	 * Metodo que llama una actividad, dependiendo del indice
	 */
	private void llamarActividades(int index) {

		//Enviar evaluacion a Activity
		Intent intent = new Intent(this.getApplicationContext(), PreguntaActivity.class);    
		intent.putExtra("Pregunta", this.evaluacion.getPregunta(index));
		
		//Llamar a la actividad con resultados
		startActivityForResult(intent, RESPUESTA_OK);
		
	}
	
	/**
	 * Metodo que obtiene las respuestas de la actividad PreguntaActivity
	 * 
	 * @param requestCode Codigo de estado de pregunta
	 * @param resultCode Codigo de estado de la actividad
	 * @param data Intent con la información obtenida
	 */
	@Override 
	public void onActivityResult(int requestCode, int resultCode, Intent data) {     
		super.onActivityResult(requestCode, resultCode, data); 
		
		//Si el codigo de respuesta es de una pregunta
		if (requestCode == RESPUESTA_OK) { 
			
			//Si el codigo de respuesta es OK
			if (resultCode == Activity.RESULT_OK) {						
				//TODO: Asignar valores de respuesta
				
				//Aumentar el indice y evaluar nueva actividad
				indexPregunta++;
				if (indexPregunta < evaluacion.getCountPreguntas()) {
					
					//Lamar a nueva actividad
					this.llamarActividades(indexPregunta);
				}
			} 
		} 
	}
	
}
