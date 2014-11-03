package com.tesis.gtgrafia.pregunta;

import java.util.ArrayList;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.estructura.CustomAdapter;
import com.tesis.gtgrafia.estructura.Pregunta;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;

/**
 * PreguntaActivity
 * Activity para realizar una pregunta y esperar la respuesta
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
public class PreguntaActivity extends Activity implements OnItemClickListener, OnEditorActionListener {

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
	 * Metodo que se activa al crear el menu de la pantalla
	 * 
	 * @param menu El elemento menu
	 * 
	 * @return Si el elemento menu fue creado
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_opciones, menu);
		
		return true;
	}
	
	/**
	 * Metodo que se activa al selecionar un elemento del menu de la pantalla
	 * 
	 * @param item El elemento selecionado del menu
	 * 
	 * @return Si se encontro con el elemento seleccionado
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//Redirige la aplicación al elemento seleccionado
		if (item.getTitle().equals("")) {
			//TODO: Regresar
			return true;
		}
		else if (item.getTitle().equals("")) {
			//TODO: Regresar
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * Metodo que coloca la información de una pregunta multiple
	 */
	public void setPreguntaMultiple() {
		
		//Colocar las fuentes
		this.colocarFuentesM();
		
		//Colocar el enunciado
		TextView textEnunciadoM = (TextView)findViewById(R.id.textEnunciadoM);
		textEnunciadoM.setText(pregunta.getEnunciado());
		
		//Colocar la pregunta
		TextView textPreguntaM = (TextView)findViewById(R.id.textPreguntaM);
		textPreguntaM.setText(pregunta.getPregunta());
		
		//Obtener los elementos
		ArrayList<String> lista = pregunta.getOpcionesArrayList();
				
		//Llenar un nuevo adaptador usando un adaptador generico		
		CustomAdapter adapter = new CustomAdapter(this,
				android.R.layout.simple_list_item_1, R.layout.custom_list_text, lista);
		
		//Asignar el adaptador al listView
		ListView listOpcionesPreguntaM = (ListView)findViewById(R.id.listOpcionesPreguntaM);
		listOpcionesPreguntaM.setAdapter(adapter); 	
		
		//Colocarle el listener (esta clase) para seleccionar elementos
		listOpcionesPreguntaM.setOnItemClickListener(this);
		
	}
	
	/**
	 * Metodo que colocar las fuentes a los elementos de selección multiple
	 */
	private void colocarFuentesM() {
		
		//Typeface
		Typeface tf = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.gt_font));
		
		//Colocar la fuente a cada elemento
		TextView textEnunciadoM = (TextView)findViewById(R.id.textEnunciadoM);
		textEnunciadoM.setTypeface(tf);
		
		TextView textPreguntaM = (TextView)findViewById(R.id.textPreguntaM);
		textPreguntaM.setTypeface(tf);
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
		
		//Colocar las fuentes
		this.colocarFuentesE();
		
		//Colocar el enunciado
		TextView textEnunciadoE = (TextView)findViewById(R.id.textEnunciadoE);
		textEnunciadoE.setText(pregunta.getEnunciado());
		
		//Colocar la pregunta
		TextView textPreguntaE = (TextView)findViewById(R.id.textPreguntaE);
		textPreguntaE.setText(pregunta.getPregunta());
		
		//Colocarle el listener (esta clase) para enviar desde el editText
		EditText editRespuestaPreguntaE = (EditText) findViewById(R.id.editRespuestaPreguntaE);
		editRespuestaPreguntaE.setOnEditorActionListener(this);
				
	}
	
	/**
	 * Metodo que colocar las fuentes a los elementos de pregunta escrita
	 */
	private void colocarFuentesE() {
		
		//Typeface
		Typeface tf = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.gt_font));
		
		//Colocar la fuente a cada elemento
		TextView textEnunciadoE = (TextView)findViewById(R.id.textEnunciadoE);
		textEnunciadoE.setTypeface(tf);
		
		TextView textPreguntaE = (TextView)findViewById(R.id.textPreguntaE);
		textPreguntaE.setTypeface(tf);
		
		EditText editRespuestaPreguntaE = (EditText)findViewById(R.id.editRespuestaPreguntaE);
		editRespuestaPreguntaE.setTypeface(tf);
	}
	
	/**
	 * Metodo que se llama al presionar el boton de Send
	 * Inserta el nuevo usuario
	 * 
	 * @param editor Referencia al textView
	 * @param actionID El id de la acción
	 * @param event	El evento del teclado
	 */
	@Override
    public boolean onEditorAction(TextView editor, int actionId, KeyEvent event) {
		//Evento manejado
        boolean handled = false;
        
        //Si la acción es la de enviar
        if (actionId == EditorInfo.IME_ACTION_SEND) {
        	
        	//Obtener el nombre de usuario e insertarlo
        	this.sendRespuesta(editor.getText().toString().trim());
            handled = true;
        }
        
        //Retorno de evento manejado
        return handled;
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
