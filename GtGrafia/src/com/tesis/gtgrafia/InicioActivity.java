package com.tesis.gtgrafia;


import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InicioActivity extends Activity  {

	SQLHelper bd = null;
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		bd = new SQLHelper (this, SQLHelper.DATABASE_VERSION);

		final Button button1 = (Button) this.findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				bd.abrir();
				EditText nombre = (EditText) findViewById(R.id.editText1);
				String textonombre = nombre.getText().toString();
				bd.InsertUsuario(textonombre);
				Cursor usuario = bd.Select("Select * from usuario;");
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
			
				abrir_menu();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void abrir_menu(){
		Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);		
	}
}
