/**
 * StartActivity
 * Activity para cargar el menu principal (pantalla principal de la aplicación)
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StartActivity extends Activity implements OnItemClickListener {

	/**
	 * Etiqueta usada para diferenciar el elemento "Iniciar Juego" del menu (1)
	 */
	private static final int MNU_INICIAR = 1;
	/**
	 * Etiqueta usada para diferenciar el elemento "Acerca de" (2)
	 */
	private static final int MNU_ACERCA = 2;
	
	/**
	 * Metodo que carga la pantalla principal
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		//llenar el listView con los items
		this.setListItems();
	}
	
	//////////////////////////////////////////LISTA////////////////////////////////////////////////

	/**
	 * Metodo que devuelve un listado de elementos String[]
	 * necesario para colocar el listView de la pantalla.
	 * 
	 * @return Arreglo de String[] con los elementos de la lista
	 */
	public String[] listItems() {
		
		return new String[] {
				"Iniciar Juego", "Acerca de"			
		};
				
	}
	
	/**
	 * Metodo que coloca los elementos en la lista de la pantalla principal
	 */
	public void setListItems() {
		
		//Obtener los elementos
		String[] lista = listItems();
		
		/*Llenar un nuevo adaptador con los elementos obtenidos, usando como plantilla
		 * el simple_list_item_1 (que es una lista simple)
		 */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, lista);
		
		//Asignar el adaptador al listView
		ListView listView = (ListView) findViewById(R.id.listStart);
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
		
		//Redirige la aplicación al elemento seleccionado
		if (fila.equals("Iniciar Juego")) {
			iniciarJuego();
		}
		else if (fila.equals("Acerca de")) {
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
		
		//Agrega nuevos elementos al menu de la pantalla
		menu.add(Menu.NONE, MNU_INICIAR, Menu.NONE, "Iniciar Juego");
		menu.add(Menu.NONE, MNU_ACERCA, Menu.NONE, "Acerca de");
		
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
		switch (item.getItemId()) {
			case MNU_INICIAR:
				iniciarJuego();
				
				return true;
	        case MNU_ACERCA:
				iniciarAcercaDe();
				
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	/////////////////////////////////////////INICIAR///////////////////////////////////////////////

	/**
	 * Metodo que inicia la pantalla de "Iniciar Juego"
	 */
	private void iniciarJuego() {
		//Inicia la actividad de "Iniciar Juego"
		
		//TODO Modificar las clases para iniciarlas
		//Intent intent = new Intent(this, CLASE_NIVEL.class);
		//startActivity(intent);
	}
	
	/**
	 * Metodo que inicia la pantalla de "Acerca de"
	 */
	private void iniciarAcercaDe() {
		//Inicia la actividad de "Acerca de"
		
		//TODO Modificar las clases para iniciarlas
		//Intent intent = new Intent(this, CLASE_ACERCA_DE.class);
		//startActivity(intent);
	}
	
}
