package com.tesis.gtgrafia;

/**
 * Script
 * Clase que se encarga de almacenar el script inicial del modelo de la base de datos
 * 
 * @author Andrea
 * @version 0.1
 * 
 */
public class Script {
	
	/**
	 * Variable que almacena el script de la tabla usuario
	 */
	protected final String create_usuario;
	/**
	 * Variable que almacena el script de la tabla tipo_pregunta
	 */
	protected final String create_tipo_pregunta;
	/**
	 * Variable que almacena el script de la tabla nivel
	 */
	protected final String create_nivel;
	/**
	 * Variable que almacena el script de la tabla pregunta
	 */
	protected final String create_pregunta;
	/**
	 * Variable que almacena el script de la tabla opcion
	 */
	protected final String create_opcion;
	/**
	 * Variable que almacena el script de la tabla usuario_nivel
	 */
	protected final String create_usuario_nivel;
	/**
	 * Variable que almacena el script de la tabla evaluacion
	 */
	protected final String create_evaluacion;
	
	/**
	 * Constructor principal que inicializa las variables con los scripts
	 */
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
				+ "idOpcion INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 			," 
				+ "palabra TEXT NOT NULL										,"
				+ "idPregunta INTEGER											,"
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
