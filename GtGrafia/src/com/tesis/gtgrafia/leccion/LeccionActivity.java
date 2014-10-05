package com.tesis.gtgrafia.leccion;
 
import com.tesis.gtgrafia.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * LeccionActivity
 * Activity para cargar la lección de un nivel
 * 
 * @author Andrea
 * @version 0.1
 * 
 */
public class LeccionActivity extends Activity {

	/**
	 * Variable usada para almacenar el idUsuario de la aplicación
	 */
	private int idUsuario = -1;
	/**
	 * Variable usada para almacenar el nivel a evaluar
	 */
	private int idNivel = -1;
	
	/**
	 * Metodo que carga la pantalla principal
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leccion);
		
		//Obtener el idUsuario
		this.idUsuario = getIntent().getIntExtra("IdUsuario", -1);
		
		//Obtener el idNivel
		this.idNivel = getIntent().getIntExtra("IdNivel", -1);
		
		//Colocar el enunciado
		TextView textNombreLeccion = (TextView)findViewById(R.id.textNombreLeccion);
		textNombreLeccion.setText(LeccionFuncion.getNombreNivel(this, idNivel));
	}
	
	
}
