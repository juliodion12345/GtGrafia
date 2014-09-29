package com.tesis.gtgrafia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class BaseDDatos extends SQLiteOpenHelper {
	 
    //Sentencia SQL para crear las tablas de la bases de datos
	String create_usuario = "CREATE TABLE usuario ( "
			+ "id INTEGER primary key ," 
			+ "Nombre TEXT ," 
			+ "Punteo INTEGER)";

	String create_tipo_pregunta = "CREATE TABLE tipo_pregunta ("
			+ "idtipo_pregunta INTEGER primary key ," 
			+ "descripcion TEXT)";

	String create_nivel = "CREATE TABLE nivel ("
			+ "idNivel INTEGER primary key ," 
			+ "dir_contenido TEXT ,"
			+ "Nombre TEXT )";

	String create_pregunta = "CREATE TABLE pregunta ("
			+ "idPregunta INTEGER primary key ," 
			+ "enunciado TEXT ,"
			+ "respuesta TEXT ," 
			+ "idtipo_pregunta INTEGER,";

	String create_opcion = "CREATE TABLE opcion ("
			+ "idOpcion INTEGER primary key ," 
			+ "palabra TEXT ,"
			+ "idPregunta INTEGER) ";

	String create_usuario_nivel = "CREATE TABLE usuario_nivel ("
			+ "Usuario_id INTEGER primary key," 
			+ "idNivel INTEGER)";

	String create_evaluacion = "CREATE TABLE evaluacion ("
			+ "idEvaluacion INTEGER primary key," 
			+ "idPregunta INTEGER ,"
			+ "Usuario_id INTEGER)";
	String index_usuario = "CREATE INDEX index_usuario" +
			"ON usuario ( id COLLATE NOCASE );";
	
    public BaseDDatos(Context contexto, String nombre,
                               CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(create_usuario);
        db.execSQL(create_tipo_pregunta);
        db.execSQL(create_nivel);
        db.execSQL(create_pregunta);
        db.execSQL(create_opcion);
        db.execSQL(create_usuario_nivel);
        db.execSQL(create_evaluacion);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.
 
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS tipo_pregunta");
        db.execSQL("DROP TABLE IF EXISTS nivel");
        db.execSQL("DROP TABLE IF EXISTS pregunta");
        db.execSQL("DROP TABLE IF EXISTS opcion");
        db.execSQL("DROP TABLE IF EXISTS usuario_nivel");
        db.execSQL("DROP TABLE IF EXISTS evaluacion");
 
        //Se crea la nueva versión de la tabla
        db.execSQL(create_usuario);
        db.execSQL(create_tipo_pregunta);
        db.execSQL(create_nivel);
        db.execSQL(create_pregunta);
        db.execSQL(create_opcion);
        db.execSQL(create_usuario_nivel);
        db.execSQL(create_evaluacion);
    }
}
