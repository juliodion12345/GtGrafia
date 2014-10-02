/**
 * PreguntaActivity
 * Activity para realizar una pregunta y esperar la respuesta
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia.pregunta;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.estructura.Evaluacion;
import com.tesis.gtgrafia.estructura.Opcion;
import com.tesis.gtgrafia.estructura.Pregunta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class PreguntaActivity extends Activity implements OnItemClickListener {

	/**
	 * Variable usada para almacenar localmente la evaluación
	 */
	Pregunta pregunta = null;
	
	/**
	 * Metodo que carga la pantalla de la pregunta
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		//Recuperar la pregunta
		this.pregunta = getIntent().getParcelableExtra("Pregunta");
		
		//Evalua que tipo de layout necesita, dependiendo del tipoPregunta
		
		//Cargar Selección multiple
		if (this.pregunta.getTipoPregunta() == Pregunta.TIPO_SELECCION_MULTIPLE) {
			
			setContentView(R.layout.activity_pregunta_multiple);
			this.setPreguntaMultiple();
		}
		//Cargar Escrita
		else 
		if (this.pregunta.getTipoPregunta() == Pregunta.TIPO_SELECCION_ESCRITA){
			
			setContentView(R.layout.activity_pregunta_escrita);
			this.setPreguntaEscrita();
		}
		
		Intent resultIntent = new Intent();
		resultIntent.putExtra("Valor", "Recibido DD:");
		setResult(Activity.RESULT_OK, resultIntent);
	}
	
	public void setPreguntaMultiple() {
		
		TextView labelPregunta = (TextView)findViewById(R.id.labelPregunta);
		labelPregunta.setText(pregunta.getEnunciado());
		
		//Obtener los elementos
		String[] lista = pregunta.getOpcionesArray();
				
		/*Llenar un nuevo adaptador con los elementos obtenidos, usando como plantilla
		 * el simple_list_item_1 (que es una lista simple)
		 */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, lista);
		
		//Asignar el adaptador al listView
		ListView listView = (ListView)findViewById(R.id.listOpciones);
		listView.setAdapter(adapter); 	
		
		//Colocarle el listener (esta clase) para seleccionar elementos
		listView.setOnItemClickListener(this);
		
	}
	
	/**
	 * Metodo que se activa al seleccionar un elemento del listView
	 * 
	 * @param adapterView El adaptador de la vista
	 * @param view El adaptador de la vista
	 * @param index La posición del elemento cliqueado
	 * @param id El ID del elemento cliqueado
	 */
	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {  
		//Obtiene el elemento seleccionado
		String fila = adapterView.getItemAtPosition(index).toString();
		
		//Redirige la aplicación con la respuesta
		sendRespuesta(fila);
	}
	
	public void setPreguntaEscrita() {
		
		TextView labelPregunta = (TextView)findViewById(R.id.labelPregunta);
		labelPregunta.setText(pregunta.getEnunciado());	
		
	}
	
	public void setRespuestaButton(View v) {
		EditText textRespuesta = (EditText)findViewById(R.id.textRespuesta);
		this.sendRespuesta(textRespuesta.getText().toString());
	}
	
	public void sendRespuesta(String respuesta) {
		//Enviamos los datos de regreso
		Intent resultIntent = new Intent();
		resultIntent.putExtra("Respuesta", respuesta);
		resultIntent.putExtra("idPregunta", pregunta.getIdPregunta());
		
		//Aceptamos el resultado y finalizamos
		setResult(Activity.RESULT_OK, resultIntent);
		this.finish();
	}
	
}
