package com.tesis.gtgrafia.nivel;

import java.util.ArrayList;

import com.tesis.gtgrafia.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * NivelActivity
 * Activity para cargar la pantalla con los niveles
 * 
 * @author Andrea
 * @version 0.1
 * 
 */
public class NivelActivity extends Activity implements OnItemClickListener{
	
	/**
	 * Metodo que carga la pantalla principal
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		this.setNiveles();
	}
	
	/**
	 * Metodo que coloca la información de los niveles
	 */
	public void setNiveles(){
		//Llenar con los niveles de la base de datos!
		ArrayList<String> lista = new ArrayList<String>();
		
		//TODO: Obtener niveles de la base de datos, dependiendo del usuario
		lista.add("1");lista.add("2");lista.add("3");lista.add("4");lista.add("5");
		
		
		//Agregar los niveles al adaptador
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, lista);
		
		//Colocar el adaptador
		GridView gridView = (GridView) findViewById(R.id.gridNiveles);
		gridView.setAdapter(adapter); 	
		
		//Colocar el listener
		gridView.setOnItemClickListener(this);
	}

	/**
	 * Metodo que se activa al seleccionar un elemento del gridview
	 * 
	 * @param adapterView El adaptador de la vista
	 * @param view El adaptador de la vista
	 * @param index La posición del elemento cliqueado
	 * @param id El ID del elemento cliqueado
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
		//Obtiene el elemento seleccionado
		//String fila = parent.getItemAtPosition(position).toString();
		
		//TODO: Administrar los niveles
	}
}
