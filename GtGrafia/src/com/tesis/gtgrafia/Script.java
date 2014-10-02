package com.tesis.gtgrafia;
 
public class Script {
	String create_usuario, create_tipo_pregunta, create_nivel, create_pregunta, create_opcion, 
	create_usuario_nivel, create_evaluacion;
	
	public Script(){
		create_usuario = "CREATE TABLE usuario ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "Nombre TEXT NOT NULL	)";

		create_tipo_pregunta = "CREATE TABLE tipo_pregunta ("
				+ "idtipo_pregunta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "descripcion TEXT NOT NULL)";

		create_nivel = "CREATE TABLE nivel ("
				+ "idNivel INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "dir_contenido TEXT 									,"
				+ "Nombre TEXT NOT NULL)";

		create_pregunta = "CREATE TABLE pregunta ("
				+ "idPregunta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 					," 
				+ "enunciado TEXT NOT NULL													,"
				+ "respuesta TEXT NOT NULL													," 
				+ "idtipo_pregunta INTEGER NOT NULL											,"
				+ "idNivel INTEGER NOT NULL													,"
				+ "FOREIGN KEY (idtipo_pregunta) REFERENCES tipo_pregunta(idtipo_pregunta)	,"
				+ "FOREIGN KEY (idNivel) REFERENCES nivel(idNivel) )";

		create_opcion = "CREATE TABLE opcion ("
				+ "idOpcion INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "palabra TEXT NOT NULL								,"
				+ "idPregunta INTEGER									,"
				+ "FOREIGN KEY (idPregunta) REFERENCES pregunta(idPregunta) )";

		create_usuario_nivel = "CREATE TABLE usuario_nivel ("
				+ "Usuario_id INTEGER NOT NULL 								," 
				+ "idNivel INTEGER NOT NULL 								,"
				+ "primary key (Usuario_id, idNivel) 						,"
				+ "FOREIGN KEY (Usuario_id) REFERENCES usuario(Usuario_id) 	,"
				+ "FOREIGN KEY (idNivel) REFERENCES nivel(idNivel) )";

		create_evaluacion = "CREATE TABLE evaluacion ("
				+ "idEvaluacion INTEGER NOT NULL							," 
				+ "idPregunta INTEGER NOT NULL								,"
				+ "Usuario_id INTEGER NOT NULL								," 
				+ "primary key (idEvaluacion, idPregunta, Usuario_id)		,"
				+ "FOREIGN KEY (idPregunta) REFERENCES pregunta(idPregunta) ,"
				+ "FOREIGN KEY (Usuario_id) REFERENCES usuario(Usuario_id) )";
		
		
		
	}

}
