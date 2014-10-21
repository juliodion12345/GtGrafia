package com.tesis.gtgrafia.evaluacion;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.base.SQLFuncion;
import com.tesis.gtgrafia.estructura.Evaluacion;
import com.tesis.gtgrafia.estructura.Pregunta;
import com.tesis.gtgrafia.leccion.LeccionFuncion;
import com.tesis.gtgrafia.pregunta.PreguntaActivity;
import com.tesis.gtgrafia.pregunta.PreguntaFuncion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
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
	private int idUsuario = -1;
	/**
	 * Variable usada para almacenar el nivel a evaluar
	 */
	private int idNivel = -1;
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
		
		//Obtener el idUsuario
		this.idUsuario = getIntent().getIntExtra("IdUsuario", -1);
				
		//Obtener el idNivel
		this.idNivel = getIntent().getIntExtra("IdNivel", -1);
		
		//Colocar el nombre de la evaluación
		TextView textNombreEvaluacion = (TextView)findViewById(R.id.textNombreEvaluacion);
		textNombreEvaluacion.setText(LeccionFuncion.getNombreNivel(this, this.idNivel));
		
		int respuestasUsuario = EvaluacionFuncion.getTotalPreguntasUsuario(this, this.idUsuario, this.idNivel);
		int respuesta = EvaluacionFuncion.getTotalPreguntas(this, this.idNivel);
		
		//Colocar el avance de la evaluación
		TextView textAvanceEvaluacion = (TextView)findViewById(R.id.textAvanceEvaluacion);
		textAvanceEvaluacion.setText(respuestasUsuario + "/" + respuesta);
						
		//Comparar nivel
		if(respuesta == respuestasUsuario) {
			//Comprobar si ya está el nivel insertado
			this.comprobarNivel(respuesta, respuestasUsuario);	
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
	
	/**
	 * Metodo que devuelve un mensaje de cierta duración de tipo Toast
	 * 
	 * @param texto El texto a mostrar
	 * @param duracion La duración del mensaje
	 */
	private void getMensaje(String texto, int duracion) {
		Toast toast = Toast.makeText(this.getApplicationContext(), texto, duracion);
		toast.show();
	}
	
	/**
	 * Metodo que redirige las preguntas de la evaluacion
	 * 
	 * @param v Referencia a la vista actual
	 */
	public void realizarEvaluacion(View v) {	
		//Comprobar usuario para el nivel de evaluacion
		if (EvaluacionFuncion.comprobarEvaluacion(this, this.idUsuario, this.idNivel)==true) {
			
			//Llenar evaluacion
			this.evaluacion = EvaluacionFuncion.getEvaluacion(this, this.idUsuario, this.idNivel);			
			
			//Llamar a las actividades
			this.indexPregunta = 0;
			
			//Lanzamiento de preguntas
			if (this.indexPregunta < this.evaluacion.getCountPreguntas()) {
				this.llamarActividades(this.indexPregunta);	
			}
			//Realización de preguntas, pero sin guardar el resultado
			else {
				
			}
			
		}
		else {			
			this.getMensaje(getString(R.string.msg_evaluacion_deshabilitada));
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
				
				//Comprobar para no pasar el indice
				if (this.indexPregunta < evaluacion.getCountPreguntas()) {
					
					//Obtener pregunta
					Pregunta p = this.evaluacion.getPregunta(indexPregunta);
					
					//Obtener extras
					p.setRespuestaUsuario(data.getExtras().getString("Respuesta"));
					int idPregunta = data.getExtras().getInt("IdPregunta");
					
					//Insertar respuesta y mostrar mensaje
					if (PreguntaFuncion.comprobarRespuesta(p.getRespuesta(), p.getRespuestaUsuario())) {
						
						//Mostrar mensaje
						this.getMensaje(getString(R.string.msg_respuesta_correcta));
						
						//Insertar respuesta correcta
						EvaluacionFuncion.insertarRespuestaCorrecta(this, 
																	this.evaluacion.getIdEvaluacion(), 
																	idPregunta, 
																	this.idUsuario);						
						
					}
					else {
						//Mostrar mensaje
						this.getMensaje(getString(R.string.msg_respuesta_incorrecta));			
					}
					
					//Aumentar el indice y evaluar nueva actividad
					this.indexPregunta++;
					
					//Lanzar nueva pregunta
					if (this.indexPregunta < evaluacion.getCountPreguntas()) {
						
						//Lamar a nueva actividad
						this.llamarActividades(indexPregunta);
					}
					//Mostrar resultado
					else {
						this.comprobarPuntuacion();
					}
					
				}					
			}
			//Mostrar resultado de respuesta RESULT_CANCELED
			else {
				this.comprobarPuntuacion();
			}
		} 
	}
	
	/**
	 * Metodo que se ejecuta al regresar a la actividad
	 */
	@Override
	public void onResume() {
		//Llamar a la super clase
		super.onResume();
	    
		int respuestasUsuario = EvaluacionFuncion.getTotalPreguntasUsuario(this, this.idUsuario, this.idNivel);
		int respuesta = EvaluacionFuncion.getTotalPreguntas(this, this.idNivel);
		
		//Colocar el avance de la evaluación
		TextView textAvanceEvaluacion = (TextView)findViewById(R.id.textAvanceEvaluacion);
		textAvanceEvaluacion.setText(respuestasUsuario + "/" + respuesta);
				
		//Comparar nivel
		if(respuesta == respuestasUsuario) {
			//Comprobar si ya está el nivel insertado
			this.comprobarNivel(respuesta, respuestasUsuario);	
		}		
	}
	
	/**
	 * Metodo que comprueba el nivel finalizado
	 * 
	 * @param respuesta Cantidad de respuestas totales
	 * @param respuestasUsuario Cantidad de respuestas del usuario
	 */
	private void comprobarNivel(int respuesta, int respuestasUsuario) {
		//Comprobar si ya está el nivel insertado
		int siguienteNivel = this.idNivel + 1;
		
		if (EvaluacionFuncion.comprobarSiguienteNivel(this, this.idUsuario, siguienteNivel)==false) {
			//Insertar el siguiente nivel
			SQLFuncion.insertUsuarioNivel(this, this.idUsuario, siguienteNivel);
			
			//Muestra mensaje de nivel finalizado
			this.getMensaje(getString(R.string.msg_evaluacion_terminada), Toast.LENGTH_LONG);
		}
	}
	
	/**
	 * Metodo que comprueba la puntuación de este nivel
	 */
	private void comprobarPuntuacion() {
		//Respuestas totales en la evaluación
		int respuesta = this.evaluacion.getCountPreguntas();
		//Respuestas totales del usuario en esta evalucación
		int respuestasUsuario = 0;
		
		for (int i=0; i<respuesta; i++) {
			//Obtener pregunta
			Pregunta p = this.evaluacion.getPregunta(i);
			
			//Comprobar la respuesta
			if (PreguntaFuncion.comprobarRespuesta(p.getRespuesta(), p.getRespuestaUsuario())==true) {
				respuestasUsuario++;
			}
		}		
		
		//Muestra mensaje de punteo
		String punteo = " " + respuestasUsuario + "/" + respuesta;	
		
		this.getMensaje(getString(R.string.msg_punteo) + punteo, Toast.LENGTH_LONG);
	}
	
}
