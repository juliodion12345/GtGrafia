package com.tesis.gtgrafia.leccion;
 
import com.tesis.gtgrafia.R;
import android.app.Activity;
import android.os.Bundle;

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
	 * Metodo que carga la pantalla principal
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leccion);
	}
}
