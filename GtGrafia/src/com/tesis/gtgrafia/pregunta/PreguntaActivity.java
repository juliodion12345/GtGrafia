/**
 * PreguntaActivity
 * Activity para realizar las preguntas y esperar las respuestas
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia.pregunta;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.estructura.Evaluacion;
import com.tesis.gtgrafia.estructura.Pregunta;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class PreguntaActivity extends Activity {

	/**
	 * Metodo que carga la pantalla de la pregunta
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pregunta);
		
		//Recuperar la evaluación
		Evaluacion evaluacion = getIntent().getParcelableExtra("Evaluacion");
		
		//TODO: Remover despues
		System.out.println("--------------------------------");
		Log.i("evaluacion", ""+evaluacion.getIdEvaluacion());		
		Log.i("evaluacion", ""+evaluacion.getIdNivel());
		Log.i("evaluacion", ""+evaluacion.getIdUsuario());
		Log.i("evaluacion", ""+evaluacion.getNombreNivel());
		Log.i("evaluacion", ""+evaluacion.getTipoEvaluacion());
		
		//TODO: Remover despues
		System.out.println("********************************");
		Pregunta p = evaluacion.getPreguntas().get(0);
		Log.i("p", "*"+p.getEnunciado());
		Log.i("p", "*"+p.getRespuesta());
		Log.i("p", "**"+p.getOpciones().get(0).getOpcion());	
		Log.i("p", "**"+p.getOpciones().get(1).getOpcion());
		Log.i("p", "**"+p.getOpciones().get(2).getOpcion());
	}
}
