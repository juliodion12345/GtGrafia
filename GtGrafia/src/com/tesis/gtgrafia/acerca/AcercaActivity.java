package com.tesis.gtgrafia.acerca;

import com.tesis.gtgrafia.R;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class AcercaActivity extends Activity {

	/**
	 * Metodo que carga la pantalla principal
	 * 
	 * @param savedInstanceState savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acerca);
		
		//Colocar las fuentes
		this.colocarFuentes();
	}
	
	/**
	 * Metodo que colocar las fuentes a los elementos
	 */
	private void colocarFuentes() {
		
		//Typeface
		Typeface tf = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.gt_font));
		
		//Colocar la fuente a cada elemento
		TextView textAplicacionAcerca = (TextView)findViewById(R.id.textAplicacionAcerca);
		textAplicacionAcerca.setTypeface(tf);
		
		TextView textTituloAcerca = (TextView)findViewById(R.id.textTituloAcerca);
		textTituloAcerca.setTypeface(tf);
		
		TextView textDevAcerca = (TextView)findViewById(R.id.textDevAcerca);
		textDevAcerca.setTypeface(tf);
		
		TextView textAndreaAcerca = (TextView)findViewById(R.id.textAndreaAcerca);
		textAndreaAcerca.setTypeface(tf);
		
		TextView textJulioAcerca = (TextView)findViewById(R.id.textJulioAcerca);
		textJulioAcerca.setTypeface(tf);

        TextView textLicenciaAcerca = (TextView)findViewById(R.id.textLicenciaAcerca);
        textLicenciaAcerca.setTypeface(tf);

        TextView textLicencia1Acerca = (TextView)findViewById(R.id.textLicencia1Acerca);
        textLicencia1Acerca.setTypeface(tf);
	}
	
}
