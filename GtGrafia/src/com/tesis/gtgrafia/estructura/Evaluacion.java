/**
 * Evaluacion
 * Clase que se encarga de almacenar los campos de una evaluacion
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia.estructura;

import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;

public class Evaluacion implements Parcelable {
	
	/**
	 * Variable usada para almacenar el idEvaluacion
	 */
	private int idEvaluacion;
	/**
	 * Variable usada para almacenar el idUsuario
	 */
	private int idUsuario;
	/**
	 * Variable usada para almacenar el idNivel
	 */
	private int idNivel;
	/**
	 * Variable usada para almacenar el tipoEvaluacion
	 */
	private int tipoEvaluacion;	
	/**
	 * Variable usada para almacenar el tipoEvaluacion
	 */
	private String nombreNivel;
	/**
	 * Variable usada para almacenar las preguntas
	 */
	private ArrayList<Pregunta> preguntas = null;

	///////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////////
	
	/**
	 * Constructor principal
	 */
	public Evaluacion() {
		this.idEvaluacion 	= 0;
		this.idUsuario 		= 0;
		this.idNivel 		= 0;
		this.tipoEvaluacion = 0;
		this.nombreNivel 	= "";
		this.preguntas 		= new ArrayList<Pregunta>();
	}
	
	/////////////////////////////////////////GET-SET///////////////////////////////////////////////

	public int getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}
	public int getTipoEvaluacion() {
		return tipoEvaluacion;
	}
	public void setTipoEvaluacion(int tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
	public String getNombreNivel() {
		return nombreNivel;
	}
	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	/////////////////////////////////////////PARCEL////////////////////////////////////////////////

	/**
	 * Describe contenido
	 * 
	 * @return id
	 */
	@Override
    public int describeContents() {
        return 0;
    }
 
	/**
	 * Escribe el nuevo objeto
	 * 
	 * @param dest Destino del Parcel
	 * @param flags Etiquetas
	 */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    	dest.writeInt(idEvaluacion);
    	dest.writeInt(idUsuario);
    	dest.writeInt(idNivel);
    	dest.writeInt(tipoEvaluacion);
    	dest.writeString(nombreNivel);
    	dest.writeTypedList(preguntas);
    }
    
    /**
	 * Lee el nuevo objeto
	 * 
	 * @param in Parcel de entrada
	 */
    private void readFromParcel(Parcel in) {
    	//Leer los valores
    	this.idEvaluacion = in.readInt();
    	this.idUsuario = in.readInt();
    	this.idNivel = in.readInt();
    	this.tipoEvaluacion = in.readInt();
    	this.nombreNivel = in.readString();
    	
    	//Leer el ArrayList de tipo Pregunta
    	in.readTypedList(preguntas, Pregunta.CREATOR);
    }
    
    /**
	 * Constructor que facilita la creación de nuevos Parcel
	 * 
	 * @param in Parcel de entrada
	 */
    public Evaluacion(Parcel in) {
    	//Inicializar objeto
    	this();
    	
        readFromParcel(in);
    }
    
    /**
	 * CREATOR que facilita la creación de nuevos elementos
	 */
    public static final Parcelable.Creator<Evaluacion> CREATOR
    	= new Parcelable.Creator<Evaluacion>() {
        public Evaluacion createFromParcel(Parcel in) {
            return new Evaluacion(in);
        }
 
        public Evaluacion[] newArray(int size) {
            return new Evaluacion[size];
        }
    };

}
