package com.tesis.gtgrafia.usuario;

import java.util.ArrayList;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.base.SQLFuncion;
import com.tesis.gtgrafia.nivel.NivelActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * UsuarioActivity
 * Activity para cargar la pantalla de selección de nombre
 * 
 * @author Andrea
 * @version 0.1
 * 
 */
public class UsuarioActivity extends Activity implements OnItemClickListener  {

	/**
	 * Metodo que carga la pantalla de inicio
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usuario);
		
		//Coloca los usuarios
		this.setListItems();
	}
	
	//////////////////////////////////////////LISTA////////////////////////////////////////////////
	
	/**
	 * Metodo que coloca los elementos en la lista de la pantalla principal
	 */
	public void setListItems() {
		
		//Obtener los elementos
		ArrayList<String> lista = UsuarioFuncion.getUsuarios(this);
		
		/*Llenar un nuevo adaptador con los elementos obtenidos, usando como plantilla
		 * el simple_list_item_1 (que es una lista simple)
		 */
				
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, lista);
		
		//Asignar el adaptador al listView
		ListView listUsuariosUsuario = (ListView) findViewById(R.id.listUsuariosUsuario);
		listUsuariosUsuario.setAdapter(adapter); 	
		
		//Colocarle el listener (esta clase) para seleccionar elementos
		listUsuariosUsuario.setOnItemClickListener(this);	
		
	}
	
	/**
	 * Metodo que se llama al presionar el boton de Aceptar
	 * Inseta el nuevo usuario
	 * 
	 * @param v Referencia a la vista actual
	 */
	public void insertarNombre(View v) {

		//Obtener el nombre de usuario
		EditText editNombreUsuario = (EditText) findViewById(R.id.editNombreUsuario);
		String nombre = editNombreUsuario.getText().toString().trim();
		
		if (! nombre.equals("")) {
			//Obtener idUsuario existente
			int idUsuario = UsuarioFuncion.getIdUsuario(this, nombre);
			
			if (idUsuario == -1) {
				//Insertarlo si no existe
				idUsuario = SQLFuncion.insertUsuario(this, nombre);
				
				//Insertar el primer nivel
				SQLFuncion.insertUsuarioNivel(this, idUsuario, 1);
			}
			
			//Redirigir al usuario a los niveles
			abrirNiveles(idUsuario);
		}
		else {
			this.getMensaje("Ingrese un nombre");
		}
		
	}
	
	/**
	 * Metodo que devuelve un mensaje corto de tipo Toast
	 * 
	 * @param texto El texto a mostrar
	 */
	private void getMensaje(String texto) {
		int duracion = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(this.getApplicationContext(), texto, duracion);
		toast.show();
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
		int idUsuario = UsuarioFuncion.getIdUsuario(this, fila);
		
		//Redirige la aplicación al elemento seleccionado
		abrirNiveles(idUsuario);
	}

	/**
	 * Metodo que abre la pantalla de niveles
	 * 
	 *  @param idUsuario El id del usuario
	 */
	public void abrirNiveles(int idUsuario){
		Intent intent = new Intent(this.getApplicationContext(), NivelActivity.class);
		
		//Enviar el idUsuario
		intent.putExtra("IdUsuario", idUsuario);
		startActivity(intent);		
	}
	
}
