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
	 * Variable usada para almacenar la opcion
	 */
	private String opcion;
	
	///////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////////
		
	public Opcion() {
		this.opcion = "";
	}

	public String getOpcion() {
		return opcion;
	}
	
	/////////////////////////////////////////GET-SET///////////////////////////////////////////////

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	/////////////////////////////////////////PARCEL////////////////////////////////////////////////

	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(opcion);
	}
	
	private void readFromParcel(Parcel in) {
		this.opcion = in.readString();
	}
	
	public Opcion(Parcel in) {
		this();

		readFromParcel(in);
	}
	
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
