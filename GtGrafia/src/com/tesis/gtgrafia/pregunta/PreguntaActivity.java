package com.tesis.gtgrafia.pregunta;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.estructura.Pregunta;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

/**
 * PreguntaActivity
 * Activity para realizar una pregunta y esperar la respuesta
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
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
		
	}
	
	/**
	 * Metodo que coloca la información de una pregunta multiple
	 */
	public void setPreguntaMultiple() {
		
		//Colocar el enunciado
		TextView textPreguntaM = (TextView)findViewById(R.id.textPreguntaM);
		textPreguntaM.setText(pregunta.getEnunciado());
		
		//Obtener los elementos
		String[] lista = pregunta.getOpcionesArray();
				
		/*Llenar un nuevo adaptador con los elementos obtenidos, usando como plantilla
		 * el simple_list_item_1 (que es una lista simple)
		 */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, lista);
		
		//Asignar el adaptador al listView
		ListView listOpcionesPreguntaM = (ListView)findViewById(R.id.listOpcionesPreguntaM);
		listOpcionesPreguntaM.setAdapter(adapter); 	
		
		//Colocarle el listener (esta clase) para seleccionar elementos
		listOpcionesPreguntaM.setOnItemClickListener(this);
		
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
	
	/**
	 * Metodo que coloca la información de una pregunta escrita
	 */
	public void setPreguntaEscrita() {
		
		//Colocar el enunciado
		TextView textPreguntaE = (TextView)findViewById(R.id.textPreguntaE);
		textPreguntaE.setText(pregunta.getEnunciado());	
		
	}
	
	/**
	 * Metodo que se llama al presionar el boton de Aceptar
	 * 
	 * @param v Referencia a la vista actual
	 */
	public void setRespuestaButton(View v) {
		
		//Obtener y enviar la respuesta
		EditText editRespuestaPreguntaE = (EditText)findViewById(R.id.editRespuestaPreguntaE);
		this.sendRespuesta(editRespuestaPreguntaE.getText().toString().trim());
	}
	
	/**
	 * Metodo que finaliza la actividad y envia los resultados
	 * 
	 * @param respuesta La respuesta seleccionada
	 */
	public void sendRespuesta(String respuesta) {
		//Enviamos los datos de regreso
		Intent resultIntent = new Intent();
		resultIntent.putExtra("Respuesta", respuesta);
		resultIntent.putExtra("IdPregunta", pregunta.getIdPregunta());
		
		//Aceptamos el resultado y finalizamos
		setResult(Activity.RESULT_OK, resultIntent);
		this.finish();
	}
	
	/**
	 * Metodo que finaliza la actividad debido a presionar el boton de Atras
	 */
	@Override
	public void onBackPressed() {
		//Enviamos los datos de regreso
		Intent resultIntent = new Intent();
				
		//Aceptamos el resultado y finalizamos
		setResult(Activity.RESULT_CANCELED, resultIntent);
		this.finish();
	}
	
}
