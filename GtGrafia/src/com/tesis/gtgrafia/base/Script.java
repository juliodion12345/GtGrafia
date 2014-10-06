package com.tesis.gtgrafia.base;

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
		
		create_usuario = "CREATE TABLE Usuario ( "
				+ "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "nombre TEXT NOT NULL	)";

		create_tipo_pregunta = "CREATE TABLE TipoPregunta ("
				+ "idTipoPregunta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "descripcion TEXT NOT NULL )";

		create_nivel = "CREATE TABLE Nivel ("
				+ "idNivel INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 	," 
				+ "archivo TEXT NOT NULL							,"
				+ "nombre TEXT NOT NULL )";

		create_pregunta = "CREATE TABLE Pregunta ("
				+ "idPregunta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 					," 
				+ "enunciado TEXT NOT NULL													,"
				+ "respuesta TEXT NOT NULL													," 
				+ "idTipoPregunta INTEGER NOT NULL											,"
				+ "idNivel INTEGER NOT NULL													,"
				+ "FOREIGN KEY (idTipoPregunta) REFERENCES TipoPregunta(idTipoPregunta)	,"
				+ "FOREIGN KEY (idNivel) REFERENCES Nivel(idNivel) )";

		create_opcion = "CREATE TABLE Opcion ("
				+ "idOpcion INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL 			," 
				+ "palabra TEXT NOT NULL										,"
				+ "idPregunta INTEGER NOT NULL									,"
				+ "FOREIGN KEY (idPregunta) REFERENCES Pregunta(idPregunta) )";

		create_usuario_nivel = "CREATE TABLE UsuarioNivel ("
				+ "idUsuario INTEGER NOT NULL 								," 
				+ "idNivel INTEGER NOT NULL 								,"
				+ "PRIMARY KEY (idUsuario, idNivel) 						,"
				+ "FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) 	,"
				+ "FOREIGN KEY (idNivel) REFERENCES Nivel(idNivel) )";

		create_evaluacion = "CREATE TABLE Evaluacion ("
				+ "idEvaluacion INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ," 
				+ "idPregunta INTEGER NOT NULL								,"
				+ "idUsuario INTEGER NOT NULL								," 
				+ "FOREIGN KEY (idPregunta) REFERENCES Pregunta(idPregunta) ,"
				+ "FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) )";
		
	}

}
