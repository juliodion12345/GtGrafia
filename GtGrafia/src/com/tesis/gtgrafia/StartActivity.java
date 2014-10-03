package com.tesis.gtgrafia;

import com.tesis.gtgrafia.base.SQLHelper;
import com.tesis.gtgrafia.evaluacion.EvaluacionActivity;
import com.tesis.gtgrafia.inicio.InicioActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * StartActivity
 * Activity para cargar el menu principal (pantalla principal de la aplicación)
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
public class StartActivity extends Activity implements OnItemClickListener {
	
	/**
	 * Variable conectora con la base de datos
	 */
	public SQLHelper bd = null;
	
	/**
	 * Metodo que carga la pantalla principal
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
	
		//Colocarle el listener (esta clase) para seleccionar elementos
		ListView listView = (ListView) findViewById(R.id.listStart);
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
		
		//Redirige la aplicación al elemento seleccionado
		if (fila.equals(getString(R.string.str_iniciar_juego))) {
			iniciarJuego();
		}
		else if (fila.equals(getString(R.string.str_acerca_de))) {
			iniciarAcercaDe();
		}
	}
	
	//////////////////////////////////////////MENU/////////////////////////////////////////////////
	
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
		getMenuInflater().inflate(R.menu.menu_start, menu);
		
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
		if (item.getTitle().equals(getString(R.string.str_iniciar_juego))) {
			iniciarJuego();
			return true;
		}
		else if (item.getTitle().equals(getString(R.string.str_acerca_de))) {
			iniciarAcercaDe();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	/////////////////////////////////////////INICIAR///////////////////////////////////////////////

	/**
	 * Metodo que inicia la pantalla de "Iniciar Juego"
	 */
	private void iniciarJuego() {
		//Inicia la actividad de "Iniciar Juego"
		
		//TODO Modificar las clases para iniciarlas
		Intent intent = new Intent(this, InicioActivity.class);
		startActivity(intent);
	}
	
	/**
	 * Metodo que inicia la pantalla de "Acerca de"
	 */
	private void iniciarAcercaDe() {
		//Inicia la actividad de "Acerca de"
		
		//TODO Modificar las clases para iniciarlas
		Intent intent = new Intent(this.getApplicationContext(), EvaluacionActivity.class);
		startActivity(intent);
			
	}
	
}
