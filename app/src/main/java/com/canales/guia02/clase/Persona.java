package com.canales.guia02.clase;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
    private int idPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private int edadPersona;
    private String correoPersona;

    public Persona() {
    }

    public Persona(int idPersona, String nombrePersona, String apellidoPersona, int edadPersona, String correoPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.edadPersona = edadPersona;
        this.correoPersona = correoPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public int getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    @Override
    public String toString() {
        return idPersona + " " + nombrePersona + " " + apellidoPersona + " " + edadPersona + " " + correoPersona;
    }
    protected Persona(Parcel in) {
        idPersona = in.readInt();
        nombrePersona = in.readString();
        apellidoPersona = in.readString();
        edadPersona = in.readInt();
        correoPersona = in.readString();
    }

    public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idPersona);
        dest.writeString(nombrePersona);
        dest.writeString(apellidoPersona);
        dest.writeInt(edadPersona);
        dest.writeString(correoPersona);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
