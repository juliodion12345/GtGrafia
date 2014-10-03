package com.tesis.gtgrafia.inicio;

import java.util.ArrayList;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.R.id;
import com.tesis.gtgrafia.R.layout;
import com.tesis.gtgrafia.base.SQLHelper;
import com.tesis.gtgrafia.menu.MenuActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * InicioActivity
 * Activity para cargar la pantalla de selección de nombre
 * 
 * @author Andrea
 * @version 0.1
 * 
 */
public class InicioActivity extends Activity implements OnItemClickListener  {

	SQLHelper bd = null;
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		bd = new SQLHelper (this, SQLHelper.DATABASE_VERSION);
		
		//Coloca los usuarios
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
		ListView listView = (ListView) findViewById(R.id.listUsuarios);
		listView.setAdapter(adapter); 	
		
		//Colocarle el listener (esta clase) para seleccionar elementos
		listView.setOnItemClickListener(this);	
		
	}
	
	public void insertarNombre(View v) {
		bd.abrir();
		EditText nombre = (EditText) findViewById(R.id.textNombre);
		String textonombre = nombre.getText().toString();
		bd.InsertUsuario(textonombre);
		Cursor usuario = bd.Select("Select * from usuario;");
		if (usuario != null && usuario.getCount() > 0) {
			usuario.moveToFirst();
			System.out.println(usuario.getString(0));
			System.out.println(usuario.getString(1));
			while (usuario.moveToNext()) {
				System.out.println(usuario.getString(0));
				System.out.println(usuario.getString(1));
			}
		}
		bd.close();
	
		abrir_menu();
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
		irMenu();

	}

	public void abrir_menu(){
		Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);		
	}
	
	private void irMenu() {
		//Inicia la actividad		
		Intent intent = new Intent(this.getApplicationContext(), MenuActivity.class);
		startActivity(intent);
		
	}
}
