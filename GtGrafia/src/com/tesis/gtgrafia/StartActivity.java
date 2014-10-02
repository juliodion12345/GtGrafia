/**
 * StartActivity
 * Activity para cargar el menu principal (pantalla principal de la aplicación)
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia;

import java.util.ArrayList;

import com.tesis.gtgrafia.evaluacion.EvaluacionActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
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
	
	//variable conectora con la base de datos
	public SQLHelper bd = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		bd = new SQLHelper (this, 1);
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
	public ArrayList<String> listItems() {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add(getString(R.string.str_iniciar_juego));
		lista.add(getString(R.string.str_acerca_de));
		//tomar nombres de la base de datos 
				bd.abrir();
		Cursor usuario = bd.Select("Select * from usuario;");
		
		if (usuario != null && usuario.getCount() > 0) {
			usuario.moveToFirst();
			lista.add(usuario.getString(1));
			while (usuario.moveToNext()) {	
				lista.add(usuario.getString(1));
			}
		}
		
		bd.cerrar();
		
		
		
		
		return lista;
				
	}
	
	/**
	 * Metodo que coloca los elementos en la lista de la pantalla principal
	 */
	public void setListItems() {
		
		//Obtener los elementos
		ArrayList<String> lista = listItems();
		
		/*Llenar un nuevo adaptador con los elementos obtenidos, usando como plantilla
		 * el simple_list_item_1 (que es una lista simple)
		 */
				
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, lista);
		
		//Asignar el adaptador al listView
		ListView listView = (ListView) findViewById(R.id.listOpciones);
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
		if (fila.equals(getString(R.string.str_iniciar_juego))) {
			iniciarJuego();
		}
		else if (fila.equals(getString(R.string.str_acerca_de))) {
			iniciarAcercaDe();
		}else{
			
			irMenu();
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
		menu.add(Menu.NONE, MNU_INICIAR, Menu.NONE, getString(R.string.str_iniciar_juego));
		menu.add(Menu.NONE, MNU_ACERCA, Menu.NONE, getString(R.string.str_acerca_de));
		
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
	private void irMenu() {
		//Inicia la actividad de "Acerca de"
		
		//TODO Modificar las clases para iniciarlas
		Intent intent = new Intent(this.getApplicationContext(), MenuActivity.class);
		startActivity(intent);
		
	}
	
}
