package com.tesis.gtgrafia;


import java.util.HashMap;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class StartActivity extends Activity {

	
	public SQLHelper bd = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		bd = new SQLHelper(this, 1);
		bd.abrir();
		bd.InsertUsuario(1,"Andrea Gonzalez");
		Cursor usuario = bd.SelectUsuario();
		if (usuario != null && usuario.getCount() > 0) {
			usuario.moveToFirst();
			System.out.println(usuario.getString(0));
			System.out.println(usuario.getString(1));
			while (usuario.moveToNext()) {
				System.out.println(usuario.getString(0));
				System.out.println(usuario.getString(1));
			}
		}
		bd.close();
		
		
	}
}
