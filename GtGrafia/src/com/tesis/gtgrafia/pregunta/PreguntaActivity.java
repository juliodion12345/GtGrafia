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
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class PreguntaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pregunta);
		
		System.out.println(getIntent().getParcelableExtra("Pregunta"));
		Evaluacion evaluacion = getIntent().getParcelableExtra("Pregunta");
		
		System.out.println("--------------------------------");
		Log.i("evaluacion", ""+evaluacion.getIdEvaluacion());		
		Log.i("evaluacion", ""+evaluacion.getIdNivel());
		Log.i("evaluacion", ""+evaluacion.getIdUsuario());
		Log.i("evaluacion", evaluacion.getNombreNivel());
		Log.i("evaluacion", ""+evaluacion.getTipoEvaluacion());
	}
}
