package com.tesis.gtgrafia.leccion;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.evaluacion.EvaluacionActivity;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
		
		//Colocar el nombre de la lección
		TextView textNombreLeccion = (TextView)findViewById(R.id.textNombreLeccion);
		textNombreLeccion.setText(LeccionFuncion.getNombreNivel(this, idNivel));
		
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
		TextView textAplicacionLeccion = (TextView)findViewById(R.id.textAplicacionLeccion);
		textAplicacionLeccion.setTypeface(tf);
		
		TextView textTituloLeccion = (TextView)findViewById(R.id.textTituloLeccion);
		textTituloLeccion.setTypeface(tf);
		
		TextView textNombreLeccion = (TextView)findViewById(R.id.textNombreLeccion);
		textNombreLeccion.setTypeface(tf);
		
		TextView textLeerLeccion = (TextView)findViewById(R.id.textLeerLeccion);
		textLeerLeccion.setTypeface(tf);
		
		TextView textEvaluarLeccion = (TextView)findViewById(R.id.textEvaluarLeccion);
		textEvaluarLeccion.setTypeface(tf);
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
	 * Metodo que se llama al presionar el boton de Aceptar
	 * Abre la evaluación
	 * 
	 * @param v Referencia a la vista actual
	 */
	public void abrirEvaluacion(View v) {
		Intent intent = new Intent(this.getApplicationContext(), EvaluacionActivity.class);
		
		//Enviar el idUsuario
		intent.putExtra("IdUsuario", idUsuario);
		
		//Enviar el idNivel
		intent.putExtra("IdNivel", idNivel);
		startActivity(intent);
    }
	
	/**
	 * Metodo que se llama al presionar el boton de Aceptar
	 * Lee la lección
	 * 
	 * @param v Referencia a la vista actual
	 */
	public void leerLeccion(View v) {
		String archivo = LeccionFuncion.getArchivo(this, idNivel);
		
		//Abrir el PDF
		this.abrirPDF(archivo);
	}
	
	/**
	 * Metodo que abre un PDF
	 * 
	 * @param archivo Nombre del archivo
	 */
	public void abrirPDF(String archivo) {
		
		//Crea el directorio
		File directorio = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.gtgrafia");
		
		if (!directorio.exists()) {
			directorio.mkdir();
		}
		
		boolean accesoPermitido = true;
		
		//Manejador de assets
		AssetManager assetManager = getAssets();
		
		//Streams para copiar
		InputStream in = null;
		OutputStream out = null;
		
		//Donde sera guardado el archivo
		File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.gtgrafia/", archivo);
		System.out.println("**" + file.getAbsolutePath());
		
		try {
			//Obtener el archivo de los assets
			in = assetManager.open("lecciones/" + archivo);
			//Abrir el archivo para guardar
			out = new FileOutputStream(file.getAbsolutePath());
			
			//Copiar el archivo
			copyFile(in, out);
			
			//Cerrar
			in.close();
			in = null;
			
			//Cerrar
			out.flush();
			out.close();
			out = null;
		} 
		catch (Exception e) {
			System.out.println(e);
			accesoPermitido = false;
		}
		
		if (accesoPermitido == true) {
			//Abrir una ventana de decisión
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setDataAndType(
					Uri.parse("file://" + file.getAbsolutePath()),
					"application/pdf" );
	
			try {
				//Intentar abrir el archivo
				startActivity(intent);
			} 
			catch (ActivityNotFoundException e) {
				//No tiene lector PDF
				this.getMensaje("No tiene un lector PDF para abrir la lección");
			}
		}
		else {
			//No tiene lector PDF
			this.getMensaje("Error desconocido: No se pudo acceder al elemento");
		}
	
	}

	/**
	 * Metodo que copia de un Stream a otro
	 * 
	 * @param in Stream de entrada
	 * @param out Stream de salida
	 * @throws IOException Si hay un problema con los Stream
	 */
	private void copyFile(InputStream in, OutputStream out) throws IOException {
		//Buffer de 1024 bytes
		byte[] buffer = new byte[1024];
		int read;
		//Leer del Stream de entrada
		while ((read = in.read(buffer)) != -1) {
			//Escribir en el Stream de salida
			out.write(buffer, 0, read);
		}
	}
	
}
