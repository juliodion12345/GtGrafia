package com.tesis.gtgrafia.nivel;

import java.util.ArrayList;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.estructura.CustomAdapter;
import com.tesis.gtgrafia.leccion.LeccionActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
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
	 * Variable usada para almacenar el idUsuario de la aplicación
	 */
	private int idUsuario = -1;
	
	/**
	 * Metodo que carga la pantalla principal
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nivel);
		
		//Obtener el idUsuario
		this.idUsuario = getIntent().getIntExtra("IdUsuario", -1);
		
		//Colocar las fuentes
		this.colocarFuentes();
		
		//Coloca los niveles
		this.setNiveles();		
	}
	
	/**
	 * Metodo que colocar las fuentes a los elementos
	 */
	private void colocarFuentes() {
		
		//Typeface
		Typeface tf = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.gt_font));
		
		//Colocar la fuente a cada elemento
		TextView textAplicacionNivel = (TextView)findViewById(R.id.textAplicacionNivel);
		textAplicacionNivel.setTypeface(tf);
		
		TextView textTituloNivel = (TextView)findViewById(R.id.textTituloNivel);
		textTituloNivel.setTypeface(tf);
	}
	
	/**
	 * Metodo que coloca la información de los niveles
	 */
	public void setNiveles(){
		//Llenar con los niveles de la base de datos!
		ArrayList<String> lista = NivelFuncion.getNiveles(this, idUsuario);

		//Llenar un nuevo adaptador usando un adaptador generico		
		CustomAdapter adapter = new CustomAdapter(this,
				android.R.layout.simple_list_item_1, R.layout.custom_list_text, lista);
		
		//Colocar el adaptador
		GridView gridNivelesNivel = (GridView) findViewById(R.id.gridNivelesNivel);
		gridNivelesNivel.setAdapter(adapter); 	
		
		//Colocar el listener
		gridNivelesNivel.setOnItemClickListener(this);
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
	public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) { 
		//Obtiene el elemento seleccionado
		//String fila = parent.getItemAtPosition(position).toString();
		String fila = adapterView.getItemAtPosition(index).toString();
		int idNivel = NivelFuncion.getIdNivel(this, fila);
		
		//Redirige la aplicación al elemento seleccionado
		abrirNivel(idNivel);
	}

	/**
	 * Metodo que abre la pantalla de lección
	 * 
	 *  @param idNivel El id del nivel
	 */
	public void abrirNivel(int idNivel){
		Intent intent = new Intent(this.getApplicationContext(), LeccionActivity.class);
		
		//Enviar el idUsuario
		intent.putExtra("IdUsuario", this.idUsuario);

		//Enviar el idNivel
		intent.putExtra("IdNivel", idNivel);
		
		startActivity(intent);		
	}
	
	/**
	 * Metodo que se ejecuta al regresar a la actividad
	 */
	@Override
	public void onResume() {
		//Llamar a la super clase
		super.onResume();
		
		//Coloca los niveles
		this.setNiveles();	
	}
}
