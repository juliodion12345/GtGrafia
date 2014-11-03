package com.tesis.gtgrafia.usuario;

import java.util.ArrayList;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.base.SQLFuncion;
import com.tesis.gtgrafia.estructura.CustomAdapter;
import com.tesis.gtgrafia.nivel.NivelActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
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
public class UsuarioActivity extends Activity implements OnItemClickListener, OnEditorActionListener  {

	/**
	 * Metodo que carga la pantalla de inicio
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usuario);
		
		//Colocar las fuentes
		this.colocarFuentes();
		
		//Coloca los usuarios
		this.setListItems();	
	}
	
	/**
	 * Metodo que colocar las fuentes a los elementos
	 */
	private void colocarFuentes() {
		
		//Typeface
		Typeface tf = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.gt_font));
		
		//Colocar la fuente a cada elemento
		TextView textAplicacionUsuario = (TextView)findViewById(R.id.textAplicacionUsuario);
		textAplicacionUsuario.setTypeface(tf);
		
		TextView textTituloUsuario = (TextView)findViewById(R.id.textTituloUsuario);
		textTituloUsuario.setTypeface(tf);
		
		TextView textNuevoUsuario = (TextView)findViewById(R.id.textNuevoUsuario);
		textNuevoUsuario.setTypeface(tf);
		
		EditText editNombreUsuario = (EditText)findViewById(R.id.editNombreUsuario);
		editNombreUsuario.setTypeface(tf);
		
		TextView textEnviarUsuario = (TextView)findViewById(R.id.textEnviarUsuario);
		textEnviarUsuario.setTypeface(tf);
		
		TextView textViejoUsuario = (TextView)findViewById(R.id.textViejoUsuario);
		textViejoUsuario.setTypeface(tf);
	}
	
	//////////////////////////////////////////LISTA////////////////////////////////////////////////
	
	/**
	 * Metodo que coloca los elementos en la lista de la pantalla principal
	 */
	public void setListItems() {
		
		//Obtener los elementos
		ArrayList<String> lista = UsuarioFuncion.getUsuarios(this);
		
		//Llenar un nuevo adaptador usando un adaptador generico		
		CustomAdapter adapter = new CustomAdapter(this,
				android.R.layout.simple_list_item_1, R.layout.custom_list_text, lista);
		
		//Asignar el adaptador al listView
		ListView listUsuariosUsuario = (ListView) findViewById(R.id.listUsuariosUsuario);
		listUsuariosUsuario.setAdapter(adapter); 	
		
		//Colocarle el listener (esta clase) para seleccionar elementos
		listUsuariosUsuario.setOnItemClickListener(this);
		
		//Colocarle el listener (esta clase) para enviar desde el editText
		EditText editNombreUsuario = (EditText) findViewById(R.id.editNombreUsuario);
		editNombreUsuario.setOnEditorActionListener(this);
		
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
        	this.insertarNombre(editor.getText().toString().trim());
            handled = true;
        }
        
        //Retorno de evento manejado
        return handled;
    }
	
	/**
	 * Metodo que inserta el nuevo usuario a la base de datos
	 * 
	 * @param v Vista del elemento
	 */
	public void insertarNombre(View v) {
		//Obtener el nombre de usuario
		EditText editNombreUsuario = (EditText)findViewById(R.id.editNombreUsuario);
		String nombre = editNombreUsuario.getText().toString().trim();
		
		//Inserta el nombre
		this.insertarNombre(nombre);		
	}
	
	/**
	 * Metodo que inserta el nuevo usuario a la base de datos
	 * 
	 * @param nombre Nombre del usuario
	 */
	public void insertarNombre(String nombre) {

		if (! nombre.equals("")) {
			//Obtener idUsuario existente
			int idUsuario = UsuarioFuncion.getIdUsuario(this, nombre);
			
			if (idUsuario == -1) {
				//Insertarlo si no existe
				idUsuario = SQLFuncion.insertUsuario(this, nombre);
				
				//Insertar el primer nivel
				SQLFuncion.insertUsuarioNivel(this, idUsuario, 1);
			}
			
			//Ingrese nombre
			this.getMensaje(getString(R.string.msg_usuario_registrado));
			
			//Redirigir al usuario a los niveles
			abrirNiveles(idUsuario);
		}
		else {
			//Ingrese nombre
			this.getMensaje(getString(R.string.msg_ingrese_nombre));
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

	/**
	 * Metodo que se ejecuta al regresar a la actividad
	 */
	@Override
	public void onResume() {
		//Llamar a la super clase
		super.onResume();
				
		//Coloca los usuarios
		this.setListItems();
		
		//Limpiar el cuadro de texto
		EditText editNombreUsuario = (EditText) findViewById(R.id.editNombreUsuario);
		editNombreUsuario.setText("");
	}
	
}
