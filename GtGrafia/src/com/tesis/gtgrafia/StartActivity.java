package com.tesis.gtgrafia;

import com.tesis.gtgrafia.acerca.AcercaActivity;
import com.tesis.gtgrafia.usuario.UsuarioActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * StartActivity
 * Activity para cargar el menu principal (pantalla principal de la aplicación)
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
public class StartActivity extends Activity {
	
	/**
	 * Metodo que carga la pantalla principal
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		//Colocar las fuentes
		this.colocarFuentes();
	}
	
	/////////////////////////////////////////INICIAR///////////////////////////////////////////////

	/**
	 * Metodo que inicia la pantalla de "Iniciar Juego"
	 * 
	 * @param v La vista de la pantalla
	 */
	public void iniciarJuego(View v) {
		//Inicia la actividad de "Iniciar Juego"
		
		Intent intent = new Intent(this.getApplicationContext(), UsuarioActivity.class);
		startActivity(intent);
	}
	
	/**
	 * Metodo que colocar las fuentes a los elementos
	 */
	private void colocarFuentes() {
		
		//Typeface
		Typeface tf = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.gt_font));
		
		//Colocar la fuente a cada elemento
		TextView textTituloStart = (TextView)findViewById(R.id.textTituloStart);
		textTituloStart.setTypeface(tf);
		
		TextView textAplicacionStart = (TextView)findViewById(R.id.textAplicacionStart);
		textAplicacionStart.setTypeface(tf);
		
		TextView textIniciarStart = (TextView)findViewById(R.id.textIniciarStart);
		textIniciarStart.setTypeface(tf);
		
		TextView textAcercaStart = (TextView)findViewById(R.id.textAcercaStart);
		textAcercaStart.setTypeface(tf);
	}
	
	/**
	 * Metodo que inicia la pantalla de "Acerca de"
	 * 
	 * @param v La vista de la pantalla
	 */
	public void iniciarAcercaDe(View v) {
		//Inicia la actividad de "Acerca de"
		
		Intent intent = new Intent(this.getApplicationContext(), AcercaActivity.class);
		startActivity(intent);			
	}
	
}
