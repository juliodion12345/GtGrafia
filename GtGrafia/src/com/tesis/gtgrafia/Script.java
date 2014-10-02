package com.tesis.gtgrafia;

public class Script {
	String create_usuario, create_tipo_pregunta, create_nivel, create_pregunta, create_opcion, 
	create_usuario_nivel, create_evaluacion;
	
	public Script(){
		create_usuario = "CREATE TABLE usuario ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "Nombre TEXT 										," 
				+ "Punteo INTEGER )";

		create_tipo_pregunta = "CREATE TABLE tipo_pregunta ("
				+ "idtipo_pregunta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "descripcion TEXT)";

		create_nivel = "CREATE TABLE nivel ("
				+ "idNivel INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "dir_contenido TEXT 									,"
				+ "Nombre TEXT )";

		create_pregunta = "CREATE TABLE pregunta ("
				+ "idPregunta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," 
				+ "enunciado TEXT 										,"
				+ "respuesta TEXT 										," 
				+ "idtipo_pregunta INTEGER)";

		create_opcion = "CREATE TABLE opcion ("
				+ "idOpcion INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "palabra TEXT 										,"
				+ "idPregunta INTEGER) ";

		create_usuario_nivel = "CREATE TABLE usuario_nivel ("
				+ "Usuario_id INTEGER NOT NULL 	," 
				+ "idNivel INTEGER NOT NULL 	,"
				+ "primary key (Usuario_id, idNivel))";

		create_evaluacion = "CREATE TABLE evaluacion ("
				+ "idEvaluacion INTEGER NOT NULL	," 
				+ "idPregunta INTEGER NOT NULL		,"
				+ "Usuario_id INTEGER NOT NULL		," 
				+ "primary key (idEvaluacion, idPregunta, Usuario_id))";
		
		
		
	}

}
