package com.tesis.gtgrafia;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * StartFuncion
 * Clase para encapsular las funciones mas utilizadas
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */
public class StartFuncion {
	
	/**
	 * Metodo que devuelve un mensaje corto de tipo Toast
	 * 
	 * @param contexto El contexto de la actividad
	 * @param texto El texto a mostrar
	 */
	public static void getMensaje(Activity actividad, String texto) {
		int duracion = Toast.LENGTH_SHORT;
		
		//Crear el inflador
		LayoutInflater inflater = LayoutInflater.from(actividad);
		//Inflar el layout
        View layout = inflater.inflate(R.layout.custom_toast,
                                       (ViewGroup) actividad.findViewById(R.id.layoutToast));

        //Typeface
      	Typeface tf = Typeface.createFromAsset(actividad.getAssets(), 
      											actividad.getResources().getString(R.string.gt_font));
        
        //Obtener el textView
        TextView text = (TextView) layout.findViewById(R.id.textToast);
        //Colocarle el texto y fuente
        text.setText(texto);
        text.setTypeface(tf);
        
        //Crear el toast
        Toast toast = new Toast(actividad.getApplicationContext());
        
        //Colocar atributos
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(duracion);
        toast.setView(layout);
        
        //Mostrar el toast
        toast.show();
	}

}
