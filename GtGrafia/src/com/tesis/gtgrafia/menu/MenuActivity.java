package com.tesis.gtgrafia.menu;

import java.util.ArrayList;

import com.tesis.gtgrafia.R;
import com.tesis.gtgrafia.R.id;
import com.tesis.gtgrafia.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * MenuActivity
 * Activity para cargar la pantalla con los niveles
 * 
 * @author Andrea
 * @version 0.1
 * 
 */
public class MenuActivity extends Activity implements OnItemClickListener{

	
	//Numero de los niveles
	
	private static final int MENU_1 = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		this.crear_menu();
	}
	
	public void crear_menu(){
		//llenar con los niveles de la base de datos!
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("1");
		lista.add("2");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, lista);
		
		GridView gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(adapter); 	
				
		gridView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
		// TODO Auto-generated method stub
		String fila = parent.getItemAtPosition(position).toString();
		if (fila.equals("1")) {
			//mostrar leccion 1
		}
		else if (fila.equals("2")) {
			//mostrar leccion 2
		}
	}
}
