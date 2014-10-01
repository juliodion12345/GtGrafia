/**
 * Opcion
 * Clase que se encarga de almacenar una opcion
 * 
 * @author Mayaka
 * @version 0.1
 * 
 */

package com.tesis.gtgrafia.estructura;

import android.os.Parcel;
import android.os.Parcelable;

public class Opcion implements Parcelable  {
	
	/**
	 * Variable usada para almacenar el idOpcion
	 */
	private int idOpcion;
	/**
	 * Variable usada para almacenar la opcion
	 */
	private String opcion;
	
	///////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////////
	
	/**
	 * Constructor principal
	 */
	public Opcion() {
		this.idOpcion = 0;
		this.opcion = "";
	}
	
	/////////////////////////////////////////GET-SET///////////////////////////////////////////////

	public int getIdOpcion() {
		return idOpcion;
	}
	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}
	public String getOpcion() {
		return opcion;
	}
	public void setOpcion(String opcion) {
		this.opcion = opcion;
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
		//Escribir los valores
		dest.writeInt(idOpcion);
		dest.writeString(opcion);
	}
	
	/**
	 * Lee el nuevo objeto
	 * 
	 * @param in Parcel de entrada
	 */
	private void readFromParcel(Parcel in) {
		//Leer los valores
		this.idOpcion = in.readInt();
		this.opcion = in.readString();
	}
	
	/**
	 * Constructor que facilita la creación de nuevos Parcel
	 * 
	 * @param in Parcel de entrada
	 */
	public Opcion(Parcel in) {
		//Inicializar objeto
		this();
		
		readFromParcel(in);
	}
	
	/**
	 * CREATOR que facilita la creación de nuevos elementos
	 */
	public static final Parcelable.Creator<Opcion> CREATOR
		= new Parcelable.Creator<Opcion>() {
		public Opcion createFromParcel(Parcel in) {
			return new Opcion(in);
		}
	
		public Opcion[] newArray(int size) {
			return new Opcion[size];
		}
	};
	
}
